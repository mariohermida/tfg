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
			this.binaryMessage = invertBits(message);
		} else {
			this.binaryMessage = invertBits(textToBinary(message));
		}
		System.out.println(binaryMessage);
		// Domain separation
		binaryMessage += "01";
		messageDigestLength = 224;
		width = 1600;
		capacity = messageDigestLength*2;
		rate = width - capacity;
	}
	
	public SHA_3_224(String message) {
		this(message, false);
	}

	@Override
	String computeHash() {
		return KECCAK();
	}

}