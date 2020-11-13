package shs;

import java.util.ArrayList;

/**
 * 
 * @author Mario Hermida
 *
 */
public class SHA_384 extends HashFunction{

	private String[] constants = {"5a827999", "6ed9eba1", "8f1bbcdc", "ca62c1d6"};
	private String[] initialHashValues = {"67452301", "efcdab89", "98badcfe", "10325476", "c3d2e1f0"};
	//private String binaryMessage;
	//private String binaryMessagePadded;
	private ArrayList<String> words;
	
	public SHA_384(String binaryMessage) {
		System.out.println("\tSHA-384 ALGORITHM");
		//this.binaryMessage = binaryMessage;
		messageDigest = 384;
		wordSize = 64;
		maximumMessageSize = 128; 
		blockSize = 1024;
		//binaryMessagePadded = padMessage(binaryMessage);
		words = parseMessage(padMessage(binaryMessage));
		for (String a : words) {
			System.out.println(a);
		}
	}
	
}