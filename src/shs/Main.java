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
	 * TRY TO AVOID REPETITION WHEN COMPUTING THE HASH (WHAT COMES TO MY MIND IS CREATING TWO
	 * MORE ABSTRACT CLASSES, ONE FOR SHA224,256 AND OTHER FOR 384,512,512_T, THEN, EVERY SUBCLASS 
	 * WOULD INHERIT THE METHOD HASHCOMPUTATION FROM THEM (CONSTANTS AND HASH VALUES HAVE TO BE TAKEN
	 * INTO ACCOUNT)
	 * CONSTANTS IN SHA_* CLASS SHOULD BE SET TO PRIVATE INSTEAD OF STATIC
	 * CHANGE INITIAL HASH VALUES TO HASH VALUES BECAUSE THEY ARE GOING TO BE CHANGED EVERY ITERATION
	 * CHECK EVERYTHING REGARDING TESTS, IT IS NOT WORTHY HAVING PUBLIC METHODS JUST FOR TESTING (FOR
	 * EXAMPLE GET BINARY MESSAGE PADDED)
	 * TRY TO THINK OTHER WAY TO KEEP RECORD OF HASH VALUES BEING BINARY
	 * CHECK EMPTY STRING FOR SHA_* COMPUTATION
	 * CHECK VALUES IN THE LIMIT IN ORDER TO SEE IF COMPUTATION FOR SEVERAL BLOCKS WORKS
	 * IN HASHFUNCTION IT IS POSSIBLE THAT MESSAGEDIGESTSIZE IS NO LONGER USEFUL
	 * DECIDE WHAT TO DO WIT CLASSES AND TESTS (SAME PACKAGE ?)
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
//		String message = "Hola a todos, amigos!";
		System.out.println("The input message is: '" + message + "'");

		SHA_256 sh = new SHA_256(message);
		System.out.println("The hash value is: '" + sh.computeHash() + "'");
	}

}