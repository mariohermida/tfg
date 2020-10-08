package version1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		System.out.println("Starting program...\n");

		Main main = new Main();

		File file = new File("C:\\Users\\Mario Hermida\\git\\tfg\\txt\\words.txt");

		main.readFile(file);
		main.writeFile(file);

	}

	private void readFile(File file) {
		FileReader fr;
		BufferedReader br;

		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);

			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	private void writeFile(File file) {
		FileWriter fw;
		
		try {
			fw = new FileWriter(file);
			
			if (file.createNewFile()) {
				System.out.println("File created: " + file.getName());
			} else {
				System.out.println("File already exists.");
			}
			
			fw.write("I am writing to a file");
			fw.close();
			System.out.println("Writing to a file successfully done!");
			
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

}