package shs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class HashFunctionTest2 {

	private SHA_1 sha1 = new SHA_1("");

	@Test
	void testCh() {
		assertEquals(Long.parseUnsignedLong("0001001111110001001000001000111000101010010101100010010001100111", 2),
				sha1.Ch2(Long.parseUnsignedLong("0111101101010011000000110111000011001100011011110110110110011101", 2),
						Long.parseUnsignedLong("1001011101111001000110001000100000101010110101101011010001000101", 2),
								Long.parseUnsignedLong("0111000011110001001000111110111010101010011110010010010101111010", 2)));
	}
	
	@Test
	void testParity() {
		assertEquals(Long.parseUnsignedLong("1001110011011011001110000001011001001100110000001111110010100010", 2),
				sha1.Parity2(Long.parseUnsignedLong("0111101101010011000000110111000011001100011011110110110110011101", 2), 
						Long.parseUnsignedLong("1001011101111001000110001000100000101010110101101011010001000101", 2),
								Long.parseUnsignedLong("0111000011110001001000111110111010101010011110010010010101111010", 2)));
	}

	@Test
	void testMaj() {
		System.out.println("mi puta madre" + Long.parseUnsignedLong("1111001101110001000000111110100010101010011111110010010101011101", 2));
		assertEquals(Long.parseUnsignedLong("0111001101110001000000111110100010101010011111110010010101011101", 2),
				sha1.Maj2(Long.parseUnsignedLong("0111101101010011000000110111000011001100011011110110110110011101", 2),
						Long.parseUnsignedLong("1001011101111001000110001000100000101010110101101011010001000101", 2),
								Long.parseUnsignedLong("0111000011110001001000111110111010101010011110010010010101111010", 2)));
	}

}