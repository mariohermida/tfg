package shs;

import java.util.ArrayList;

/**
 * 
 * @author Mario Hermida
 *
 */
public class SHA_256 extends HashFunction {

	private long[] initialHashValues = { 0x6a09e667, 0xbb67ae85, 0x3c6ef372, 0xa54ff53a, 0x510e527f, 0x9b05688c,
			0x1f83d9ab, 0x5be0cd19 };
	private String[] initialHashValues2 = { "6a09e667", "bb67ae85", "3c6ef372", "a54ff53a", "510e527f", "9b05688c",
			"1f83d9ab", "5be0cd19" };

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
		return computeSHA2Hash(initialHashValues, 64, 1);
	}

	public String computeHash2() {
		return computeSHA2Hash2(initialHashValues2, 64, 1);
	}

}