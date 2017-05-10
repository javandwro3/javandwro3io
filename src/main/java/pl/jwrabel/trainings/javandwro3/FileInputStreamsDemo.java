package pl.jwrabel.trainings.javandwro3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamsDemo {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("ala.txt");

        int read = fileInputStream.read();
        System.out.println((char)read);

        System.out.println((char)fileInputStream.read());

        fileInputStream.close();

    }

}
