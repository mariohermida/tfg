package shs;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * 
 * @author Mario Hermida
 *
 */
public abstract class HashFunction {

	static final String[] CONSTANTS1 = { "428a2f98", "71374491", "b5c0fbcf", "e9b5dba5", "3956c25b", "59f111f1",
			"923f82a4", "ab1c5ed5", "d807aa98", "12835b01", "243185be", "550c7dc3", "72be5d74", "80deb1fe", "9bdc06a7",
			"c19bf174", "e49b69c1", "efbe4786", "0fc19dc6", "240ca1cc", "2de92c6f", "4a7484aa", "5cb0a9dc", "76f988da",
			"983e5152", "a831c66d", "b00327c8", "bf597fc7", "c6e00bf3", "d5a79147", "06ca6351", "14292967", "27b70a85",
			"2e1b2138", "4d2c6dfc", "53380d13", "650a7354", "766a0abb", "81c2c92e", "92722c85", "a2bfe8a1", "a81a664b",
			"c24b8b70", "c76c51a3", "d192e819", "d6990624", "f40e3585", "106aa070", "19a4c116", "1e376c08", "2748774c",
			"34b0bcb5", "391c0cb3", "4ed8aa4a", "5b9cca4f", "682e6ff3", "748f82ee", "78a5636f", "84c87814", "8cc70208",
			"90befffa", "a4506ceb", "bef9a3f7", "c67178f2" }; // Used for SHA-256 and SHA-224
	static final String[] CONSTANTS2 = { "428a2f98d728ae22", "7137449123ef65cd", "b5c0fbcfec4d3b2f", "e9b5dba58189dbbc",
			"3956c25bf348b538", "59f111f1b605d019", "923f82a4af194f9b", "ab1c5ed5da6d8118", "d807aa98a3030242",
			"12835b0145706fbe", "243185be4ee4b28c", "550c7dc3d5ffb4e2", "72be5d74f27b896f", "80deb1fe3b1696b1",
			"9bdc06a725c71235", "c19bf174cf692694", "e49b69c19ef14ad2", "efbe4786384f25e3", "0fc19dc68b8cd5b5",
			"240ca1cc77ac9c65", "2de92c6f592b0275", "4a7484aa6ea6e483", "5cb0a9dcbd41fbd4", "76f988da831153b5",
			"983e5152ee66dfab", "a831c66d2db43210", "b00327c898fb213f", "bf597fc7beef0ee4", "c6e00bf33da88fc2",
			"d5a79147930aa725", "06ca6351e003826f", "142929670a0e6e70", "27b70a8546d22ffc", "2e1b21385c26c926",
			"4d2c6dfc5ac42aed", "53380d139d95b3df", "650a73548baf63de", "766a0abb3c77b2a8", "81c2c92e47edaee6",
			"92722c851482353b", "a2bfe8a14cf10364", "a81a664bbc423001", "c24b8b70d0f89791", "c76c51a30654be30",
			"d192e819d6ef5218", "d69906245565a910", "f40e35855771202a", "106aa07032bbd1b8", "19a4c116b8d2d0c8",
			"1e376c085141ab53", "2748774cdf8eeb99", "34b0bcb5e19b48a8", "391c0cb3c5c95a63", "4ed8aa4ae3418acb",
			"5b9cca4f7763e373", "682e6ff3d6b2b8a3", "748f82ee5defb2fc", "78a5636f43172f60", "84c87814a1f0ab72",
			"8cc702081a6439ec", "90befffa23631e28", "a4506cebde82bde9", "bef9a3f7b2c67915", "c67178f2e372532b",
			"ca273eceea26619c", "d186b8c721c0c207", "eada7dd6cde0eb1e", "f57d4f7fee6ed178", "06f067aa72176fba",
			"0a637dc5a2c898a6", "113f9804bef90dae", "1b710b35131c471b", "28db77f523047d84", "32caab7b40c72493",
			"3c9ebe0a15c9bebc", "431d67c49c100d4c", "4cc5d4becb3e42b6", "597f299cfc657e2a", "5fcb6fab3ad6faec",
			"6c44198c4a475817" }; // Used for SHA-512, SHA-384 and SHA-512/t
	static final long[] C1 = { 0x428a2f98, 0x71374491, 0xb5c0fbcf, 0xe9b5dba5, 0x3956c25b, 0x59f111f1, 0x923f82a4,
			0xab1c5ed5, 0xd807aa98, 0x12835b01, 0x243185be, 0x550c7dc3, 0x72be5d74, 0x80deb1fe, 0x9bdc06a7, 0xc19bf174,
			0xe49b69c1, 0xefbe4786, 0x0fc19dc6, 0x240ca1cc, 0x2de92c6f, 0x4a7484aa, 0x5cb0a9dc, 0x76f988da, 0x983e5152,
			0xa831c66d, 0xb00327c8, 0xbf597fc7, 0xc6e00bf3, 0xd5a79147, 0x06ca6351, 0x14292967, 0x27b70a85, 0x2e1b2138,
			0x4d2c6dfc, 0x53380d13, 0x650a7354, 0x766a0abb, 0x81c2c92e, 0x92722c85, 0xa2bfe8a1, 0xa81a664b, 0xc24b8b70,
			0xc76c51a3, 0xd192e819, 0xd6990624, 0xf40e3585, 0x106aa070, 0x19a4c116, 0x1e376c08, 0x2748774c, 0x34b0bcb5,
			0x391c0cb3, 0x4ed8aa4a, 0x5b9cca4f, 0x682e6ff3, 0x748f82ee, 0x78a5636f, 0x84c87814, 0x8cc70208, 0x90befffa,
			0xa4506ceb, 0xbef9a3f7, 0xc67178f2 }; // Used for SHA-256 and SHA-224
	static final long[] C2 = { 0x428a2f98d728ae22L, 0x7137449123ef65cdL, 0xb5c0fbcfec4d3b2fL, 0xe9b5dba58189dbbcL,
			0x3956c25bf348b538L, 0x59f111f1b605d019L, 0x923f82a4af194f9bL, 0xab1c5ed5da6d8118L, 0xd807aa98a3030242L,
			0x12835b0145706fbeL, 0x243185be4ee4b28cL, 0x550c7dc3d5ffb4e2L, 0x72be5d74f27b896fL, 0x80deb1fe3b1696b1L,
			0x9bdc06a725c71235L, 0xc19bf174cf692694L, 0xe49b69c19ef14ad2L, 0xefbe4786384f25e3L, 0x0fc19dc68b8cd5b5L,
			0x240ca1cc77ac9c65L, 0x2de92c6f592b0275L, 0x4a7484aa6ea6e483L, 0x5cb0a9dcbd41fbd4L, 0x76f988da831153b5L,
			0x983e5152ee66dfabL, 0xa831c66d2db43210L, 0xb00327c898fb213fL, 0xbf597fc7beef0ee4L, 0xc6e00bf33da88fc2L,
			0xd5a79147930aa725L, 0x06ca6351e003826fL, 0x142929670a0e6e70L, 0x27b70a8546d22ffcL, 0x2e1b21385c26c926L,
			0x4d2c6dfc5ac42aedL, 0x53380d139d95b3dfL, 0x650a73548baf63deL, 0x766a0abb3c77b2a8L, 0x81c2c92e47edaee6L,
			0x92722c851482353bL, 0xa2bfe8a14cf10364L, 0xa81a664bbc423001L, 0xc24b8b70d0f89791L, 0xc76c51a30654be30L,
			0xd192e819d6ef5218L, 0xd69906245565a910L, 0xf40e35855771202aL, 0x106aa07032bbd1b8L, 0x19a4c116b8d2d0c8L,
			0x1e376c085141ab53L, 0x2748774cdf8eeb99L, 0x34b0bcb5e19b48a8L, 0x391c0cb3c5c95a63L, 0x4ed8aa4ae3418acbL,
			0x5b9cca4f7763e373L, 0x682e6ff3d6b2b8a3L, 0x748f82ee5defb2fcL, 0x78a5636f43172f60L, 0x84c87814a1f0ab72L,
			0x8cc702081a6439ecL, 0x90befffa23631e28L, 0xa4506cebde82bde9L, 0xbef9a3f7b2c67915L, 0xc67178f2e372532bL,
			0xca273eceea26619cL, 0xd186b8c721c0c207L, 0xeada7dd6cde0eb1eL, 0xf57d4f7fee6ed178L, 0x06f067aa72176fbaL,
			0x0a637dc5a2c898a6L, 0x113f9804bef90daeL, 0x1b710b35131c471bL, 0x28db77f523047d84L, 0x32caab7b40c72493L,
			0x3c9ebe0a15c9bebcL, 0x431d67c49c100d4cL, 0x4cc5d4becb3e42b6L, 0x597f299cfc657e2aL, 0x5fcb6fab3ad6faecL,
			0x6c44198c4a475817L }; // Used for SHA-512, SHA-384 and SHA-512/t
	protected String binaryMessage; // Original binary message
	protected String binaryMessagePadded; // Binary message (multiple of 512/1024 bits)
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
	abstract String computeHash();

