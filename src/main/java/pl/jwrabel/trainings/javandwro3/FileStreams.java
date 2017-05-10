package pl.jwrabel.trainings.javandwro3;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreams {

    public static void main(String[] args) throws IOException {

        // Strumień wyjściowy do pliku
        // czyści plik przed rozpoczęciem zapisywania
        FileOutputStream outputStream = new FileOutputStream("test.txt");

        outputStream.write(97); // 'a'
        outputStream.write(98); // 'b'

        outputStream.close();

        // strumień dodający do pliku
        FileOutputStream outputStreamAppending = new FileOutputStream("test.txt", true);

        outputStreamAppending.write(100); // 'd'

        outputStreamAppending.close();

        // === zadanie === zapisać do pliku cały alfabet
        FileOutputStream fisAlpha = new FileOutputStream("alpha.txt");

        for (int i = 'a'; i <= 'z'; i++) {
            fisAlpha.write(i);
        }

        fisAlpha.write('\n');

        for (int i = 'A'; i <= 'Z'; i++) {
            fisAlpha.write(i);
        }

        fisAlpha.close();

        // sprawdzenie kodu ASCII znaku nowej linii
        System.out.println((int) '\n');

        FileOutputStream testStream = new FileOutputStream("sds");
        try {
            testStream.write('a');
        } catch (Exception ex) {

        } finally {
            testStream.close();
        }

        // try-with-resources
        try (FileOutputStream outputStream1 = new FileOutputStream("sds")) {
            outputStream1.write('a');
        }


        // zapisanie Stringa do pliku z użyciem FileOutputStreama
        FileOutputStream fileOutputStream = new FileOutputStream("ala.txt");

        String text = "Ala ma kota";
        byte[] bytes = text.getBytes();
        fileOutputStream.write(bytes);

        // LUB
        fileOutputStream.write("Ala ma kota".getBytes());

        fileOutputStream.close();


    }

}
