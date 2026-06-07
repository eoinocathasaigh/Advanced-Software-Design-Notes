//Using "open" effectively means that this module is open access
open module atu.software {
	//A module has a dependency on another module using the "requires" keyword
	//If we want any of the packages in a module to be available we need to export them
	//We now need to rebuild the jar/path
	//Windows - command line - remove crypto.jar (rm crypto.jar) then rebuild it using the same command as before
	exports ie.atu.sw.crypto;
	exports ie.atu.sw.crypto.symmetric;
	
	//Creates a transitive dependency on the atu.classic package - we need it to be able to do anything
	requires transitive atu.classic;
}