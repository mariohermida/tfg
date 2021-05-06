package hashing;

//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.PrintStream;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * All computations are performed taking into consideration the documents
 * published in the following NIST links: Secure Hash Standard (SHS) (SHA-1 and
 * SHA-2): https://nvlpubs.nist.gov/nistpubs/FIPS/NIST.FIPS.180-4.pdf SHA-3
 * Standard (SHA-3 and Extendable-Output Functions):
 * https://nvlpubs.nist.gov/nistpubs/FIPS/NIST.FIPS.202.pdf
 * 
 * @author Mario Hermida
 *
 */
public abstract class HashFunction {

	// Hexadecimal string constants used for SHA-256 and SHA-224
	static final String[] CONSTANTS1 = { "428a2f98", "71374491", "b5c0fbcf", "e9b5dba5", "3956c25b", "59f111f1",
			"923f82a4", "ab1c5ed5", "d807aa98", "12835b01", "243185be", "550c7dc3", "72be5d74", "80deb1fe", "9bdc06a7",
			"c19bf174", "e49b69c1", "efbe4786", "0fc19dc6", "240ca1cc", "2de92c6f", "4a7484aa", "5cb0a9dc", "76f988da",
			"983e5152", "a831c66d", "b00327c8", "bf597fc7", "c6e00bf3", "d5a79147", "06ca6351", "14292967", "27b70a85",
			"2e1b2138", "4d2c6dfc", "53380d13", "650a7354", "766a0abb", "81c2c92e", "92722c85", "a2bfe8a1", "a81a664b",
			"c24b8b70", "c76c51a3", "d192e819", "d6990624", "f40e3585", "106aa070", "19a4c116", "1e376c08", "2748774c",
			"34b0bcb5", "391c0cb3", "4ed8aa4a", "5b9cca4f", "682e6ff3", "748f82ee", "78a5636f", "84c87814", "8cc70208",
			"90befffa", "a4506ceb", "bef9a3f7", "c67178f2" };

