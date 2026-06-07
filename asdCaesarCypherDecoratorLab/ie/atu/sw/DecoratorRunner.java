package ie.atu.sw;

import java.io.*;
public class DecoratorRunner {
	public static void main(String[] args) throws IOException{
		byte key = 7;
		
		System.out.println("----- No Buffering: Read One Byte at a Time-----");
		try (var in = new CaesarCypherInputStream(new FileInputStream("./caesar.txt"), key)){
			int c;
			while ((c = in.read()) != -1){
				System.out.print((char) c);
			}
		}
		
		System.out.println("\n\n----- Buffering: Read a Line at a Time -----");
		try (var br = new BufferedReader(new InputStreamReader(new CaesarCypherInputStream(new FileInputStream("./caesar.txt"), key)))){
			String next;
			
			while ((next = br.readLine()) != null){
				System.out.println(next);
			}		
		}
	}
}