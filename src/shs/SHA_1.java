package shs;

import java.util.ArrayList;

/**
 * 
 * @author Mario Hermida
 *
 */
public class SHA_1 extends HashFunction {

	static final int[] CONSTANTS = { 0x5a827999, 0x6ed9eba1, 0x8f1bbcdc, 0xca62c1d6 };
	static final String[] CONSTANTS2 = { "5a827999", "6ed9eba1", "8f1bbcdc", "ca62c1d6" };
	private int[] initialHashValues = { 0x67452301, 0xefcdab89, 0x98badcfe, 0x10325476, 0xc3d2e1f0 };
	private String[] initialHashValues2 = { "67452301", "efcdab89", "98badcfe", "10325476", "c3d2e1f0" };

	public SHA_1(String message, boolean isBinary) {
		System.out.println("\tSHA-1 ALGORITHM");
		if (isBinary) {
			this.binaryMessage = message;
		} else {
			this.binaryMessage = textToBinary(message);
		}
		messageDigestLength = 160;
		wordSize = 32;
		maximumMessageLength = 64;
		blockSize = 512;
		words = new ArrayList<>();
		padMessage();
		parseMessage();
	}

	public SHA_1(String message) {
		this(message, false);
	}

	/**
	 * Ordinary SHA-1 hash computation. It uses 32-bit integer values in order to
	 * produce the 160-bit hash.
	 */
	@Override
	public String computeHash() {
		String hash = "";
		System.out.println("Hash is being computed... (integer version)");

		// A copy of the hashes is made in order not to overwrite original values
		int[] hashValues = new int[initialHashValues.length];
		for (int j = 0; j < initialHashValues.length; j++) {
			hashValues[j] = initialHashValues[j];
		}

		// Iteration through each block
		int[] w = new int[80];
		for (int i = 0; i < words.size(); i++) {
			// Message schedule (w) preparation (80 words)
			for (int t = 0; t < 80; t++) {
				if (t < 16) {
					w[t] = Integer.parseUnsignedInt(words.get(i).get(t), 2);
				} else { // From 16 to 79
					w[t] = Integer.rotateLeft(w[t - 3] ^ w[t - 8] ^ w[t - 14] ^ w[t - 16], 1);
				}
			}

			// Initialize the working variables
			int a = hashValues[0];
			int b = hashValues[1];
			int c = hashValues[2];
			int d = hashValues[3];
			int e = hashValues[4];

			int T, index;
			for (int t = 0; t < 80; t++) {
				if (t < 20) {
					index = 0;
				} else if (t < 40) {
					index = 1;
				} else if (t < 60) {
					index = 2;
				} else {
					index = 3;
				}
				T = Integer.rotateLeft(a, 5) + f(b, c, d, t) + e + CONSTANTS[index] + w[t];
				e = d;
				d = c;
				c = Integer.rotateLeft(b, 30);
				b = a;
				a = T;
			}

			// Compute the intermediate hash value
			hashValues[0] = a + hashValues[0];
			hashValues[1] = b + hashValues[1];
			hashValues[2] = c + hashValues[2];
			hashValues[3] = d + hashValues[3];
			hashValues[4] = e + hashValues[4];

		}

		// Concatenate hash values
		String temp;
		for (int i = 0; i < hashValues.length; i++) {
			temp = Integer.toBinaryString(hashValues[i]);
			// Fill with leading zeros if length is not the desired
			while (temp.length() < wordSize) {
				temp = "0" + temp;
			}
			hash += binaryToHexadecimal(temp);
		}
		return hash;
	}

