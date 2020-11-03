package version1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 
 * @author Mario Hermida
 *
 */

public class Main {

	public static void main(String[] args) {

		System.out.println("Starting program...\n");

		Main main = new Main();

		/*File file = new File("C:\\Users\\Mario Hermida\\git\\tfg\\txt\\words.txt");

		main.readFile(file);
		main.writeFile(file);*/
		
//		main.binaryToHexadecimal("11010");
//		main.hexadecimalToBinary("aaaa");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Write a message to be hashed: ");
		String message = sc.nextLine();
		sc.close();
		System.out.println("The input message is: '" + message + "'");
		System.out.println("The text converted to binary is: '" + main.textToBinary(message) + "'");
		
		//SHA-1
		//The goal is to achieve a 160 message digest from a l-length message where 0<l<2^64
		SHA_1 sha1 = new SHA_1(main.textToBinary(message));
		
	}
	
	/**
	 * It converts every character to 7-bit sequences (US_ASCII),
	 * then it is zero padded so that it is a 8-bit string
	 * 
	 * @param message Whole text to be converted
	 * @return The binary 8-bit string
	 */
	private String textToBinary(String message) {
		String binary = "";
		byte[] byteArray = message.getBytes(StandardCharsets.US_ASCII);
		for (byte b : byteArray) { 
			binary += "0" + Integer.toBinaryString(b);
		}
		return binary;
	}

	/**
	 * 
	 * @param binary Binary string to be converted
	 * @return Hexadecimal value from binary string
	 */
	private String binaryToHexadecimal(String binary) {
		String hexadecimal = "", substring;
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
			hexadecimal += Integer.toHexString(Integer.parseInt(substring, 2));
		}
		System.out.println(hexadecimal);
		return hexadecimal;
	}
	
	/**
	 * 
	 * @param hexadecimal Hexadecimal value to be converted
	 * @return Binary value from hexadecimal value
	 */
	private String hexadecimalToBinary(String hexadecimal) {		
		String binary = "", hexDigit;
		for (int i = 0; i < hexadecimal.length(); i++) {
			hexDigit = String.valueOf(hexadecimal.charAt(i));
			binary += Integer.toBinaryString((Integer.parseInt(hexDigit, 16)));
			//Appending zeroes for having multiple of 4 bits number
			while(binary.length()%4 != 0) {				
				binary = "0" + binary;
			}
		}
		System.out.println(binary);
		return binary;
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