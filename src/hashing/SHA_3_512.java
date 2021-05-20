package hashing;

/**
 * 
 * @author Mario Hermida
 *
 */
public class SHA_3_512 extends HashFunction {

	public SHA_3_512(String message, boolean isBinary) {
		System.out.println("\tSHA3-512 ALGORITHM");
		if (isBinary) {
			this.binaryMessage = invertBits(message);
		} else {
			this.binaryMessage = invertBits(textToBinary(message));
		}
		// Domain separation
		binaryMessage += "01";
		messageDigestLength = 512;
		width = 1600;
		capacity = messageDigestLength * 2;
		rate = width - capacity;
	}
	
	public SHA_3_512(String message) {
		this(message, false);
	}

	@Override
	String computeHash() {
		return KECCAK();
	}

}