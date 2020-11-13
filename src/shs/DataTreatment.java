package shs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 
 * @author Mario Hermida
 *
 */
public class DataTreatment {

	/*File file = new File("C:\\Users\\Mario Hermida\\git\\tfg\\txt\\words.txt");*/
	String originalMessage;
	String binaryMessage;
	
	public DataTreatment(String message) {
		originalMessage = message;
		binaryMessage = "";
		textToBinary();
		System.out.println("The binary sequence is: " + binaryMessage);
	}
	
	/**
	 * It converts every character (byte) to a 7-bit sequence (US_ASCII),
	 * then it is zero padded so that it is a 8-bit string.
	 * 
	 * @param message Whole text to be converted
	 * @return The binary string multiple of 8 bits
	 */
	private void textToBinary() {
		byte[] byteArray = originalMessage.getBytes(StandardCharsets.US_ASCII);
		String binaryCharacter;
		for (byte b : byteArray) {
			binaryCharacter = Integer.toBinaryString(b);
			while(binaryCharacter.length() < 8) {
				binaryCharacter = "0" + binaryCharacter;
			}
			binaryMessage += binaryCharacter;
		}
	}

	/**
	 * 
	 * @param binary Binary string to be converted
	 * @return Hexadecimal value from binary string
	 */
	public String binaryToHexadecimal(String binary) {
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
	public String hexadecimalToBinary(String hexadecimal) {		
		String binary = "", binaryResult = "", hexDigit;
		for (int i = 0; i < hexadecimal.length(); i++) {
			hexDigit = String.valueOf(hexadecimal.charAt(i));
			binary = Integer.toBinaryString((Integer.parseInt(hexDigit, 16)));
			//Appending zeroes for having multiple of 4 bits number
			while(binary.length()%4 != 0) {				
				binary = "0" + binary;
			}
			binaryResult += binary;
		}
		System.out.println(binaryResult);
		return binaryResult;
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
