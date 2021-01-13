package shs;

import java.util.Scanner;

/**
 * 
 * @author Mario Hermida
 *
 */

public class Main {

	/*
	 * WHAT TO DO (MAIN FUNCTIONALITY): IMPLEMENT FUNCTIONS ON HASHFUNCTION CLASS
	 * (CH, PARITY, MAJ, SIGMA UPPER/LOWER CASE WITH DIFFERENT LENGTHS 32/64 BITS)
	 * INSERT CONSTANTS AND INITIAL HASH VALUES IN CORRESPONDING SHA_X CLASS
	 * IMPLEMENT BEHAVIOUR OF THE ROOT ALGORITHM IN HASHFUNCTION CLASS HOW TO DEAL
	 * WITH LARGER MESSAGES THAN maximumMessageLength IN HASHFUNCTION CLASS CREATE A
	 * SOLID STRONG STRUCTURE/ARCHITECTURE FOR DATATREATMENT CLASS REVIEW ACCES
	 * MODIFIERS POLICIES BOTH IN FUNCTIONS AND ATTRIBUTES IN DATA TREATMENT CLASS
	 * MAYBE INDICATE WITHIN THE CONSTRUCTOR THE TYPE OF DATA (TEXT, BINARY,
	 * HEXADECIMAL) IN DATA TREATMENT CLASS
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
		String message = sc.nextLine();
		sc.close();
		System.out.println("The input message is: '" + message + "'");

	}

}