	// Hexadecimal string constants used for SHA-512, SHA-384 and SHA-512/t
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
			"6c44198c4a475817" };

	// Hexadecimal integer constants used for SHA-256 and SHA-224
	static final long[] C1 = { 0x428a2f98, 0x71374491, 0xb5c0fbcf, 0xe9b5dba5, 0x3956c25b, 0x59f111f1, 0x923f82a4,
			0xab1c5ed5, 0xd807aa98, 0x12835b01, 0x243185be, 0x550c7dc3, 0x72be5d74, 0x80deb1fe, 0x9bdc06a7, 0xc19bf174,
			0xe49b69c1, 0xefbe4786, 0x0fc19dc6, 0x240ca1cc, 0x2de92c6f, 0x4a7484aa, 0x5cb0a9dc, 0x76f988da, 0x983e5152,
			0xa831c66d, 0xb00327c8, 0xbf597fc7, 0xc6e00bf3, 0xd5a79147, 0x06ca6351, 0x14292967, 0x27b70a85, 0x2e1b2138,
			0x4d2c6dfc, 0x53380d13, 0x650a7354, 0x766a0abb, 0x81c2c92e, 0x92722c85, 0xa2bfe8a1, 0xa81a664b, 0xc24b8b70,
			0xc76c51a3, 0xd192e819, 0xd6990624, 0xf40e3585, 0x106aa070, 0x19a4c116, 0x1e376c08, 0x2748774c, 0x34b0bcb5,
			0x391c0cb3, 0x4ed8aa4a, 0x5b9cca4f, 0x682e6ff3, 0x748f82ee, 0x78a5636f, 0x84c87814, 0x8cc70208, 0x90befffa,
			0xa4506ceb, 0xbef9a3f7, 0xc67178f2 };

	// Hexadecimal integer constants used for SHA-512, SHA-384 and SHA-512/t
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
			0x6c44198c4a475817L };

	// Round constants for Iota permutation in Keccak_p function (SHA-3)
	static final long[] RC = { 0x0000000000000001L, 0x0000000000008082L, 0x800000000000808AL, 0x8000000080008000L,
			0x000000000000808BL, 0x0000000080000001L, 0x8000000080008081L, 0x8000000000008009L, 0x000000000000008AL,
			0x0000000000000088L, 0x0000000080008009L, 0x000000008000000AL, 0x000000008000808BL, 0x800000000000008BL,
			0x8000000000008089L, 0x8000000000008003L, 0x8000000000008002L, 0x8000000000000080L, 0x000000000000800AL,
			0x800000008000000AL, 0x8000000080008081L, 0x8000000000008080L, 0x0000000080000001L, 0x8000000080008008L };

	// Offset needed for permuting lanes in Rho permutation in Keccak_p function
	// (SHA-3)
	static final int[][] offset = { { 0, 36, 3, 41, 18 }, { 1, 44, 10, 45, 2 }, { 62, 6, 43, 15, 61 },
			{ 28, 55, 25, 21, 56 }, { 27, 20, 39, 8, 14 } };

	protected String binaryMessage; // Original binary message
	protected String binaryMessagePadded; // Binary message plus the padding (multiple of blockSize for SHS and
											// multiple of rate for SHA-3)
	protected int messageDigestLength; // Number of bits resulted from hash computation

	// Variables used for SHS computation
	protected int blockSize;
	protected ArrayList<ArrayList<String>> words; // 32/64-bits words extracted from every block
	protected int wordSize;
	protected int maximumMessageLength; // Maximum amount of bits for representing message length

	// Variables used for SHA-3 computation
	protected int rate;
	protected int capacity;
	protected int width;

	/**
	 * Computes the final hash according to the algorithm chosen
	 * 
	 * @return hexadecimal hash resulted from the original message
	 */
	abstract String computeHash();

	/**
	 * It performs the hash computation (SHA-2 family) according to different
	 * parameters. Depending on them the corresponding hash is computed (SHA-224,
	 * SHA-256, SHA-384, SHA-512, SHA-512/t)
	 * 
	 * @param initialHashValues Array containing the initial hash values of each
	 *                          class
	 * @param loopIterations    Number of iterations performed in main loop (64 or
	 *                          80) It depends on the algorithm
	 * @param oneOrTwo          It identifies the group of constants (depends on the
	 *                          algorithm)
	 * @return Hexadecimal hash computed
	 */
	protected String computeSHA2Hash(long[] initialHashValues, int loopIterations, int oneOrTwo) {
		String hash = "";
		System.out.println("Hash is being computed... (integer version)");

		// A copy of the hashes is made in order not to overwrite original values
		long[] hashValues = new long[initialHashValues.length];
		for (int i = 0; i < initialHashValues.length; i++) {
			hashValues[i] = initialHashValues[i];
		}

		// Iteration through each block
		long[] w = new long[loopIterations];
		for (int i = 0; i < words.size(); i++) {
			// Message schedule (w) preparation (80/64 words)
			for (int t = 0; t < loopIterations; t++) {
				if (t < 16) {
					w[t] = Long.parseUnsignedLong(words.get(i).get(t), 2);
				} else {
					w[t] = sigmaFunctionSplitter(w[t - 2], wordSize, "lower", true) + w[t - 7]
							+ sigmaFunctionSplitter(w[t - 15], wordSize, "lower", false) + w[t - 16];
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
					T1 = h + sigmaFunctionSplitter(e, wordSize, "upper", true) + Ch(e, f, g) + C1[t] + w[t];
				} else {
					T1 = h + sigmaFunctionSplitter(e, wordSize, "upper", true) + Ch(e, f, g) + C2[t] + w[t];
				}
				T2 = sigmaFunctionSplitter(a, wordSize, "upper", false) + Maj(a, b, c);
				h = g;
				g = f;
				f = e;
				e = d + T1;
				d = c;
				c = b;
				b = a;
				a = T1 + T2;
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

		// Concatenate hash values
		String temp;
		for (int i = 0; i < hashValues.length; i++) {
			if (wordSize == 32) {
				temp = Integer.toBinaryString((int) hashValues[i]);
			} else { // wordSize == 64
				temp = Long.toBinaryString(hashValues[i]);
			}
			// Fill with leading zeros if length is not the desired
			while (temp.length() < wordSize) {
				temp = "0" + temp;
			}
			hash += binaryToHexadecimal(temp);
		}

		// Length is represented in bits (divided by 4 to convert it to hexadecimal)
		return hash.substring(0, messageDigestLength / 4);
	}

	/**
	 * Same as above, but performing hash computation using string representation
	 * instead of integer values.
	 * 
	 */
	protected String computeSHA2Hash(String[] initialHashValues, int loopIterations, int oneOrTwo) {
		String hash = "";
//		System.out.println("Hash is being computed... (string version)");

		// Writing file in order to store intermediate hash values
		/*
		 * PrintStream o = null; try { o = new PrintStream(new File("file.txt")); }
		 * catch (FileNotFoundException e1) { e1.printStackTrace(); } // Assign o to
		 * output stream System.setOut(o);
		 */

		// A copy of the hashes is made in order not to overwrite original values
		String[] hashValues = new String[initialHashValues.length];
		for (int i = 0; i < initialHashValues.length; i++) {
			hashValues[i] = initialHashValues[i];
		}

		// Iteration through each block
		String[] w = new String[loopIterations];
		for (int i = 0; i < words.size(); i++) {
			// Message schedule (w) preparation (80/64 words)
			for (int t = 0; t < loopIterations; t++) {
				if (t < 16) {
					w[t] = words.get(i).get(t);
				} else {
					w[t] = binaryAddition(sigmaFunctionSplitter(w[t - 2], wordSize, "lower", true), w[t - 7],
							sigmaFunctionSplitter(w[t - 15], wordSize, "lower", false), w[t - 16]);
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

//			System.out.println("Ini: a=" + binaryToHexadecimal(a) + "b=" + binaryToHexadecimal(b) + "c=" + binaryToHexadecimal(c) + "d=" + binaryToHexadecimal(d) + "e=" + binaryToHexadecimal(e) + "f=" + binaryToHexadecimal(f) + "g=" + binaryToHexadecimal(g) + "h=" + binaryToHexadecimal(h));
			/*
			 * System.out.println("\tIni:\tA=" + binaryToHexadecimal(a) + "\t\tB=" +
			 * binaryToHexadecimal(b) + "\t\tC=" + binaryToHexadecimal(c) + "\t\tD=" +
			 * binaryToHexadecimal(d)); System.out.println("\t\tE=" + binaryToHexadecimal(e)
			 * + "\t\tF=" + binaryToHexadecimal(f) + "\t\tG=" + binaryToHexadecimal(g) +
			 * "\t\tH=" + binaryToHexadecimal(h));
			 */

			String T1, T2;
			for (int t = 0; t < loopIterations; t++) {
				if (oneOrTwo == 1) {
					T1 = binaryAddition(h, sigmaFunctionSplitter(e, wordSize, "upper", true), Ch(e, f, g),
							hexadecimalToBinary(CONSTANTS1[t]), w[t]);
				} else {
					T1 = binaryAddition(h, sigmaFunctionSplitter(e, wordSize, "upper", true), Ch(e, f, g),
							hexadecimalToBinary(CONSTANTS2[t]), w[t]);
				}
				T2 = binaryAddition(sigmaFunctionSplitter(a, wordSize, "upper", false), Maj(a, b, c));
				h = g;
				g = f;
				f = e;
				e = binaryAddition(d, T1);
				d = c;
				c = b;
				b = a;
				a = binaryAddition(T1, T2);

				// Output is directed to the file previously defined
//				System.out.println("R" + (t+1) + ": a=" + binaryToHexadecimal(a) + "b=" + binaryToHexadecimal(b) + "c=" + binaryToHexadecimal(c) + "d=" + binaryToHexadecimal(d) + "e=" + binaryToHexadecimal(e) + "f=" + binaryToHexadecimal(f) + "g=" + binaryToHexadecimal(g) + "h=" + binaryToHexadecimal(h));
				/*
				 * System.out.println("\tR" + (t + 1) + ":\tA=" + binaryToHexadecimal(a) +
				 * "\t\tB=" + binaryToHexadecimal(b) + "\t\tC=" + binaryToHexadecimal(c) +
				 * "\t\tD=" + binaryToHexadecimal(d)); System.out.println("\t\tE=" +
				 * binaryToHexadecimal(e) + "\t\tF=" + binaryToHexadecimal(f) + "\t\tG=" +
				 * binaryToHexadecimal(g) + "\t\tH=" + binaryToHexadecimal(h));
				 */
			}

			/*
			 * System.out.println("\n\tH[0] = " + binaryToHexadecimal(a) + " + " +
			 * hashValues[0] + " = " + binaryToHexadecimal(binaryAddition(a,
			 * hexadecimalToBinary(hashValues[0])))); System.out.println("\tH[1] = " +
			 * binaryToHexadecimal(b) + " + " + hashValues[1] + " = " +
			 * binaryToHexadecimal(binaryAddition(b, hexadecimalToBinary(hashValues[1]))));
			 * System.out.println("\tH[2] = " + binaryToHexadecimal(c) + " + " +
			 * hashValues[2] + " = " + binaryToHexadecimal(binaryAddition(c,
			 * hexadecimalToBinary(hashValues[2])))); System.out.println("\tH[3] = " +
			 * binaryToHexadecimal(d) + " + " + hashValues[3] + " = " +
			 * binaryToHexadecimal(binaryAddition(d, hexadecimalToBinary(hashValues[3]))));
			 * System.out.println("\tH[4] = " + binaryToHexadecimal(e) + " + " +
			 * hashValues[4] + " = " + binaryToHexadecimal(binaryAddition(e,
			 * hexadecimalToBinary(hashValues[4])))); System.out.println("\tH[5] = " +
			 * binaryToHexadecimal(f) + " + " + hashValues[5] + " = " +
			 * binaryToHexadecimal(binaryAddition(f, hexadecimalToBinary(hashValues[5]))));
			 * System.out.println("\tH[6] = " + binaryToHexadecimal(g) + " + " +
			 * hashValues[6] + " = " + binaryToHexadecimal(binaryAddition(g,
			 * hexadecimalToBinary(hashValues[6])))); System.out.println("\tH[7] = " +
			 * binaryToHexadecimal(h) + " + " + hashValues[7] + " = " +
			 * binaryToHexadecimal(binaryAddition(h, hexadecimalToBinary(hashValues[7]))));
			 */

			// Compute the intermediate hash value
			hashValues[0] = binaryAddition(a, hexadecimalToBinary(hashValues[0]));
			hashValues[1] = binaryAddition(b, hexadecimalToBinary(hashValues[1]));
			hashValues[2] = binaryAddition(c, hexadecimalToBinary(hashValues[2]));
			hashValues[3] = binaryAddition(d, hexadecimalToBinary(hashValues[3]));
			hashValues[4] = binaryAddition(e, hexadecimalToBinary(hashValues[4]));
			hashValues[5] = binaryAddition(f, hexadecimalToBinary(hashValues[5]));
			hashValues[6] = binaryAddition(g, hexadecimalToBinary(hashValues[6]));
			hashValues[7] = binaryAddition(h, hexadecimalToBinary(hashValues[7]));

			// Since hashValues are binary we should translate it into hexadecimal
			for (int j = 0; j < hashValues.length; j++) {
				hashValues[j] = binaryToHexadecimal(hashValues[j]);
			}

		}

		// Concatenate hash values
		for (int i = 0; i < hashValues.length; i++) {
			hash += hashValues[i];
		}

		/*
		 * System.out.println("\n\tResumen:\t" + hash);
		 * System.out.println("\tResumen:\t" + hash.substring(0, messageDigestLength /
		 * 4));
		 */

		// Length is represented in hexadecimal (divided by 4)
		return hash.substring(0, messageDigestLength / 4);
	}

	/**
	 * The idea is to have a message whose length is multiple of 512/1024 (block
	 * size) The binaryMessagePadded is built this way: original binary message + 1
	 * + as many 0s as needed + length of the original message in binary (reserving
	 * 64/128 (maximumMessageSize) bits here). Say here that padding is always
	 * added, even if the message is already the desired length.
	 * 
	 * @return The message padded with determined number of zeroes
	 */
	protected void padMessageSHS() {
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
		}
		// auxLength value here is equal or less than blockSize
		if (auxLength >= blockSize - maximumMessageLength) {
			isPaddingInTwoBlocks = true;
		}

		// Deal with padding
		int bitsToAdd = (blockSize - maximumMessageLength) - auxLength;
		if (isPaddingInTwoBlocks) {
			bitsToAdd += maximumMessageLength; // Add bits for padding the second last block
			bitsToAdd += blockSize - maximumMessageLength; // Add bits for wholly padding the last block
		}
		binaryMessagePadded = addSimplePadding(binaryMessagePadded, bitsToAdd);

		// Binary length representation of the original message (64/128 bits)
		String binaryMessageLength = Integer.toBinaryString(binaryMessage.length());
		while (binaryMessageLength.length() < maximumMessageLength) {
			binaryMessageLength = "0" + binaryMessageLength;
		}
		binaryMessagePadded = binaryMessagePadded + binaryMessageLength;
	}

	/**
	 * It pads the message with a 1 and as many 0s as needed
	 * 
	 * @param message
	 * @param numberOfBitsToAdd
	 * @return Message padded
	 */
	private String addSimplePadding(String message, int numberOfBitsToAdd) {
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
	 * Binary addition of 5 values, performed modulo 2^wordSize
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @param e
	 * @return a + b + c + d + e (mod 2^wordSize)
	 */
	protected String binaryAddition(String a, String b, String c, String d, String e) {
		if (a.length() > wordSize || b.length() > wordSize || c.length() > wordSize || d.length() > wordSize
				|| e.length() > wordSize) {
			throw new IllegalArgumentException("Binary string length exceeds the maximum allowed.");
		}
		BigInteger ba = new BigInteger(a, 2);
		BigInteger bb = new BigInteger(b, 2);
		BigInteger bc = new BigInteger(c, 2);
		BigInteger bd = new BigInteger(d, 2);
		BigInteger be = new BigInteger(e, 2);
		BigInteger bMod = BigInteger.TWO.pow(wordSize);
		String result = ba.add(bb.add(bc.add(bd.add(be)))).mod(bMod).toString(2);
		while (result.length() < wordSize) {
			result = "0" + result;
		}
		return result;
	}

	protected String binaryAddition(String a, String b, String c, String d) {
		return binaryAddition(a, b, c, d, "0");
	}

	protected String binaryAddition(String a, String b) {
		return binaryAddition(a, b, "0", "0", "0");
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
			// First 24 bits are ignored, due to 8 bit string is wanted
			binaryCharacter = Integer.toBinaryString((b & 0xFF) + 0x100).substring(1);
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
	 * f function. Used at the time of computing SHA-1 algorithm only. Depending on
	 * the value of index it redirects the input to the right function
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @param index Variable in charge of selecting the right logical function
	 * @return 32-bit word resulted from the convenient logical function
	 */
	protected int f(int x, int y, int z, int index) {
		if (index >= 0 && index <= 19) {
			return (int) Ch(x, y, z);
		} else if (index >= 20 && index <= 39) {
			return (int) Parity(x, y, z);
		} else if (index >= 40 && index <= 59) {
			return (int) Maj(x, y, z);
		} else if (index >= 60 && index <= 79) {
			return (int) Parity(x, y, z);
		}
		throw new IllegalArgumentException("Invalid parameters introduced in f function (SHA-1)");
	}

	/**
	 * Same as above, but instead of using integer values, using string
	 * representation
	 * 
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
	protected long Ch(long x, long y, long z) {
		return (x & y) ^ (~x & z);
	}

	/**
	 * Same as above, but instead of using integer values, using string
	 * representation
	 * 
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

	/**
	 * Parity function
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @return x XOR y XOR z
	 */
	protected long Parity(long x, long y, long z) {
		return (x ^ y ^ z);
	}

	/**
	 * Same as above, but instead of using integer values, using string
	 * representation
	 * 
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

	/**
	 * Maj function
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @return (x AND y) XOR (x AND z) XOR (y AND z)
	 */
	protected long Maj(long x, long y, long z) {
		return (x & y) ^ (x & z) ^ (y & z);
	}

	/**
	 * Same as above, but instead of using integer values, using string
	 * representation
	 * 
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

	/**
	 * It identifies the different sigma operations according to the following
	 * parameters: wordLength, upperOrLower and zeroOrOne
	 * 
	 * @param word         The word (integer number) to be changed
	 * @param wordLength   Word length (32 or 64) (bits)
	 * @param upperOrLower Represents the kind of sigma operation (upper or lower)
	 * @param oneOrZero    Represents the kind of sigma operation (1 (true) or 0
	 *                     (false))
	 * @return The word (integer number) modified according to the specific sigma
	 *         function
	 */
	protected long sigmaFunctionSplitter(long word, int wordLength, String upperOrLower, boolean oneOrZero) {
		switch (wordLength) {
		case 32:
			switch (upperOrLower) {
			case "upper":
				if (oneOrZero) {
					return sigmaFunctionOperationInteger((int) word, 6, 11, 25, false);
				}
				return sigmaFunctionOperationInteger((int) word, 2, 13, 22, false);
			case "lower":
				if (oneOrZero) {
					return sigmaFunctionOperationInteger((int) word, 17, 19, 10, true);
				}
				return sigmaFunctionOperationInteger((int) word, 7, 18, 3, true);
			}
		case 64:
			switch (upperOrLower) {
			case "upper":
				if (oneOrZero) {
					return sigmaFunctionOperationLong(word, 14, 18, 41, false);
				}
				return sigmaFunctionOperationLong(word, 28, 34, 39, false);
			case "lower":
				if (oneOrZero) {
					return sigmaFunctionOperationLong(word, 19, 61, 6, true);
				}
				return sigmaFunctionOperationLong(word, 1, 8, 7, true);
			}
		}
		throw new IllegalArgumentException("Invalid parameters introduced in Sigma function");
	}

	/**
	 * Same as above, but instead of using integer values, using string
	 * representation
	 * 
	 */
	protected String sigmaFunctionSplitter(String word, int wordLength, String upperOrLower, boolean oneOrZero) {
		switch (wordLength) {
		case 32:
			switch (upperOrLower) {
			case "upper":
				if (oneOrZero) {
					return sigmaFunctionOperation(word, 6, 11, 25, false);
				}
				return sigmaFunctionOperation(word, 2, 13, 22, false);
			case "lower":
				if (oneOrZero) {
					return sigmaFunctionOperation(word, 17, 19, 10, true);
				}
				return sigmaFunctionOperation(word, 7, 18, 3, true);
			}
		case 64:
			switch (upperOrLower) {
			case "upper":
				if (oneOrZero) {
					return sigmaFunctionOperation(word, 14, 18, 41, false);
				}
				return sigmaFunctionOperation(word, 28, 34, 39, false);
			case "lower":
				if (oneOrZero) {
					return sigmaFunctionOperation(word, 19, 61, 6, true);
				}
				return sigmaFunctionOperation(word, 1, 8, 7, true);
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
	private long sigmaFunctionOperationLong(long word, int parameter1, int parameter2, int parameter3, boolean SHR) {
		if (SHR) { // Unsigned bit shift is used
			return Long.rotateRight(word, parameter1) ^ Long.rotateRight(word, parameter2) ^ (word >>> parameter3);
		} else {
			return Long.rotateRight(word, parameter1) ^ Long.rotateRight(word, parameter2)
					^ Long.rotateRight(word, parameter3);
		}
	}

	/**
	 * Same as above but using int instead of long representation (32 bits instead
	 * of 64)
	 *
	 */
	private long sigmaFunctionOperationInteger(int word, int parameter1, int parameter2, int parameter3, boolean SHR) {
		if (SHR) { // Unsigned bit shift is used
			return Integer.rotateRight(word, parameter1) ^ Integer.rotateRight(word, parameter2)
					^ (word >>> parameter3);
		} else {
			return Integer.rotateRight(word, parameter1) ^ Integer.rotateRight(word, parameter2)
					^ Integer.rotateRight(word, parameter3);
		}
	}

	/**
	 * Same as above, but instead of using integer values, using string
	 * representation
	 * 
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

	// From here on, only methods used in SHA-3 computation

	// KECCAK SPONGE FUNCTION
	protected String KECCAK() {
		// Message must be padded in order to have a multiple of r-bit length
		padMessageSHA3();
		if (binaryMessagePadded.length() % rate != 0) {
			throw new NumberFormatException("Padding was not appropriately computed");
		}
		System.out.println(binaryMessagePadded);

		// Calculate the number of r-bit blocks within binaryMessagePadded
		int n = binaryMessagePadded.length() / rate;
		System.out.println("Number of blocks = " + n);

		// Absorbing phase (absorbs the bits from the input from r in r)
		String S = zeroString(width); // Start state
		String zeroC = zeroString(capacity);
		// Bit reordering: within a byte, the MSb is the one on the right
		binaryMessagePadded = invertBits(binaryMessagePadded);
		// As many times as blocks
		for (int i = 0; i < n; i++) {
			System.out.println("Block " + (i + 1));
			showLanes(stateToLanes(binaryMessagePadded.substring(i * rate, i * rate + rate).concat(zeroC)));
			S = Keccak_p(XOR(S, binaryMessagePadded.substring(i * rate, i * rate + rate).concat(zeroC)));
		}

		// Squeezing phase (squeezes bits from r in r)
		String Z = "";
		Z = S;
		Z = Z.concat(S.substring(0, rate));
		// Until the output length is not the desired take r bits from string Z and
		// recompute Keccak_p once per each squeezing
		while (Z.length() < messageDigestLength) {
			S = Keccak_p(S);
			Z = Z.concat(S.substring(0, rate));
		}

		// Hexadecimal digest
		return binaryToHexadecimal(Z.substring(0, messageDigestLength));
	}

	private String invertBits(String input) {
		String res = "";
		StringBuffer sb;
		for (int i = 0; i < input.length(); i += 8) {
			sb = new StringBuffer(input.substring(i, i + 8));
			res += sb.reverse().toString();
		}
		return res;
	}

	private String AND(String a, String b) {
		if (a.equals("1") && b.equals("1")) {
			return "1";
		} else {
			return "0";
		}
	}

	private String XOR(String a, String b) {
		String res = "";
		for (int i = 0; i < a.length(); i++) {
			res += a.charAt(i) ^ b.charAt(i);
		}
		return res;
	}

	private String Keccak_p(String state) {
		// State array is converted into 25 64-bit lanes
		String[][] lanes = stateToLanes(state);
		// Bytes are reversed due to little-endian representation
		reverseBytesLanes(lanes);

		// 5 Step mappings during 24 rounds
		for (int i = 0; i < 24; i++) {
			// Theta substitution
			String[][] C = new String[5][64]; // It contains the parity (XOR) of every column
			String bit1, bit2, bit3, bit4, bit5;
			// XOR operation for every bit in the same column
			for (int x = 0; x < 5; x++) {
				for (int l = 0; l < 64; l++) {
					bit1 = Character.toString(lanes[x][0].charAt(l));
					bit2 = Character.toString(lanes[x][1].charAt(l));
					bit3 = Character.toString(lanes[x][2].charAt(l));
					bit4 = Character.toString(lanes[x][3].charAt(l));
					bit5 = Character.toString(lanes[x][4].charAt(l));
					C[x][l] = XOR(XOR(XOR(XOR(bit1, bit2), bit3), bit4), bit5);
				}
			}
			String[][] D = new String[5][64]; // It contains the parity from two certain columns
			for (int x = 0; x < 5; x++) {
				for (int l = 0; l < 64; l++) {
					// (x + 4) % 5 represents the column before
					// (x + 1) % 5 represents the column after
					// (l + 1) % 64 represents one position forward
					// As bytes are stored little-endian, l position is +1 instead of -1
					D[x][l] = XOR(C[(x + 4) % 5][l], C[(x + 1) % 5][(l + 1) % 64]);
				}
			}
			String originalBit;
			for (int y = 0; y < 5; y++) {
				for (int x = 0; x < 5; x++) {
					for (int l = 0; l < 64; l++) {
						originalBit = Character.toString(lanes[x][y].charAt(l));
						lanes[x][y] = lanes[x][y].substring(0, l) + XOR(originalBit, D[x][l])
								+ lanes[x][y].substring(l + 1);
					}
				}
			}

			System.out.println("\nAfter Theta");
			showLanes(reverseBytesLanes(lanes));
			reverseBytesLanes(lanes);

			// Rho and Pi permutations
			String auxLanes[][] = new String[5][5];

			for (int y = 0; y < 5; y++) {
				for (int x = 0; x < 5; x++) {
					// lanes[0][0] stays the same
					auxLanes[y][(2 * x + 3 * y) % 5] = ROTL(lanes[x][y], offset[x][y]);
				}
			}

			System.out.println("\nAfter Pi and Rho");
			showLanes(reverseBytesLanes(auxLanes));
			reverseBytesLanes(auxLanes);

			// Chi substitution
			String nextBit, nextNextBit;
			for (int y = 0; y < 5; y++) {
				for (int x = 0; x < 5; x++) {
					for (int l = 0; l < 64; l++) {
						originalBit = Character.toString(auxLanes[x][y].charAt(l));
						nextBit = Character.toString(auxLanes[(x + 1) % 5][y].charAt(l));
						nextNextBit = Character.toString(auxLanes[(x + 2) % 5][y].charAt(l));
						lanes[x][y] = lanes[x][y].substring(0, l)
								+ XOR(originalBit, AND(XOR(nextBit, "1"), nextNextBit)) + lanes[x][y].substring(l + 1);
					}
				}
			}

			System.out.println("\nAfter Chi");
			showLanes(reverseBytesLanes(lanes));
			reverseBytesLanes(lanes);

			// Iota substitution
			String rc = Long.toBinaryString(RC[i]);
			// String constants must be 64 bits long
			while (rc.length() < 64) {
				rc = "0" + rc;
			}
			lanes[0][0] = XOR(lanes[0][0], rc);

			System.out.println("\nAfter Iota");
			showLanes(reverseBytesLanes(lanes));
			reverseBytesLanes(lanes);
		}

		reverseBytesLanes(lanes);
		state = lanesToState(lanes);
		return state;
	}

	private void showLanes(String[][] lanes) {
		for (int y = 0; y < 5; y++) {
			for (int x = 0; x < 5; x++) {
//				System.out.println("[" + x + "," + y + "]" + binaryToHexadecimal(lanes[x][y]));
				System.out.println(binaryToHexadecimal(lanes[x][y]));
//				System.out.println("[" + x + "," + y + "]" + lanes[x][y]);
			}
		}
	}

	private String[][] reverseBytesLanes(String[][] lanes) {
		for (int y = 0; y < 5; y++) {
			for (int x = 0; x < 5; x++) {
				lanes[x][y] = reverseBytes64BitWord(lanes[x][y]);
			}
		}
		return lanes;
	}

	private String reverseBytes64BitWord(String word) {
		word = word.substring(56, 64) + word.substring(48, 56) + word.substring(40, 48) + word.substring(32, 40)
				+ word.substring(24, 32) + word.substring(16, 24) + word.substring(8, 16) + word.substring(0, 8);
		return word;
	}

	private String[][] stateToLanes(String state) {
		int index = 0;
		String[][] lanes = new String[5][5];
		for (int y = 0; y < 5; y++) {
			for (int x = 0; x < 5; x++) {
				lanes[x][y] = state.substring(index, index += 64);
			}
		}
		return lanes;
	}

	private String lanesToState(String[][] lanes) {
		String state = "";
		for (int y = 0; y < 5; y++) {
			for (int x = 0; x < 5; x++) {
				state += lanes[x][y];
			}
		}
		return state;
	}

	private void padMessageSHA3() {
		binaryMessagePadded = binaryMessage;
		int j = -binaryMessage.length() - 2;
		// j = mod rate
		while (j < 0) {
			j += rate;
		}
		binaryMessagePadded = binaryMessagePadded + addMultiRatePadding(j);
	}

	private String addMultiRatePadding(int j) {
		String P = "1";
		P += zeroString(j);
		P += "1";
		return P;
	}

	private String zeroString(int length) {
		String zeroString = "";
		for (int i = 0; i < length; i++) {
			zeroString += "0";
		}
		return zeroString;
	}

}