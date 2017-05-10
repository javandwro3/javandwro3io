package pl.jwrabel.trainings.javandwro3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedStreams {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("a.txt");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

        StringBuilder stringBuilder = new StringBuilder();
        int read;
        while ((read = bufferedInputStream.read()) > 0) {
            stringBuilder.append((char) read);
        }

        System.out.println(stringBuilder.toString());

        bufferedInputStream.close();
        fileInputStream.close();

        FileOutputStream fileOutputStream = new FileOutputStream("b.txt");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        bufferedOutputStream.write('A');
        bufferedOutputStream.write('B');
        bufferedOutputStream.write('C');
        bufferedOutputStream.write('D');

        bufferedOutputStream.flush();
        bufferedOutputStream.close();
        fileOutputStream.close();

    }

}
