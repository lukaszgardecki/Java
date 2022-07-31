class Problem {
    public static void main(String[] args) {
        int index = 0;
        for (int i = 0; i < args.length; i++) {
            boolean isFound = args[i].equals("test");
            if (isFound) {
                index = i;
                break;
            }

            if (i == args.length - 1) index = -1;
        }
        System.out.println(index);
    }
}