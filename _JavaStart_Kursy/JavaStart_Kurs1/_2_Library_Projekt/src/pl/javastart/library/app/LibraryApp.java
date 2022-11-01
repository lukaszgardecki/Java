package pl.javastart.library.app;

class LibraryApp {
    final static String APP_NAME = "Biblioteka v1.5";

    public static void main(String[] args) {
        System.out.println(APP_NAME);
        LibraryControl libraryControl = new LibraryControl();
        libraryControl.controlLoop();
    }

}
