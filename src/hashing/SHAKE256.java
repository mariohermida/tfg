package hashing;

/**
 * 
 * @author Mario Hermida
 *
 */
public class SHAKE256 extends HashFunction {

	public SHAKE256(String message, int outputLength ,boolean isBinary) {
		System.out.println("\tSHA3-224 ALGORITHM");
		if (isBinary) {
			this.binaryMessage = invertBits(message);
		} else {
			this.binaryMessage = invertBits(textToBinary(message));
		}
		System.out.println(binaryMessage);
		// Domain separation
		binaryMessage += "1111";
		messageDigestLength = outputLength;
		width = 1600;
		capacity = 512;
		rate = width - capacity;
	}
	
	public SHAKE256(String message, int outputLength) {
		this(message, outputLength, false);
	}

	@Override
	String computeHash() {
		return KECCAK();
	}

}