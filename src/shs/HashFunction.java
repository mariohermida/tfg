package shs;

/**
 * 
 * @author Mario Hermida
 *
 */
public class HashFunction {
	
	int messageDigest;
	int wordSize;
	int blockSize;
	int maximumMessageSize;
	String[] constants; //has to be changed
	String[] initialHashValues; //has to be changed
	
	/**
	 * 
	 * @return The message padded with zeroes
	 */
	public String padMessage(String message) {
		String messagePadded, messageLength = ""; 
		messagePadded = message;
		if (messagePadded.length() < blockSize-maximumMessageSize) {
			messagePadded += "1";
		}
		while (messagePadded.length() < blockSize-maximumMessageSize) {
			messagePadded += "0";
		}
		messageLength = binaryLength(message);
		while (messageLength.length() < maximumMessageSize) {
			messageLength = "0" + messageLength;
		}
		messagePadded = messagePadded + messageLength;
		System.out.println("Message padded: " + messagePadded);
		return messagePadded;
	}
	
	private String binaryLength(String sequence) {
		System.out.println("Sequence length: " + Integer.toBinaryString(sequence.length()));
		return Integer.toBinaryString(sequence.length());
	}

}
