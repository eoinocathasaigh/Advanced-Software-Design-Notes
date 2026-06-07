package ie.atu.sw;

import ie.atu.sw.crypto.Algorithm;
import ie.atu.sw.crypto.CypherFactory;
import ie.atu.sw.crypto.Cypherable;

public class Runner {
	public static void main(String[] args) throws Throwable{
		CypherFactory cf = CypherFactory.getInstance();
		Cypherable cypher = cf.getCypherable(Algorithm.VIGENERE);
		
		
		byte[] s = new String("HAPPY DAYS").getBytes("UTF-8");
		byte[] t = cypher.encrypt(s);
		
		System.out.println(new String(t));
		System.out.println(new String(cypher.decrypt(t)));
	}
	
	/*LAB EXPLANATION
	 * This lab is all about further encapsulation with Modules
	 * Modules are packages deployed in Jar Archives with 1 module per Jar
	 * From the command line we can use the Module path and specify we want to use a module and a path to run the application
	 * e.g. java --module-path ./ --module atu.software/ie.atu.sw.Runner in the bin directory for this project
	 * To create a jar archive we run the following line of code:
	 * jar -cf crypto.jar *
	 * Then to check what is in this jar file we can just run
	 * jar -tf crypto.jar
	 * This upholds the Reuse-Release Principle: granule of re-use is the full atu.software module and all its packages
	 * This is also the granule of release - single module per JAR
	 * 
	 * OVERALL THINK ABOUT IT LIKE THIS:
	 * We get the behaviour of classes, functions etc, and move them into packages
	 * - E.G. we move things to do with crypto stuff like the cypherable interface and the AbstractCypher class into the ie.atu.sw.crypto package
	 * We then repeat the behaviour for the other classes i.e. symmetric ciphers & asymmetric ciphers into the various packages
	 * 
	 * We then go to the module class & specify the specific packages we're going to export/make available to other classes
	 * 
	 * Why do any of this in the first place - remove dependencies
	 * 
	 * How do we open a registry
	 * go to search and type regedit
	 * 
	 * MODULES WONT BE IN AN ASSESSMENT
	 * */
}