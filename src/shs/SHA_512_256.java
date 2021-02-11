package shs;

import java.util.ArrayList;

/**
 * 
 * @author Mario Hermida
 *
 */
public class SHA_512_256 extends HashFunction {

	private long[] hashValues = { 0x22312194fc2bf72cL, 0x9f555fa3c84c64c2L, 0x2393b86b6f53b151L, 0x963877195940eabdL,
			0x96283ee2a88effe3L, 0xbe5e1e2553863992L, 0x2b0199fc2c85b8aaL, 0x0eb72ddc81c52ca2L };
	private String[] hashValues2 = { "22312194fc2bf72c", "9f555fa3c84c64c2", "2393b86b6f53b151", "963877195940eabd",
			"96283ee2a88effe3", "be5e1e2553863992", "2b0199fc2c85b8aa", "0eb72ddc81c52ca2" };

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
		return computeSHA2Hash(hashValues, 80, 2);
	}

	String computeHash2() {
		return computeSHA2Hash2(hashValues2, 80, 2);
	}

}