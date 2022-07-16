import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        
        int[][] arr = new int[n][m];
        
        //input matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        
        //which column?
        int k = scanner.nextInt();
        int l = scanner.nextInt();
        int x;
        
        //swap the columns
        for (int i = 0; i < n; i++) {
            x = arr[i][k];
            arr[i][k] = arr[i][l];
            arr[i][l] = x;
        }
        
        //display the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
