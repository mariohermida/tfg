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
	
	public SHA_1(String binaryMessage) {
		System.out.println("\tSHA-1 ALGORITHM");
		this.binaryMessage = binaryMessage;
		//check whether the length is valid or not (if it exceeds 2^64)
		messageDigest = 160;
		wordSize = 32;
		maximumMessageSize = 64;
		blockSize = 512;
		blockList = new ArrayList<>();
		binaryMessagePadded = padMessage();
		parseMessage();
		for (int i = 0; i < words.size(); i++) {
			System.out.println("Block number: " + (i+1));
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
