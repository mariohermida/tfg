package shs;

import java.util.Scanner;

/**
 * 
 * @author Mario Hermida
 *
 */

public class Main {

	public static void main(String[] args) {
		Main program = new Main();
		program.start();
	}

	private void start() {
		System.out.println("Starting program...\n");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Write a message to be hashed: ");
		String message = sc.nextLine();
		sc.close();
		System.out.println("The input message is: '" + message + "'");
		DataTreatment data = new DataTreatment(message);
		//maybe indicate within the constructor the type of data (text, binary, hexadecimal)
		
		//new SHA_1(data.binaryMessage);
		//new SHA_256(data.binaryMessage);
		
		HashFunction h = new HashFunction();
		System.out.println(h.ROTL("111111000000000000000000000000000", 13));
		System.out.println(h.ROTR(h.ROTL("111111000000000000000000000000000", 13), 13));
		
		String a = "da02ce3a89ecac3b";
		String b = "ee92b50606b62b0b";
		DataTreatment dat = new DataTreatment("");
		String bina = dat.hexadecimalToBinary(a);
		String binb = dat.hexadecimalToBinary(b);
		dat.binaryToHexadecimal(bina);
		dat.binaryToHexadecimal(binb);
	}

}