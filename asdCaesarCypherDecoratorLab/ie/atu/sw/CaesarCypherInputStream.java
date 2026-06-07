package ie.atu.sw;

import java.io.*;

public class CaesarCypherInputStream extends FilterInputStream {
	private byte key = 0;
	
	public CaesarCypherInputStream(InputStream in, byte key){
		super(in);
		this.key = key;
	}	
	
	public int read() throws IOException {	
		int next = super.read();
		if (next != -1) next -= key;
		return next;
	}
		
	public int read(byte[] b, int offset, int len) throws IOException {
		int result = super.read(b, offset, len);
		for (int i = offset; i < offset + result; i++){
			int decrypt = ((int) b[i]) - key;
			b[i] = (byte) decrypt;
		}
		return result;
	}
}
