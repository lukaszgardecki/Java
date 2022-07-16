import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        String[][] arr = new String[n][n];
        String dot = ".";
        String star = "*";
        int middle;
        int osWsteczna;

        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = dot;
            }
        }
        
        middle = (n - 1) / 2;
        
        
        for (int i = 0; i < n; i++) {
            osWsteczna = n - i - 1;
            
            arr[i][i] = star;
            arr[i][osWsteczna] = star;
            arr[middle][i] = star;
            arr[i][middle] = star;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
