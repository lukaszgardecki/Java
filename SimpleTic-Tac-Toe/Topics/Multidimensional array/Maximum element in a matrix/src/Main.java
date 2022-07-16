import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = 0;
        int r = 0;
        int c = 0;
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        
        int[][] arr = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        
        max = arr[0][0];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                    r = i;
                    c = j;
                }
            }
        }
        System.out.printf("%d %d", r, c);
    }
}
