package shs;

import java.util.ArrayList;

/**
 * 
 * @author Mario Hermida
 *
 */
public class SHA_384 extends HashFunction {

	private String[] hashValues = { "cbbb9d5dc1059ed8", "629a292a367cd507", "9159015a3070dd17",
			"152fecd8f70e5939", "67332667ffc00b31", "8eb44a8768581511", "db0c2e0d64f98fa7", "47b5481dbefa4fa4" };

	public SHA_384(String message, boolean isBinary) {
		System.out.println("\tSHA-384 ALGORITHM");
		if (isBinary) {
			this.binaryMessage = message;
		} else {
			this.binaryMessage = textToBinary(message);
		}
		messageDigestLength = 384;
		wordSize = 64;
		maximumMessageLength = 128;
		blockSize = 1024;
		words = new ArrayList<>();
		padMessage();
		parseMessage();
	}
	
	public SHA_384(String message) {
		this(message, false);
	}
	
	@Override
	String computeHash() {
		SHA_512 sh = new SHA_512(binaryMessage, true);
		return sh.computeHashOperation(hashValues).substring(0, 96);
	}

}
