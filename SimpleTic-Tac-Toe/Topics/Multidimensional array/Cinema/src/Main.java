import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] seats = new int[n][m];
        int counter = 0;
        int freeRow = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                seats[i][j] = scanner.nextInt();
            }
        }

        int k = scanner.nextInt();

        freeSeats:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (seats[i][j] == 0) {
                    counter++;
                } else {
                    counter = 0;
                }
                if (counter >= k) {
                    freeRow = i + 1;
                    break freeSeats;
                }
            }
            counter = 0;
        }
        System.out.println(freeRow);

    }
}