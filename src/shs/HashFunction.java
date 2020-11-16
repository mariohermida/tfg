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
	 * as we need + length of the original message in binary (reserving 64/128 bits
	 * here)
	 * 
	 * @return The message padded with determined number of zeroes
	 */
	public String padMessage(String originalMessage) {
		String messagePadded = originalMessage, messageBinaryLength = "";
		// the previous 1
		if (messagePadded.length() < blockSize - maximumMessageSize) {
			messagePadded += "1";
		}
		// as many zeroes as we need
		while (messagePadded.length() < blockSize - maximumMessageSize) {
			messagePadded += "0";
		}
		// binary length representation of the original message (64/128 bits)
		messageBinaryLength = Integer.toBinaryString(originalMessage.length());
		while (messageBinaryLength.length() < maximumMessageSize) {
			messageBinaryLength = "0" + messageBinaryLength;
		}
		messagePadded = messagePadded + messageBinaryLength;
		System.out.println("Message padded: " + "\t" + messagePadded);
		return messagePadded;
	}

	/**
	 * The goal here is to have 16 binary words (32/64 bits long) according to the
	 * word size of the algorithm chosen
	 * 
	 * @param binarySequence 512/1024 bits long padded sequence to be parsed
	 * @return A list composed of the 16 binary words
	 */
	public ArrayList<String> parseMessage(String binarySequence) {
		ArrayList<String> words = new ArrayList<>();
		for (int i = 0; i < binarySequence.length(); i += wordSize) {
			words.add(binarySequence.substring(i, i + wordSize));
		}
		return words;
	}

	/**
	 * Ch function
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @return (x AND y) XOR (~x AND z)
	 */
	public String Ch(String x, String y, String z) {
		String result1, result2, finalResult = "";
		BigInteger bx = new BigInteger(x, 2);
		BigInteger by = new BigInteger(y, 2);
		BigInteger bz = new BigInteger(z, 2);
		result1 = bx.and(by).toString(2);
		result2 = bz.andNot(bx).toString(2);
		//Keeping original length
		while (result1.length() < x.length()) {
			result1 = "0" + result1;
		}
		while (result2.length() < x.length()) {
			result2 = "0" + result2;
		}
		for (int i = 0; i < x.length(); i++) {
			finalResult += (result1.charAt(i) ^ result2.charAt(i));
		}
		System.out.println("x:\t" + x);
		System.out.println("y:\t" + y);
		System.out.println("z:\t" + z);
		System.out.println("Res:\t" + finalResult);
		return finalResult;
	}

	/**
	 * Parity function
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @return x XOR y XOR z
	 */
	public String Parity(String x, String y, String z) {
		String result = "", finalResult = "";
		for (int i = 0; i < x.length(); i++) {
			result += (x.charAt(i) ^ y.charAt(i));
		}
		for (int i = 0; i < x.length(); i++) {
			finalResult += (result.charAt(i) ^ z.charAt(i));
		}
		System.out.println("x:\t" + x);
		System.out.println("y:\t" + y);
		System.out.println("z:\t" + z);
		System.out.println("Res:\t" + finalResult);
		return finalResult;
	}

	/**
	 * Maj function
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @return (x AND y) XOR (x AND z) XOR (y AND z)
	 */
	public String Maj(String x, String y, String z) {
		String result1, result2, result3, result4 = "", finalResult = "";
		BigInteger bx = new BigInteger(x, 2);
		BigInteger by = new BigInteger(y, 2);
		BigInteger bz = new BigInteger(z, 2);
		result1 = bx.and(by).toString(2);
		result2 = bx.and(bz).toString(2);
		result3 = by.and(bz).toString(2);
		//Keeping original length
		while (result1.length() < x.length()) {
			result1 = "0" + result1;
		}
		while (result2.length() < x.length()) {
			result2 = "0" + result2;
		}
		while (result3.length() < x.length()) {
			result3 = "0" + result3;
		}
		for (int i = 0; i < x.length(); i++) {
			result4 += (result1.charAt(i) ^ result2.charAt(i));
		}
		for (int i = 0; i < x.length(); i++) {
			finalResult += (result4.charAt(i) ^ result3.charAt(i));
		}
		System.out.println("x:\t" + x);
		System.out.println("y:\t" + y);
		System.out.println("z:\t" + z);
		System.out.println("Res:\t" + finalResult);
		return finalResult;
	}

	/**
	 * When a left circular rotation takes place, the idea is that the bits that are
	 * discarded are appended from the right
	 * 
	 * @param sequence Binary sequence to be rotated
	 * @param n        Times the sequence is rotated
	 * @return The binary sequence left-rotated n times
	 */
	public String ROTL(String sequence, int n) {
		String result;
		BigInteger b1 = new BigInteger(leftShiftOperation(sequence, n), 2);
		BigInteger b2 = new BigInteger(rightShiftOperation(sequence, sequence.length() - n), 2);
		result = b1.or(b2).toString(2);
		while (result.length() < sequence.length()) {
			result = "0" + result;
		}
		return result;
	}

	/**
	 * When a right circular rotation takes place, the idea is that the bits that
	 * are discarded are appended from the left
	 * 
	 * @param sequence Binary sequence to be rotated
	 * @param n        Times the sequence is rotated
	 * @return The binary sequence right-rotated n times
	 */
	public String ROTR(String sequence, int n) {
		String result;
		BigInteger b1 = new BigInteger(rightShiftOperation(sequence, n), 2);
		BigInteger b2 = new BigInteger(leftShiftOperation(sequence, sequence.length() - n), 2);
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
	 * The left-most n bits are discarded, padding the result with n zeroes on the
	 * right
	 * 
	 * @param sequence Binary sequence to be modified
	 * @param n        Number of zeroes padded
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
	 * The right-most n bits are discarded, padding the result with n zeroes on the
	 * left
	 * 
	 * @param sequence Binary sequence to be modified
	 * @param n        Number of zeroes padded
	 * @return right-shift binary sequence
	 */
	private String rightShiftOperation(String sequence, int n) {
		int end = n;
		while (n != 0) {
			sequence = "0" + sequence;
			n--;
		}
		return sequence.substring(0, sequence.length() - end);
	}

}
