package hashing;

import java.util.ArrayList;

/**
 * 
 * @author Mario Hermida
 *
 */
public class SHA_512_224 extends HashFunction {

	private long[] initialHashValues = { 0x8c3d37c819544da2L, 0x73e1996689dcd4d6L, 0x1dfab7ae32ff9c82L,
			0x679dd514582f9fcfL, 0x0f6d2b697bd44da8L, 0x77e36f7304c48942L, 0x3f9d85a86a1d36c8L, 0x1112e6ad91d692a1L };
	private String[] initialHashValues2 = { "8c3d37c819544da2", "73e1996689dcd4d6", "1dfab7ae32ff9c82",
			"679dd514582f9fcf", "0f6d2b697bd44da8", "77e36f7304c48942", "3f9d85a86a1d36c8", "1112e6ad91d692a1" };

	public SHA_512_224(String message, boolean isBinary) {
		System.out.println("\tSHA-512/224 ALGORITHM");
		if (isBinary) {
			this.binaryMessage = message;
		} else {
			this.binaryMessage = textToBinary(message);
		}
		messageDigestLength = 224;
		wordSize = 64;
		maximumMessageLength = 128;
		blockSize = 1024;
		words = new ArrayList<>();
		padMessageSHS();
		parseMessage();
	}

	public SHA_512_224(String message) {
		this(message, false);
	}

	@Override
	String computeHash() {
		return computeSHA2Hash(initialHashValues, 80, 2);
	}

	String computeHash2() {
		return computeSHA2Hash(initialHashValues2, 80, 2);
	}

}