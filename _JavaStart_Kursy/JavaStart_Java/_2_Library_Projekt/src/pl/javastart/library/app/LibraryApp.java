package pl.javastart.library.app;

class LibraryApp {
    final static String APP_NAME = "Biblioteka v1.9.0";

    public static void main(String[] args) {
        System.out.println(APP_NAME);
        LibraryControl libraryControl = new LibraryControl();
        libraryControl.controlLoop();
    }

}
