package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import shs.DataTreatment;

public class DataTreatmentTest {

	private DataTreatment d = new DataTreatment();
	
	@Test
	void testTextToBinary() {
		assertEquals("00000000", d.textToBinary(""));
		assertEquals(
				"0010000000100001001000100010001100100100001001010010011000100111001010000010100100101010001010110010110000101101001011100010111100110000001100010011001000110011001101000011010100110110001101110011100000111001001110100011101100111100001111010011111000111111010000000100000101000010010000110100010001000101010001100100011101001000010010010100101001001011010011000100110101001110010011110101000001010001010100100101001101010100010101010101011001010111010110000101100101011010010110110101110001011101010111100101111101100000011000010110001001100011011001000110010101100110011001110110100001101001011010100110101101101100011011010110111001101111011100000111000101110010011100110111010001110101011101100111011101111000011110010111101001111011011111000111110101111110",
				d.textToBinary(
						" !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~"));
	}

	@Test
	void testBinaryToHexadecimal() {
		assertEquals("00", d.binaryToHexadecimal("000000"));
		assertEquals("52", d.binaryToHexadecimal("1010010"));
		assertEquals("094acaaf", d.binaryToHexadecimal("01001010010101100101010101111"));
	}

	@Test
	void testHexadecimalToBinary() {
		assertEquals("00000000", d.hexadecimalToBinary("00"));
		assertEquals("01010010", d.hexadecimalToBinary("52"));
		assertEquals("00001001010010101100101010101111", d.hexadecimalToBinary("094acaaf"));
	}

}
