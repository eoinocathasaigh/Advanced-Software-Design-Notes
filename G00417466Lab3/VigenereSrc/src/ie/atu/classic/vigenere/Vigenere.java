package ie.atu.classic.vigenere;

import java.security.Key;

//Our new class for the Vigenere cipher aspects
public class Vigenere {

	// Need to migrate everything from VigenereCypher to this class

	/*
	 * The tabula recta represents a 26x26 array of characters. For a message of
	 * length n, there are 26^n combinations.
	 * 
	 * Vigenere is a symmetric poly-alphabetic substitution cypher, but suffers from
	 * the problem that only upper-case characters are supported in the tabula
	 * recta. Additional characters can be added, including non-alphabetic
	 * characters by extending the matrix with additional rows and columns. Larger
	 * matrices increase the running time of encryption / decryption in the order of
	 * O(n^2). Note that the tabula recta is analogous to a 26-rotor Enigma machine,
	 * with each rotor permanently offset by one (and missing the plugboard and
	 * reflective components Enigma!).
	 * 
	 */
	private char[][] tabulaRecta = {
			{ 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
					'V', 'W', 'X', 'Y', 'Z' },
			{ 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
					'W', 'X', 'Y', 'Z', 'A' },
			{ 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
					'X', 'Y', 'Z', 'A', 'B' },
			{ 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
					'Y', 'Z', 'A', 'B', 'C' },
			{ 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
					'Z', 'A', 'B', 'C', 'D' },
			{ 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
					'A', 'B', 'C', 'D', 'E' },
			{ 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A',
					'B', 'C', 'D', 'E', 'F' },
			{ 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B',
					'C', 'D', 'E', 'F', 'G' },
			{ 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C',
					'D', 'E', 'F', 'G', 'H' },
			{ 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D',
					'E', 'F', 'G', 'H', 'I' },
			{ 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E',
					'F', 'G', 'H', 'I', 'J' },
			{ 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F',
					'G', 'H', 'I', 'J', 'K' },
			{ 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
					'H', 'I', 'J', 'K', 'L' },
			{ 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
					'I', 'J', 'K', 'L', 'M' },
			{ 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
					'J', 'K', 'L', 'M', 'N' },
			{ 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
					'K', 'L', 'M', 'N', 'O' },
			{ 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
					'L', 'M', 'N', 'O', 'P' },
			{ 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
					'M', 'N', 'O', 'P', 'Q' },
			{ 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
					'N', 'O', 'P', 'Q', 'R' },
			{ 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
					'O', 'P', 'Q', 'R', 'S' },
			{ 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
					'P', 'Q', 'R', 'S', 'T' },
			{ 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
					'Q', 'R', 'S', 'T', 'U' },
			{ 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
					'R', 'S', 'T', 'U', 'V' },
			{ 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
					'S', 'T', 'U', 'V', 'W' },
			{ 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
					'T', 'U', 'V', 'W', 'X' },
			{ 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
					'U', 'V', 'W', 'X', 'Y' } };

	private char[] keyText; // Store the cypher key as a char array for convenience
	//Need to delcare these here since we dont have access to the AbstractCypher Class
	private Key key;
	
	public Key getKey() {
		return key;
	}

	public void setKey(String keyString) {
		if (keyString == null || keyString.length() == 0) {
            this.keyText = new char[0];
            this.key = null;
        } else {
            // store key characters
            this.keyText = keyString.toCharArray();
            // create Key representation (inner class sets outer keyText)
            this.key = new VigenereKey(keyString);
        }
	}

	/*
	 * To encrypt using the matrix, for each letter in the plain-text, one finds the
	 * intersection of the row given by the corresponding keyword letter and the
	 * column given by the plain-text letter itself to pick out the cypher-text
	 * letter.
	 * 
	 * To decrypt, use the keyword letter to pick a column of the table and then
	 * trace down the column to the row containing the cypher-text letter. The index
	 * of that row is the plain-text letter.
	 */
	public byte[] doCypher(byte[] text, boolean encrypt) {
		byte[] result = new byte[text.length];
		for (int i = 0; i < text.length; i++) {
			if (encrypt) {
				result[i] = getEncryptedCharacter(keyText[i], (char) text[i]);
			} else {
				result[i] = getDecryptedCharacter(keyText[i], (char) text[i]);
			}
		}
		return result;
	}

	/*
	 * Return the character given by the intersection of the row of the keyword
	 * character and the column of the plain-text character. If no such intersection
	 * exists, return the (unencrypted) plain-text character.
	 */
	private byte getEncryptedCharacter(char key, char plain) {
		for (int rows = 0; rows < tabulaRecta.length; rows++) {
			if (tabulaRecta[rows][0] == key) {
				for (int cols = 0; cols < tabulaRecta[rows].length; cols++) {
					if (tabulaRecta[0][cols] == plain) {
						return (byte) tabulaRecta[rows][cols];
					}
				}
			}
		}
		return (byte) plain;
	}

	/*
	 * Return the character in the first column of the row containing the cypher
	 * character that intersects with the column containing the keyword character.
	 */
	private byte getDecryptedCharacter(char key, char cypher) {
		for (int cols = 0; cols < tabulaRecta[0].length; cols++) {
			if (tabulaRecta[0][cols] == key) {
				for (int rows = 0; rows < tabulaRecta.length; rows++) {
					if (tabulaRecta[rows][cols] == cypher) {
						return (byte) tabulaRecta[rows][0];
					}
				}
			}
		}
		return (byte) cypher;
	}

	private class VigenereKey implements Key {
		private static final long serialVersionUID = 1L; // The interface Key is serializable...
		private static final String algorithmName = "Vigenere";
		private static final String keyFormat = "RAW";

		public VigenereKey(String key) {
			keyText = new char[key.length()];
			for (int i = 0; i < key.length(); i++) {
				keyText[i] = key.charAt(i);
			}
		}

		public String getAlgorithm() {
			return algorithmName;
		}

		public String getFormat() {
			return keyFormat;
		}

		public byte[] getEncoded() {
			byte[] bytes = new byte[keyText.length];
			for (int i = 0; i < keyText.length; i++) {
				bytes[i] = (byte) keyText[i];
			}
			return bytes;
		}
	}
}
