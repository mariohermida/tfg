package shs;

import java.util.ArrayList;

/**
 * 
 * @author Mario Hermida
 *
 */
public class SHA_512_256 extends HashFunction {

	private String[] hashValues = { "22312194fc2bf72c", "9f555fa3c84c64c2", "2393b86b6f53b151",
			"963877195940eabd", "96283ee2a88effe3", "be5e1e2553863992", "2b0199fc2c85b8aa", "0eb72ddc81c52ca2" };

	public SHA_512_256(String message, boolean isBinary) {
		System.out.println("\tSHA-512/256 ALGORITHM");
		if (isBinary) {
			this.binaryMessage = message;
		} else {
			this.binaryMessage = textToBinary(message);
		}
		messageDigestLength = 256;
		wordSize = 64;
		maximumMessageLength = 128;
		blockSize = 1024;
		words = new ArrayList<>();
		padMessage();
		parseMessage();
	}
	
	public SHA_512_256(String message) {
		this(message, false);
	}
	
	@Override
	String computeHash() {
		// TODO Auto-generated method stub
		return null;
	}

}
