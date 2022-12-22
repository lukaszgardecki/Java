public class Playlist {

    static int playlistLength(Song... songs) {
        int totalTime = 0;
        for (Song song : songs) {
            totalTime += song.getTimeInSec();
        }
        return totalTime;
    }

    static void displayTime(int lenInSec) {
        int hours = lenInSec / 3600;
        int minutes = (lenInSec % 3600) / 60;
        int seconds = lenInSec % 60;

        System.out.printf("%s:%s:%s%n",
                hours < 10 ? "0" + hours : hours,
                minutes < 10 ? "0" + minutes : minutes,
                seconds < 10 ? "0" + seconds : seconds);
    }
}
