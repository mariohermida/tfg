package shs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class HashFunctionTest2 {
	
//	private SHA_1 sha1 = new SHA_1("");

	// LEFT ROTATION
	
	@Test
	void testROTL4() {
		long l = Long.parseLong("11101000101100010100101001010101", 2); 
		assertEquals("10100010110001010010100101010111", Integer.toBinaryString(Integer.rotateLeft((int)l, 2)));
	}

	@Test
	void testROTL5() {
		long l = Long.parseLong("11101000101100010100101001010101", 2); 
		assertEquals("10010100101010111101000101100010", Integer.toBinaryString(Integer.rotateLeft((int)l, 17)));
	}

	@Test
	void testROTL6() {
		long l = Long.parseLong("0101001010010100100100101010100111010010101010101011010011001010", 2); 
		assertEquals("1001010010010010101010011101001010101010101101001100101001010010", Long.toBinaryString(Long.rotateLeft(l, 8)));
	}

	@Test
	void testROTL7() {
		long l = Long.parseLong("0101001010010100100100101010100111010010101010101011010011001010", 2); 
		assertEquals("101001010010100101001001001010101001110100101010101010110100110", Long.toBinaryString(Long.rotateLeft(l, 59)));
	}
	
	// RIGHT ROTATION

	@Test
	void testROTR4() {
		long l = Long.parseLong("11101000101100010100101001010101", 2); 
		assertEquals("1111010001011000101001010010101", Integer.toBinaryString(Integer.rotateRight((int)l, 2)));
	}

	@Test
	void testROTR5() {
		long l = Long.parseLong("11101000101100010100101001010101", 2); 
		assertEquals("10100101001010101111010001011000", Integer.toBinaryString(Integer.rotateRight((int)l, 17)));
	}

	@Test
	void testROTR6() {
		long l = Long.parseLong("0101001010010100100100101010100111010010101010101011010011001010", 2); 
		assertEquals("1100101001010010100101001001001010101001110100101010101010110100", Long.toBinaryString(Long.rotateRight(l, 8)));
	}

	@Test
	void testROTR7() {
		long l = Long.parseLong("0101001010010100100100101010100111010010101010101011010011001010", 2); 
		assertEquals("101001010010010010101010011101001010101010101101001100101001010", Long.toBinaryString(Long.rotateRight(l, 59)));
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
		assertEquals("10100010110001010010100101010100", Integer.toBinaryString(((int)l << 2)));
	}

	@Test
	void testLeftShiftOperation6() {
		long l = Long.parseLong("11101000101100010100101001010101", 2);
		assertEquals("10010100101010100000000000000000", Integer.toBinaryString(((int)l << 17)));
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
		assertEquals("111010001011000101001010010101", Long.toBinaryString(l >> 2));
	}

	@Test
	void testRightShiftOperation6() {
		long l = Long.parseLong("11101000101100010100101001010101", 2);
		assertEquals("111010001011000", Long.toBinaryString(l >> 17));
	}

	@Test
	void testRightShiftOperation7() {
		long l = Long.parseLong("0101001010010100100100101010100111010010101010101011010011001010", 2);
		assertEquals("1010010100101001001001010101001110100101010101010110100", Long.toBinaryString(l >> 8));
	}

	@Test
	void testRightShiftOperation8() {
		long l = Long.parseLong("0101001010010100100100101010100111010010101010101011010011001010", 2);
		assertEquals("1010", Long.toBinaryString(l >> 59));
	}

}
