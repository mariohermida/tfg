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
	 * 
	 * CONTROL OVER CONSTRUCTOR SHA_*(*,TRUE) -> BINARY STRINGS
	 * 
	 * SWING INCLUDE SwingUtilities.invokeLater(new Runnable() { FOR STARTING THE
	 * PROGRAM INCLUDE A RESIZING FACTOR IN ORDER TO EASE THE MOVEMENT OF ELEMENTS
	 * 
	 */

	public static void main(String[] args) {
		Main program = new Main();
		program.start();
	}

	private void start() {
		System.out.println("Starting program...\n");

//		new ControllerSHS();
		
		SHA_224 sh = new SHA_224("Hola");
		sh.computeHash2();

	}

}