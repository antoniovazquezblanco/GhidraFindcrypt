package findcrypt;

import java.io.Reader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import ghidra.util.Msg;

/**
 * A simple data structure that deserializes {@link CryptSignature}
 * objects from a file.
 *
 * @author torgo
 */
public class CryptDatabase {
	private final ArrayList<CryptSignature> signatures;
	private final boolean bigEndian;

	public CryptDatabase() {
		this(false);
	}

	/**
	 * @param bigEndian true if the target program is big-endian; multi-byte
	 *                  signatures (wordLength > 1) are then byte-swapped on load
	 */
	public CryptDatabase(boolean bigEndian) {
		this.signatures = new ArrayList<>();
		this.bigEndian = bigEndian;
	}

	public void parse(Reader reader) {
		Gson gson = new Gson();
		final ArrayList<CryptSignature> loadedSignatures = gson.fromJson(reader, new TypeToken<ArrayList<CryptSignature>>() {
		}.getType());
		loadedSignatures.forEach(signature -> addSignature(signature.getName(), signature.getHexBytes(), signature.getWordLength()));
	}
	
	public ArrayList<CryptSignature> getSignatures() {
		return this.signatures;
	}
	
	public void addSignature(String name, String hexString) {
		addSignature(name, hexString, 1);
	}

	public void addSignature(String name, String hexString, int wordLength) {
		CryptSignature sig = new CryptSignature(name, hexString, wordLength, this.bigEndian);
		this.signatures.add(sig);
		Msg.debug(this, String.format("Added signature: %s", sig.getName()));
	}
}
