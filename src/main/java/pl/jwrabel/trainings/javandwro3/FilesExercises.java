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
//		List<Point> points = new ArrayList<>();
//		points.add(new Point(100, 200));
//		points.add(new Point(4, 10));
//		points.add(new Point(1000, 50));
//
//
//		CharSink pointsCharSink = Files.asCharSink(new File("points.csv"), Charsets.UTF_8, FileWriteMode.APPEND);
//
//		for (Point point : points) {
//			pointsCharSink.write(point.toString() + "\n"); // z użyciem nadpisanej metody toString
//			// LUB
////			pointsCharSink.write("" + point);
//
//			// LUB
////			pointsCharSink.write(point.getX() + "," + point.getY() + "\n");
//
//		}

		// === ZADANIE === Wczytać listę punktów z pliku CSV

		// Przeczytanie wszsytkich linii z pliku i zapisanie do listy Stringów, każdy element to kolejna linia
		List<String> fileLines = Files.readLines(new File("points.csv"), Charsets.UTF_8);
		List<Point> pointsReadFromFile = new ArrayList<>();

		// Przejście po wszystkich liniach (pętla FOR-EACH)
		for (String fileLine : fileLines) {
			System.out.println("Line  >" + fileLine + "<");

			// Podzielenie Stringa "100,200" na 2 Stringi "100", "200"
			String[] split = fileLine.split(",");
			String xString = split[0];
			String yString = split[1];

			// Wypisanie podzielonych Stringów
			System.out.println("xString >" + xString + "<");
			System.out.println("yString >" + yString + "<");

			// Parsowanie - zamiana stringów z liczbą na liczbę
			double x = Double.parseDouble(xString);
			double y = Double.parseDouble(yString);

			// Stworzenie nowego punktu o przeczytanych współrzędnych i dodanie do listy
			Point point = new Point(x, y);
			pointsReadFromFile.add(point);

			// WYKORZYSTANIE METODY
			List<Point> points = new ArrayList<>();
			points.add(new Point(100, 200));
			points.add(new Point(4, 10));
			points.add(new Point(1000, 50));

			FilesExercises.savePointsToFile(points, "points.csv");
			List<Point> pointsReadFromFileMethod = FilesExercises.readPointsFromFile("points.csv");
		}
	}

	public static List<Point> readPointsFromFile(String file) throws IOException {
		List<String> fileLines = Files.readLines(new File(file), Charsets.UTF_8);
		List<Point> pointsReadFromFile = new ArrayList<>();

		for (String fileLine : fileLines) {
			System.out.println("Line  >" + fileLine + "<");

			// Podzielenie Stringa "100,200" na 2 Stringi "100", "200"
			String[] split = fileLine.split(",");
			String xString = split[0];
			String yString = split[1];

			// Wypisanie podzielonych Stringów
			System.out.println("xString >" + xString + "<");
			System.out.println("yString >" + yString + "<");

			// Parsowanie - zamiana stringów z liczbą na liczbę
			double x = Double.parseDouble(xString);
			double y = Double.parseDouble(yString);

			// Stworzenie nowego punktu o przeczytanych współrzędnych i dodanie do listy
			Point point = new Point(x, y);
			pointsReadFromFile.add(point);
		}

		return pointsReadFromFile;
	}

	public static void savePointsToFile(List<Point> points, String fileName) throws IOException {
		CharSink pointsCharSink = Files.asCharSink(new File(fileName), Charsets.UTF_8, FileWriteMode.APPEND);

		for (Point point : points) {
			pointsCharSink.write(point.toString() + "\n"); // z użyciem nadpisanej metody toString

		}

	}
}
