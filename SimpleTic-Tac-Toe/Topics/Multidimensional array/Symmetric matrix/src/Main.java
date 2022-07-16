import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[][] matrix = new int[size][size];
        for (int k = 0; k < size; k++) {
            for (int l = 0; l < size; l++) {
                matrix[k][l] = scanner.nextInt();
            }
        }
        boolean isSymmetrical = true;
        outer:
        for (int k = 0; k < size; k++) {
            for (int l = 0; l < size; l++) {
                if (matrix[k][l] != matrix[l][k]) {
                    isSymmetrical = false;
                    break outer;
                }
            }
        }
        System.out.println(isSymmetrical ? "YES" : "NO");
    }
}
