class ArrayOperations {
    public static void printCorners(int[][] twoDimArray) {
        int k = twoDimArray[0][0];
        int l = twoDimArray[0][twoDimArray[0].length - 1];
        int n = twoDimArray[twoDimArray.length - 1][0];
        int m = twoDimArray[twoDimArray.length - 1][twoDimArray[0].length - 1];
        
        System.out.printf("%d %d \n %d %d", k, l, n, m);
       
    }
}
