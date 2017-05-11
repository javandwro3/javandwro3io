package pl.jwrabel.trainings.javandwro3;

import com.google.common.base.Charsets;
import com.google.common.io.CharSink;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jakubwrabel on 11/05/2017.
 */
public class FilesExercises {
	public static void main(String[] args) throws IOException {
		// === ZADANIE === Zapisać plik z liczbami 1-1000
		FileWriter fileWriter = new FileWriter("numbers.txt");

		for (int i = 0; i <= 10_000; i++) {
			fileWriter.write("" + i + "\n");
		}

		fileWriter.close();

		// LUB (GUAVA)
//		CharSink charSink = Files.asCharSink(new File("numbers.txt"), Charsets.UTF_8, FileWriteMode.APPEND);
//
//		for (int i = 0; i <= 10_000; i++) {
//			charSink.write("" + i + "\n");
//		}

		// LUB (GUAVA#2)
		CharSink charSink2 = Files.asCharSink(new File("numbers.txt"), Charsets.UTF_8);

		List<String> stringList = new ArrayList<>();

		for (int i = 0; i <= 10_000; i++) {
			stringList.add("" + i);
		}

		charSink2.writeLines(stringList);

		// === ZADANIE === Zapisać listę punktów do pliku
		List<Point> points = new ArrayList<>();
		points.add(new Point(100, 200));
		points.add(new Point(4, 10));
		points.add(new Point(1000, 50));

		CharSink pointsCharSink = Files.asCharSink(new File("points.csv"), Charsets.UTF_8, FileWriteMode.APPEND);

		for (Point point : points) {
			pointsCharSink.write(point.toString() + "\n"); // z użyciem nadpisanej metody toString
			// LUB
//			pointsCharSink.write("" + point);

			// LUB
//			pointsCharSink.write(point.getX() + "," + point.getY() + "\n");

		}


	}
}
