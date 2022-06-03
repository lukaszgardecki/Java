package Polimorfizm;

public class FiguraTest {
    public static void main(String[] args) {
        Figura fig = new Figura();
        Kolo kolo = new Kolo();
        Kolo kolo2 = new Kolo(50);
        Prostokat prost = new Prostokat();
        Prostokat prost2 = new Prostokat(3, 7, "Be¿owy",true);

        Figura[] figury = new Figura[5];

        figury[0] = kolo;
        figury[1] = kolo2;
        figury[2] = prost;
        figury[3] = prost2;
        figury[4] = fig;

        for (int i = 0; i < figury.length; i++) {
            System.out.println(figury[i]);
        }
    }
}
