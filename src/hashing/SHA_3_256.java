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
		System.out.println(binaryMessage);
		//pad message
	}
	
	public SHA_3_256(String message) {
		this(message, false);
	}

	@Override
	String computeHash() {
		return "Hexadecimal hash";
	}

}