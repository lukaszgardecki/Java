class Problem {
    public static void main(String[] args) {
        boolean isOK = args[0].equals("+") || args[0].equals("-") || args[0].equals("*");
        if (isOK) {
            int num1 = Integer.parseInt(args[1]);
            int num2 = Integer.parseInt(args[2]);

            switch (args[0]) {
                case "+":
                    System.out.println(num1 + num2);
                    break;
                case "-":
                    System.out.println(num1 - num2);
                    break;
                case "*":
                    System.out.println(num1 * num2);
                    break;
            }
        } else {
            System.out.println("Unknown operator");
        }
    }
}