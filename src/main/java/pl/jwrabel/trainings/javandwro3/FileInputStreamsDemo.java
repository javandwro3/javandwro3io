package pl.jwrabel.trainings.javandwro3;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamsDemo {

    public static void main(String[] args) throws IOException {
        // FileInputStream strumień wejściowy do aplikacji czytający z pliku
//        FileInputStream fileInputStream = new FileInputStream("ala.txt");
//
//        int read = fileInputStream.read();
//        System.out.println((char)read);
//
//        System.out.println((char)fileInputStream.read());
//
//        fileInputStream.close();

        // wczytanie całego pliku
        FileInputStream fis = new FileInputStream("ala.txt");

        while (true) {
            int read = fis.read();
            if (read >= 0) {
                System.out.println((char) read);
            } else {
                break;
            }
        }
        // LUB
        int read;
        while ((read = fis.read()) > 0) {
            System.out.println((char) read);
        }

        fis.close();

        // === ZADANIE === odczytać cyfrę z pliku, wypisać pomnożoną razy 3
        System.out.println("=== CZYTANIE CYFRY Z PLIKU ===");
        FileInputStream numberFis = new FileInputStream("number.txt");

        int numberCode = numberFis.read();
        int number = numberCode - '0';
//        int number = numberCode - 48;
        System.out.println("Przeczytana liczba");
        System.out.println(number);

        System.out.println("Pomnożona liczba");
        System.out.println(number * 3);

        numberFis.close();

        // === ZADANIE === przeczytać cały plik do Stringa
        System.out.println("=== CZYTANIE PLIKU DO STRINGA ===");


    }

}
