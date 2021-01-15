package shs;

import java.util.ArrayList;

/**
 * 
 * @author Mario Hermida
 *
 */
public class SHA_1 extends HashFunction {

	private String[] constants = {"5a827999", "6ed9eba1", "8f1bbcdc", "ca62c1d6"};
	private String[] initialHashValues = {"67452301", "efcdab89", "98badcfe", "10325476", "c3d2e1f0"};
	private ArrayList<String> words;
	
	public SHA_1(String binaryMessage) {
		System.out.println("\tSHA-1 ALGORITHM");
		this.binaryMessage = binaryMessage;
		messageDigest = 160;
		wordSize = 32;
		maximumMessageSize = 64;
		blockSize = 512;
		binaryMessagePadded = padMessage();
		words = parseMessage(binaryMessagePadded);
		for (String a : words) {
			System.out.println(a);
		}
	}
	
	public String[] getValues() {
		return initialHashValues;
	}
	
	public String getBinaryMessagePadded() {
		return binaryMessagePadded;
	}
	
}
