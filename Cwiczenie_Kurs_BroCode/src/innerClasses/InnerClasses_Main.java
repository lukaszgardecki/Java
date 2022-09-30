package innerClasses;

public class InnerClasses_Main {
    public static void main(String[] args) {


        Outside out = new Outside();
        Outside.Inside in = out.new Inside();

        in.Greeting();


    }
}
