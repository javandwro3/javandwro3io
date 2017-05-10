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
    }

}
