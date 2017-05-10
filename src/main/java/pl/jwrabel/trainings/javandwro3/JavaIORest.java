package pl.jwrabel.trainings.javandwro3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class JavaIORest {

    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("a.txt");

        fileWriter.write("Ala ma kota");

        fileWriter.flush();
        fileWriter.close();


        FileWriter fileWriterAppend = new FileWriter("a.txt", true);

        fileWriterAppend.write("Ala ma kota");

        fileWriterAppend.flush();
        fileWriterAppend.close();

        // NIE POLECAM
        FileReader fileReader = new FileReader("a.txt");

        fileReader.read();

        fileReader.close();

        // Scanner
        FileInputStream fileInputStream = new FileInputStream("a.txt");
        Scanner scanner = new Scanner(fileInputStream);

        String line = scanner.nextLine();
        scanner.next();

        fileInputStream.close();

        // PrintStream
        PrintStream printStream = new PrintStream(new FileOutputStream("b.txt"));
        printStream.println("ABC");

    }

}