	/**
	 * It performs the hash computation (SHA-2 family) according to different
	 * parameters. Depending on them the corresponding hash is computed (SHA-224,
	 * SHA-256, SHA-384, SHA-512, SHA-512/t)
	 * 
	 * @param hashValues     Array containing the initial hash values of each class
	 * @param loopIterations Number of iterations performed in main loop (64 or 80)
	 * @param oneOrTwo       It identifies the group of constants (depends on the
	 *                       algorithm)
	 * @return Hexadecimal hash computed
	 */
	protected String computeSHA2Hash(String[] hashValues, int loopIterations, int oneOrTwo) {
		String hash = "";
		System.out.println("I am computing the hash...");

		// Each block is iterated through
		ArrayList<String> messageSchedule = null;
		for (int i = 0; i < words.size(); i++) {
			// Message schedule preparation (80/64 words)
			messageSchedule = new ArrayList<>();
			for (int t = 0; t < loopIterations; t++) {
				if (t < 16) {
					messageSchedule.add(words.get(i).get(t));
				} else {
					messageSchedule
							.add(binaryAddition(sigmaFunctionSplitter(messageSchedule.get(t - 2), wordSize, "lower", 1),
									messageSchedule.get(t - 7),
									sigmaFunctionSplitter(messageSchedule.get(t - 15), wordSize, "lower", 0),
									messageSchedule.get(t - 16), wordSize));
				}
			}

			// Initialize the working variables
			String a = hexadecimalToBinary(hashValues[0]);
			String b = hexadecimalToBinary(hashValues[1]);
			String c = hexadecimalToBinary(hashValues[2]);
			String d = hexadecimalToBinary(hashValues[3]);
			String e = hexadecimalToBinary(hashValues[4]);
			String f = hexadecimalToBinary(hashValues[5]);
			String g = hexadecimalToBinary(hashValues[6]);
			String h = hexadecimalToBinary(hashValues[7]);

			String T1, T2;
			for (int t = 0; t < loopIterations; t++) {
				if (oneOrTwo == 1) {
					T1 = binaryAddition(h, sigmaFunctionSplitter(e, wordSize, "upper", 1), Ch(e, f, g),
							hexadecimalToBinary(CONSTANTS1[t]), messageSchedule.get(t), wordSize);
				} else {
					T1 = binaryAddition(h, sigmaFunctionSplitter(e, wordSize, "upper", 1), Ch(e, f, g),
							hexadecimalToBinary(CONSTANTS2[t]), messageSchedule.get(t), wordSize);
				}
				T2 = binaryAddition(sigmaFunctionSplitter(a, wordSize, "upper", 0), Maj(a, b, c), wordSize);
				h = g;
				g = f;
				f = e;
				e = binaryAddition(d, T1, wordSize);
				d = c;
				c = b;
				b = a;
				a = binaryAddition(T1, T2, wordSize);
			}

			// Compute the intermediate hash value
			hashValues[0] = binaryAddition(a, hexadecimalToBinary(hashValues[0]), wordSize);
			hashValues[1] = binaryAddition(b, hexadecimalToBinary(hashValues[1]), wordSize);
			hashValues[2] = binaryAddition(c, hexadecimalToBinary(hashValues[2]), wordSize);
			hashValues[3] = binaryAddition(d, hexadecimalToBinary(hashValues[3]), wordSize);
			hashValues[4] = binaryAddition(e, hexadecimalToBinary(hashValues[4]), wordSize);
			hashValues[5] = binaryAddition(f, hexadecimalToBinary(hashValues[5]), wordSize);
			hashValues[6] = binaryAddition(g, hexadecimalToBinary(hashValues[6]), wordSize);
			hashValues[7] = binaryAddition(h, hexadecimalToBinary(hashValues[7]), wordSize);

			// Since hashValues are binary we should translate it into hexadecimal
			for (int j = 0; j < hashValues.length; j++) {
				hashValues[j] = binaryToHexadecimal(hashValues[j]);
			}
		}

		// Concatenate hash values
		for (int i = 0; i < hashValues.length; i++) {
			hash += hashValues[i];
		}
		System.out.println(hash);
		return hash;
	}