	/**
	 * Alternate method for computing SHA-1 hash. This is efficient from the
	 * standpoint of memory save. 64 32-bit words of storage are saved, but it is
	 * likely to lengthen the execution time. By the way, the same hash is resulted.
	 * 
	 * @return resulting hash
	 */
	public String computeHashAlternateMethod() {
		String hash = "";
		System.out.println("Hash is being computed... (alternate method) (integer version)");

		// A copy of the hashes is made in order not to overwrite original values
		int[] hashValues = new int[initialHashValues.length];
		for (int j = 0; j < initialHashValues.length; j++) {
			hashValues[j] = initialHashValues[j];
		}

		// Iteration through each block
		int[] w = new int[16];
		for (int i = 0; i < words.size(); i++) {
			// Message schedule (w) preparation (16 words)
			for (int t = 0; t < 16; t++) {
				w[t] = Integer.parseUnsignedInt(words.get(i).get(t), 2);
			}

			// Initialize the working variables
			int a = hashValues[0];
			int b = hashValues[1];
			int c = hashValues[2];
			int d = hashValues[3];
			int e = hashValues[4];

			int T, index, mask = 0x0000000f, s;
			for (int t = 0; t < 80; t++) {
				if (t < 20) {
					index = 0;
				} else if (t < 40) {
					index = 1;
				} else if (t < 60) {
					index = 2;
				} else {
					index = 3;
				}
				// Different kind of addressing
				s = t & mask;
				if (t >= 16) {
					w[s] = Integer.rotateLeft(w[(s + 13) & mask] ^ w[(s + 8) & mask] ^ w[(s + 2) & mask] ^ w[s], 1);
				}
				T = Integer.rotateLeft(a, 5) + f(b, c, d, t) + e + CONSTANTS[index] + w[s];
				e = d;
				d = c;
				c = Integer.rotateLeft(b, 30);
				b = a;
				a = T;
			}

			// Compute the intermediate hash value
			hashValues[0] = a + hashValues[0];
			hashValues[1] = b + hashValues[1];
			hashValues[2] = c + hashValues[2];
			hashValues[3] = d + hashValues[3];
			hashValues[4] = e + hashValues[4];

		}

		// Concatenate hash values
		String temp;
		for (int i = 0; i < hashValues.length; i++) {
			temp = Integer.toBinaryString(hashValues[i]);
			// Fill with leading zeros if length is not the desired
			while (temp.length() < wordSize) {
				temp = "0" + temp;
			}
			hash += binaryToHexadecimal(temp);
		}
		return hash;
	}

	/**
	 * A 160-bit hash is produced following the same procedure as the ordinary
	 * function. The difference is the data treatment: strings are used, instead of
	 * integer numbers. It is not as efficient as the first method, it takes more
	 * time to compute the hash.
	 * 
	 * @return resulting hash
	 */
	public String computeHash2() {
		String hash = "";
		System.out.println("Hash is being computed... (string version)");

		// A copy of the hashes is made in order not to overwrite original values
		String[] hashValues = new String[initialHashValues2.length];
		for (int j = 0; j < initialHashValues2.length; j++) {
			hashValues[j] = initialHashValues2[j];
		}

		// Iteration through each block
		String[] w = new String[80];
		for (int i = 0; i < words.size(); i++) {
			// Message schedule preparation (80 words)
			for (int t = 0; t < 80; t++) {
				if (t < 16) {
					w[t] = words.get(i).get(t);
				} else { // From 16 to 79
					w[t] = ROTL(XOR(w[t - 3], w[t - 8], w[t - 14], w[t - 16]), 1);
				}
			}

			// Initialize the working variables
			String a = hexadecimalToBinary(hashValues[0]);
			String b = hexadecimalToBinary(hashValues[1]);
			String c = hexadecimalToBinary(hashValues[2]);
			String d = hexadecimalToBinary(hashValues[3]);
			String e = hexadecimalToBinary(hashValues[4]);

			String T;
			int index;
			for (int t = 0; t < 80; t++) {
				if (t < 20) {
					index = 0;
				} else if (t < 40) {
					index = 1;
				} else if (t < 60) {
					index = 2;
				} else {
					index = 3;
				}
				T = binaryAddition(ROTL(a, 5), f(b, c, d, t), e, hexadecimalToBinary(CONSTANTS2[index]), w[t]);
				e = d;
				d = c;
				c = ROTL(b, 30);
				b = a;
				a = T;
			}

			// Compute the intermediate hash value
			hashValues[0] = binaryAddition(a, hexadecimalToBinary(hashValues[0]));
			hashValues[1] = binaryAddition(b, hexadecimalToBinary(hashValues[1]));
			hashValues[2] = binaryAddition(c, hexadecimalToBinary(hashValues[2]));
			hashValues[3] = binaryAddition(d, hexadecimalToBinary(hashValues[3]));
			hashValues[4] = binaryAddition(e, hexadecimalToBinary(hashValues[4]));

			// Since hashValues are binary we should translate it into hexadecimal
			for (int j = 0; j < hashValues.length; j++) {
				hashValues[j] = binaryToHexadecimal(hashValues[j]);
			}
		}

		// Concatenate hash values
		for (int i = 0; i < hashValues.length; i++) {
			hash += hashValues[i];
		}
		return hash;
	}

	/**
	 * XOR operation of 4 values (using strings)
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @return a XOR b XOR c XOR d
	 */
	private String XOR(String a, String b, String c, String d) {
		String result1 = "", result2 = "", finalResult = "";
		for (int i = 0; i < a.length(); i++) {
			result1 += (a.charAt(i) ^ b.charAt(i));
		}
		for (int i = 0; i < c.length(); i++) {
			result2 += (c.charAt(i) ^ d.charAt(i));
		}
		for (int i = 0; i < result1.length(); i++) {
			finalResult += (result1.charAt(i) ^ result2.charAt(i));
		}
		return finalResult;
	}

}