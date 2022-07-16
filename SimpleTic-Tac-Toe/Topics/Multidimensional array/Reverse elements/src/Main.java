class ArrayOperations {
    public static void reverseElements(int[][] twoDimArray) {
        int x = 0;
        int v = 0;
        
        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0; j < (twoDimArray[i].length / 2); j++) {
                x = twoDimArray[i][j];
                v = Math.abs(j - (twoDimArray[i].length-1));
                
                twoDimArray[i][j] = twoDimArray[i][v];
                twoDimArray[i][v] = x;
            }
        }

    }
}
