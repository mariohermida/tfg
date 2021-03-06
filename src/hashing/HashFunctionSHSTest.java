package hashing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * This test class is used for testing hash computations which use integer
 * representation and for testing common methods
 * 
 * @author Mario Hermida
 *
 */
class HashFunctionSHSTest {

	private SHA_1 sha1 = new SHA_1("");
	private SHA_224 sha224;
	private SHA_256 sha256;
	private SHA_384 sha384;
	private SHA_512 sha512;
	private SHA_512_224 sha512_224;
	private SHA_512_256 sha512_256;

	// HASH COMPUTATIONS

	// UNICODE ONES

	@Test
	void testHashComputation_UNICODE() { // Armenian characters
		sha1 = new SHA_1("ԱԲԳԴԵԶԷԸԹԺԻԼԽԾԿՀՁՂՃՄՅՆՇՈՉՊՋՌՍՎՏՐՑՒՓՔՕՖՙ՚՛՜՝՞՟ՠաբգդեզէըթժիլխծկհձղճմյնշոչպջռսվտրցւփքօֆևֈ։֊֍֎֏");
		assertEquals("0fb9cd7870517bf0984bd061963abb28b50e33c5", sha1.computeHash());
	}

	@Test
	void testHashComputation_UNICODE2() { // Tibetan characters
		sha224 = new SHA_224(
				"ༀ༁༂༃༄༅༆༇༈༉༊་༌།༎༏༐༑༒༓༔༕༖༗༘༙༚༛༜༝༞༟༠༡༢༣༤༥༦༧༨༩༪༫༬༭༮༯༰༱༲༳༴༵༶༷༸༹༺༻༼༽༾༿ཀཁགགྷངཅཆཇཉཊཋཌཌྷཎཏཐདདྷནཔཕབབྷམཙཚཛཛྷཝཞཟའཡརལཤཥསཧཨཀྵཪཫཬཱཱཱིིུུྲྀཷླྀཹེཻོཽཾཿ྄ཱྀྀྂྃ྅྆྇ྈྉྊྋྌྍྏྐྑྒྒྷྔྕྖྗྙྚྛྜྜྷྞྟྠྡྡྷྣྤྥྦྦྷྨྩྪྫྫྷྭྮྯྰྱྲླྴྵྶྷྸྐྵྺྻྼ྾྿࿀࿁࿂࿃࿄࿅࿆࿇࿈࿉࿊࿋࿌࿎࿏࿐࿑࿒࿓࿔࿕࿖࿗࿘࿙࿚");
		assertEquals("639ea3cd2385cdcef8a9a36241ca17161d106f3c3f7a38ac8a255673", sha224.computeHash());
	}

	@Test
	void testHashComputation_UNICODE3() { // Manding languages characters
		sha512 = new SHA_512(
				"߀‎߁‎߂‎߃‎߄‎߅‎߆‎߇‎߈‎߉‎ߊ‎ߋ‎ߌ‎ߍ‎ߎ‎ߏ‎ߐ‎ߑ‎ߒ‎ߓ‎ߔ‎ߕ‎ߖ‎ߗ‎ߘ‎ߙ‎ߚ‎ߛ‎ߜ‎ߝ‎ߞ‎ߟ‎ߠ‎ߡ‎ߢ‎ߣ‎ߤ‎ߥ‎ߦ‎ߧ‎ߨ‎ߩ‎ߪ‎߫‎߬‎߭‎߮‎߯‎߰‎߱‎߲‎߳‎ߴ‎ߵ‎߶‎߷‎߸‎߹‎ߺ‎߽‎߾‎߿");
		assertEquals(
				"393a94c271d0717b7bab57d8652064b71d7ffd6349564d15f64e7243c92bfb910bef6ec237b0811f50223354c226d1e048707d1033970a3d9368143ae22e77a9",
				sha512.computeHash());
	}

	// SHA-256

	@Test
	void testHashComputation_SHA_256() {
		sha256 = new SHA_256("a");
		assertEquals("ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb", sha256.computeHash());
	}

	@Test
	void testHashComputation2_SHA_256() {
		sha256 = new SHA_256(""); // empty string
		assertEquals("e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855", sha256.computeHash());
	}

