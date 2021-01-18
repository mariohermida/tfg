package shs;

import java.util.ArrayList;

/**
 * 
 * @author Mario Hermida
 *
 */
public class SHA_224 extends HashFunction {

	private String[] constants = { "428a2f98", "71374491", "b5c0fbcf", "e9b5dba5", "3956c25b", "59f111f1", "923f82a4",
			"ab1c5ed5", "d807aa98", "12835b01", "243185be", "550c7dc3", "72be5d74", "80deb1fe", "9bdc06a7", "c19bf174",
			"e49b69c1", "efbe4786", "0fc19dc6", "240ca1cc", "2de92c6f", "4a7484aa", "5cb0a9dc", "76f988da", "983e5152",
			"a831c66d", "b00327c8", "bf597fc7", "c6e00bf3", "d5a79147", "06ca6351", "14292967", "27b70a85", "2e1b2138",
			"4d2c6dfc", "53380d13", "650a7354", "766a0abb", "81c2c92e", "92722c85", "a2bfe8a1", "a81a664b", "c24b8b70",
			"c76c51a3", "d192e819", "d6990624", "f40e3585", "106aa070", "19a4c116", "1e376c08", "2748774c", "34b0bcb5",
			"391c0cb3", "4ed8aa4a", "5b9cca4f", "682e6ff3", "748f82ee", "78a5636f", "84c87814", "8cc70208", "90befffa",
			"a4506ceb", "bef9a3f7", "c67178f2" };
	private String[] initialHashValues = {"c1059ed8", "367cd507", "3070dd17", "f70e5939", "ffc00b31", "68581511", "64f98fa7", "befa4fa4"};
	// private String binaryMessage;
	// private String binaryMessagePadded;
	private ArrayList<String> words;

	public SHA_224(String binaryMessage) {
		// this.binaryMessage = binaryMessage;
		System.out.println("\tSHA-224 ALGORITHM");
		messageDigest = 224;
		wordSize = 32;
		maximumMessageSize = 64;
		blockSize = 512;
		// binaryMessagePadded = padMessage(binaryMessage);
		words = parseMessage(padMessage());
		for (String a : words) {
			System.out.println(a);
		}
	}
	
	public String[] getValues() {
		return initialHashValues;
	}

}