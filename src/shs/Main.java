package shs;

/**
 * 
 * @author Mario Hermida
 *
 */

public class Main {

	/*
	 * FUNCTIONALITY I HAVE THOUGHT DROPPING PADMESSAGE AND PARSEMESSAGE FUNCTIONS
	 * FROM THE CONSTRUCTOR THINK OF WHETHER INCLUDING ALTERNATE COMPUTATION METHOD
	 * MAYBE CHANGE ARGUMENT ZEROORONE IN SPLITTERFUNCTION USING BOOLEAN
	 * 
	 * SWING INCLUDE SwingUtilities.invokeLater(new Runnable() { FOR STARTING THE
	 * PROGRAM INCLUDE A RESIZING FACTOR IN ORDER TO EASE THE MOVEMENT OF ELEMENTS
	 * 
	 * ADDITIONAL FUNCTIONALITIES: CREATE AN OPTION TO ESTABLISH THE BITS YOU WANT
	 * TO TRUNCATE WITHIN THE MESSAGE (REGARDLESS THE KNOWN ALGORITHMS) WHAT COMES
	 * TO MY MIND IS TO ADD AN ENTRY BOX TO CHOOSE HOW MANY BITS YOU WANT TO GET AND
	 * AFTER THAT VERIFYING IF THE INPUT LENGTH IS BETWEEN MESSAGEDIGESTLENGTH AND
	 * 4, ALSO CHECK IF THE NUMBER IS MULTIPLE OF 4 BITS IN ORDER TO CONVERT IT
	 * EASILY TO HEXADECIMAL
	 */

	public static void main(String[] args) {
		Main program = new Main();
		program.start();
	}

	private void start() {
		System.out.println("Starting program...\n");

//		new ControllerSHS();
		
		SHA_256 sh = new SHA_256("Hola");
		System.out.println(sh.computeHash());
		System.out.println(sh.computeHash2());

	}

}