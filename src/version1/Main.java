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

		/*File file = new File("C:\\Users\\Mario Hermida\\git\\tfg\\txt\\words.txt");

		main.readFile(file);
		main.writeFile(file);*/
		
		main.binaryToHexadecimal("11010");
		main.hexadecimalToBinary("1a");

	}
	
	private String binaryToHexadecimal(String binary) {
		String hexValue = "", substring;
		//Adapting binary number for being multiple of 4 bits
		while (binary.length()%4!=0) {
			binary = "0" + binary;
		}
		//Splitting into 4-bit blocks and converting into hexadecimal
		for (int i = 0; i < binary.length(); i+=4) {
			substring = "";
			substring += binary.charAt(i);
			substring += binary.charAt(i+1);
			substring += binary.charAt(i+2);
			substring += binary.charAt(i+3);
			hexValue += Integer.toHexString(Integer.parseInt(substring, 2));
		}
		System.out.println(hexValue);
		return hexValue;
	}
	
	private String hexadecimalToBinary(String hexadecimalString) {		
		String binValue = "", hexDigit;
		for (int i = 0; i < hexadecimalString.length(); i++) {
			hexDigit = String.valueOf(hexadecimalString.charAt(i));
			String binary4BitNumber = Integer.toBinaryString((Integer.parseInt(hexDigit, 16)));
			//Appending zeroes for having multiple of 4 bits number
			while(binary4BitNumber.length() < 4) {				
				binary4BitNumber = "0" + binary4BitNumber;
			}
			binValue += binary4BitNumber;
		}
		System.out.println(binValue);
		return binValue;
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