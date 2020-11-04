package shs;

/**
 * 
 * @author Mario Hermida
 *
 */
public class SHA_1 extends HashFunction {

	/*private String[] constants = {"5a827999", "6ed9eba1", "8f1bbcdc", "ca62c1d6"};
	private String[] initialHashValues = {"67452301", "efcdab89", "98badcfe", "10325476", "c3d2e1f0"};*/
	private String binaryMessage;
	private String binaryMessagePadded;
	
	public SHA_1(String binaryMessage) {
		this.binaryMessage = binaryMessage;
		messageDigest = 160;
		wordSize = 32;
		maximumMessageSize = 64; 
		blockSize = 512;
		binaryMessagePadded = padMessage(binaryMessage);
	}
	
}
