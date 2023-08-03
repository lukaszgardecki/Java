package serialization;

import javax.imageio.event.IIOWriteProgressListener;
import java.io.*;

class SerDeserDemo {

    public static void main(String[] args) {

        Student student = new Student("John", 25, "23 East, California");
        student.setX(10);

        String filename = "C:\\Users\\lukas_000\\Desktop\\Java_Projekty\\Java\\Cwiczenie_Kurs_JavaZaawansowana\\src\\serialization\\text.txt";
        FileOutputStream fileOut = null;
        ObjectOutputStream objOut = null;

        //Serialization
        try {
            fileOut = new FileOutputStream(filename);
            objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(student);

            objOut.close();
            fileOut.close();

            System.out.println("Object has been serialized: \n" + student);
        } catch (IOException e) {
            System.out.println("IOException is caught");
        }

        //Deserialization
        FileInputStream fileIn = null;
        ObjectInputStream objIn = null;

        try {
            fileIn = new FileInputStream(filename);
            objIn = new ObjectInputStream(fileIn);

            Student object = (Student) objIn.readObject();

            System.out.println("Object has been derelialized: \n" + object);
            System.out.println("The deselialized value of x is: " + object.getX());

            objIn.close();
            fileIn.close();
        } catch (IOException e) {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }

    }
}
