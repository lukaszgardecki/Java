package pl.am.projects.rownanieKwadratowe;

public class RownanieKwadratowe {
    private int a;
    private int b;
    private int c;

    public RownanieKwadratowe(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String rozwiaz() {
        String rozwiazanie = "";
        double delta;
        delta = (b * b - 4 * a * c);

        if (delta > 0) {
            delta = Math.sqrt(delta);
            double x1 = (-b - delta) / (2 * a);
            double x2 = (-b + delta) / (2 * a);
            rozwiazanie = "R�wnanie posiada dwa pierwiastki rzeczywiste: " + x1 + " oraz: " + x2;
        } else if (delta == 0) {
            //delta = Math.sqrt(delta);
            double x0 = -b / (2 * a);
            rozwiazanie = "R�wnanie posiada jeden pierwiastek rzeczywisty: " + x0;
        } else {
            rozwiazanie = "Brak pierwiastk�w rzeczywistych";
        }
        return rozwiazanie;
    }

    public String toString() {
        return "R�wnanie kwadratowe: " + a + "x^2 + " + b + "x +" + c;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setC(int c) {
        this.c = c;
    }

    public static void main(String[] args) {
        RownanieKwadratowe rownanie = new RownanieKwadratowe(15, 4, 0);
        System.out.println(rownanie.rozwiaz());
    }
}
