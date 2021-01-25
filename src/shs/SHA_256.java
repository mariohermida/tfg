package shs;

import java.util.ArrayList;

/**
 * 
 * @author Mario Hermida
 *
 */
public class SHA_256 extends HashFunction {

	static final String[] CONSTANTS = { "428a2f98", "71374491", "b5c0fbcf", "e9b5dba5", "3956c25b", "59f111f1",
			"923f82a4", "ab1c5ed5", "d807aa98", "12835b01", "243185be", "550c7dc3", "72be5d74", "80deb1fe", "9bdc06a7",
			"c19bf174", "e49b69c1", "efbe4786", "0fc19dc6", "240ca1cc", "2de92c6f", "4a7484aa", "5cb0a9dc", "76f988da",
			"983e5152", "a831c66d", "b00327c8", "bf597fc7", "c6e00bf3", "d5a79147", "06ca6351", "14292967", "27b70a85",
			"2e1b2138", "4d2c6dfc", "53380d13", "650a7354", "766a0abb", "81c2c92e", "92722c85", "a2bfe8a1", "a81a664b",
			"c24b8b70", "c76c51a3", "d192e819", "d6990624", "f40e3585", "106aa070", "19a4c116", "1e376c08", "2748774c",
			"34b0bcb5", "391c0cb3", "4ed8aa4a", "5b9cca4f", "682e6ff3", "748f82ee", "78a5636f", "84c87814", "8cc70208",
			"90befffa", "a4506ceb", "bef9a3f7", "c67178f2" };
	private String[] hashValues = { "6a09e667", "bb67ae85", "3c6ef372", "a54ff53a", "510e527f", "9b05688c", "1f83d9ab",
			"5be0cd19" };

	public SHA_256(String binaryMessage) {
		System.out.println("\tSHA-256 ALGORITHM");
		this.binaryMessage = textToBinary(binaryMessage);
		messageDigestLength = 256;
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
			// Message schedule preparation (64 words)
			messageSchedule = new ArrayList<>();
			for (int t = 0; t < 64; t++) {
				if (t < 16) {
					messageSchedule.add(words.get(i).get(t));
				} else { // From 16 to 63
					messageSchedule.add(addition(sigmaFunctionSplitter(messageSchedule.get(t - 2), 32, "lower", 1),
							messageSchedule.get(t - 7),
							sigmaFunctionSplitter(messageSchedule.get(t - 15), 32, "lower", 0),
							messageSchedule.get(t - 16), "0", 32));
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
			for (int t = 0; t < 64; t++) {
				T1 = addition(h, sigmaFunctionSplitter(e, 32, "upper", 1), Ch(e, f, g), hexadecimalToBinary(CONSTANTS[t]),
						messageSchedule.get(t), 32);
				T2 = addition(sigmaFunctionSplitter(a, 32, "upper", 0), Maj(a, b, c), "0", "0", "0", 32);
				h = g;
				g = f;
				f = e;
				e = addition(d, T1, "0", "0", "0", 32);
				d = c;
				c = b;
				b = a;
				a = addition(T1, T2, "0", "0", "0", 32);
			}

			// Compute the intermediate hash value
			hashValues[0] = addition(a, hexadecimalToBinary(hashValues[0]), "0", "0", "0", 32);
			hashValues[1] = addition(b, hexadecimalToBinary(hashValues[1]), "0", "0", "0", 32);
			hashValues[2] = addition(c, hexadecimalToBinary(hashValues[2]), "0", "0", "0", 32);
			hashValues[3] = addition(d, hexadecimalToBinary(hashValues[3]), "0", "0", "0", 32);
			hashValues[4] = addition(e, hexadecimalToBinary(hashValues[4]), "0", "0", "0", 32);
			hashValues[5] = addition(f, hexadecimalToBinary(hashValues[5]), "0", "0", "0", 32);
			hashValues[6] = addition(g, hexadecimalToBinary(hashValues[6]), "0", "0", "0", 32);
			hashValues[7] = addition(h, hexadecimalToBinary(hashValues[7]), "0", "0", "0", 32);

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

	public String getBinaryMessagePadded() {
		return binaryMessagePadded;
	}

}
