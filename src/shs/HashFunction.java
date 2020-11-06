package shs;

import java.math.BigInteger;
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
		System.out.println("Message padded: " + "\t" + messagePadded);
		return messagePadded;
	}
	
	/**
	 * The goal here is to have 16 binary words (32/64 bits long)
	 * according to the word size of the algorithm chosen
	 * 
	 * @param binarySequence 512/1024 bits long padded sequence to be parsed
	 * @return A list composed of the 16 binary words
	 */
	public ArrayList<String> parseMessage(String binarySequence) {
		ArrayList<String> words = new ArrayList<>();
		for (int i = 0; i < binarySequence.length(); i+=wordSize) {
			words.add(binarySequence.substring(i, i+wordSize));
		}
		return words;
	}	
	
	/**
	 * When a left circular rotation takes place, the idea is that the
	 * bits that are discarded are appended from the right
	 * 
	 * @param sequence Binary sequence to be rotated
	 * @param n Times the sequence is rotated
	 * @return The binary sequence left-rotated n times
	 */
	public String ROTL(String sequence, int n) {
		String result;
		BigInteger b1 = new BigInteger(leftShiftOperation(sequence, n), 2);
		BigInteger b2 = new BigInteger(rightShiftOperation(sequence, sequence.length()-n), 2);
		result = b1.or(b2).toString(2);
		while (result.length() < sequence.length()) {
			result = "0" + result; 
		}
		return result;
	}
	
	/**
	 * When a right circular rotation takes place, the idea is that the
	 * bits that are discarded are appended from the left
	 * 
	 * @param sequence Binary sequence to be rotated
	 * @param n Times the sequence is rotated
	 * @return The binary sequence right-rotated n times
	 */
	public String ROTR(String sequence, int n) {
		String result;
		BigInteger b1 = new BigInteger(rightShiftOperation(sequence, n), 2);
		BigInteger b2 = new BigInteger(leftShiftOperation(sequence, sequence.length()-n), 2);
		result = b1.or(b2).toString(2);
		while (result.length() < sequence.length()) {
			result = result + "0";
		}
		return result;
	}
	
	/**
	 * Same operation as right shift
	 * 
	 * @param sequence
	 * @param n
	 * @return
	 */
	public String SHR(String sequence, int n) {
		return rightShiftOperation(sequence, n);
	}
	
	/**
	 * The left-most n bits are discarded, padding
	 * the result with n zeroes on the right
	 * 
	 * @param sequence Binary sequence to be modified
	 * @param n Number of zeroes padded
	 * @return left-shift binary sequence
	 */
	private String leftShiftOperation(String sequence, int n) {
		int start = n;
		while (n != 0) {
			sequence = sequence + "0";
			n--;
		}
		return sequence.substring(start, sequence.length());
	}
	
	/**
	 * The right-most n bits are discarded, padding
	 * the result with n zeroes on the left
	 * 
	 * @param sequence Binary sequence to be modified
	 * @param n Number of zeroes padded
	 * @return right-shift binary sequence
	 */
	private String rightShiftOperation(String sequence, int n) {
		int end = n;
		while (n != 0) {
			sequence = "0" + sequence;
			n--;
		}
		return sequence.substring(0, sequence.length()-end);
	}

}
