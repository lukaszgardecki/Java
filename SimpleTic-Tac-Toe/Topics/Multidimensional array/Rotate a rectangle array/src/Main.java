import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //=3
        int m = scanner.nextInt(); //=4
        int[][] arr1 = new int[n][m];
        int r = m; //=4
        int c = n; //=3
        int[][] arr2 = new int[r][c];
        int v = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr1[i][j] = scanner.nextInt();
            }
        }
        
        for (int i = 0; i < r; i++) { // 0,1,2,3
            for (int j = 0; j < c; j++) { //0,1,2
                v = Math.abs(j - (arr1.length - 1));
                arr2[i][j] = arr1[v][i];
            }
        }
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(arr2[i][j] + " ");
            }
            System.out.println();
        }
        
        
    }
}
