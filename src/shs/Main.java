package shs;

import java.util.Scanner;

/**
 * 
 * @author Mario Hermida
 *
 */

public class Main {

	/*
	 * INSERT CONSTANTS AND INITIAL HASH VALUES IN CORRESPONDING SHA_X CLASS
	 * IMPLEMENT BEHAVIOUR OF THE ROOT ALGORITHM IN HASHFUNCTION CLASS HOW TO DEAL
	 * WITH LARGER MESSAGES THAN maximumMessageLength IN HASHFUNCTION CLASS CREATE A
	 * SOLID STRONG STRUCTURE/ARCHITECTURE FOR DATATREATMENT CLASS REVIEW ACCES
	 * MODIFIERS POLICIES BOTH IN FUNCTIONS AND ATTRIBUTES IN DATA TREATMENT CLASS
	 * MAYBE INDICATE WITHIN THE CONSTRUCTOR THE TYPE OF DATA (TEXT, BINARY,
	 * HEXADECIMAL) IN DATA TREATMENT CLASS
	 * FUNCTIONALITY CAN BE DEVELOPED IN HASHFUNCTION CLASS WHEREAS ALL THE PARAMETERS
	 * ARE EXPLICITED IN EACH ALGORITHM CLASS
	 * 
	 * FURTHER ACTIONS: CREATE USER INTERFACE AND ESTABLISH EVENT LISTENER POLICIES
	 * 
	 * ADDITIONAL FUNCTIONALITIES: CREATE AN OPTION TO ESTABLISH THE BITS YOU WANT
	 * TO TRUNCATE WITHIN THE MESSAGE (REGARDLESS THE KNOWN ALGORITHMS)
	 */

	public static void main(String[] args) {
		Main program = new Main();
		program.start();
	}

	private void start() {
		System.out.println("Starting program...\n");
		Scanner sc = new Scanner(System.in);
		System.out.println("Write a message to be hashed: ");
		//String message = sc.nextLine();
		//sc.close();
		String message = "¡Hola a todos, amigos!"; 
		System.out.println("The input message is: '" + message + "'");

		DataTreatment d = new DataTreatment();
		System.out.println(d.textToBinary(message));
		SHA_512_256 sh = new SHA_512_256(d.textToBinary(message));
		
		System.out.println("Initial hash values are going to be shown");
		int contador = 0; 
		for (String s : sh.getValues()) {
			System.out.println(++contador + ": '" + s + "'");
		}
	}

}