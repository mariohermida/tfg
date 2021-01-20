package shs;

import java.util.Scanner;

/**
 * 
 * @author Mario Hermida
 *
 */

public class Main {

	/*
	 * IMPLEMENT BEHAVIOUR OF THE ROOT ALGORITHM IN HASHFUNCTION CLASS
	 * CREATE A SOLID STRONG STRUCTURE/ARCHITECTURE FOR DATATREATMENT CLASS REVIEW ACCES
	 * MODIFIERS POLICIES BOTH IN FUNCTIONS AND ATTRIBUTES IN DATA TREATMENT CLASS
	 * MAYBE INDICATE WITHIN THE CONSTRUCTOR THE TYPE OF DATA (TEXT, BINARY,
	 * HEXADECIMAL) IN DATA TREATMENT CLASS FUNCTIONALITY CAN BE DEVELOPED IN
	 * HASHFUNCTION CLASS WHEREAS ALL THE PARAMETERS ARE EXPLICITED IN EACH
	 * ALGORITHM CLASS 
	 * THINK OF CHANGING HASHFUNCTION CLASS TO ABSTRACT
	 * THINK OF DECLARING ALL THE VARIABLES IN THE SUPERCLASS (HASHFUNCTION)
	 * CONSIDER PASSING THE TEXT AS IT IS (CHANGING TO BINARY IN THE SHA_* CONSTRUCTOR) 
	 * VARIABLE NUMBER OF BLOCKS CAN BE DELETED (IT IS NOT USED)
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
//		 String message = sc.nextLine();
		sc.close();
		String message = "¡Hola a todos, amigos!";
		System.out.println("The input message is: '" + message + "'");

		// Testing
		DataTreatment d = new DataTreatment();
		System.out.println(d.textToBinary(""));
		zeroGenerator(116);

	}

	private void zeroGenerator(int number) {
		for (int i = 0; i < number; i++) {
			System.out.print("0");
		}
	}

}