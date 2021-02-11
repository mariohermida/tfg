package shs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class HashFunctionTest2 {

	private SHA_1 sha1 = new SHA_1("");

	// HASH COMPUTATIONS
	// SHA-1
	@Test
	void testHashComputation_SHA_1() {
		sha1 = new SHA_1("a");
		assertEquals("86f7e437faa5a7fce15d1ddcb9eaeaea377667b8", sha1.computeHash2());
	}

	@Test
	void testHashComputation2_SHA_1() {
		sha1 = new SHA_1(""); // empty string
		assertEquals("da39a3ee5e6b4b0d3255bfef95601890afd80709", sha1.computeHash2());
	}

	@Test
	void testHashComputation3_SHA_1() {
		sha1 = new SHA_1("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertEquals("c1c8bbdc22796e28c0e15163d20899b65621d65a", sha1.computeHash2());
	}

	@Test
	void testHashComputation4_SHA_1() {
		sha1 = new SHA_1("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertEquals("c2db330f6083854c99d4b5bfb6e8f29f201be699", sha1.computeHash2());
	}

	@Test
	void testHashComputation5_SHA_1() {
		sha1 = new SHA_1(
				" !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~");
		assertEquals("e4f8188cdca2a68b074005e2ccab5b67842c6fc7", sha1.computeHash2());
	}

	@Test
	void testHashComputation6_SHA_1() {
		sha1 = new SHA_1(
				"jsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829");
		assertEquals("3775e8d97dac1f0a26ac1418d6009698fa6c8631", sha1.computeHash2());
	}

	@Test
	void testHashComputation7_SHA_1() {
		sha1 = new SHA_1(
				"jsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829A");
		assertEquals("111dd7f517ac9fcc76308b43877df74bf80be10c", sha1.computeHash2());
	}

	@Test
	void testHashComputation8_SHA_1() {
		sha1 = new SHA_1(
				"And what is love? It is a doll dressed up For idleness to cosset, nurse, and dandle; A thing of soft misnomers, so divine That silly youth doth think to make itself Divine by loving, and so goes on Yawning and doting a whole summer long, Till Miss's comb is made a perfect tiara, And common Wellingtons turn Romeo boots; Till Cleopatra lives at Number Seven, And Antony resides in Brunswick Square.");
		assertEquals("1af89fe6c87f9ce56fe768e5598c9876659052e1", sha1.computeHash2());
	}

	@Test
	void testHashComputation9_SHA_1() { // the one proposed by the NIST institution
		sha1 = new SHA_1("abcdbcdecdefdefgefghfghighijhijkijkljklmklmnlmnomnopnopq");
		assertEquals("84983e441c3bd26ebaae4aa1f95129e5e54670f1", sha1.computeHash2());
	}

	// FUNCTIONS

	@Test
	void testF() {
		int a = Integer.parseUnsignedInt("01111011010100110000001101110000", 2);
		int b = Integer.parseUnsignedInt("10010111011110010001100010001000", 2);
		int c = Integer.parseUnsignedInt("01110000111100010010001111101110", 2);
		assertEquals("10011111100010010000010001110", Integer.toBinaryString(sha1.f2(a, b, c, 0)));
	}

	@Test
	void testF2() {
		int a = Integer.parseUnsignedInt("01111011010100110000001101110000", 2);
		int b = Integer.parseUnsignedInt("10010111011110010001100010001000", 2);
		int c = Integer.parseUnsignedInt("01110000111100010010001111101110", 2);
		assertEquals("10011100110110110011100000010110", Integer.toBinaryString(sha1.f2(a, b, c, 39)));
	}

	@Test
	void testF3() {
		int a = Integer.parseUnsignedInt("01111011010100110000001101110000", 2);
		int b = Integer.parseUnsignedInt("10010111011110010001100010001000", 2);
		int c = Integer.parseUnsignedInt("01110000111100010010001111101110", 2);
		assertEquals("1110011011100010000001111101000", Integer.toBinaryString(sha1.f2(a, b, c, 40)));
	}

	@Test
	void testF4() {
		int a = Integer.parseUnsignedInt("01111011010100110000001101110000", 2);
		int b = Integer.parseUnsignedInt("10010111011110010001100010001000", 2);
		int c = Integer.parseUnsignedInt("01110000111100010010001111101110", 2);
		assertEquals("10011100110110110011100000010110", Integer.toBinaryString(sha1.f2(a, b, c, 79)));
	}

	@Test
	void testCh() {
		long a = Long.parseUnsignedLong("0111101101010011000000110111000011001100011011110110110110011101", 2);
		long b = Long.parseUnsignedLong("1001011101111001000110001000100000101010110101101011010001000101", 2);
		long c = Long.parseUnsignedLong("0111000011110001001000111110111010101010011110010010010101111010", 2);
		assertEquals("1001111110001001000001000111000101010010101100010010001100111",
				Long.toBinaryString(sha1.Ch2(a, b, c)));
	}

	@Test
	void testParity() {
		long a = Long.parseUnsignedLong("0111101101010011000000110111000011001100011011110110110110011101", 2);
		long b = Long.parseUnsignedLong("1001011101111001000110001000100000101010110101101011010001000101", 2);
		long c = Long.parseUnsignedLong("0111000011110001001000111110111010101010011110010010010101111010", 2);
		assertEquals("1001110011011011001110000001011001001100110000001111110010100010",
				Long.toBinaryString(sha1.Parity2(a, b, c)));
	}

	@Test
	void testMaj() {
		long a = Long.parseUnsignedLong("0111101101010011000000110111000011001100011011110110110110011101", 2);
		long b = Long.parseUnsignedLong("1001011101111001000110001000100000101010110101101011010001000101", 2);
		long c = Long.parseUnsignedLong("0111000011110001001000111110111010101010011110010010010101111010", 2);
		assertEquals("111001101110001000000111110100010101010011111110010010101011101",
				Long.toBinaryString(sha1.Maj2(a, b, c)));
	}

	// SIGMA FUNCTION SPLITTER (64 bits)

	@Test
	void testUpperSigma512_0_64bits() {
		Long l = Long.parseUnsignedLong("1001000000110110111001010001010000001101100001011001110101010111", 2);
		assertEquals("1111001100100011101110010001011001001000010000111000010111001111",
				Long.toBinaryString(sha1.sigmaFunctionSplitter2(l, 64, "upper", 0)));
	}

	@Test
	void testUpperSigma512_1_64bits() {
		Long l = Long.parseUnsignedLong("1001000000110110111001010001010000001101100001011001110101010111", 2);
		assertEquals("1001100000001101011001100001100010000110110111010010111000000101",
				Long.toBinaryString(sha1.sigmaFunctionSplitter2(l, 64, "upper", 1)));
	}

	@Test
	void testLowerSigma512_0_64bits() {
		Long l = Long.parseUnsignedLong("1001000000110110111001010001010000001101100001011001110101010111", 2);
		assertEquals("1001111010101011001010011010010100111010110101000100000000001100",
				Long.toBinaryString(sha1.sigmaFunctionSplitter2(l, 64, "lower", 0)));
	}

	@Test
	void testLowerSigma512_1_64bits() {
		Long l = Long.parseUnsignedLong("1001000000110110111001010001010000001101100001011001110101010111", 2);
		assertEquals("11000001011101000000010011001011100000101110000111110101111001",
				Long.toBinaryString(sha1.sigmaFunctionSplitter2(l, 64, "lower", 1)));
	}

	// SIGMA FUNCTION SPLITTER (32 bits)

	@Test
	void testUpperSigma256_0_32bits() {
		Long l = Long.parseLong("01111010111010000100110101000111", 2);
		assertEquals("10101101101001101100111111000",
				Integer.toBinaryString((int) sha1.sigmaFunctionSplitter2(l, 32, "upper", 0)));
	}

	@Test
	void testUpperSigma256_1_32bits() {
		Long l = Long.parseLong("01111010111010000100110101000111", 2);
		assertEquals("11000001001000100101111110000001",
				Integer.toBinaryString((int) sha1.sigmaFunctionSplitter2(l, 32, "upper", 1)));
	}

	@Test
	void testLowerSigma256_0_32bits() {
		Long l = Long.parseLong("01111010111010000100110101000111", 2);
		assertEquals("10010010111110010000011110001000",
				Integer.toBinaryString((int) sha1.sigmaFunctionSplitter2(l, 32, "lower", 0)));
	}

	@Test
	void testLowerSigma256_1_32bits() {
		Long l = Long.parseLong("01111010111010000100110101000111", 2);
		assertEquals("101111000101011110100000111010",
				Integer.toBinaryString((int) sha1.sigmaFunctionSplitter2(l, 32, "lower", 1)));
	}

	// LEFT ROTATION

	@Test
	void testROTL4() {
		long l = Long.parseLong("11101000101100010100101001010101", 2);
		assertEquals("10100010110001010010100101010111", Integer.toBinaryString(Integer.rotateLeft((int) l, 2)));
	}

	@Test
	void testROTL5() {
		long l = Long.parseLong("11101000101100010100101001010101", 2);
		assertEquals("10010100101010111101000101100010", Integer.toBinaryString(Integer.rotateLeft((int) l, 17)));
	}

	@Test
	void testROTL6() {
		long l = Long.parseLong("0101001010010100100100101010100111010010101010101011010011001010", 2);
		assertEquals("1001010010010010101010011101001010101010101101001100101001010010",
				Long.toBinaryString(Long.rotateLeft(l, 8)));
	}

	@Test
	void testROTL7() {
		long l = Long.parseLong("0101001010010100100100101010100111010010101010101011010011001010", 2);
		assertEquals("101001010010100101001001001010101001110100101010101010110100110",
				Long.toBinaryString(Long.rotateLeft(l, 59)));
	}

	// RIGHT ROTATION

	@Test
	void testROTR4() {
		long l = Long.parseLong("11101000101100010100101001010101", 2);
		assertEquals("1111010001011000101001010010101", Integer.toBinaryString(Integer.rotateRight((int) l, 2)));
	}

	@Test
	void testROTR5() {
		long l = Long.parseLong("11101000101100010100101001010101", 2);
		assertEquals("10100101001010101111010001011000", Integer.toBinaryString(Integer.rotateRight((int) l, 17)));
	}

	@Test
	void testROTR6() {
		long l = Long.parseLong("0101001010010100100100101010100111010010101010101011010011001010", 2);
		assertEquals("1100101001010010100101001001001010101001110100101010101010110100",
				Long.toBinaryString(Long.rotateRight(l, 8)));
	}

	@Test
	void testROTR7() {
		long l = Long.parseLong("0101001010010100100100101010100111010010101010101011010011001010", 2);
		assertEquals("101001010010010010101010011101001010101010101101001100101001010",
				Long.toBinaryString(Long.rotateRight(l, 59)));
	}

	// DOUBLE ROTATION

	@Test
	void testROTLROTR() {
		long l = Long.parseLong("0101001010010100100100101010100111010010101010101011010011001010", 2);
		assertEquals(Long.rotateRight(l, 56), Long.rotateLeft(l, 8));
	}

	@Test
	void testROTLROTR2() {
		long l = Long.parseLong("0101001010010100100100101010100111010010101010101011010011001010", 2);
		assertEquals(Long.rotateRight(l, 5), Long.rotateLeft(l, 59));
	}

	// LEFT SHIFT OPERATION

	@Test
	void testLeftShiftOperation5() {
		long l = Long.parseLong("11101000101100010100101001010101", 2);
		assertEquals("10100010110001010010100101010100", Integer.toBinaryString(((int) l << 2)));
	}

	@Test
	void testLeftShiftOperation6() {
		long l = Long.parseLong("11101000101100010100101001010101", 2);
		assertEquals("10010100101010100000000000000000", Integer.toBinaryString(((int) l << 17)));
	}

	@Test
	void testLeftShiftOperation7() {
		long l = Long.parseLong("0101001010010100100100101010100111010010101010101011010011001010", 2);
		assertEquals("1001010010010010101010011101001010101010101101001100101000000000", Long.toBinaryString(l << 8));
	}

	@Test
	void testLeftShiftOperation8() {
		long l = Long.parseLong("0101001010010100100100101010100111010010101010101011010011001010", 2);
		assertEquals("101000000000000000000000000000000000000000000000000000000000000", Long.toBinaryString(l << 59));
	}

	// RIGHT SHIFT OPERATION

	@Test
	void testRightShiftOperation5() {
		long l = Long.parseLong("11101000101100010100101001010101", 2);
		assertEquals("111010001011000101001010010101", Long.toBinaryString(l >>> 2));
	}

	@Test
	void testRightShiftOperation6() {
		long l = Long.parseLong("11101000101100010100101001010101", 2);
		assertEquals("111010001011000", Long.toBinaryString(l >>> 17));
	}

	@Test
	void testRightShiftOperation7() {
		long l = Long.parseLong("0101001010010100100100101010100111010010101010101011010011001010", 2);
		assertEquals("1010010100101001001001010101001110100101010101010110100", Long.toBinaryString(l >>> 8));
	}

	@Test
	void testRightShiftOperation8() {
		long l = Long.parseLong("0101001010010100100100101010100111010010101010101011010011001010", 2);
		assertEquals("1010", Long.toBinaryString(l >>> 59));
	}

	@Test
	void testRightShiftOperation9() {
		long l = Long.parseUnsignedLong("1101001010010100100100101010100111010010101010101011010011001010", 2);
		assertEquals("11010", Long.toBinaryString(l >>> 59));
	}

}
