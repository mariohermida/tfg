package version1;

/**
 * 
 * @author Mario Hermida
 *
 */

public class SHA_1 {

	private int word_length;
	private int bitsDigestMessage;
	private int blockSize;
	private String[] constants = {"5a827999", "6ed9eba1", "8f1bbcdc", "ca62c1d6"};
	private String[] initialHashValues = {"67452301", "efcdab89", "98badcfe", "10325476", "c3d2e1f0"};;
	private String message;
	private String messagePadded;
	
	public SHA_1(String message) {
		word_length = 32;
		bitsDigestMessage = 160;
		blockSize = 512;
		this.message = message;
		padMessage();
	}
	
	/**
	 * 
	 * @return The 512-bit message padded with zeroes
	 */
	private void padMessage() {
		String binaryLength;
		messagePadded = message;
		if (messagePadded.length() < 30) {
			messagePadded += "1";
		}
		while (messagePadded.length() < 30) {
			messagePadded += "0";
		}
		binaryLength = Integer.toBinaryString(message.length());
		while (binaryLength.length() < 5) {
			binaryLength = "0" + binaryLength;
		}
		messagePadded = messagePadded + binaryLength;
		System.out.println(messagePadded);
	}

}
