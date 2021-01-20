package shs;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * 
 * @author Mario Hermida
 *
 */
public abstract class HashFunction {

	protected String binaryMessage; // Original binary message
	protected String binaryMessagePadded; // Binary message (multiple of 512/1024 bits)
	protected ArrayList<String> blocks; // Binary padded message divided into blocks
	protected ArrayList<ArrayList<String>> words; // 32/64-bits words extracted from every block
	protected int messageDigestLength; // Number of bits resulted from hash computation
	protected int wordSize;
	protected int blockSize;
	protected int maximumMessageLength; // Maximum amount of bits for representing message length

	/**
	 * Computes the final hash according to the algorithm chosen
	 * 
	 * @return Hexadecimal hash resulted from the original message
	 */
	// ADDITION IS PERFORMED MODULO 2^wordSize
	abstract String computeHash();

	/**
	 * The idea is to have a message whose length is multiple of 512/1024 (block
	 * size) The binaryMessagePadded is built this way: original binary message + 1
	 * + as many 0s as needed + length of the original message in binary (reserving
	 * 64/128 (maximumMessageSize) bits here)
	 * 
	 * @return The message padded with determined number of zeroes
	 */
	protected void padMessage() {
		binaryMessagePadded = binaryMessage;
//		int numberOfBlocks = 1;
		int auxLength = binaryMessage.length();
		boolean isPaddingInTwoBlocks = false;

		// Message length management
		if (binaryMessage.length() > Math.pow(2, maximumMessageLength)) {
			throw new IllegalArgumentException("Input message exceeds maximum length allowed");
		}

		// Detect if there is going to be padding in two blocks
		while (auxLength > blockSize) {
//			numberOfBlocks++;
			auxLength -= blockSize;
		} // auxLength value here is equal or less than blockSize
		if (auxLength >= blockSize - maximumMessageLength) {
//			numberOfBlocks++;
			isPaddingInTwoBlocks = true;
		}
//		System.out.println("Number of blocks: " + numberOfBlocks);

		// Deal with padding
		int bitsToAdd = (blockSize - maximumMessageLength) - auxLength;
		if (isPaddingInTwoBlocks) {
			bitsToAdd += maximumMessageLength; // Add bits for padding the second last block
			bitsToAdd += blockSize - maximumMessageLength; // Add bits for wholly padding the last block
		}
		binaryMessagePadded = addPadding(binaryMessagePadded, bitsToAdd);

		// Binary length representation of the original message (64/128 bits)
		String binaryMessageLength = Integer.toBinaryString(binaryMessage.length());
		while (binaryMessageLength.length() < maximumMessageLength) {
			binaryMessageLength = "0" + binaryMessageLength;
		}
		binaryMessagePadded = binaryMessagePadded + binaryMessageLength;

		// Division into blocks
		for (int i = 0; i < binaryMessagePadded.length();) {
			blocks.add(binaryMessagePadded.substring(i, i += blockSize));
		}
	}

	/**
	 * It fills the message with a 1 and as 0s as needed
	 * 
	 * @param message
	 * @param numberOfBitsToAdd
	 * @return Message with convenient padding added
	 */
	private String addPadding(String message, int numberOfBitsToAdd) {
		message += "1";
		numberOfBitsToAdd--;
		while (numberOfBitsToAdd > 0) {
			message += "0";
			numberOfBitsToAdd--;
		}
		return message;
	}

	/**
	 * The goal here is to have 16 binary words (32/64 bits long) according to the
	 * word size of the algorithm chosen
	 * 
	 * @return A list composed of the 16 binary words
	 */
	protected void parseMessage() {
		ArrayList<String> temp = null;
		for (int i = 0; i < blocks.size(); i++) {
			temp = new ArrayList<>();
			for (int j = 0; j < blocks.get(i).length(); j += wordSize) {
				temp.add(blocks.get(i).substring(j, j + wordSize));
			}
			words.add(temp);
		}
	}