	protected String computeSHA2Hash2(long[] hashValues, int loopIterations, int oneOrTwo) {
		String hash = "";
		System.out.println("I am computing the hash... (Version 2)");

		// Each block is iterated through
		ArrayList<Long> messageSchedule = null;
		for (int i = 0; i < words.size(); i++) {
			// Message schedule preparation (80 words)
			messageSchedule = new ArrayList<>();
			for (int t = 0; t < loopIterations; t++) {
				if (t < 16) {
					messageSchedule.add(Long.parseUnsignedLong(words.get(i).get(t), 2));
				} else {
					messageSchedule.add(sigmaFunctionSplitter2(messageSchedule.get(t - 2), wordSize, "lower", 1)
							+ messageSchedule.get(t - 7)
							+ sigmaFunctionSplitter2(messageSchedule.get(t - 15), wordSize, "lower", 0)
							+ messageSchedule.get(t - 16));
				}
			}

			// Initialize the working variables
			long a = hashValues[0];
			long b = hashValues[1];
			long c = hashValues[2];
			long d = hashValues[3];
			long e = hashValues[4];
			long f = hashValues[5];
			long g = hashValues[6];
			long h = hashValues[7];

			long T1, T2;
			for (int t = 0; t < loopIterations; t++) {
				if (oneOrTwo == 1) {
					T1 = h + sigmaFunctionSplitter2(e, wordSize, "upper", 1) + Ch2(e, f, g) +
							C1[t] + messageSchedule.get(t);
				} else {
					T1 = h + sigmaFunctionSplitter2(e, wordSize, "upper", 1) + Ch2(e, f, g) +
							C2[t] + messageSchedule.get(t);
				}
				T2 = sigmaFunctionSplitter2(a, wordSize, "upper", 0) + Maj2(a, b, c);
				h = g;
				g = f;
				f = e;
				e = d + T1 + wordSize;
				d = c;
				c = b;
				b = a;
				a = T1 + T2 + wordSize;
			}

			// Compute the intermediate hash value
			hashValues[0] = a + hashValues[0];
			hashValues[1] = b + hashValues[1];
			hashValues[2] = c + hashValues[2];
			hashValues[3] = d + hashValues[3];
			hashValues[4] = e + hashValues[4];
			hashValues[5] = f + hashValues[5];
			hashValues[6] = g + hashValues[6];
			hashValues[7] = h + hashValues[7];

		}
		System.out.println(hash);
		// Concatenate hash values
		for (int i = 0; i < hashValues.length; i++) {
			hash += Long.toHexString(hashValues[i]);
		}
		return hash;
	}

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
		int auxLength = binaryMessage.length();
		boolean isPaddingInTwoBlocks = false;

