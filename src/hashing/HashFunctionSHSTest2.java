package hashing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * This test class is used for carrying out tests over the hash computation that
 * uses string representation instead of integer values
 * 
 * @author Mario Hermida
 *
 */
public class HashFunctionSHSTest2 {

	private SHA_1 sha1 = new SHA_1("");
	private SHA_224 sha224;
	private SHA_256 sha256;
	private SHA_384 sha384;
	private SHA_512 sha512 = new SHA_512("");
	private SHA_512_224 sha512_224;
	private SHA_512_256 sha512_256;

	// HASH COMPUTATIONS

	// UNICODE ONES

	@Test
	void testHashComputation_UNICODE() { // Armenian characters
		sha1 = new SHA_1("ԱԲԳԴԵԶԷԸԹԺԻԼԽԾԿՀՁՂՃՄՅՆՇՈՉՊՋՌՍՎՏՐՑՒՓՔՕՖՙ՚՛՜՝՞՟ՠաբգդեզէըթժիլխծկհձղճմյնշոչպջռսվտրցւփքօֆևֈ։֊֍֎֏");
		assertEquals("0fb9cd7870517bf0984bd061963abb28b50e33c5", sha1.computeHash2());
	}

	@Test
	void testHashComputation_UNICODE2() { // Tibetan characters
		sha224 = new SHA_224(
				"ༀ༁༂༃༄༅༆༇༈༉༊་༌།༎༏༐༑༒༓༔༕༖༗༘༙༚༛༜༝༞༟༠༡༢༣༤༥༦༧༨༩༪༫༬༭༮༯༰༱༲༳༴༵༶༷༸༹༺༻༼༽༾༿ཀཁགགྷངཅཆཇཉཊཋཌཌྷཎཏཐདདྷནཔཕབབྷམཙཚཛཛྷཝཞཟའཡརལཤཥསཧཨཀྵཪཫཬཱཱཱིིུུྲྀཷླྀཹེཻོཽཾཿ྄ཱྀྀྂྃ྅྆྇ྈྉྊྋྌྍྏྐྑྒྒྷྔྕྖྗྙྚྛྜྜྷྞྟྠྡྡྷྣྤྥྦྦྷྨྩྪྫྫྷྭྮྯྰྱྲླྴྵྶྷྸྐྵྺྻྼ྾྿࿀࿁࿂࿃࿄࿅࿆࿇࿈࿉࿊࿋࿌࿎࿏࿐࿑࿒࿓࿔࿕࿖࿗࿘࿙࿚");
		assertEquals("639ea3cd2385cdcef8a9a36241ca17161d106f3c3f7a38ac8a255673", sha224.computeHash2());
	}

	@Test
	void testHashComputation_UNICODE3() { // Manding languages characters
		sha512 = new SHA_512(
				"߀‎߁‎߂‎߃‎߄‎߅‎߆‎߇‎߈‎߉‎ߊ‎ߋ‎ߌ‎ߍ‎ߎ‎ߏ‎ߐ‎ߑ‎ߒ‎ߓ‎ߔ‎ߕ‎ߖ‎ߗ‎ߘ‎ߙ‎ߚ‎ߛ‎ߜ‎ߝ‎ߞ‎ߟ‎ߠ‎ߡ‎ߢ‎ߣ‎ߤ‎ߥ‎ߦ‎ߧ‎ߨ‎ߩ‎ߪ‎߫‎߬‎߭‎߮‎߯‎߰‎߱‎߲‎߳‎ߴ‎ߵ‎߶‎߷‎߸‎߹‎ߺ‎߽‎߾‎߿");
		assertEquals(
				"393a94c271d0717b7bab57d8652064b71d7ffd6349564d15f64e7243c92bfb910bef6ec237b0811f50223354c226d1e048707d1033970a3d9368143ae22e77a9",
				sha512.computeHash2());
	}

	// SHA-256

	@Test
	void testHashComputation_SHA_256() {
		sha256 = new SHA_256("a");
		assertEquals("ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb", sha256.computeHash2());
	}

	@Test
	void testHashComputation2_SHA_256() {
		sha256 = new SHA_256(""); // empty string
		assertEquals("e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855", sha256.computeHash2());
	}

