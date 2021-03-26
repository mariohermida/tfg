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

	public static void main(String[] args) throws Exception {
		Main program = new Main();
		program.start();
//		new ViewSHS2(null);
	}

	private void start() {
		System.out.println("Starting program...\n");

		new ControllerSHS();
		
		/*SHA_512 sh = new SHA_512("SHA-512/256");
//		System.out.println(sh.computeHash2());
		String a[] = new String[8];
		for (int i = 0; i < 8; i++) {
			a[i] = sh.hexadecimalToBinary(sh.initialHashValues2[i]);
		}
		String b = sh.hexadecimalToBinary("a5a5a5a5a5a5a5a5");
		String temp[] = new String[8];
		for (int j = 0; j < 8; j++) {
			temp[j] = "";
			for (int i = 0; i < b.length(); i++) {
				temp[j] += (a[j].charAt(i) ^ b.charAt(i));
			}
		}
		for (int i = 0; i < 8; i++) {
			temp[i] = sh.binaryToHexadecimal(temp[i]);
		}
		for (int i = 0; i < 128; i+=16) {
			System.out.println(sh.computeSHA2Hash(temp, 80, 2).substring(i, i+16));
		}*/

	}

}