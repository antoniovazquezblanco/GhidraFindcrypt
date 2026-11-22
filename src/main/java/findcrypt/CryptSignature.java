package findcrypt;

/**
 * A cryptographic constant we can search for
 *
 * @author torgo
 */
public class CryptSignature {
	private final String name;
	private transient final byte[] data;
	private final String hexBytes;
	// Size in bytes of the words the constant is made of (1 = plain bytes / unknown)
	private final int wordLength;

	public CryptSignature(String name, String hexBytes) {
		this(name, hexBytes, 1, false);
	}

	/**
	 * @param name       signature name
	 * @param hexBytes   the constant as stored by a little-endian target
	 * @param wordLength size in bytes of each word in the constant (values below 2 mean byte data)
	 * @param bigEndian  true if the target is big-endian, in which case each word is byte-swapped
	 */
	public CryptSignature(String name, String hexBytes, int wordLength, boolean bigEndian) {
		this.name = name;
		this.hexBytes = hexBytes;
		this.wordLength = wordLength > 1 ? wordLength : 1;
		byte[] bytes = hexStringToByteArray(this.hexBytes);
		if (bigEndian && this.wordLength > 1) {
			swapWords(bytes, this.wordLength);
		}
		this.data = bytes;
	}
	
	public byte[] getBytes() {
		return this.data;
	}
	
	public String getName() {
		return this.name;
	}

	public String getHexBytes() {
		return this.hexBytes;
	}

	public int getWordLength() {
		// Signatures loaded from JSON without a wordLength key have 0 here
		return this.wordLength > 1 ? this.wordLength : 1;
	}

	/**
	 * Reverses the byte order of every complete word in the array, in place.
	 * Trailing bytes that don't fill a whole word are left untouched.
	 */
	public static void swapWords(byte[] data, int wordLength) {
		for (int w = 0; w + wordLength <= data.length; w += wordLength) {
			for (int i = w, j = w + wordLength - 1; i < j; i++, j--) {
				byte tmp = data[i];
				data[i] = data[j];
				data[j] = tmp;
			}
		}
	}

	public static byte[] hexStringToByteArray(String s) {
		int len = s.length();
		byte[] data = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
					+ Character.digit(s.charAt(i+1), 16));
		}
		return data;
	}

}
