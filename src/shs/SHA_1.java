package shs;

import java.util.ArrayList;

/**
 * 
 * @author Mario Hermida
 *
 */
public class SHA_1 extends HashFunction {

	static final String[] CONSTANTS = { "5a827999", "6ed9eba1", "8f1bbcdc", "ca62c1d6" };
	private String[] hashValues = { "67452301", "efcdab89", "98badcfe", "10325476", "c3d2e1f0" };

	public SHA_1(String binaryMessage) {
		System.out.println("\tSHA-1 ALGORITHM");
		this.binaryMessage = textToBinary(binaryMessage);
		messageDigestLength = 160;
		wordSize = 32;
		maximumMessageLength = 64;
		blockSize = 512;
		words = new ArrayList<>();
		padMessage();
		parseMessage();
	}

	@Override
	public String computeHash() {
		String hash = "";
		System.out.println("I am computing the hash...");

		// Each block is iterated through
		ArrayList<String> messageSchedule = null;
		for (int i = 0; i < words.size(); i++) {
			// Message schedule preparation (80 words)
			messageSchedule = new ArrayList<>();
			for (int t = 0; t < 80; t++) {
				if (t < 16) {
					messageSchedule.add(words.get(i).get(t));
				} else { // From 16 to 79
					messageSchedule.add(ROTL(XOR(messageSchedule.get(t - 3), messageSchedule.get(t - 8),
							messageSchedule.get(t - 14), messageSchedule.get(t - 16)), 1));
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
				T = addition(ROTL(a, 5), f(b, c, d, t), e, hexadecimalToBinary(CONSTANTS[index]),
						messageSchedule.get(t), 32);
				e = d;
				d = c;
				c = ROTL(b, 30);
				b = a;
				a = T;
			}

			// Compute the intermediate hash value
			hashValues[0] = addition(a, hexadecimalToBinary(hashValues[0]), "0", "0", "0", 32);
			hashValues[1] = addition(b, hexadecimalToBinary(hashValues[1]), "0", "0", "0", 32);
			hashValues[2] = addition(c, hexadecimalToBinary(hashValues[2]), "0", "0", "0", 32);
			hashValues[3] = addition(d, hexadecimalToBinary(hashValues[3]), "0", "0", "0", 32);
			hashValues[4] = addition(e, hexadecimalToBinary(hashValues[4]), "0", "0", "0", 32);

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
	 * XOR operation of 4 values
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

	public String getBinaryMessagePadded() {
		return binaryMessagePadded;
	}

}
