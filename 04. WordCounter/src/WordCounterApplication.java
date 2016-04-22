import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WordCounterApplication {

	public static void main(String[] args) {

		WordCounter counter = new WordCounter();
		StringBuilder lines = new StringBuilder();
		String line;

		//File file = new File("demo.txt");
		File file = new File(args[0]);
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			while ((line = br.readLine()) != null) {
				lines.append(line);
				lines.append(" ");
			}
			counter.countDistinctWords(lines.toString());
			counter.printDistinctWords();

		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + file.toString());
		} catch (IOException e) {
			System.out.println("File not open: " + file.toString());
		}

	}

}