	@Test
	void testHashComputation3_SHA_256() {
		sha256 = new SHA_256("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertEquals("9f4390f8d30c2dd92ec9f095b65e2b9ae9b0a925a5258e241c9f1e910f734318", sha256.computeHash2());
	}

	@Test
	void testHashComputation4_SHA_256() {
		sha256 = new SHA_256("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertEquals("b35439a4ac6f0948b6d6f9e3c6af0f5f590ce20f1bde7090ef7970686ec6738a", sha256.computeHash2());
	}

	@Test
	void testHashComputation5_SHA_256() {
		sha256 = new SHA_256(
				" !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~");
		assertEquals("cb2a9233adc1225c5c495c46e62cf6308223c5e241ef33ad109f03141b57966a", sha256.computeHash2());
	}

	@Test
	void testHashComputation6_SHA_256() {
		sha256 = new SHA_256(
				"jsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829");
		assertEquals("b5309136b68ba3506388149a71be42699a8a12bcf6c27891472664680b687b55", sha256.computeHash2());
	}

	@Test
	void testHashComputation7_SHA_256() {
		sha256 = new SHA_256(
				"jsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829A");
		assertEquals("a99b2e5ff1db9f5985bc1de6065c3dbab32a4f8c99e30aba4fe516a7978ad748", sha256.computeHash2());
	}

	@Test
	void testHashComputation8_SHA_256() {
		sha256 = new SHA_256(
				"And what is love? It is a doll dressed up For idleness to cosset, nurse, and dandle; A thing of soft misnomers, so divine That silly youth doth think to make itself Divine by loving, and so goes on Yawning and doting a whole summer long, Till Miss's comb is made a perfect tiara, And common Wellingtons turn Romeo boots; Till Cleopatra lives at Number Seven, And Antony resides in Brunswick Square.");
		assertEquals("9bbbd77600ee390ab31746a11a6202182572158766295d8919ab3c90123f2a14", sha256.computeHash2());
	}

	@Test
	void testHashComputation9_SHA_256() { // the one proposed by the NIST institution
		sha256 = new SHA_256("abcdbcdecdefdefgefghfghighijhijkijkljklmklmnlmnomnopnopq");
		assertEquals("248d6a61d20638b8e5c026930c3e6039a33ce45964ff2167f6ecedd419db06c1", sha256.computeHash2());
	}

	// SHA-224

	@Test
	void testHashComputation_SHA_224() {
		sha224 = new SHA_224("a");
		assertEquals("abd37534c7d9a2efb9465de931cd7055ffdb8879563ae98078d6d6d5", sha224.computeHash2());
	}

	@Test
	void testHashComputation2_SHA_224() {
		sha224 = new SHA_224(""); // empty string
		assertEquals("d14a028c2a3a2bc9476102bb288234c415a2b01f828ea62ac5b3e42f", sha224.computeHash2());
	}

	@Test
	void testHashComputation3_SHA_224() {
		sha224 = new SHA_224("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertEquals("fb0bd626a70c28541dfa781bb5cc4d7d7f56622a58f01a0b1ddd646f", sha224.computeHash2());
	}

	@Test
	void testHashComputation4_SHA_224() {
		sha224 = new SHA_224("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertEquals("d40854fc9caf172067136f2e29e1380b14626bf6f0dd06779f820dcd", sha224.computeHash2());
	}

	@Test
	void testHashComputation5_SHA_224() {
		sha224 = new SHA_224(
				" !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~");
		assertEquals("88cc8b6a9c95f8322361f219efb3309020b865fbe0bc0e580c442ff1", sha224.computeHash2());
	}

	@Test
	void testHashComputation6_SHA_224() {
		sha224 = new SHA_224(
				"jsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829");
		assertEquals("de71734bcdd6e336732466572da170ae12034b2434d1d7821ac63066", sha224.computeHash2());
	}

	@Test
	void testHashComputation7_SHA_224() {
		sha224 = new SHA_224(
				"jsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829A");
		assertEquals("4794eb16378a30b6f467c4888193ae64699a38345ed6d25458031bd6", sha224.computeHash2());
	}

	@Test
	void testHashComputation8_SHA_224() {
		sha224 = new SHA_224(
				"And what is love? It is a doll dressed up For idleness to cosset, nurse, and dandle; A thing of soft misnomers, so divine That silly youth doth think to make itself Divine by loving, and so goes on Yawning and doting a whole summer long, Till Miss's comb is made a perfect tiara, And common Wellingtons turn Romeo boots; Till Cleopatra lives at Number Seven, And Antony resides in Brunswick Square.");
		assertEquals("07fefa4dd58d9aba6210e6efdc19f5d56bc0195ff78e72ef2cdc6291", sha224.computeHash2());
	}

	@Test
	void testHashComputation9_SHA_224() { // the one proposed by the NIST institution
		sha224 = new SHA_224("abcdbcdecdefdefgefghfghighijhijkijkljklmklmnlmnomnopnopq");
		assertEquals("75388b16512776cc5dba5da1fd890150b0c6455cb4f58b1952522525", sha224.computeHash2());
	}

	// SHA-512

	@Test
	void testHashComputation_SHA_512() {
		sha512 = new SHA_512("a");
		assertEquals(
				"1f40fc92da241694750979ee6cf582f2d5d7d28e18335de05abc54d0560e0f5302860c652bf08d560252aa5e74210546f369fbbbce8c12cfc7957b2652fe9a75",
				sha512.computeHash2());
	}

	@Test
	void testHashComputation2_SHA_512() {
		sha512 = new SHA_512(""); // empty string
		assertEquals(
				"cf83e1357eefb8bdf1542850d66d8007d620e4050b5715dc83f4a921d36ce9ce47d0d13c5d85f2b0ff8318d2877eec2f63b931bd47417a81a538327af927da3e",
				sha512.computeHash2());
	}

	@Test
	void testHashComputation3_SHA_512() {
		sha512 = new SHA_512(
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertEquals(
				"fa9121c7b32b9e01733d034cfc78cbf67f926c7ed83e82200ef86818196921760b4beff48404df811b953828274461673c68d04e297b0eb7b2b4d60fc6b566a2",
				sha512.computeHash2());
	}

	@Test
	void testHashComputation4_SHA_512() {
		sha512 = new SHA_512(
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertEquals(
				"c01d080efd492776a1c43bd23dd99d0a2e626d481e16782e75d54c2503b5dc32bd05f0f1ba33e568b88fd2d970929b719ecbb152f58f130a407c8830604b70ca",
				sha512.computeHash2());
	}

	@Test
	void testHashComputation5_SHA_512() {
		sha512 = new SHA_512(
				" !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~");
		assertEquals(
				"2078a296f525f03cbb046a26308fbc34d2b9f159f1918978aed4c8e3ca8359c675d7f1188d426016462456b168b6b4c018089db66931ba03b987a87270b95d92",
				sha512.computeHash2());
	}

	@Test
	void testHashComputation6_SHA_512() {
		sha512 = new SHA_512(
				"jsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829jsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829");
		assertEquals(
				"26950004405cfd9c02c8d6bcb41748123923709cf7678a8cc0303457096d49b1e7e029bd3d8e5e6c61660fd43353b3917a10c1bb78383e9052905ee470f90ea6",
				sha512.computeHash2());
	}

	@Test
	void testHashComputation7_SHA_512() {
		sha512 = new SHA_512(
				"jsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829Ajsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829");
		assertEquals(
				"105f1ee5e621618215ac0728911a2a5e1f27b40f306d8eee904fc282ed71aec608607d480199cb9a2ffb586422ded3a0c24db3bdc491577ce78cf5bef3de918d",
				sha512.computeHash2());
	}

	@Test
	void testHashComputation8_SHA_512() {
		sha512 = new SHA_512(
				"And what is love? It is a doll dressed up For idleness to cosset, nurse, and dandle; A thing of soft misnomers, so divine That silly youth doth think to make itself Divine by loving, and so goes on Yawning and doting a whole summer long, Till Miss's comb is made a perfect tiara, And common Wellingtons turn Romeo boots; Till Cleopatra lives at Number Seven, And Antony resides in Brunswick Square.");
		assertEquals(
				"f1b4faaf076bf0ddac03b791d089c6724d28205653b79226c5655fdfa8ee8a99fd412d507ee377d36d1fcc182150004058315efbad5fff1ae35cf56253e4cd8c",
				sha512.computeHash2());
	}

	@Test
	void testHashComputation9_SHA_512() { // the one proposed by the NIST institution
		sha512 = new SHA_512(
				"abcdefghbcdefghicdefghijdefghijkefghijklfghijklmghijklmnhijklmnoijklmnopjklmnopqklmnopqrlmnopqrsmnopqrstnopqrstu");
		assertEquals(
				"8e959b75dae313da8cf4f72814fc143f8f7779c6eb9f7fa17299aeadb6889018501d289e4900f7e4331b99dec4b5433ac7d329eeb6dd26545e96e55b874be909",
				sha512.computeHash2());
	}

	// SHA-384

	@Test
	void testHashComputation_SHA_384() {
		sha384 = new SHA_384("a");
		assertEquals("54a59b9f22b0b80880d8427e548b7c23abd873486e1f035dce9cd697e85175033caa88e6d57bc35efae0b5afd3145f31",
				sha384.computeHash2());
	}

	@Test
	void testHashComputation2_SHA_384() {
		sha384 = new SHA_384("");
		assertEquals("38b060a751ac96384cd9327eb1b1e36a21fdb71114be07434c0cc7bf63f6e1da274edebfe76f65fbd51ad2f14898b95b",
				sha384.computeHash2());
	}

	@Test
	void testHashComputation3_SHA_384() {
		sha384 = new SHA_384(
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertEquals("3c37955051cb5c3026f94d551d5b5e2ac38d572ae4e07172085fed81f8466b8f90dc23a8ffcdea0b8d8e58e8fdacc80a",
				sha384.computeHash2());
	}

	@Test
	void testHashComputation4_SHA_384() {
		sha384 = new SHA_384(
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertEquals("187d4e07cb306103c69967bf544d0dfbe9042577599c73c330abc0cb64c61236d5ed565ee19119d8c31779a38f791fcd",
				sha384.computeHash2());
	}

	@Test
	void testHashComputation5_SHA_384() {
		sha384 = new SHA_384(
				" !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~");
		assertEquals("a09263cf52a3fb9c810dadabb4b744eade65e98e4e7c5ce7e76edfd51460255732658a6dc01f6f925663d64636d0522b",
				sha384.computeHash2());
	}

	@Test
	void testHashComputation6_SHA_384() {
		sha384 = new SHA_384(
				"jsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829jsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829");
		assertEquals("bc1db39a331f1120871290e6e4d62bdd53505c068f30069baecef47def661e66aba5d6562756fa94ceaa55af5405a53f",
				sha384.computeHash2());
	}

	@Test
	void testHashComputation7_SHA_384() {
		sha384 = new SHA_384(
				"jsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829Ajsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829");
		assertEquals("7476ef2819be31b2185181b11a66ce77ddea3d1e8c3fd5031a2f44555dcdb8cd7ba3b8c41188dafbf3c227df3788a3e6",
				sha384.computeHash2());
	}

	@Test
	void testHashComputation8_SHA_384() {
		sha384 = new SHA_384(
				"And what is love? It is a doll dressed up For idleness to cosset, nurse, and dandle; A thing of soft misnomers, so divine That silly youth doth think to make itself Divine by loving, and so goes on Yawning and doting a whole summer long, Till Miss's comb is made a perfect tiara, And common Wellingtons turn Romeo boots; Till Cleopatra lives at Number Seven, And Antony resides in Brunswick Square.");
		assertEquals("21131ae6b08496e859e1593981967bb646c35c174b637073027d199f8a3b047d1ed618850af9e810e5e4bfd7fcd88d16",
				sha384.computeHash2());
	}

	@Test
	void testHashComputation9_SHA_384() { // the one proposed by the NIST institution
		sha384 = new SHA_384(
				"abcdefghbcdefghicdefghijdefghijkefghijklfghijklmghijklmnhijklmnoijklmnopjklmnopqklmnopqrlmnopqrsmnopqrstnopqrstu");
		assertEquals("09330c33f71147e83d192fc782cd1b4753111b173b3b05d22fa08086e3b0f712fcc7c71a557e2db966c3e9fa91746039",
				sha384.computeHash2());
	}

	// SHA-512/224

	@Test
	void testHashComputation_SHA_512_224() {
		sha512_224 = new SHA_512_224("a");
		assertEquals("d5cdb9ccc769a5121d4175f2bfdd13d6310e0d3d361ea75d82108327", sha512_224.computeHash2());
	}

	@Test
	void testHashComputation2_SHA_512_224() {
		sha512_224 = new SHA_512_224("");
		assertEquals("6ed0dd02806fa89e25de060c19d3ac86cabb87d6a0ddd05c333b84f4", sha512_224.computeHash2());
	}

	@Test
	void testHashComputatio3n_SHA_512_224() {
		sha512_224 = new SHA_512_224(
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertEquals("3ebe1b48e8c66acb9ae014db95b4bec93de7e9572bff41cf566bd7d0", sha512_224.computeHash2());
	}

	@Test
	void testHashComputation4_SHA_512_224() {
		sha512_224 = new SHA_512_224(
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertEquals("79b41fef2a0439d2705724a67615f7bcbcd2bf5664a7774b80818eb6", sha512_224.computeHash2());
	}

	@Test
	void testHashComputation5_SHA_512_224() {
		sha512_224 = new SHA_512_224(
				" !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~");
		assertEquals("2f6dcbd0a19753fbd1983a7c3d21a99c9c967e173e642bc277595916", sha512_224.computeHash2());
	}

	@Test
	void testHashComputation6_SHA_512_224() {
		sha512_224 = new SHA_512_224(
				"jsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829jsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829");
		assertEquals("be9e42f749a7fa3d23dad48ea8123acda3b744e8fddeab4df2dcf30f", sha512_224.computeHash2());
	}

	@Test
	void testHashComputation7_SHA_512_224() {
		sha512_224 = new SHA_512_224(
				"jsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829Ajsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829");
		assertEquals("06c7b50fec23cc0a04e4a23252408b89d304abe8be2ac9ecdf3311e7", sha512_224.computeHash2());
	}

	@Test
	void testHashComputation8_SHA_512_224() {
		sha512_224 = new SHA_512_224(
				"And what is love? It is a doll dressed up For idleness to cosset, nurse, and dandle; A thing of soft misnomers, so divine That silly youth doth think to make itself Divine by loving, and so goes on Yawning and doting a whole summer long, Till Miss's comb is made a perfect tiara, And common Wellingtons turn Romeo boots; Till Cleopatra lives at Number Seven, And Antony resides in Brunswick Square.");
		assertEquals("79bb805e77b4dc0abd46eb4b8c030fad9f85adaf2775a231f877bd60", sha512_224.computeHash2());
	}

	@Test
	void testHashComputation9_SHA_512_224() { // the one proposed by the NIST institution
		sha512_224 = new SHA_512_224(
				"abcdefghbcdefghicdefghijdefghijkefghijklfghijklmghijklmnhijklmnoijklmnopjklmnopqklmnopqrlmnopqrsmnopqrstnopqrstu");
		assertEquals("23fec5bb94d60b23308192640b0c453335d664734fe40e7268674af9", sha512_224.computeHash2());
	}

	// SHA-512/256

	@Test
	void testHashComputation_SHA_512_256() {
		sha512_256 = new SHA_512_256("a");
		assertEquals("455e518824bc0601f9fb858ff5c37d417d67c2f8e0df2babe4808858aea830f8", sha512_256.computeHash2());
	}

	@Test
	void testHashComputation2_SHA_512_256() {
		sha512_256 = new SHA_512_256("");
		assertEquals("c672b8d1ef56ed28ab87c3622c5114069bdd3ad7b8f9737498d0c01ecef0967a", sha512_256.computeHash2());
	}

	@Test
	void testHashComputatio3n_SHA_512_256() {
		sha512_256 = new SHA_512_256(
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertEquals("0239e429f98d0ed61ee8e2a7c30afe98c1c3a80ce5dff62a107e9c538f7632ce", sha512_256.computeHash2());
	}

	@Test
	void testHashComputation4_SHA_512_256() {
		sha512_256 = new SHA_512_256(
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertEquals("9216b5303edb66504570bee90e48ea5beaa5e9fe9f760bbd3e0460559fc005f6", sha512_256.computeHash2());
	}

	@Test
	void testHashComputation5_SHA_512_256() {
		sha512_256 = new SHA_512_256(
				" !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~");
		assertEquals("0510340172e3a264338e1ceba2e50127f8b634014ec142b855c9ada34f51e8d3", sha512_256.computeHash2());
	}

	@Test
	void testHashComputation6_SHA_512_256() {
		sha512_256 = new SHA_512_256(
				"jsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829jsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829");
		assertEquals("c8c06366ec9dfe16b5759d7f098c41fa91437c9c5d2e67089b8af792b5afcb2f", sha512_256.computeHash2());
	}

	@Test
	void testHashComputation7_SHA_512_256() {
		sha512_256 = new SHA_512_256(
				"jsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829Ajsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829");
		assertEquals("e1c7705b4fb01bb4619545dd99810f2034b0f8e340e594ca1822588226644b88", sha512_256.computeHash2());
	}

	@Test
	void testHashComputation8_SHA_512_256() {
		sha512_256 = new SHA_512_256(
				"And what is love? It is a doll dressed up For idleness to cosset, nurse, and dandle; A thing of soft misnomers, so divine That silly youth doth think to make itself Divine by loving, and so goes on Yawning and doting a whole summer long, Till Miss's comb is made a perfect tiara, And common Wellingtons turn Romeo boots; Till Cleopatra lives at Number Seven, And Antony resides in Brunswick Square.");
		assertEquals("dc4636c1e3b12e5d1f79a853587f88d2bfa7570793587d50d1097c8a40b7c646", sha512_256.computeHash2());
	}

	@Test
	void testHashComputation9_SHA_512_256() { // the one proposed by the NIST institution
		sha512_256 = new SHA_512_256(
				"abcdefghbcdefghicdefghijdefghijkefghijklfghijklmghijklmnhijklmnoijklmnopjklmnopqklmnopqrlmnopqrsmnopqrstnopqrstu");
		assertEquals("3928e184fb8690f840da3988121d31be65cb9d3ef83ee6146feac861e19b563a", sha512_256.computeHash2());
	}

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

	// END HASH COMPUTATIONS

	// BINARY ADDITION

	@Test
	void testBinaryAddition_32bits() {
		assertEquals("11111111111111111111111111111111",
				sha1.binaryAddition("11111111111111111111111111111111", "0", "0", "0", "0"));
	}

	@Test
	void testBinaryAddition2_32bits() {
		assertEquals("00000000000000000000000000000000",
				sha1.binaryAddition("11111111111111111111111111111111", "1", "0", "0", "0"));
	}

	@Test
	void testBinaryAddition3_32bits() {
		assertEquals("00000000000000000000000000000000", sha1.binaryAddition("11111111111111111111111111111111",
				"11111111111111111111111111111111", "1", "1", "0"));
	}

	@Test
	void testBinaryAddition4_32bits() {
		assertEquals("00111001010000100011011001001110",
				sha1.binaryAddition("11111000100100111", "110001110110011000011001011100", "1000011",
						"10101111000101110011", "111010110111100110100010101"));
	}

	@Test
	void testBinaryAddition5_32bits() {
		assertEquals("00111001010000100011011000001010",
				sha1.binaryAddition("11111000100100111", "110001110110011000011001011100",
						"11111111111111111111111111111111", "10101111000101110011", "111010110111100110100010101"));
	}

	@Test
	void testBinaryAddition_32bits_Exception() {
		assertThrows(IllegalArgumentException.class, () -> {
			sha1.binaryAddition("10010111011110010001100010001000", "10010111011110010001100010001000",
					"100101110111100100011000100010001", "11", "0");
		});
	}

	@Test
	void testBinaryAddition_64bits() {
		assertEquals("1111111111111111111111111111111111111111111111111111111111111111", sha512.binaryAddition(
				"1111111111111111111111111111111111111111111111111111111111111111", "0", "0", "0", "0"));
	}

	@Test
	void testBinaryAddition2_64bits() {
		assertEquals("0000000000000000000000000000000000000000000000000000000000000000", sha512.binaryAddition(
				"1111111111111111111111111111111111111111111111111111111111111111", "1", "0", "0", "0"));
	}

	@Test
	void testBinaryAddition3_64bits() {
		assertEquals("0000000000000000000000000000000000000000000000000000000000000000",
				sha512.binaryAddition("1111111111111111111111111111111111111111111111111111111111111111",
						"1111111111111111111111111111111111111111111111111111111111111111", "1", "1", "0"));
	}

	@Test
	void testBinaryAddition4_64bits() {
		assertEquals("0000000000000000000000000000000000111001010000100011011001001110",
				sha512.binaryAddition("11111000100100111", "110001110110011000011001011100", "1000011",
						"10101111000101110011", "111010110111100110100010101"));
	}

	@Test
	void testBinaryAddition5_64bits() {
		assertEquals("0000000000000000000000000000000000111001010000100011011000001010",
				sha512.binaryAddition("11111000100100111", "110001110110011000011001011100",
						"1111111111111111111111111111111111111111111111111111111111111111", "10101111000101110011",
						"111010110111100110100010101"));
	}

	@Test
	void testBinaryAddition_64bits_Exception() {
		assertThrows(IllegalArgumentException.class, () -> {
			sha512.binaryAddition("1001011101111001000110001000100010010111011110010001100010001000",
					"1001011101111001000110001000100010010111011110010001100010001000",
					"1001011101111001000110001000100010010111011110010001100010001000",
					"1001011101111001000110001000100010010111011110010001100010001000",
					"10010111011110010001100010001000100101110111100100011000100010001");
		});
	}

	// HEXADECIMAL TO BINARY

	@Test
	void testHexadecimalToBinary() {
		assertEquals("00000000", sha1.hexadecimalToBinary("00"));
	}

	@Test
	void testHexadecimalToBinary2() {
		assertEquals("01010010", sha1.hexadecimalToBinary("52"));
	}

	@Test
	void testHexadecimalToBinary3() {
		assertEquals("00001001010010101100101010101111", sha1.hexadecimalToBinary("094acaaf"));
	}

	// FUNCTIONS

	@Test
	void testF() {
		assertEquals("0001001111110001001000001000111000101010010101100010010001100111",
				sha1.f("0111101101010011000000110111000011001100011011110110110110011101",
						"1001011101111001000110001000100000101010110101101011010001000101",
						"0111000011110001001000111110111010101010011110010010010101111010", 0));
	}

	@Test
	void testF2() {
		assertEquals("1001110011011011001110000001011001001100110000001111110010100010",
				sha1.f("0111101101010011000000110111000011001100011011110110110110011101",
						"1001011101111001000110001000100000101010110101101011010001000101",
						"0111000011110001001000111110111010101010011110010010010101111010", 39));
	}

	@Test
	void testF3() {
		assertEquals("0111001101110001000000111110100010101010011111110010010101011101",
				sha1.f("0111101101010011000000110111000011001100011011110110110110011101",
						"1001011101111001000110001000100000101010110101101011010001000101",
						"0111000011110001001000111110111010101010011110010010010101111010", 40));
	}

	@Test
	void testF4() {
		assertEquals("1001110011011011001110000001011001001100110000001111110010100010",
				sha1.f("0111101101010011000000110111000011001100011011110110110110011101",
						"1001011101111001000110001000100000101010110101101011010001000101",
						"0111000011110001001000111110111010101010011110010010010101111010", 79));
	}

	@Test
	void testFException() {
		assertThrows(IllegalArgumentException.class, () -> {
			sha1.f("0111101101010011000000110111000011001100011011110110110110011101",
					"1001011101111001000110001000100000101010110101101011010001000101",
					"0111000011110001001000111110111010101010011110010010010101111010", 80);
		});
	}

	@Test
	void testCh() {
		assertEquals("0001001111110001001000001000111000101010010101100010010001100111",
				sha1.Ch("0111101101010011000000110111000011001100011011110110110110011101",
						"1001011101111001000110001000100000101010110101101011010001000101",
						"0111000011110001001000111110111010101010011110010010010101111010"));
	}

	@Test
	void testParity() {
		assertEquals("1001110011011011001110000001011001001100110000001111110010100010",
				sha1.Parity("0111101101010011000000110111000011001100011011110110110110011101",
						"1001011101111001000110001000100000101010110101101011010001000101",
						"0111000011110001001000111110111010101010011110010010010101111010"));
	}

	@Test
	void testMaj() {
		assertEquals("0111001101110001000000111110100010101010011111110010010101011101",
				sha1.Maj("0111101101010011000000110111000011001100011011110110110110011101",
						"1001011101111001000110001000100000101010110101101011010001000101",
						"0111000011110001001000111110111010101010011110010010010101111010"));
	}

	// SIGMA FUNCTION SPLITTER (64 bits)

	@Test
	void testUpperSigma512_1_64bits() {
		assertEquals("1001100000001101011001100001100010000110110111010010111000000101", sha1.sigmaFunctionSplitter(
				"1001000000110110111001010001010000001101100001011001110101010111", 64, "upper", true));
	}

	@Test
	void testUpperSigma512_0_64bits() {
		assertEquals("1111001100100011101110010001011001001000010000111000010111001111", sha1.sigmaFunctionSplitter(
				"1001000000110110111001010001010000001101100001011001110101010111", 64, "upper", false));
	}

	@Test
	void testLowerSigma512_1_64bits() {
		assertEquals("0011000001011101000000010011001011100000101110000111110101111001", sha1.sigmaFunctionSplitter(
				"1001000000110110111001010001010000001101100001011001110101010111", 64, "lower", true));
	}

	@Test
	void testLowerSigma512_0_64bits() {
		assertEquals("1001111010101011001010011010010100111010110101000100000000001100", sha1.sigmaFunctionSplitter(
				"1001000000110110111001010001010000001101100001011001110101010111", 64, "lower", false));
	}

	// SIGMA FUNCTION SPLITTER (32 BITS)

	@Test
	void testUpperSigma256_1_32bits() {
		assertEquals("11000001001000100101111110000001",
				sha1.sigmaFunctionSplitter("01111010111010000100110101000111", 32, "upper", true));
	}

	@Test
	void testUpperSigma256_0_32bits() {
		assertEquals("00010101101101001101100111111000",
				sha1.sigmaFunctionSplitter("01111010111010000100110101000111", 32, "upper", false));
	}

	@Test
	void testLowerSigma256_1_32bits() {
		assertEquals("00101111000101011110100000111010",
				sha1.sigmaFunctionSplitter("01111010111010000100110101000111", 32, "lower", true));
	}

	@Test
	void testLowerSigma256_0_32bits() {
		assertEquals("10010010111110010000011110001000",
				sha1.sigmaFunctionSplitter("01111010111010000100110101000111", 32, "lower", false));
	}

	// EXCEPTIONS OVER SIGMA FUNCTION

	@Test
	void testSigmaFunctionSplitterException() {
		assertThrows(IllegalArgumentException.class, () -> {
			sha1.sigmaFunctionSplitter("1100101001010010100101001001001010101001110100101010101010110100", 64, "LOWER",
					false);
		});
	}

	@Test
	void testSigmaFunctionSplitterException2() {
		assertThrows(IllegalArgumentException.class, () -> {
			sha1.sigmaFunctionSplitter("1100101001010010100101001001001010101001110100101010101010110100", 128, "lower",
					true);
		});
	}

	// ROTATE LEFT

	@Test
	void testROTL() {
		assertEquals("111010", sha1.ROTL("111010", 0));
	}

	@Test
	void testROTL2() {
		assertEquals("110111", sha1.ROTL("111011", 1));
	}

	@Test
	void testROTL3() {
		assertEquals("111101", sha1.ROTL("111011", 5));
	}

	@Test
	void testROTL4() {
		assertEquals("10100010110001010010100101010111", sha1.ROTL("11101000101100010100101001010101", 2));
	}

	@Test
	void testROTL5() {
		assertEquals("10010100101010111101000101100010", sha1.ROTL("11101000101100010100101001010101", 17));
	}

	@Test
	void testROTL6() {
		assertEquals("1001010010010010101010011101001010101010101101001100101001010010",
				sha1.ROTL("0101001010010100100100101010100111010010101010101011010011001010", 8));
	}

	@Test
	void testROTL7() {
		assertEquals("0101001010010100101001001001010101001110100101010101010110100110",
				sha1.ROTL("0101001010010100100100101010100111010010101010101011010011001010", 59));
	}

	@Test
	void testROTLException() {
		assertThrows(NumberFormatException.class, () -> {
			sha1.ROTL("111010", -5);
		});
	}

	// ROTATE RIGHT

	@Test
	void testROTR() {
		assertEquals("111010", sha1.ROTR("111010", 0));
	}

	@Test
	void testROTR2() {
		assertEquals("011101", sha1.ROTR("111010", 1));
	}

	@Test
	void testROTR3() {
		assertEquals("110101", sha1.ROTR("111010", 5));
	}

	@Test
	void testROTR4() {
		assertEquals("01111010001011000101001010010101", sha1.ROTR("11101000101100010100101001010101", 2));
	}

	@Test
	void testROTR5() {
		assertEquals("10100101001010101111010001011000", sha1.ROTR("11101000101100010100101001010101", 17));
	}

	@Test
	void testROTR6() {
		assertEquals("1100101001010010100101001001001010101001110100101010101010110100",
				sha1.ROTR("0101001010010100100100101010100111010010101010101011010011001010", 8));
	}

	@Test
	void testROTR7() {
		assertEquals("0101001010010010010101010011101001010101010101101001100101001010",
				sha1.ROTR("0101001010010100100100101010100111010010101010101011010011001010", 59));
	}

	@Test
	void testROTRException() {
		assertThrows(NumberFormatException.class, () -> {
			sha1.ROTR("1110", -19);
		});
	}

	// DOUBLE ROTATION

	@Test
	void testROTLROTR() {
		assertEquals(sha1.ROTR("0101001010010100100100101010100111010010101010101011010011001010", 56),
				sha1.ROTL("0101001010010100100100101010100111010010101010101011010011001010", 8));
	}

	@Test
	void testROTLROTR2() {
		assertEquals(sha1.ROTR("0101010100001010011110101010101010101010010110011010101111101010", 5),
				sha1.ROTL("0101010100001010011110101010101010101010010110011010101111101010", 59));
	}

	// SHIFT ROTATION

	@Test
	void testSHR() {
		assertEquals("111010", sha1.SHR("111010", 0));
	}

	@Test
	void testSHR2() {
		assertEquals("011101", sha1.SHR("111010", 1));
	}

	@Test
	void testSHR3() {
		assertEquals("000001", sha1.SHR("111010", 5));
	}

	@Test
	void testSHR4() {
		assertEquals("000000", sha1.SHR("111010", 15));
	}

	@Test
	void testSHR5() {
		assertEquals("00111010001011000101001010010101", sha1.SHR("11101000101100010100101001010101", 2));
	}

	@Test
	void testSHR6() {
		assertEquals("00000000000000000111010001011000", sha1.SHR("11101000101100010100101001010101", 17));
	}

	@Test
	void testSHR7() {
		assertEquals("0000000001010010100101001001001010101001110100101010101010110100",
				sha1.SHR("0101001010010100100100101010100111010010101010101011010011001010", 8));
	}

	@Test
	void testSHR8() {
		assertEquals("0000000000000000000000000000000000000000000000000000000000001010",
				sha1.SHR("0101001010010100100100101010100111010010101010101011010011001010", 59));
	}

	@Test
	void testSHRException() {
		assertThrows(NumberFormatException.class, () -> {
			sha1.SHR("11", -999);
		});
	}

	// LEFT SHIFT OPERATION

	@Test
	void testLeftShiftOperation() {
		assertEquals("111010", sha1.leftShiftOperation("111010", 0));
	}

	@Test
	void testLeftShiftOperation2() {
		assertEquals("110110", sha1.leftShiftOperation("111011", 1));
	}

	@Test
	void testLeftShiftOperation3() {
		assertEquals("100000", sha1.leftShiftOperation("111011", 5));
	}

	@Test
	void testLeftShiftOperation4() {
		assertEquals("000000", sha1.leftShiftOperation("111011", 15));
	}

	@Test
	void testLeftShiftOperation5() {
		assertEquals("10100010110001010010100101010100",
				sha1.leftShiftOperation("11101000101100010100101001010101", 2));
	}

	@Test
	void testLeftShiftOperation6() {
		assertEquals("10010100101010100000000000000000",
				sha1.leftShiftOperation("11101000101100010100101001010101", 17));
	}

	@Test
	void testLeftShiftOperation7() {
		assertEquals("1001010010010010101010011101001010101010101101001100101000000000",
				sha1.leftShiftOperation("0101001010010100100100101010100111010010101010101011010011001010", 8));
	}

	@Test
	void testLeftShiftOperation8() {
		assertEquals("0101000000000000000000000000000000000000000000000000000000000000",
				sha1.leftShiftOperation("0101001010010100100100101010100111010010101010101011010011001010", 59));
	}

	@Test
	void testLeftShiftOperationException() {
		assertThrows(NumberFormatException.class, () -> {
			sha1.leftShiftOperation("111010", -1);
		});
	}

	// RIGHT SHIFT OPERATION

	@Test
	void testRightShiftOperation() {
		assertEquals("111010", sha1.rightShiftOperation("111010", 0));
	}

	@Test
	void testRightShiftOperation2() {
		assertEquals("011101", sha1.rightShiftOperation("111010", 1));
	}

	@Test
	void testRightShiftOperation3() {
		assertEquals("000001", sha1.rightShiftOperation("111010", 5));
	}

	@Test
	void testRightShiftOperation4() {
		assertEquals("000000", sha1.rightShiftOperation("111010", 15));
	}

	@Test
	void testRightShiftOperation5() {
		assertEquals("00111010001011000101001010010101",
				sha1.rightShiftOperation("11101000101100010100101001010101", 2));
	}

	@Test
	void testRightShiftOperation6() {
		assertEquals("00000000000000000111010001011000",
				sha1.rightShiftOperation("11101000101100010100101001010101", 17));
	}

	@Test
	void testRightShiftOperation7() {
		assertEquals("0000000001010010100101001001001010101001110100101010101010110100",
				sha1.rightShiftOperation("0101001010010100100100101010100111010010101010101011010011001010", 8));
	}

	@Test
	void testRightShiftOperation8() {
		assertEquals("0000000000000000000000000000000000000000000000000000000000001010",
				sha1.rightShiftOperation("0101001010010100100100101010100111010010101010101011010011001010", 59));
	}

	@Test
	void testRightShiftOperationException() {
		assertThrows(NumberFormatException.class, () -> {
			sha1.rightShiftOperation("111010", -9);
		});
	}

}
