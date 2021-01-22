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
		this.binaryMessage = binaryMessage;
		messageDigestLength = 160;
		wordSize = 32;
		maximumMessageLength = 64;
		blockSize = 512;
		words = new ArrayList<>();
		padMessage();
		parseMessage();
//		showWords();
//		computeHash();
//		showHashValues();
	}

	@Override
	public String computeHash() {
		String hash = "";
		System.out.println("I am computing the hash...");

		// Each block is iterated through
		ArrayList<String> messageSchedule = null;
		for (int i = 0; i < words.size(); i++) {
			// Message schedule preparation
			messageSchedule = new ArrayList<>();
			for (int j = 0; j < 80; j++) {
				if (j < 16) {
					messageSchedule.add(words.get(i).get(j));
				} else {
					messageSchedule.add(ROTL(XOR(messageSchedule.get(j - 3), messageSchedule.get(j - 8),
							messageSchedule.get(j - 14), messageSchedule.get(j - 16)), 1));
				}
			}

			//IMPLEMENT ADDITION MODULO 2^32 AND HEXADECIMAL TO BINARY VALUES
			
			// Initialize the working variables
			String a = hashValues[0];
			String b = hashValues[1];
			String c = hashValues[2];
			String d = hashValues[3];
			String e = hashValues[4];

			String t;
			for (int j = 0; j < 80; j++) {
				t = ROTL(a, 5) + f(b, c, d, j) + e + CONSTANTS[j] + messageSchedule.get(j);
				e = d;
				d = c;
				c = ROTL(b, 30);
				b = a;
				a = t;
			}
			
			// Compute the intermediate hash value
			hashValues[0] = a + hashValues[0];
			hashValues[1] = b + hashValues[1];
			hashValues[2] = c + hashValues[2];
			hashValues[3] = d + hashValues[3];
			hashValues[4] = e + hashValues[4];
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

	private void showWords() {
		for (int i = 0; i < words.size(); i++) {
			System.out.println("Block number: " + (i + 1));
			for (int j = 0; j < words.get(i).size(); j++) {
				System.out.println(words.get(i).get(j));
			}
			System.out.println();
		}
	}

	public String[] getValues() {
		return hashValues;
	}

	public String getBinaryMessagePadded() {
		return binaryMessagePadded;
	}

}
