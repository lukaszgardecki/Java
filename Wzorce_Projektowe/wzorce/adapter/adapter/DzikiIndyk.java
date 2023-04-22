package wzorce.adapter.adapter;

public class DzikiIndyk implements Indyk{

    @Override
    public void gulgocz() {
        System.out.println("Gulgulgulgul");
    }

    @Override
    public void lataj() {
        System.out.println("O rany! Latam! ... ale tylko na krótkich dystanasach!");
    }
}
