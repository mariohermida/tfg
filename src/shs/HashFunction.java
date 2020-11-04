package shs;

import java.util.ArrayList;

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
	 * The idea is to have a message with length multiple of 512/1024 (block size)
	 * The messagePadded is built this way: original binary message + 1 + as many 0s
	 * as we need + length of the original message in binary (reserving 64/128 bits here)
	 * 
	 * @return The message padded with determined number of zeroes
	 */
	public String padMessage(String originalMessage) {
		String messagePadded = originalMessage, messageBinaryLength = "";
		//the previous 1
		if (messagePadded.length() < blockSize-maximumMessageSize) {
			messagePadded += "1";
		}
		//as many zeroes as we need
		while (messagePadded.length() < blockSize-maximumMessageSize) {
			messagePadded += "0";
		}
		//binary length representation of the original message (64/128 bits)
		messageBinaryLength = Integer.toBinaryString(originalMessage.length());
		while (messageBinaryLength.length() < maximumMessageSize) {
			messageBinaryLength = "0" + messageBinaryLength;
		}
		messagePadded = messagePadded + messageBinaryLength;
		System.out.println("Message padded: " + messagePadded);
		return messagePadded;
	}
	
	public ArrayList<String> parseMessage(String binarySequence) {
		ArrayList<String> words = new ArrayList<>();
		for (int i = 0; i < binarySequence.length(); i+=wordSize) {
			words.add(binarySequence.substring(i, i+wordSize));
		}
		return words;
	}

}
