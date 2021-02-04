package shs;

import java.util.Scanner;

/**
 * 
 * @author Mario Hermida
 *
 */

public class Main {

	/*
	 * FUNCTIONALITY
	 * I HAVE THOUGHT DROPPING PADMESSAGE AND PARSEMESSAGE FUNCTIONS FROM THE
	 * CONSTRUCTOR THINK OF WHETHER INCLUDING ALTERNATE COMPUTATION METHOD FOR SHA-1
	 * WATCH OUT (WHAT HAPPENS WHEN UNICODE VALUE IS INPUT?) CHECK MESSAGE LENGTH WHEN SO
	 * 
	 * SWING
	 * INCLUDE SwingUtilities.invokeLater(new Runnable() { FOR STARTING THE PROGRAM
	 * INCLUDE A RESIZING FACTOR IN ORDER TO EASE THE MOVEMENT OF ELEMENTS
	 * INCLUDE SOMETHING FOR CHOOSING BETWEEN BINARY AND NONBINARYDATA
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

		new ControllerSHS();

		/*
		Scanner sc = new Scanner(System.in);
		System.out.println("Write a message to be hashed: ");
//		String message = sc.nextLine();
//		String message = "c56d80e97ccde9a94edb51f7b63997160efb140c0319b0f559b1fdef0c07ea51c56d80e97ccde9a94edb51f7b63997160efb140c0319b0f559b1fdef0c07ea51c56d80e97ccde9a94edb51f7b63997160efb140c0319b0f559b1fdef0c07ea51\n"
//				+ "c56d80e97ccde9a94edb51f7b63997160efb140c0319b0f559b1fdef0c07ea51";
		String message = "cbc";
		message.replace("\r\n", "\n").replace("\r", "\n");
		sc.close();
		System.out.println("The input message is: '" + message + "'");

		SHA_1 sh1 = new SHA_1(message);
		System.out.println("The hash value is: '" + sh1.computeHash() + "'");

		SHA_256 sh2 = new SHA_256(message);
		System.out.println("The hash value is: '" + sh2.computeHash() + "'");

		SHA_224 sh3 = new SHA_224(message);
		System.out.println("The hash value is: '" + sh3.computeHash() + "'");

		SHA_512 sh4 = new SHA_512(message);
		System.out.println("The hash value is: '" + sh4.computeHash() + "'");

		SHA_384 sh5 = new SHA_384(message);
		System.out.println("The hash value is: '" + sh5.computeHash() + "'");

		SHA_512_224 sh6 = new SHA_512_224(message);
		System.out.println("The hash value is: '" + sh6.computeHash() + "'");

		SHA_512_256 sh7 = new SHA_512_256(message);
		System.out.println("The hash value is: '" + sh7.computeHash() + "'");*/
		
	}

}