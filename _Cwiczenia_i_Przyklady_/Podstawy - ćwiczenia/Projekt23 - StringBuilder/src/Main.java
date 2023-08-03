public class Main {
    public static void main(String[] args) {

        int j =1000;
        String s = "";
        long start = System.currentTimeMillis();
        for (int i = 0; i < j; i++) {
            s += "a";
        }

        System.out.println(s);
        System.out.println("Czas: " + (System.currentTimeMillis() - start));


        //To samo ale działające SZYBCIEJ. StringBuilder można znacznie przyspieszyć czas działania programu
        StringBuilder sb = new StringBuilder();
        start = System.currentTimeMillis();

        for (int i = 0; i < j; i++) {
            sb.append("a");
        }
        System.out.println(sb.toString());
        System.out.println("Czas: " + (System.currentTimeMillis() - start));

        System.out.println(sb.toString());
        System.out.format("Czas: %d", (System.currentTimeMillis() - start));


    }
}
