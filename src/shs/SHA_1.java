package shs;

import java.util.ArrayList;

/**
 * 
 * @author Mario Hermida
 *
 */
public class SHA_1 extends HashFunction {

	static final String[] CONSTANTS = { "5a827999", "6ed9eba1", "8f1bbcdc", "ca62c1d6" };
	private String[] initialHashValues = { "67452301", "efcdab89", "98badcfe", "10325476", "c3d2e1f0" };

	public SHA_1(String binaryMessage) {
		System.out.println("\tSHA-1 ALGORITHM");
		this.binaryMessage = binaryMessage;
		messageDigestLength = 160;
		wordSize = 32;
		maximumMessageLength = 64;
		blockSize = 512;
		blocks = new ArrayList<>();
		words = new ArrayList<>();
		padMessage();
		parseMessage();
		showWords();
		computeHash();
	}
	
	@Override
	String computeHash() {
		System.out.println("I am computing the hash function");
		System.out.println();
		return "";
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
		return initialHashValues;
	}

	public String getBinaryMessagePadded() {
		return binaryMessagePadded;
	}

}
