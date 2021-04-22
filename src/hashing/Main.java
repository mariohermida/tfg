package hashing;

/**
 * 
 * @author Mario Hermida
 *
 */

public class Main {

	public static void main(String[] args) throws Exception {
		Main program = new Main();
		program.start();
	}

	private void start() {
		System.out.println("Starting program...\n");
		
		SHA_3_224 sh = new SHA_3_224("Prueba");
		System.out.println(sh.computeHash());
		SHA_3_256 sh2 = new SHA_3_256("Prueba");
		System.out.println(sh2.computeHash());
		SHA_3_384 sh3 = new SHA_3_384("Prueba");
		System.out.println(sh3.computeHash());
		SHA_3_512 sh4 = new SHA_3_512("Prueba");
		System.out.println(sh4.computeHash());
		
		// Hello from here
		
//		new ControllerSHS();
		
		
		/* SHA-512/224 AND SHA-512/256 INITIALIZATION VECTORS
		 * 
		SHA_512 sh = new SHA_512("SHA-512/256");
		String a[] = new String[8];
		for (int i = 0; i < 8; i++) {
			a[i] = sh.hexadecimalToBinary(sh.initialHashValues2[i]);
		}
		String b = sh.hexadecimalToBinary("a5a5a5a5a5a5a5a5");
		String temp[] = new String[8];
		for (int j = 0; j < 8; j++) {
			temp[j] = "";
			for (int i = 0; i < b.length(); i++) {
				temp[j] += (a[j].charAt(i) ^ b.charAt(i));
			}
		}
		for (int i = 0; i < 8; i++) {
			temp[i] = sh.binaryToHexadecimal(temp[i]);
		}
		for (int i = 0; i < 128; i+=16) {
			System.out.println(sh.computeSHA2Hash(temp, 80, 2).substring(i, i+16));
		}*/

	}

}