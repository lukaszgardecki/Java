package wzorce.decorator;

class Main {
    public static void main(String[] args) {
        JalapenoDecorator pizza = new JalapenoDecorator(new CheeseBurstDecorator(new BasePizza()));
        System.out.println(pizza.bake()); // = "Base pizza... cheese jalapeno"
    }
}
