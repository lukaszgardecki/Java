public class Main {
    public static void main(String[] args) {
        //  Klasa Math, jest cała statyczna
        int a = -5;
        int b =  11;

        //Wartość maksymalna:
        System.out.println(Math.max(a, b));
        //Wartość minimalna:
        System.out.println(Math.min(a, b));
        //Wartość bezwzględna:
        System.out.println(Math.abs(a));
        //Potęga:
        System.out.println(Math.pow(a, 2));
        //Pierwiastek kwadratowy
        System.out.println(Math.sqrt(16));
        //Zaokrąglanie:
        System.out.println(Math.round(14.5));
        //Zaokrąglanie w górę:
        System.out.println(Math.ceil(14.5));
        //Zaokrąglanie w dół:
        System.out.println(Math.floor(14.5));
        //Stała PI
        System.out.println(Math.PI);
        //Stała E
        System.out.println(Math.E);
    }
}