		// Message length control
		if (binaryMessage.length() > Math.pow(2, maximumMessageLength)) {
			throw new IllegalArgumentException("Input message exceeds maximum length allowed");
		}

		// Detect if there is going to be padding in two blocks
		while (auxLength > blockSize) {
			auxLength -= blockSize;
		} // auxLength value here is equal or less than blockSize
		if (auxLength >= blockSize - maximumMessageLength) {
			isPaddingInTwoBlocks = true;
		}

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
		for (int i = 0; i < binaryMessagePadded.length();) {
			temp = new ArrayList<>();
			for (int j = 0; j < 16; j++) {
				temp.add(binaryMessagePadded.substring(i, i += wordSize));
			}
			words.add(temp);
		}
	}

	/**
	 * Binary addition of 5 values, performed modulo 2^mod
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @param e
	 * @param mod
	 * @return
	 */
	protected String binaryAddition(String a, String b, String c, String d, String e, int mod) {
		if (a.length() > mod || b.length() > mod || c.length() > mod || d.length() > mod || e.length() > mod) {
			throw new IllegalArgumentException("Binary string length exceeds the maximum allowed.");
		}
		BigInteger ba = new BigInteger(a, 2);
		BigInteger bb = new BigInteger(b, 2);
		BigInteger bc = new BigInteger(c, 2);
		BigInteger bd = new BigInteger(d, 2);
		BigInteger be = new BigInteger(e, 2);
		BigInteger bMod = BigInteger.TWO.pow(mod);
		String result = ba.add(bb.add(bc.add(bd.add(be)))).mod(bMod).toString(2);
		while (result.length() < mod) {
			result = "0" + result;
		}
		return result;
	}

	protected String binaryAddition(String a, String b, String c, String d, int mod) {
		return binaryAddition(a, b, c, d, "0", mod);
	}

	protected String binaryAddition(String a, String b, int mod) {
		return binaryAddition(a, b, "0", "0", "0", mod);
	}

	/**
	 * It converts the whole text to a multiple of 8 bit string (using UNICODE
	 * encoding)
	 * 
	 * @param text Whole text to be converted
	 * @return The binary string multiple of 8 bits
	 */
	protected String textToBinary(String text) {
		byte[] byteArray = text.getBytes(StandardCharsets.UTF_8);
		String binaryCharacter, binaryMessage = "";
		for (byte b : byteArray) {
			binaryCharacter = Integer.toBinaryString(b);
			// Java Integer class works with signed 32-bit numbers, but UNICODE works with
			// 8-bit blocks, so the only thing it is needed is to get the least significant
			// 8 bits
			if (binaryCharacter.length() > 8) {
				binaryCharacter = binaryCharacter.substring(binaryCharacter.length() - 8);
			}
			// If an ASCII character is input the binary string will be padded to reach
			// those mentioned 8 bits
			while (binaryCharacter.length() % 8 != 0) {
				binaryCharacter = "0" + binaryCharacter;
			}
			binaryMessage += binaryCharacter;
		}
		return binaryMessage;
	}

	/**
	 * 
	 * @param binary Binary string to be converted
	 * @return Hexadecimal value from binary string
	 */
	protected String binaryToHexadecimal(String binary) {
		String hexadecimal = "", substring;
		// Adapting binary number for being multiple of 4 bits
		while (binary.length() % 4 != 0) {
			binary = "0" + binary;
		}
		// Splitting into 4-bit blocks and converting into hexadecimal
		for (int i = 0; i < binary.length(); i += 4) {
			substring = "";
			substring += binary.charAt(i);
			substring += binary.charAt(i + 1);
			substring += binary.charAt(i + 2);
			substring += binary.charAt(i + 3);
			hexadecimal += Integer.toHexString(Integer.parseInt(substring, 2));
		}
		return hexadecimal;
	}

	/**
	 * 
	 * @param hexadecimal Hexadecimal value to be converted
	 * @return Binary value from hexadecimal value
	 */
	protected String hexadecimalToBinary(String hexadecimal) {
		String binary = "", binaryResult = "", hexDigit;
		for (int i = 0; i < hexadecimal.length(); i++) {
			hexDigit = String.valueOf(hexadecimal.charAt(i));
			binary = Integer.toBinaryString((Integer.parseInt(hexDigit, 16)));
			// Appending zeroes for having numbers multiple of 4 bits
			while (binary.length() % 4 != 0) {
				binary = "0" + binary;
			}
			binaryResult += binary;
		}
		return binaryResult;
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
	protected String f(String x, String y, String z, int index) {
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
	protected String Ch(String x, String y, String z) {
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
	
	protected long Ch2(long x, long y, long z) {
		return (x & y) ^ (~x & z);
	}

	/**
	 * Parity function
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @return x XOR y XOR z
	 */
	protected String Parity(String x, String y, String z) {
		String result = "", finalResult = "";
		for (int i = 0; i < x.length(); i++) {
			result += (x.charAt(i) ^ y.charAt(i));
		}
		for (int i = 0; i < x.length(); i++) {
			finalResult += (result.charAt(i) ^ z.charAt(i));
		}
		return finalResult;
	}
	
	protected long Parity2(long x, long y, long z) {
		return (x ^ y ^ z);
	}

	/**
	 * Maj function
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @return (x AND y) XOR (x AND z) XOR (y AND z)
	 */
	protected String Maj(String x, String y, String z) {
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
	
	protected long Maj2(long x, long y, long z) {
		return (x & y) ^ (x & z) ^ (y ^ z);
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
	protected String sigmaFunctionSplitter(String word, int wordLength, String upperOrLower, int zeroOrOne) {
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

	protected long sigmaFunctionSplitter2(long word, int wordLength, String upperOrLower, int zeroOrOne) {
		switch (wordLength) {
		case 32:
			switch (upperOrLower) {
			case "upper":
				switch (zeroOrOne) {
				case 0:
					return sigmaFunctionOperation2(word, 2, 13, 22, false);
				case 1:
					return sigmaFunctionOperation2(word, 6, 11, 25, false);
				}
			case "lower":
				switch (zeroOrOne) {
				case 0:
					return sigmaFunctionOperation2(word, 7, 18, 3, true);
				case 1:
					return sigmaFunctionOperation2(word, 17, 19, 10, true);
				}
			}
		case 64:
			switch (upperOrLower) {
			case "upper":
				switch (zeroOrOne) {
				case 0:
					return sigmaFunctionOperation2(word, 28, 34, 39, false);
				case 1:
					return sigmaFunctionOperation2(word, 14, 18, 41, false);
				}
			case "lower":
				switch (zeroOrOne) {
				case 0:
					return sigmaFunctionOperation2(word, 1, 8, 7, true);
				case 1:
					return sigmaFunctionOperation2(word, 19, 61, 6, true);
				}
			}
		}
		throw new IllegalArgumentException("Invalid parameters introduced in Sigma function");
	}

	/**
	 * Performs the sigma operation taking into account the different explicit
	 * values within the parameters
	 * 
	 * @param word       Binary word to be changed
	 * @param parameter1 Number of rotations
	 * @param parameter2 Number of rotations
	 * @param parameter3 Number of rotations
	 * @param SHR        Represents if SHR is used instead of ROTR
	 * @return ROTR(parameter1)(word) XOR ROTR(parameter2)(word) XOR
	 *         (ROTR(parameter3)(word) | SHR(parameter3)(word))
	 */
	private String sigmaFunctionOperation(String word, int parameter1, int parameter2, int parameter3, boolean SHR) {
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

	private long sigmaFunctionOperation2(long word, int parameter1, int parameter2, int parameter3, boolean SHR) {
		if (SHR) {
			return Long.rotateRight(word, parameter1) ^ Long.rotateRight(word, parameter2) ^ word >> parameter3;
		} else {
			return Long.rotateRight(word, parameter1) ^ Long.rotateRight(word, parameter2)
					^ Long.rotateRight(word, parameter3);
		}
	}

	/**
	 * When a left circular rotation takes place, the idea is that the bits that are
	 * discarded from the left are appended from the right
	 * 
	 * @param sequence Binary sequence to be rotated
	 * @param n        Times the sequence is rotated
	 * @return The binary sequence left-rotated n times
	 */
	protected String ROTL(String sequence, int n) {
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
	 * are discarded from the right are appended from the left
	 * 
	 * @param sequence Binary sequence to be rotated
	 * @param n        Times the sequence is rotated
	 * @return The binary sequence right-rotated n times
	 */
	protected String ROTR(String sequence, int n) {
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
	protected String SHR(String sequence, int n) {
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
	protected String leftShiftOperation(String sequence, int n) {
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
	protected String rightShiftOperation(String sequence, int n) {
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
