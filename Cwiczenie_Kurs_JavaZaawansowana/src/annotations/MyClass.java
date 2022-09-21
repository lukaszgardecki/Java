package annotations;


import java.lang.reflect.Method;

class MyClass {

    @MyCustomAnnotation(value = 10)
    public void sayHello() {
        System.out.println("my custom annotation");
    }

    public static void main(String[] args) throws Exception {
        MyClass h = new MyClass();

        //stw�rz metod�: we� klas� MyClass, we� z tej klasy metod� o nazwie "sayHello"
        Method methodVal = h.getClass().getMethod("sayHello");

        MyCustomAnnotation myCustomAnnotation = methodVal.getAnnotation(MyCustomAnnotation.class);
        System.out.println("value is: " + myCustomAnnotation.value());
    }


}
