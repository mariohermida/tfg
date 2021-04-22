package hashing;

/**
 * 
 * @author Mario Hermida
 *
 */
public class SHA_3_224 extends HashFunction {

	public SHA_3_224(String message, boolean isBinary) {
		System.out.println("\tSHA3-224 ALGORITHM");
		if (isBinary) {
			this.binaryMessage = message;
		} else {
			this.binaryMessage = textToBinary(message);
		}
		// Add bits that indicate domain separation
		binaryMessage += "01";
		messageDigestLength = 224;
		width = 1600;
		capacity = messageDigestLength*2;
		rate = width - capacity;
		KECCAK();
		System.out.println(binaryMessagePadded);
	}
	
	public SHA_3_224(String message) {
		this(message, false);
	}

	@Override
	String computeHash() {
		return binaryMessagePadded;
	}

}