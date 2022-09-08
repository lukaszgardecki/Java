package io.javabrains.unit1;

public class RunnableExample {
    public static void main(String[] args) {

        //u¿ycie Runnable jest mo¿liwe poniewa¿ ten interfejs ma tylko jedn¹ metodê. Gdyby mia³ wiêcej mêtod, które trzeba zaimplementowaæ, jego u¿ycie nie by³oby mo¿liwe
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