	/**
	 * f function, used at the time of computing only SHA-1 algorithm. Depending on
	 * the value of index it redirects the input to the right function
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @param index Variable in charge of selecting the right logical function
	 * @return 32-bit word resulted from the convenient logical function
	 */
	public String f(String x, String y, String z, int index) {
		if (index >= 0 && index <= 19) {
			return Ch(x, y, z);
		} else if (index >= 20 && index <= 39) {
			return Parity(x, y, z);
		} else if (index >= 40 && index <= 59) {
			return Maj(x, y, z);
		} else if (index >= 60 && index <= 79) {
			return Parity(x, y, z);
		}
		throw new IllegalArgumentException("Invalid parameters introduced in f function (SHA-1)");
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
		// Keeping original length
		while (result1.length() < x.length()) {
			result1 = "0" + result1;
		}
		while (result2.length() < x.length()) {
			result2 = "0" + result2;
		}
		for (int i = 0; i < x.length(); i++) {
			finalResult += (result1.charAt(i) ^ result2.charAt(i));
		}
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
		// Keeping original length
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
		return finalResult;
	}

	/**
	 * It identifies the different sigma operations according to the following
	 * parameters: wordLength, upperOrLower and zeroOrOne
	 * 
	 * @param word         The binary word to be changed
	 * @param wordLength   Word length (32 or 64) (bits)
	 * @param upperOrLower Represents the kind of sigma operation (upper or lower)
	 * @param zeroOrOne    Represents the kind of sigma operation (0 or 1)
	 * @return The binary word modified according to the right sigma function
	 */
	public String sigmaFunctionSplitter(String word, int wordLength, String upperOrLower, int zeroOrOne) {
		switch (wordLength) {
		case 32:
			switch (upperOrLower) {
			case "upper":
				switch (zeroOrOne) {
				case 0:
					return sigmaFunctionOperation(word, 2, 13, 22, false);
				case 1:
					return sigmaFunctionOperation(word, 6, 11, 25, false);
				}
			case "lower":
				switch (zeroOrOne) {
				case 0:
					return sigmaFunctionOperation(word, 7, 18, 3, true);
				case 1:
					return sigmaFunctionOperation(word, 17, 19, 10, true);
				}
			}
		case 64:
			switch (upperOrLower) {
			case "upper":
				switch (zeroOrOne) {
				case 0:
					return sigmaFunctionOperation(word, 28, 34, 39, false);
				case 1:
					return sigmaFunctionOperation(word, 14, 18, 41, false);
				}
			case "lower":
				switch (zeroOrOne) {
				case 0:
					return sigmaFunctionOperation(word, 1, 8, 7, true);
				case 1:
					return sigmaFunctionOperation(word, 19, 61, 6, true);
				}
			}
		}
		throw new IllegalArgumentException("Invalid parameters introduced in Sigma function");
	}

	/**
	 * Performs the sigma operation taking into account the different values
	 * explicited within the parameters
	 * 
	 * @param word       Binary word to be changed
	 * @param parameter1 Number of rotations
	 * @param parameter2 Number of rotations
	 * @param parameter3 Number of rotations
	 * @param SHR        Represents if SHR is used instead of ROTR
	 * @return ROTR(parameter1)(word) XOR ROTR(parameter2)(word) XOR
	 *         (ROTR(parameter3)(word) | SHR(parameter3)(word))
	 */
	private String sigmaFunctionOperation(String word, int parameter1, int parameter2, int parameter3,
			boolean SHR) {
		String result = "", finalResult = "";
		String rotation1 = ROTR(word, parameter1), rotation2 = ROTR(word, parameter2), rotation3;
		if (SHR) {
			rotation3 = SHR(word, parameter3);
		} else {
			rotation3 = ROTR(word, parameter3);
		}
		for (int i = 0; i < word.length(); i++) {
			result += rotation1.charAt(i) ^ rotation2.charAt(i);
		}
		for (int i = 0; i < word.length(); i++) {
			finalResult += result.charAt(i) ^ rotation3.charAt(i);
		}
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
			result = "0" + result;
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
	public String leftShiftOperation(String sequence, int n) {
		int start = n;
		if (n < 0) {
			throw new NumberFormatException("Cannot left shift bits a negative number of times.");
		}
		while (n > 0) {
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
	 * @throws Exception
	 */
	public String rightShiftOperation(String sequence, int n) {
		int end = n;
		if (n < 0) {
			throw new NumberFormatException("Cannot right shift bits a negative number of times.");
		}
		while (n > 0) {
			sequence = "0" + sequence;
			n--;
		}
		return sequence.substring(0, sequence.length() - end);
	}

}
