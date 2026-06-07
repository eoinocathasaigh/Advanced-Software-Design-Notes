package ie.atu.sw.crypto.symmetric;

import ie.atu.sw.crypto.*;
import ie.atu.classic.vigenere.*;

public class VigenereCypher extends AbstractCypher {

	private Vigenere v = new Vigenere(); // Compose

	public void setKey(String key) {
		v.setKey(key); // Delegate
	}

	public byte[] encrypt(byte[] plainText) throws Throwable {
		return v.doCypher(plainText, true); // Delegate
	}

	public byte[] decrypt(byte[] cypherText) throws Throwable {
		return v.doCypher(cypherText, false); // Delegate
	}
}