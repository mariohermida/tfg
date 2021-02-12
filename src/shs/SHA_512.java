package shs;

import java.util.ArrayList;

/**
 * 
 * @author Mario Hermida
 *
 */
public class SHA_512 extends HashFunction {

	private long[] initialHashValues = { 0x6a09e667f3bcc908L, 0xbb67ae8584caa73bL, 0x3c6ef372fe94f82bL,
			0xa54ff53a5f1d36f1L, 0x510e527fade682d1L, 0x9b05688c2b3e6c1fL, 0x1f83d9abfb41bd6bL, 0x5be0cd19137e2179L };
	private String[] initialHashValues2 = { "6a09e667f3bcc908", "bb67ae8584caa73b", "3c6ef372fe94f82b",
			"a54ff53a5f1d36f1", "510e527fade682d1", "9b05688c2b3e6c1f", "1f83d9abfb41bd6b", "5be0cd19137e2179" };

	public SHA_512(String message, boolean isBinary) {
		System.out.println("\tSHA-512 ALGORITHM");
		if (isBinary) {
			this.binaryMessage = message;
		} else {
			this.binaryMessage = textToBinary(message);
		}
		messageDigestLength = 512;
		wordSize = 64;
		maximumMessageLength = 128;
		blockSize = 1024;
		words = new ArrayList<>();
		padMessage();
		parseMessage();
	}

	public SHA_512(String message) {
		this(message, false);
	}

	@Override
	public String computeHash() {
		return computeSHA2Hash(initialHashValues, 80, 2);
	}

	public String computeHash2() {
		return computeSHA2Hash2(initialHashValues2, 80, 2);
	}

}