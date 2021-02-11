package shs;

import java.nio.charset.StandardCharsets;

/**
 * 
 * @author Mario Hermida
 *
 */

public class Main {

	/*
	 * FUNCTIONALITY I HAVE THOUGHT DROPPING PADMESSAGE AND PARSEMESSAGE FUNCTIONS
	 * FROM THE CONSTRUCTOR THINK OF WHETHER INCLUDING ALTERNATE COMPUTATION METHOD
	 * FOR SHA-1 CHECK IF BIGINTEGER CAN BE USED MORE OFTEN INSTEAD OF STRING SHA-1
	 * ALGORITHM CAN BE USED WITH INTEGERS ONLY WATCH OUT WITH INTEGERS AND LONG
	 * (PARSE WHEN NECESSARY) MAYBE CHANGE ARGUMENT ZEROORONE IN SPLITTERFUNCTION
	 * USING BOOLEAN CHANGE MESSAGE SCHEDULE TO W AND CONVERT IT TO ARRAY INSTEAD OF
	 * ARRAYLIST INCLUDE ALL METHODS WITHIN THE CLASS HASHFUNCTION (BOTH STRING AND
	 * INTEGER)
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
		
		new ControllerSHS();

		byte[] byteArray = "a".getBytes(StandardCharsets.UTF_8);
		String binaryCharacter, binaryMessage = "";
		for (byte b : byteArray) {
			// binaryCharacter = Integer.toBinaryString(b);
			System.out.println(Integer.toBinaryString(b));
			binaryCharacter = Integer.toBinaryString((b & 0xFF) + 0x100).substring(1);
			System.out.println(binaryCharacter);
			binaryMessage += binaryCharacter;
		}
		System.out.println(binaryMessage);

		byte num = -128;
		for (int i = 0; i < 256; i++) {
			String cad = Integer.toBinaryString((num & 0xff) + 0x100).substring(1);
			num++;
			if (cad.length() != 8) {
				System.out.println("error Man");
			}
		}

	}

}