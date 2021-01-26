package shs;

import java.util.ArrayList;

/**
 * 
 * @author Mario Hermida
 *
 */
public class SHA_224 extends HashFunction {

	private String[] hashValues = { "c1059ed8", "367cd507", "3070dd17", "f70e5939", "ffc00b31", "68581511", "64f98fa7",
			"befa4fa4" };

	public SHA_224(String message, boolean isBinary) {
		System.out.println("\tSHA-224 ALGORITHM");
		if (isBinary) {
			this.binaryMessage = message;
		} else {
			this.binaryMessage = textToBinary(message);
		}
		messageDigestLength = 224;
		wordSize = 32;
		maximumMessageLength = 64;
		blockSize = 512;
		words = new ArrayList<>();
		padMessage();
		parseMessage();
	}

	public SHA_224(String message) {
		this(message, false);
	}

	@Override
	public String computeHash() {
		return computeSHA2Hash(hashValues, 64, 1).substring(0, messageDigestLength / 4);
	}

}