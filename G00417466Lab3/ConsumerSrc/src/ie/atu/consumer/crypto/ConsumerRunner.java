package ie.atu.consumer.crypto;

import ie.atu.sw.crypto.Algorithm;

//This class will utilise some of the crypto behaviour using the jar file/referenced library
//USING THE MODULE SYSTEM

//Initially this will tell us that crypto isnt accessible
//To fix this we need to go to the module info and tell it that we need to use it
//This will still give us errors though - why?
//Even if it's made public, unless the module exports it then it is inaccessible - need to go to the other module-info and export it
import ie.atu.sw.crypto.CypherFactory;
import ie.atu.sw.crypto.Cypherable;
import ie.atu.sw.crypto.symmetric.AESCypher;
import ie.atu.sw.crypto.symmetric.VigenereCypher;

public class ConsumerRunner {
	public static void main(String[] args) throws Throwable {
		CypherFactory cf = CypherFactory.getInstance();
		
		//Initially this will throw an error so we need to again import and refresh everything
		//Cypherable cypher = new VigenereCypher();
		Cypherable cypher = cf.getCypherable(Algorithm.AES);
		byte[] s = new String("HAPPY DAYS").getBytes("UTF-8");
		byte[] t = cypher.encrypt(s);
		System.out.println(new String(t));
		System.out.println(new String(cypher.decrypt(t)));
	}
	
	/*USING JLINK TO LINK MODULES
	 * First we create the jar file from the cmd like before
	 * Then still in the cmd we use this command to specify that we want to link the 2 jar files, we need to specify the path to them as well
	 * We then specify where we want certain stuff to be output to
	 * Initial command with the location of 1 jar
	 * jlink --module-path ./myapp.jar; - semi-colon on the end is used on windows to show that we want to join it onto something
	 * Specifying the location of our other jar file
	 * ../../Lab3CryptoAndModules/bin/crypto.jar
	 * Specifying the output
	 *  --output ./out/ --add-modules atu.consumer
	 *  
	 * FULL COMMAND
	 * jlink --module-path ./myapp.jar;../../Lab3CryptoAndModules/bin/crypto.jar --output ./out/ --add-modules atu.consumer
	 * 
	 * This will effectively generate our own runtime environment with the dependencies/modules etc for our application
	 * 
	 * To test if everything works correctly we can go into the out/bin directory of our output file
	 * Then we get it to run this command which runs the JVM and lists the modules
	 * ./java --list-modules
	 * We should see the java modules we made today as well as a java.base which just contains the basic base stuff for java
	 * 
	 * If we make changes to this file or something like that we will need to recompile everything to do with the linking & making this projects jar file to be able to run things correctly from the cmd
	 * Remember to delete myapp.jar and the out file first
	 * 
	 * Then when everything is done we just run this command (in the out directory)
	 * bin/java --module-path ./ --module atu.consumer/ie.atu.consumer.crypto.ConsumerRunner
	 * 
	 * WHY DO ALL THIS?
	 * To create an environment that has all dependencies needed by an application at runtime straight out of the box
	 * */
}
