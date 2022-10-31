package Zad_34_SklepKomputerowy;

class ComputerStore {
    public static void main(String[] args) {
        Computer computer = new Computer(45, 16384);
        Notebook notebook = new Notebook(40, 8192, 10000);

        computer.coolDown();
        notebook.coolDown();

    }
}
