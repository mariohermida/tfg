package shs;

import java.util.ArrayList;

/**
 * 
 * @author Mario Hermida
 *
 */
public class SHA_512 extends HashFunction {

	private String[] hashValues = { "6a09e667f3bcc908", "bb67ae8584caa73b", "3c6ef372fe94f82b", "a54ff53a5f1d36f1",
			"510e527fade682d1", "9b05688c2b3e6c1f", "1f83d9abfb41bd6b", "5be0cd19137e2179" };

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
		return computeSHA2Hash(hashValues, 80, 2);
	}

}