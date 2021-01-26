package shs;

import java.util.ArrayList;

/**
 * 
 * @author Mario Hermida
 *
 */
public class SHA_256 extends HashFunction {

	private String[] hashValues = { "6a09e667", "bb67ae85", "3c6ef372", "a54ff53a", "510e527f", "9b05688c", "1f83d9ab",
			"5be0cd19" };

	public SHA_256(String message, boolean isBinary) {
		System.out.println("\tSHA-256 ALGORITHM");
		if (isBinary) {
			this.binaryMessage = message;
		} else {
			this.binaryMessage = textToBinary(message);
		}
		messageDigestLength = 256;
		wordSize = 32;
		maximumMessageLength = 64;
		blockSize = 512;
		words = new ArrayList<>();
		padMessage();
		parseMessage();
	}

	public SHA_256(String message) {
		this(message, false);
	}

	@Override
	public String computeHash() {
		return computeSHA2Hash(hashValues, 64, 1);
	}

}