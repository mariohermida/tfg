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
		System.out.println(binaryMessage);
		messageDigestLength = 224;
		wordSize = 1600 - messageDigestLength*2;
		System.out.println(wordSize);
		//pad message
	}
	
	public SHA_3_224(String message) {
		this(message, false);
	}

	@Override
	String computeHash() {
		return "Hexadecimal hash";
	}

}