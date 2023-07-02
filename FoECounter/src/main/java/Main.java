import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

public class Main {
    private static final List<User> users = new ArrayList<>();
    private static final List<Sector> sectors = new ArrayList<>();
    private static final Printer printer = new Printer();
    private static final MyFileReader reader = new MyFileReader();

    public static void main(String[] args) throws MalformedURLException {
        fetchData();
        printer.printHeaderInfo(sectors);
        printer.printSectorStats(sectors);
        printer.printUserStats(users);

        printer.saveToTextFile(users, sectors);
    }

    private static void fetchData() {
        updateSectorList();
        updateUserList();
    }

    private static void updateUserList() {
        sectors.forEach(sector -> sector.getActiveUsers()
                .forEach(activeUser -> addToUserList(activeUser, sector)));
        Collections.sort(users);
    }

    private static void addToUserList(User user, Sector sector) {
        boolean userListContainsUser = checkIfUserListContainsUser(user);

        if (userListContainsUser) {
            User userInList = findUserInUserList(user);
            if (sector.getCamps() <= 3) {
                userInList.setTotalScore3OrLessCamps(userInList.getTotalScore3OrLessCamps() + user.getTotalScore());
            } else {
                userInList.setTotalScore4OrMoreCamps(userInList.getTotalScore4OrMoreCamps() + user.getTotalScore());
            }
        } else {
            if (sector.getCamps() <= 3) {
                user.setTotalScore3OrLessCamps(user.getTotalScore());
            } else {
                user.setTotalScore4OrMoreCamps(user.getTotalScore());
            }

            users.add(user);
        }
    }

    private static User findUserInUserList(User user) {
        for (User userInList : users) {
            if (user.getName().equals(userInList.getName())) return userInList;
        }
        return null;
    }

    private static boolean checkIfUserListContainsUser(User user) {
        String userName = user.getName();
        for (User u : users) {
            if (u.getName().equals(userName)) return true;
        }
        return false;
    }



    private static void updateSectorList() {
        List<File> exchangeDirectoriesList = reader.getExchangeDirectoriesList();

        for (int i = 0; i < exchangeDirectoriesList.size(); i++) {
            File exchangeDirectory = exchangeDirectoriesList.get(i);
            File startFile = reader.getStartFile(exchangeDirectory);
            List<File> sectorFileList = reader.getSectorFileList(exchangeDirectory);

            List<User> startUserList = reader.createUserListFromFile(startFile);


            for (int k = 0; k < sectorFileList.size(); k++) {
                File sectorFile = sectorFileList.get(k);
                List<User> allSectorUsers = reader.createUserListFromFile(sectorFile);

                Sector sector = new Sector();
                sector.setCamps(reader.getCamps(sectorFile));
                List<User> activeSectorUsers = findActiveSectorUsers(startUserList, allSectorUsers);
                sector.setActiveUsers(activeSectorUsers);
                sector.setBattles(activeSectorUsers.stream().mapToInt(User::getBattles).sum());
                sector.setNegotiations(activeSectorUsers.stream().mapToInt(User::getNegotiations).sum());
                sector.setTotalScore(activeSectorUsers.stream().mapToInt(User::getTotalScore).sum());
                sector.setDate(getCreationDateFromFile(sectorFile));
                sectors.add(sector);

                startUserList = allSectorUsers;
            }
        }
        Collections.sort(sectors);
    }

    private static LocalDateTime getCreationDateFromFile(File sectorFile) {
        LocalDateTime dateTime = null;
        try {
            BasicFileAttributes attrs = Files.readAttributes(Path.of(sectorFile.getPath()), BasicFileAttributes.class);
            FileTime fileTime = attrs.creationTime();
            dateTime = LocalDateTime.ofInstant(fileTime.toInstant(), ZoneId.systemDefault());
        } catch (IOException e) {
            printer.println("Nie znaleziono atrybutów.");
        }
        return dateTime;
    }

    private static List<User> findActiveSectorUsers(List<User> startUserList, List<User> allSectorUsers) {
        List<User> activeUsers = new ArrayList<>();
        int sectorTotalScore = countSectorTotalScore(startUserList, allSectorUsers);

        for (int i = 0; i < allSectorUsers.size(); i++) {
            User userAfterFight = allSectorUsers.get(i);
            User userBeforeFight = startUserList.stream()
                    .filter(u -> u.getName().equals(userAfterFight.getName()))
                    .findFirst()
                    .get();

            if (userAfterFight.getTotalScore() > userBeforeFight.getTotalScore()) {
                User newActiveUser = new User();
                newActiveUser.setId(userAfterFight.getId());
                newActiveUser.setName(userAfterFight.getName());
                newActiveUser.setBattles(userAfterFight.getBattles() - userBeforeFight.getBattles());
                newActiveUser.setNegotiations(userAfterFight.getNegotiations() - userBeforeFight.getNegotiations());
                int totalScore = userAfterFight.getTotalScore() - userBeforeFight.getTotalScore();
                newActiveUser.setTotalScore(totalScore);
                double percentage = (totalScore * 100.0) / sectorTotalScore;
                newActiveUser.setPercentage(percentage);
                activeUsers.add(newActiveUser);
            }
        }
        return activeUsers;
    }

    private static int countSectorTotalScore(List<User> startUserList, List<User> allSectorUsers) {
        int totalScoreBeforeFight = startUserList.stream().mapToInt(User::getTotalScore).sum();
        int totalScoreAfterFight = allSectorUsers.stream().mapToInt(User::getTotalScore).sum();
        return totalScoreAfterFight - totalScoreBeforeFight;
    }
}
