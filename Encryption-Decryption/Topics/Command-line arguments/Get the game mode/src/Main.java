class Problem {
    public static void main(String[] args) {
        for (int i = 1; i < args.length; i = i + 2) {
            String param = args[i-1];
            String value = args[i];

            if (param.equals("mode")) {
                System.out.println(value);
                break;
            }
            if (i == args.length -1) System.out.println("default");
        }
    }
}