	@Test
	void testHashComputation3_SHA_256() {
		sha256 = new SHA_256("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertEquals("9f4390f8d30c2dd92ec9f095b65e2b9ae9b0a925a5258e241c9f1e910f734318", sha256.computeHash());
	}

	@Test
	void testHashComputation4_SHA_256() {
		sha256 = new SHA_256("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertEquals("b35439a4ac6f0948b6d6f9e3c6af0f5f590ce20f1bde7090ef7970686ec6738a", sha256.computeHash());
	}

	@Test
	void testHashComputation5_SHA_256() {
		sha256 = new SHA_256(
				" !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~");
		assertEquals("cb2a9233adc1225c5c495c46e62cf6308223c5e241ef33ad109f03141b57966a", sha256.computeHash());
	}

	@Test
	void testHashComputation6_SHA_256() {
		sha256 = new SHA_256(
				"jsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829");
		assertEquals("b5309136b68ba3506388149a71be42699a8a12bcf6c27891472664680b687b55", sha256.computeHash());
	}

	@Test
	void testHashComputation7_SHA_256() {
		sha256 = new SHA_256(
				"jsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829A");
		assertEquals("a99b2e5ff1db9f5985bc1de6065c3dbab32a4f8c99e30aba4fe516a7978ad748", sha256.computeHash());
	}

	@Test
	void testHashComputation8_SHA_256() {
		sha256 = new SHA_256(
				"And what is love? It is a doll dressed up For idleness to cosset, nurse, and dandle; A thing of soft misnomers, so divine That silly youth doth think to make itself Divine by loving, and so goes on Yawning and doting a whole summer long, Till Miss's comb is made a perfect tiara, And common Wellingtons turn Romeo boots; Till Cleopatra lives at Number Seven, And Antony resides in Brunswick Square.");
		assertEquals("9bbbd77600ee390ab31746a11a6202182572158766295d8919ab3c90123f2a14", sha256.computeHash());
	}

	@Test
	void testHashComputation9_SHA_256() { // the one proposed by the NIST institution
		sha256 = new SHA_256("abcdbcdecdefdefgefghfghighijhijkijkljklmklmnlmnomnopnopq");
		assertEquals("248d6a61d20638b8e5c026930c3e6039a33ce45964ff2167f6ecedd419db06c1", sha256.computeHash());
	}

	// SHA-224

	@Test
	void testHashComputation_SHA_224() {
		sha224 = new SHA_224("a");
		assertEquals("abd37534c7d9a2efb9465de931cd7055ffdb8879563ae98078d6d6d5", sha224.computeHash());
	}

	@Test
	void testHashComputation2_SHA_224() {
		sha224 = new SHA_224(""); // empty string
		assertEquals("d14a028c2a3a2bc9476102bb288234c415a2b01f828ea62ac5b3e42f", sha224.computeHash());
	}

	@Test
	void testHashComputation3_SHA_224() {
		sha224 = new SHA_224("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertEquals("fb0bd626a70c28541dfa781bb5cc4d7d7f56622a58f01a0b1ddd646f", sha224.computeHash());
	}

	@Test
	void testHashComputation4_SHA_224() {
		sha224 = new SHA_224("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertEquals("d40854fc9caf172067136f2e29e1380b14626bf6f0dd06779f820dcd", sha224.computeHash());
	}

	@Test
	void testHashComputation5_SHA_224() {
		sha224 = new SHA_224(
				" !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~");
		assertEquals("88cc8b6a9c95f8322361f219efb3309020b865fbe0bc0e580c442ff1", sha224.computeHash());
	}

	@Test
	void testHashComputation6_SHA_224() {
		sha224 = new SHA_224(
				"jsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829");
		assertEquals("de71734bcdd6e336732466572da170ae12034b2434d1d7821ac63066", sha224.computeHash());
	}

	@Test
	void testHashComputation7_SHA_224() {
		sha224 = new SHA_224(
				"jsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829A");
		assertEquals("4794eb16378a30b6f467c4888193ae64699a38345ed6d25458031bd6", sha224.computeHash());
	}

	@Test
	void testHashComputation8_SHA_224() {
		sha224 = new SHA_224(
				"And what is love? It is a doll dressed up For idleness to cosset, nurse, and dandle; A thing of soft misnomers, so divine That silly youth doth think to make itself Divine by loving, and so goes on Yawning and doting a whole summer long, Till Miss's comb is made a perfect tiara, And common Wellingtons turn Romeo boots; Till Cleopatra lives at Number Seven, And Antony resides in Brunswick Square.");
		assertEquals("07fefa4dd58d9aba6210e6efdc19f5d56bc0195ff78e72ef2cdc6291", sha224.computeHash());
	}

	@Test
	void testHashComputation9_SHA_224() { // the one proposed by the NIST institution
		sha224 = new SHA_224("abcdbcdecdefdefgefghfghighijhijkijkljklmklmnlmnomnopnopq");
		assertEquals("75388b16512776cc5dba5da1fd890150b0c6455cb4f58b1952522525", sha224.computeHash());
	}

	// SHA-512

	@Test
	void testHashComputation_SHA_512() {
		sha512 = new SHA_512("a");
		assertEquals(
				"1f40fc92da241694750979ee6cf582f2d5d7d28e18335de05abc54d0560e0f5302860c652bf08d560252aa5e74210546f369fbbbce8c12cfc7957b2652fe9a75",
				sha512.computeHash());
	}

	@Test
	void testHashComputation2_SHA_512() {
		sha512 = new SHA_512(""); // empty string
		assertEquals(
				"cf83e1357eefb8bdf1542850d66d8007d620e4050b5715dc83f4a921d36ce9ce47d0d13c5d85f2b0ff8318d2877eec2f63b931bd47417a81a538327af927da3e",
				sha512.computeHash());
	}

	@Test
	void testHashComputation3_SHA_512() {
		sha512 = new SHA_512(
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertEquals(
				"fa9121c7b32b9e01733d034cfc78cbf67f926c7ed83e82200ef86818196921760b4beff48404df811b953828274461673c68d04e297b0eb7b2b4d60fc6b566a2",
				sha512.computeHash());
	}

	@Test
	void testHashComputation4_SHA_512() {
		sha512 = new SHA_512(
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertEquals(
				"c01d080efd492776a1c43bd23dd99d0a2e626d481e16782e75d54c2503b5dc32bd05f0f1ba33e568b88fd2d970929b719ecbb152f58f130a407c8830604b70ca",
				sha512.computeHash());
	}

	@Test
	void testHashComputation5_SHA_512() {
		sha512 = new SHA_512(
				" !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~");
		assertEquals(
				"2078a296f525f03cbb046a26308fbc34d2b9f159f1918978aed4c8e3ca8359c675d7f1188d426016462456b168b6b4c018089db66931ba03b987a87270b95d92",
				sha512.computeHash());
	}

	@Test
	void testHashComputation6_SHA_512() {
		sha512 = new SHA_512(
				"jsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829jsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829");
		assertEquals(
				"26950004405cfd9c02c8d6bcb41748123923709cf7678a8cc0303457096d49b1e7e029bd3d8e5e6c61660fd43353b3917a10c1bb78383e9052905ee470f90ea6",
				sha512.computeHash());
	}

	@Test
	void testHashComputation7_SHA_512() {
		sha512 = new SHA_512(
				"jsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829Ajsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829");
		assertEquals(
				"105f1ee5e621618215ac0728911a2a5e1f27b40f306d8eee904fc282ed71aec608607d480199cb9a2ffb586422ded3a0c24db3bdc491577ce78cf5bef3de918d",
				sha512.computeHash());
	}

	@Test
	void testHashComputation8_SHA_512() {
		sha512 = new SHA_512(
				"And what is love? It is a doll dressed up For idleness to cosset, nurse, and dandle; A thing of soft misnomers, so divine That silly youth doth think to make itself Divine by loving, and so goes on Yawning and doting a whole summer long, Till Miss's comb is made a perfect tiara, And common Wellingtons turn Romeo boots; Till Cleopatra lives at Number Seven, And Antony resides in Brunswick Square.");
		assertEquals(
				"f1b4faaf076bf0ddac03b791d089c6724d28205653b79226c5655fdfa8ee8a99fd412d507ee377d36d1fcc182150004058315efbad5fff1ae35cf56253e4cd8c",
				sha512.computeHash());
	}

	@Test
	void testHashComputation9_SHA_512() { // the one proposed by the NIST institution
		sha512 = new SHA_512(
				"abcdefghbcdefghicdefghijdefghijkefghijklfghijklmghijklmnhijklmnoijklmnopjklmnopqklmnopqrlmnopqrsmnopqrstnopqrstu");
		assertEquals(
				"8e959b75dae313da8cf4f72814fc143f8f7779c6eb9f7fa17299aeadb6889018501d289e4900f7e4331b99dec4b5433ac7d329eeb6dd26545e96e55b874be909",
				sha512.computeHash());
	}

	// SHA-384

	@Test
	void testHashComputation_SHA_384() {
		sha384 = new SHA_384("a");
		assertEquals("54a59b9f22b0b80880d8427e548b7c23abd873486e1f035dce9cd697e85175033caa88e6d57bc35efae0b5afd3145f31",
				sha384.computeHash());
	}

	@Test
	void testHashComputation2_SHA_384() {
		sha384 = new SHA_384("");
		assertEquals("38b060a751ac96384cd9327eb1b1e36a21fdb71114be07434c0cc7bf63f6e1da274edebfe76f65fbd51ad2f14898b95b",
				sha384.computeHash());
	}

	@Test
	void testHashComputation3_SHA_384() {
		sha384 = new SHA_384(
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertEquals("3c37955051cb5c3026f94d551d5b5e2ac38d572ae4e07172085fed81f8466b8f90dc23a8ffcdea0b8d8e58e8fdacc80a",
				sha384.computeHash());
	}

	@Test
	void testHashComputation4_SHA_384() {
		sha384 = new SHA_384(
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertEquals("187d4e07cb306103c69967bf544d0dfbe9042577599c73c330abc0cb64c61236d5ed565ee19119d8c31779a38f791fcd",
				sha384.computeHash());
	}

	@Test
	void testHashComputation5_SHA_384() {
		sha384 = new SHA_384(
				" !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~");
		assertEquals("a09263cf52a3fb9c810dadabb4b744eade65e98e4e7c5ce7e76edfd51460255732658a6dc01f6f925663d64636d0522b",
				sha384.computeHash());
	}

	@Test
	void testHashComputation6_SHA_384() {
		sha384 = new SHA_384(
				"jsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829jsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829");
		assertEquals("bc1db39a331f1120871290e6e4d62bdd53505c068f30069baecef47def661e66aba5d6562756fa94ceaa55af5405a53f",
				sha384.computeHash());
	}

	@Test
	void testHashComputation7_SHA_384() {
		sha384 = new SHA_384(
				"jsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829Ajsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829");
		assertEquals("7476ef2819be31b2185181b11a66ce77ddea3d1e8c3fd5031a2f44555dcdb8cd7ba3b8c41188dafbf3c227df3788a3e6",
				sha384.computeHash());
	}

	@Test
	void testHashComputation8_SHA_384() {
		sha384 = new SHA_384(
				"And what is love? It is a doll dressed up For idleness to cosset, nurse, and dandle; A thing of soft misnomers, so divine That silly youth doth think to make itself Divine by loving, and so goes on Yawning and doting a whole summer long, Till Miss's comb is made a perfect tiara, And common Wellingtons turn Romeo boots; Till Cleopatra lives at Number Seven, And Antony resides in Brunswick Square.");
		assertEquals("21131ae6b08496e859e1593981967bb646c35c174b637073027d199f8a3b047d1ed618850af9e810e5e4bfd7fcd88d16",
				sha384.computeHash());
	}

	@Test
	void testHashComputation9_SHA_384() { // the one proposed by the NIST institution
		sha384 = new SHA_384(
				"abcdefghbcdefghicdefghijdefghijkefghijklfghijklmghijklmnhijklmnoijklmnopjklmnopqklmnopqrlmnopqrsmnopqrstnopqrstu");
		assertEquals("09330c33f71147e83d192fc782cd1b4753111b173b3b05d22fa08086e3b0f712fcc7c71a557e2db966c3e9fa91746039",
				sha384.computeHash());
	}

	// SHA-512/224

	@Test
	void testHashComputation_SHA_512_224() {
		sha512_224 = new SHA_512_224("a");
		assertEquals("d5cdb9ccc769a5121d4175f2bfdd13d6310e0d3d361ea75d82108327", sha512_224.computeHash());
	}

	@Test
	void testHashComputation2_SHA_512_224() {
		sha512_224 = new SHA_512_224("");
		assertEquals("6ed0dd02806fa89e25de060c19d3ac86cabb87d6a0ddd05c333b84f4", sha512_224.computeHash());
	}

	@Test
	void testHashComputatio3n_SHA_512_224() {
		sha512_224 = new SHA_512_224(
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertEquals("3ebe1b48e8c66acb9ae014db95b4bec93de7e9572bff41cf566bd7d0", sha512_224.computeHash());
	}

	@Test
	void testHashComputation4_SHA_512_224() {
		sha512_224 = new SHA_512_224(
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertEquals("79b41fef2a0439d2705724a67615f7bcbcd2bf5664a7774b80818eb6", sha512_224.computeHash());
	}

	@Test
	void testHashComputation5_SHA_512_224() {
		sha512_224 = new SHA_512_224(
				" !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~");
		assertEquals("2f6dcbd0a19753fbd1983a7c3d21a99c9c967e173e642bc277595916", sha512_224.computeHash());
	}

	@Test
	void testHashComputation6_SHA_512_224() {
		sha512_224 = new SHA_512_224(
				"jsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829jsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829");
		assertEquals("be9e42f749a7fa3d23dad48ea8123acda3b744e8fddeab4df2dcf30f", sha512_224.computeHash());
	}

	@Test
	void testHashComputation7_SHA_512_224() {
		sha512_224 = new SHA_512_224(
				"jsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829Ajsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829");
		assertEquals("06c7b50fec23cc0a04e4a23252408b89d304abe8be2ac9ecdf3311e7", sha512_224.computeHash());
	}

	@Test
	void testHashComputation8_SHA_512_224() {
		sha512_224 = new SHA_512_224(
				"And what is love? It is a doll dressed up For idleness to cosset, nurse, and dandle; A thing of soft misnomers, so divine That silly youth doth think to make itself Divine by loving, and so goes on Yawning and doting a whole summer long, Till Miss's comb is made a perfect tiara, And common Wellingtons turn Romeo boots; Till Cleopatra lives at Number Seven, And Antony resides in Brunswick Square.");
		assertEquals("79bb805e77b4dc0abd46eb4b8c030fad9f85adaf2775a231f877bd60", sha512_224.computeHash());
	}

	@Test
	void testHashComputation9_SHA_512_224() { // the one proposed by the NIST institution
		sha512_224 = new SHA_512_224(
				"abcdefghbcdefghicdefghijdefghijkefghijklfghijklmghijklmnhijklmnoijklmnopjklmnopqklmnopqrlmnopqrsmnopqrstnopqrstu");
		assertEquals("23fec5bb94d60b23308192640b0c453335d664734fe40e7268674af9", sha512_224.computeHash());
	}

	// SHA-512/256

	@Test
	void testHashComputation_SHA_512_256() {
		sha512_256 = new SHA_512_256("a");
		assertEquals("455e518824bc0601f9fb858ff5c37d417d67c2f8e0df2babe4808858aea830f8", sha512_256.computeHash());
	}

	@Test
	void testHashComputation2_SHA_512_256() {
		sha512_256 = new SHA_512_256("");
		assertEquals("c672b8d1ef56ed28ab87c3622c5114069bdd3ad7b8f9737498d0c01ecef0967a", sha512_256.computeHash());
	}

	@Test
	void testHashComputatio3n_SHA_512_256() {
		sha512_256 = new SHA_512_256(
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertEquals("0239e429f98d0ed61ee8e2a7c30afe98c1c3a80ce5dff62a107e9c538f7632ce", sha512_256.computeHash());
	}

	@Test
	void testHashComputation4_SHA_512_256() {
		sha512_256 = new SHA_512_256(
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertEquals("9216b5303edb66504570bee90e48ea5beaa5e9fe9f760bbd3e0460559fc005f6", sha512_256.computeHash());
	}

	@Test
	void testHashComputation5_SHA_512_256() {
		sha512_256 = new SHA_512_256(
				" !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~");
		assertEquals("0510340172e3a264338e1ceba2e50127f8b634014ec142b855c9ada34f51e8d3", sha512_256.computeHash());
	}

	@Test
	void testHashComputation6_SHA_512_256() {
		sha512_256 = new SHA_512_256(
				"jsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829jsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829");
		assertEquals("c8c06366ec9dfe16b5759d7f098c41fa91437c9c5d2e67089b8af792b5afcb2f", sha512_256.computeHash());
	}

	@Test
	void testHashComputation7_SHA_512_256() {
		sha512_256 = new SHA_512_256(
				"jsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829Ajsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829");
		assertEquals("e1c7705b4fb01bb4619545dd99810f2034b0f8e340e594ca1822588226644b88", sha512_256.computeHash());
	}

	@Test
	void testHashComputation8_SHA_512_256() {
		sha512_256 = new SHA_512_256(
				"And what is love? It is a doll dressed up For idleness to cosset, nurse, and dandle; A thing of soft misnomers, so divine That silly youth doth think to make itself Divine by loving, and so goes on Yawning and doting a whole summer long, Till Miss's comb is made a perfect tiara, And common Wellingtons turn Romeo boots; Till Cleopatra lives at Number Seven, And Antony resides in Brunswick Square.");
		assertEquals("dc4636c1e3b12e5d1f79a853587f88d2bfa7570793587d50d1097c8a40b7c646", sha512_256.computeHash());
	}

	@Test
	void testHashComputation9_SHA_512_256() { // the one proposed by the NIST institution
		sha512_256 = new SHA_512_256(
				"abcdefghbcdefghicdefghijdefghijkefghijklfghijklmghijklmnhijklmnoijklmnopjklmnopqklmnopqrlmnopqrsmnopqrstnopqrstu");
		assertEquals("3928e184fb8690f840da3988121d31be65cb9d3ef83ee6146feac861e19b563a", sha512_256.computeHash());
	}

	// SHA-1

	@Test
	void testHashComputation_SHA_1() {
		sha1 = new SHA_1("a");
		assertEquals("86f7e437faa5a7fce15d1ddcb9eaeaea377667b8", sha1.computeHash());
	}

	@Test
	void testHashComputation2_SHA_1() {
		sha1 = new SHA_1(""); // empty string
		assertEquals("da39a3ee5e6b4b0d3255bfef95601890afd80709", sha1.computeHash());
	}

	@Test
	void testHashComputation3_SHA_1() {
		sha1 = new SHA_1("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertEquals("c1c8bbdc22796e28c0e15163d20899b65621d65a", sha1.computeHash());
	}

	@Test
	void testHashComputation4_SHA_1() {
		sha1 = new SHA_1("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertEquals("c2db330f6083854c99d4b5bfb6e8f29f201be699", sha1.computeHash());
	}

	@Test
	void testHashComputation5_SHA_1() {
		sha1 = new SHA_1(
				" !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~");
		assertEquals("e4f8188cdca2a68b074005e2ccab5b67842c6fc7", sha1.computeHash());
	}

	@Test
	void testHashComputation6_SHA_1() {
		sha1 = new SHA_1(
				"jsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829");
		assertEquals("3775e8d97dac1f0a26ac1418d6009698fa6c8631", sha1.computeHash());
	}

	@Test
	void testHashComputation7_SHA_1() {
		sha1 = new SHA_1(
				"jsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829A");
		assertEquals("111dd7f517ac9fcc76308b43877df74bf80be10c", sha1.computeHash());
	}

	@Test
	void testHashComputation8_SHA_1() {
		sha1 = new SHA_1(
				"And what is love? It is a doll dressed up For idleness to cosset, nurse, and dandle; A thing of soft misnomers, so divine That silly youth doth think to make itself Divine by loving, and so goes on Yawning and doting a whole summer long, Till Miss's comb is made a perfect tiara, And common Wellingtons turn Romeo boots; Till Cleopatra lives at Number Seven, And Antony resides in Brunswick Square.");
		assertEquals("1af89fe6c87f9ce56fe768e5598c9876659052e1", sha1.computeHash());
	}

	@Test
	void testHashComputation9_SHA_1() { // the one proposed by the NIST institution
		sha1 = new SHA_1("abcdbcdecdefdefgefghfghighijhijkijkljklmklmnlmnomnopnopq");
		assertEquals("84983e441c3bd26ebaae4aa1f95129e5e54670f1", sha1.computeHash());
	}
	
	// SHA-1 ALTERNATE METHOD
	
	@Test
	void testHashComputation_SHA_1AlternateMethod() {
		sha1 = new SHA_1("a");
		assertEquals("86f7e437faa5a7fce15d1ddcb9eaeaea377667b8", sha1.computeHashAlternateMethod());
	}

	@Test
	void testHashComputation2_SHA_1AlternateMethod() {
		sha1 = new SHA_1(""); // empty string
		assertEquals("da39a3ee5e6b4b0d3255bfef95601890afd80709", sha1.computeHashAlternateMethod());
	}

	@Test
	void testHashComputation3_SHA_1AlternateMethod() {
		sha1 = new SHA_1("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertEquals("c1c8bbdc22796e28c0e15163d20899b65621d65a", sha1.computeHashAlternateMethod());
	}

	@Test
	void testHashComputation4_SHA_1AlternateMethod() {
		sha1 = new SHA_1("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertEquals("c2db330f6083854c99d4b5bfb6e8f29f201be699", sha1.computeHashAlternateMethod());
	}

	@Test
	void testHashComputation5_SHA_1AlternateMethod() {
		sha1 = new SHA_1(
				" !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~");
		assertEquals("e4f8188cdca2a68b074005e2ccab5b67842c6fc7", sha1.computeHashAlternateMethod());
	}

	@Test
	void testHashComputation6_SHA_1AlternateMethod() {
		sha1 = new SHA_1(
				"jsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829");
		assertEquals("3775e8d97dac1f0a26ac1418d6009698fa6c8631", sha1.computeHashAlternateMethod());
	}

	@Test
	void testHashComputation7_SHA_1AlternateMethod() {
		sha1 = new SHA_1(
				"jsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829A");
		assertEquals("111dd7f517ac9fcc76308b43877df74bf80be10c", sha1.computeHashAlternateMethod());
	}

	@Test
	void testHashComputation8_SHA_1AlternateMethod() {
		sha1 = new SHA_1(
				"And what is love? It is a doll dressed up For idleness to cosset, nurse, and dandle; A thing of soft misnomers, so divine That silly youth doth think to make itself Divine by loving, and so goes on Yawning and doting a whole summer long, Till Miss's comb is made a perfect tiara, And common Wellingtons turn Romeo boots; Till Cleopatra lives at Number Seven, And Antony resides in Brunswick Square.");
		assertEquals("1af89fe6c87f9ce56fe768e5598c9876659052e1", sha1.computeHashAlternateMethod());
	}

	@Test
	void testHashComputation9_SHA_1AlternateMethod() { // the one proposed by the NIST institution
		sha1 = new SHA_1("abcdbcdecdefdefgefghfghighijhijkijkljklmklmnlmnomnopnopq");
		assertEquals("84983e441c3bd26ebaae4aa1f95129e5e54670f1", sha1.computeHashAlternateMethod());
	}

	// END HASH COMPUTATIONS

	// MESSAGE PADDING

	@Test
	void testPadMessage_32bitsWords() {
		sha1 = new SHA_1("abc");
		assertEquals(
				"01100001011000100110001110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011000",
				joinWords(sha1.words));
	}

	@Test
	void testPadMessage2_32bitsWords() {
		sha1 = new SHA_1("");
		assertEquals(
				"10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
				joinWords(sha1.words));
	}

	@Test
	void testPadMessage3_32bitsWords() { // one block length (binary length = 440 bits)
		sha224 = new SHA_224("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertEquals(
				"01100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001100000000000000000000000000000000000000000000000000000000000000110111000",
				joinWords(sha224.words));
	}

	@Test
	void testPadMessage4_32bitsWords() { // binary length = 448 bits exactly (despite the length pad must be added)
		sha256 = new SHA_256("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertEquals(
				"0110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111000000",
				joinWords(sha256.words));
	}

	@Test
	void testPadMessage5_32bitsWords() { // two blocks needed (binary length = 760 bits)
		sha1 = new SHA_1(
				" !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~");
		assertEquals(
				"0010000000100001001000100010001100100100001001010010011000100111001010000010100100101010001010110010110000101101001011100010111100110000001100010011001000110011001101000011010100110110001101110011100000111001001110100011101100111100001111010011111000111111010000000100000101000010010000110100010001000101010001100100011101001000010010010100101001001011010011000100110101001110010011110101000001010001010100100101001101010100010101010101011001010111010110000101100101011010010110110101110001011101010111100101111101100000011000010110001001100011011001000110010101100110011001110110100001101001011010100110101101101100011011010110111001101111011100000111000101110010011100110111010001110101011101100111011101111000011110010111101001111011011111000111110101111110100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001011111000",
				joinWords(sha1.words));
	}

	@Test
	void testPadMessage6_32bitsWords() { // binary length = 960 bits (last block wholly padded)
		sha224 = new SHA_224(
				"jsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829");
		assertEquals(
				"011010100111001101101010011100110110000101101110011001000111001101101110011100110110000101101111011000110110110101110111011000010110101101101111011001000110111101101010011011100110000101101110011100110110111001101011011001000110101101110011011001000111001101101011011001000111001101101010011100110110010001101010011000010110010001110011011010100110101101100100011100110110101101100100011100110110110101110111011011010111011101101011011101110111011101100101011010110111011101101101011001010111011101101101011001010110110101110001011010110110010001110011011010110110010001101011011001000111001101101011011100110110010001101011011100110110010000101100011101110111000001110001001110000011001000110011001101110011001100110010001110000011000001100010011100110110010000110111001110000011001001101001001100010011001000110011001110110111001101101011011100110110101101110011001100010011000000110001001100000011000100111001001100100011100000110010001110000011001000111001100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111000000",
				joinWords(sha224.words));
	}

	@Test
	void testPadMessage7_32bitsWords() { // binary length 968
		sha256 = new SHA_256(
				"jsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829A");
		assertEquals(
				"011010100111001101101010011100110110000101101110011001000111001101101110011100110110000101101111011000110110110101110111011000010110101101101111011001000110111101101010011011100110000101101110011100110110111001101011011001000110101101110011011001000111001101101011011001000111001101101010011100110110010001101010011000010110010001110011011010100110101101100100011100110110101101100100011100110110110101110111011011010111011101101011011101110111011101100101011010110111011101101101011001010111011101101101011001010110110101110001011010110110010001110011011010110110010001101011011001000111001101101011011100110110010001101011011100110110010000101100011101110111000001110001001110000011001000110011001101110011001100110010001110000011000001100010011100110110010000110111001110000011001001101001001100010011001000110011001110110111001101101011011100110110101101110011001100010011000000110001001100000011000100111001001100100011100000110010001110000011001000111001010000011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111001000",
				joinWords(sha256.words));
	}

	@Test
	void testPadMessage8_32bitsWords() { // long phrase
		sha256 = new SHA_256(
				"And what is love? It is a doll dressed up For idleness to cosset, nurse, and dandle; A thing of soft misnomers, so divine That silly youth doth think to make itself Divine by loving, and so goes on Yawning and doting a whole summer long, Till Miss's comb is made a perfect tiara, And common Wellingtons turn Romeo boots; Till Cleopatra lives at Number Seven, And Antony resides in Brunswick Square.");
		assertEquals(
				"01000001011011100110010000100000011101110110100001100001011101000010000001101001011100110010000001101100011011110111011001100101001111110010000001001001011101000010000001101001011100110010000001100001001000000110010001101111011011000110110000100000011001000111001001100101011100110111001101100101011001000010000001110101011100000010000001000110011011110111001000100000011010010110010001101100011001010110111001100101011100110111001100100000011101000110111100100000011000110110111101110011011100110110010101110100001011000010000001101110011101010111001001110011011001010010110000100000011000010110111001100100001000000110010001100001011011100110010001101100011001010011101100100000010000010010000001110100011010000110100101101110011001110010000001101111011001100010000001110011011011110110011001110100001000000110110101101001011100110110111001101111011011010110010101110010011100110010110000100000011100110110111100100000011001000110100101110110011010010110111001100101001000000101010001101000011000010111010000100000011100110110100101101100011011000111100100100000011110010110111101110101011101000110100000100000011001000110111101110100011010000010000001110100011010000110100101101110011010110010000001110100011011110010000001101101011000010110101101100101001000000110100101110100011100110110010101101100011001100010000001000100011010010111011001101001011011100110010100100000011000100111100100100000011011000110111101110110011010010110111001100111001011000010000001100001011011100110010000100000011100110110111100100000011001110110111101100101011100110010000001101111011011100010000001011001011000010111011101101110011010010110111001100111001000000110000101101110011001000010000001100100011011110111010001101001011011100110011100100000011000010010000001110111011010000110111101101100011001010010000001110011011101010110110101101101011001010111001000100000011011000110111101101110011001110010110000100000010101000110100101101100011011000010000001001101011010010111001101110011001001110111001100100000011000110110111101101101011000100010000001101001011100110010000001101101011000010110010001100101001000000110000100100000011100000110010101110010011001100110010101100011011101000010000001110100011010010110000101110010011000010010110000100000010000010110111001100100001000000110001101101111011011010110110101101111011011100010000001010111011001010110110001101100011010010110111001100111011101000110111101101110011100110010000001110100011101010111001001101110001000000101001001101111011011010110010101101111001000000110001001101111011011110111010001110011001110110010000001010100011010010110110001101100001000000100001101101100011001010110111101110000011000010111010001110010011000010010000001101100011010010111011001100101011100110010000001100001011101000010000001001110011101010110110101100010011001010111001000100000010100110110010101110110011001010110111000101100001000000100000101101110011001000010000001000001011011100111010001101111011011100111100100100000011100100110010101110011011010010110010001100101011100110010000001101001011011100010000001000010011100100111010101101110011100110111011101101001011000110110101100100000010100110111000101110101011000010111001001100101001011101000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000110001110000",
				joinWords(sha256.words));
	}

	@Test
	void testPadMessage_64bitsWords() {
		sha384 = new SHA_384("abc");
		assertEquals(
				"0110000101100010011000111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011000",
				joinWords(sha384.words));
	}

	@Test
	void testPadMessage2_64bitsWords() {
		sha512 = new SHA_512("");
		assertEquals(
				"1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
				joinWords(sha512.words));
	}

	@Test
	void testPadMessage3_64bitsWords() { // one block length (binary length = 888 bits)
		sha512_224 = new SHA_512_224(
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertEquals(
				"0110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001101111000",
				joinWords(sha512_224.words));
	}

	@Test
	void testPadMessage4_64bitsWords() { // binary length = 896 bits exactly (despite the length pad must be added)
		sha512_256 = new SHA_512_256(
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertEquals(
				"01100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001011000010110000101100001100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001110000000",
				joinWords(sha512_256.words));
	}

	@Test
	void testPadMessage5_64bitsWords() { // two blocks needed (binary length = 1520 bits)
		sha384 = new SHA_384(
				" !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~");
		assertEquals(
				"00100000001000010010001000100011001001000010010100100110001001110010100000101001001010100010101100101100001011010010111000101111001100000011000100110010001100110011010000110101001101100011011100111000001110010011101000111011001111000011110100111110001111110100000001000001010000100100001101000100010001010100011001000111010010000100100101001010010010110100110001001101010011100100111101010000010100010101001001010011010101000101010101010110010101110101100001011001010110100101101101011100010111010101111001011111011000000110000101100010011000110110010001100101011001100110011101101000011010010110101001101011011011000110110101101110011011110111000001110001011100100111001101110100011101010111011001110111011110000111100101111010011110110111110001111101011111100010000000100001001000100010001100100100001001010010011000100111001010000010100100101010001010110010110000101101001011100010111100110000001100010011001000110011001101000011010100110110001101110011100000111001001110100011101100111100001111010011111000111111010000000100000101000010010000110100010001000101010001100100011101001000010010010100101001001011010011000100110101001110010011110101000001010001010100100101001101010100010101010101011001010111010110000101100101011010010110110101110001011101010111100101111101100000011000010110001001100011011001000110010101100110011001110110100001101001011010100110101101101100011011010110111001101111011100000111000101110010011100110111010001110101011101100111011101111000011110010111101001111011011111000111110101111110100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010111110000",
				joinWords(sha384.words));
	}

	@Test
	void testPadMessage6_64bitsWords() { // binary length = 1920 bits (last block wholly padded)
		sha512 = new SHA_512(
				"jsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829jsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829");
		assertEquals(
				"011010100111001101101010011100110110000101101110011001000111001101101110011100110110000101101111011000110110110101110111011000010110101101101111011001000110111101101010011011100110000101101110011100110110111001101011011001000110101101110011011001000111001101101011011001000111001101101010011100110110010001101010011000010110010001110011011010100110101101100100011100110110101101100100011100110110110101110111011011010111011101101011011101110111011101100101011010110111011101101101011001010111011101101101011001010110110101110001011010110110010001110011011010110110010001101011011001000111001101101011011100110110010001101011011100110110010000101100011101110111000001110001001110000011001000110011001101110011001100110010001110000011000001100010011100110110010000110111001110000011001001101001001100010011001000110011001110110111001101101011011100110110101101110011001100010011000000110001001100000011000100111001001100100011100000110010001110000011001000111001011010100111001101101010011100110110000101101110011001000111001101101110011100110110000101101111011000110110110101110111011000010110101101101111011001000110111101101010011011100110000101101110011100110110111001101011011001000110101101110011011001000111001101101011011001000111001101101010011100110110010001101010011000010110010001110011011010100110101101100100011100110110101101100100011100110110110101110111011011010111011101101011011101110111011101100101011010110111011101101101011001010111011101101101011001010110110101110001011010110110010001110011011010110110010001101011011001000111001101101011011100110110010001101011011100110110010000101100011101110111000001110001001110000011001000110011001101110011001100110010001110000011000001100010011100110110010000110111001110000011001001101001001100010011001000110011001110110111001101101011011100110110101101110011001100010011000000110001001100000011000100111001001100100011100000110010001110000011001000111001100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011110000000",
				joinWords(sha512.words));
	}

	@Test
	void testPadMessage7_64bitsWords() { // binary length 1928
		sha512_224 = new SHA_512_224(
				"jsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829Ajsjsandsnsaocmwakodojnansnkdksdskdsjsdjadsjkdskdsmwmwkwwekwmewmemqkdskdkdsksdksd,wpq82373280bsd782i123;sksks101019282829");
		assertEquals(
				"011010100111001101101010011100110110000101101110011001000111001101101110011100110110000101101111011000110110110101110111011000010110101101101111011001000110111101101010011011100110000101101110011100110110111001101011011001000110101101110011011001000111001101101011011001000111001101101010011100110110010001101010011000010110010001110011011010100110101101100100011100110110101101100100011100110110110101110111011011010111011101101011011101110111011101100101011010110111011101101101011001010111011101101101011001010110110101110001011010110110010001110011011010110110010001101011011001000111001101101011011100110110010001101011011100110110010000101100011101110111000001110001001110000011001000110011001101110011001100110010001110000011000001100010011100110110010000110111001110000011001001101001001100010011001000110011001110110111001101101011011100110110101101110011001100010011000000110001001100000011000100111001001100100011100000110010001110000011001000111001010000010110101001110011011010100111001101100001011011100110010001110011011011100111001101100001011011110110001101101101011101110110000101101011011011110110010001101111011010100110111001100001011011100111001101101110011010110110010001101011011100110110010001110011011010110110010001110011011010100111001101100100011010100110000101100100011100110110101001101011011001000111001101101011011001000111001101101101011101110110110101110111011010110111011101110111011001010110101101110111011011010110010101110111011011010110010101101101011100010110101101100100011100110110101101100100011010110110010001110011011010110111001101100100011010110111001101100100001011000111011101110000011100010011100000110010001100110011011100110011001100100011100000110000011000100111001101100100001101110011100000110010011010010011000100110010001100110011101101110011011010110111001101101011011100110011000100110000001100010011000000110001001110010011001000111000001100100011100000110010001110011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011110001000",
				joinWords(sha512_224.words));
	}

	@Test
	void testPadMessage8_64bitsWords() { // long phrase
		sha512_256 = new SHA_512_256(
				"And what is love? It is a doll dressed up For idleness to cosset, nurse, and dandle; A thing of soft misnomers, so divine That silly youth doth think to make itself Divine by loving, and so goes on Yawning and doting a whole summer long, Till Miss's comb is made a perfect tiara, And common Wellingtons turn Romeo boots; Till Cleopatra lives at Number Seven, And Antony resides in Brunswick Square.");
		assertEquals(
				"0100000101101110011001000010000001110111011010000110000101110100001000000110100101110011001000000110110001101111011101100110010100111111001000000100100101110100001000000110100101110011001000000110000100100000011001000110111101101100011011000010000001100100011100100110010101110011011100110110010101100100001000000111010101110000001000000100011001101111011100100010000001101001011001000110110001100101011011100110010101110011011100110010000001110100011011110010000001100011011011110111001101110011011001010111010000101100001000000110111001110101011100100111001101100101001011000010000001100001011011100110010000100000011001000110000101101110011001000110110001100101001110110010000001000001001000000111010001101000011010010110111001100111001000000110111101100110001000000111001101101111011001100111010000100000011011010110100101110011011011100110111101101101011001010111001001110011001011000010000001110011011011110010000001100100011010010111011001101001011011100110010100100000010101000110100001100001011101000010000001110011011010010110110001101100011110010010000001111001011011110111010101110100011010000010000001100100011011110111010001101000001000000111010001101000011010010110111001101011001000000111010001101111001000000110110101100001011010110110010100100000011010010111010001110011011001010110110001100110001000000100010001101001011101100110100101101110011001010010000001100010011110010010000001101100011011110111011001101001011011100110011100101100001000000110000101101110011001000010000001110011011011110010000001100111011011110110010101110011001000000110111101101110001000000101100101100001011101110110111001101001011011100110011100100000011000010110111001100100001000000110010001101111011101000110100101101110011001110010000001100001001000000111011101101000011011110110110001100101001000000111001101110101011011010110110101100101011100100010000001101100011011110110111001100111001011000010000001010100011010010110110001101100001000000100110101101001011100110111001100100111011100110010000001100011011011110110110101100010001000000110100101110011001000000110110101100001011001000110010100100000011000010010000001110000011001010111001001100110011001010110001101110100001000000111010001101001011000010111001001100001001011000010000001000001011011100110010000100000011000110110111101101101011011010110111101101110001000000101011101100101011011000110110001101001011011100110011101110100011011110110111001110011001000000111010001110101011100100110111000100000010100100110111101101101011001010110111100100000011000100110111101101111011101000111001100111011001000000101010001101001011011000110110000100000010000110110110001100101011011110111000001100001011101000111001001100001001000000110110001101001011101100110010101110011001000000110000101110100001000000100111001110101011011010110001001100101011100100010000001010011011001010111011001100101011011100010110000100000010000010110111001100100001000000100000101101110011101000110111101101110011110010010000001110010011001010111001101101001011001000110010101110011001000000110100101101110001000000100001001110010011101010110111001110011011101110110100101100011011010110010000001010011011100010111010101100001011100100110010100101110100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000110001110000",
				joinWords(sha512_256.words));
	}

	// Method that concatenates all the binary words in a single string
	private String joinWords(ArrayList<ArrayList<String>> words) {
		String sequence = "";
		for (int i = 0; i < words.size(); i++) {
			for (int j = 0; j < words.get(i).size(); j++) {
				sequence += words.get(i).get(j);
			}
		}
		return sequence;
	}

	// TEXT TO BINARY

	@Test
	void testTextToBinary() {
		assertEquals("", sha1.textToBinary(""));
	}

	@Test
	void testTextToBinary2() { // all printable ASCII characters
		assertEquals(
				"0010000000100001001000100010001100100100001001010010011000100111001010000010100100101010001010110010110000101101001011100010111100110000001100010011001000110011001101000011010100110110001101110011100000111001001110100011101100111100001111010011111000111111010000000100000101000010010000110100010001000101010001100100011101001000010010010100101001001011010011000100110101001110010011110101000001010001010100100101001101010100010101010101011001010111010110000101100101011010010110110101110001011101010111100101111101100000011000010110001001100011011001000110010101100110011001110110100001101001011010100110101101101100011011010110111001101111011100000111000101110010011100110111010001110101011101100111011101111000011110010111101001111011011111000111110101111110",
				sha1.textToBinary(
						" !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~"));
	}

	// BINARY TO HEXADECIMAL

	@Test
	void testBinaryToHexadecimal() {
		assertEquals("00", sha1.binaryToHexadecimal("000000"));
	}

	@Test
	void testBinaryToHexadecimal2() {
		assertEquals("52", sha1.binaryToHexadecimal("1010010"));
	}

	@Test
	void testBinaryToHexadecimal3() {
		assertEquals("094acaaf", sha1.binaryToHexadecimal("01001010010101100101010101111"));
	}

	// FUNCTIONS

	@Test
	void testF() {
		int a = Integer.parseUnsignedInt("01111011010100110000001101110000", 2);
		int b = Integer.parseUnsignedInt("10010111011110010001100010001000", 2);
		int c = Integer.parseUnsignedInt("01110000111100010010001111101110", 2);
		assertEquals("10011111100010010000010001110", Integer.toBinaryString(sha1.f(a, b, c, 0)));
	}

	@Test
	void testF2() {
		int a = Integer.parseUnsignedInt("01111011010100110000001101110000", 2);
		int b = Integer.parseUnsignedInt("10010111011110010001100010001000", 2);
		int c = Integer.parseUnsignedInt("01110000111100010010001111101110", 2);
		assertEquals("10011100110110110011100000010110", Integer.toBinaryString(sha1.f(a, b, c, 39)));
	}

	@Test
	void testF3() {
		int a = Integer.parseUnsignedInt("01111011010100110000001101110000", 2);
		int b = Integer.parseUnsignedInt("10010111011110010001100010001000", 2);
		int c = Integer.parseUnsignedInt("01110000111100010010001111101110", 2);
		assertEquals("1110011011100010000001111101000", Integer.toBinaryString(sha1.f(a, b, c, 40)));
	}

	@Test
	void testF4() {
		int a = Integer.parseUnsignedInt("01111011010100110000001101110000", 2);
		int b = Integer.parseUnsignedInt("10010111011110010001100010001000", 2);
		int c = Integer.parseUnsignedInt("01110000111100010010001111101110", 2);
		assertEquals("10011100110110110011100000010110", Integer.toBinaryString(sha1.f(a, b, c, 79)));
	}

	@Test
	void testCh() {
		long a = Long.parseUnsignedLong("0111101101010011000000110111000011001100011011110110110110011101", 2);
		long b = Long.parseUnsignedLong("1001011101111001000110001000100000101010110101101011010001000101", 2);
		long c = Long.parseUnsignedLong("0111000011110001001000111110111010101010011110010010010101111010", 2);
		assertEquals("1001111110001001000001000111000101010010101100010010001100111",
				Long.toBinaryString(sha1.Ch(a, b, c)));
	}

	@Test
	void testParity() {
		long a = Long.parseUnsignedLong("0111101101010011000000110111000011001100011011110110110110011101", 2);
		long b = Long.parseUnsignedLong("1001011101111001000110001000100000101010110101101011010001000101", 2);
		long c = Long.parseUnsignedLong("0111000011110001001000111110111010101010011110010010010101111010", 2);
		assertEquals("1001110011011011001110000001011001001100110000001111110010100010",
				Long.toBinaryString(sha1.Parity(a, b, c)));
	}

	@Test
	void testMaj() {
		long a = Long.parseUnsignedLong("0111101101010011000000110111000011001100011011110110110110011101", 2);
		long b = Long.parseUnsignedLong("1001011101111001000110001000100000101010110101101011010001000101", 2);
		long c = Long.parseUnsignedLong("0111000011110001001000111110111010101010011110010010010101111010", 2);
		assertEquals("111001101110001000000111110100010101010011111110010010101011101",
				Long.toBinaryString(sha1.Maj(a, b, c)));
	}

	// SIGMA FUNCTION SPLITTER (64 bits)

	@Test
	void testUpperSigma512_1_64bits() {
		Long l = Long.parseUnsignedLong("1001000000110110111001010001010000001101100001011001110101010111", 2);
		assertEquals("1001100000001101011001100001100010000110110111010010111000000101",
				Long.toBinaryString(sha1.sigmaSplitter(l, 64, "upper", true)));
	}

	@Test
	void testUpperSigma512_0_64bits() {
		Long l = Long.parseUnsignedLong("1001000000110110111001010001010000001101100001011001110101010111", 2);
		assertEquals("1111001100100011101110010001011001001000010000111000010111001111",
				Long.toBinaryString(sha1.sigmaSplitter(l, 64, "upper", false)));
	}

	@Test
	void testLowerSigma512_1_64bits() {
		Long l = Long.parseUnsignedLong("1001000000110110111001010001010000001101100001011001110101010111", 2);
		assertEquals("11000001011101000000010011001011100000101110000111110101111001",
				Long.toBinaryString(sha1.sigmaSplitter(l, 64, "lower", true)));
	}

	@Test
	void testLowerSigma512_0_64bits() {
		Long l = Long.parseUnsignedLong("1001000000110110111001010001010000001101100001011001110101010111", 2);
		assertEquals("1001111010101011001010011010010100111010110101000100000000001100",
				Long.toBinaryString(sha1.sigmaSplitter(l, 64, "lower", false)));
	}

	// SIGMA FUNCTION SPLITTER (32 bits)

	@Test
	void testUpperSigma256_1_32bits() {
		Long l = Long.parseLong("01111010111010000100110101000111", 2);
		assertEquals("11000001001000100101111110000001",
				Integer.toBinaryString((int) sha1.sigmaSplitter(l, 32, "upper", true)));
	}

	@Test
	void testUpperSigma256_0_32bits() {
		Long l = Long.parseLong("01111010111010000100110101000111", 2);
		assertEquals("10101101101001101100111111000",
				Integer.toBinaryString((int) sha1.sigmaSplitter(l, 32, "upper", false)));
	}

	@Test
	void testLowerSigma256_1_32bits() {
		Long l = Long.parseLong("01111010111010000100110101000111", 2);
		assertEquals("101111000101011110100000111010",
				Integer.toBinaryString((int) sha1.sigmaSplitter(l, 32, "lower", true)));
	}

	@Test
	void testLowerSigma256_0_32bits() {
		Long l = Long.parseLong("01111010111010000100110101000111", 2);
		assertEquals("10010010111110010000011110001000",
				Integer.toBinaryString((int) sha1.sigmaSplitter(l, 32, "lower", false)));
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
