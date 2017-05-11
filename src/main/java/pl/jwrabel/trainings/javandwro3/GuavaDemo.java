package pl.jwrabel.trainings.javandwro3;

import com.google.common.base.Charsets;
import com.google.common.io.CharSink;
import com.google.common.io.Files;
import com.google.common.io.MoreFiles;
import com.google.common.io.Resources;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jakubwrabel on 11/05/2017.
 */
public class GuavaDemo {
	public static void main(String[] args) throws IOException {
		File file = new File("test.txt");
		List<String> lines = Files.readLines(file, Charsets.UTF_8);

		for (String line : lines) {
			System.out.println(line);
		}


		CharSink charSink = Files.asCharSink(new File("test.txt"), Charsets.UTF_8);
		// zapisanie Stringa do pliku
		charSink.write("String");

		// zapisanie listy Stringów do pliku
		List<String> stringList = new ArrayList<>();
		stringList.add("ABC");
		stringList.add("BCD");
		charSink.writeLines(stringList);

		// Przeczytanie całego pliku do Stringa
		String fileContent = Files.toString(new File("test.txt"), Charsets.UTF_8);

		// Stworzenie pliku
		Files.touch(new File("newFile.txt"));

		// Skopiowanie plików
		Files.copy(new File("a.txt"), new File("b.txt"));

		// Przeniesienie pliku
		Files.move(new File("a.txt"), new File("C:\\a.txt"));

		// Przeczytanie zasobu
		URL resource = Resources.getResource("test.txt");
		String resourceAsString = Resources.toString(resource, Charsets.UTF_8);

		// MoreFiles.
	}
}
