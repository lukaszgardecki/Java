package unit1;

public class RunnableExample {
    public static void main(String[] args) {

        //u�ycie Runnable jest mo�liwe poniewa� ten interfejs ma tylko jedn� metod�. Gdyby mia� wi�cej m�tod, kt�re trzeba zaimplementowa�, jego u�ycie nie by�oby mo�liwe
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Printed inside Runnable");
            }
        });
        myThread.run();

        //zapis lambdowy
        Thread myLambdaThread = new Thread(() -> System.out.println("Printed inside Lambda Runnable"));
        myLambdaThread.run();
    }
}
