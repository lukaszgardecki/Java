package Zad_32_HurtowniaMotoryzacyjna;

class Test {
    public static void main(String[] args) {
        Part part = new Part(3, "proddd", "jakiœmodel", "jakaœseria");
        Tire tire = new Tire(1, "Michelin", "XXX", "Xd835", "15", "200");
        ExhaustPart expart = new ExhaustPart(2, "Producer1", "model1", "series1", true);


        System.out.println(part);
        System.out.println(tire);
        System.out.println(expart);

    }
}
