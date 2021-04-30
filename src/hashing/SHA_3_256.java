package hashing;

/**
 * 
 * @author Mario Hermida
 *
 */
public class SHA_3_256 extends HashFunction {

	public SHA_3_256(String message, boolean isBinary) {
		System.out.println("\tSHA3-256 ALGORITHM");
		if (isBinary) {
			this.binaryMessage = message;
		} else {
			this.binaryMessage = textToBinary(message);
		}
		// Domain separation
		binaryMessage += "01";
		messageDigestLength = 256;
		width = 1600;
		capacity = messageDigestLength * 2;
		rate = width - capacity;
	}

	public SHA_3_256(String message) {
		this(message, false);
	}

	@Override
	String computeHash() {
		return KECCAK();
	}

}