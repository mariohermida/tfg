package shs;

import java.util.Scanner;

/**
 * 
 * @author Mario Hermida
 *
 */

public class Main {

	/*
	 * THINK OF CHANGING HASHFUNCTION TO NON-ABSTRACT AGAIN
	 * THINK OF DECLARING ALL THE VARIABLES IN THE SUPERCLASS (HASHFUNCTION) 
	 * CONSTANTS IN SHA_* CLASS SHOULD BE SET TO PRIVATE INSTEAD OF STATIC
	 * TRY TO THINK OTHER WAY TO KEEP RECORD OF HASH VALUES BEING BINARY
	 * I HAVE THOUGHT DROPPING PADMESSAGE AND PARSEMESSAGE FUNCTIONS FROM THE CONSTRUCTOR
	 * THINK OF WHETHER INCLUDING ALTERNATE COMPUTATION METHOD FOR SHA-1 OR NOT
	 * HASH CAN ALSO BE COMPUTED FROM FILES WITH A NEW CONSTRUCTOR (IT CAN HAVE THE FILE AND FROM THERE
	 * THE TEXT WITHIN THE FILE)
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

		SHA_1 sh1 = new SHA_1(message);
		System.out.println("The hash value is: '" + sh1.computeHash() + "'");
		
		SHA_256 sh2 = new SHA_256(message);
		System.out.println("The hash value is: '" + sh2.computeHash() + "'");
		
		SHA_224 sh3 = new SHA_224(message);
		System.out.println("The second hash value is: '" + sh3.computeHash() + "'");
		
		SHA_512 sh4 = new SHA_512(message);
		System.out.println("The second hash value is: '" + sh4.computeHash() + "'");
		
		SHA_384 sh5 = new SHA_384(message);
		System.out.println("The second hash value is: '" + sh5.computeHash() + "'");
		
		SHA_512_224 sh6 = new SHA_512_224(message);
		System.out.println("The second hash value is: '" + sh6.computeHash() + "'");
		
		SHA_512_256 sh7 = new SHA_512_256(message);
		System.out.println("The second hash value is: '" + sh7.computeHash() + "'");
	}

}