//This module is meant to represent the suite of classical ciphers

//This part of the lab is all about TRANSITIVE DEPENDENCIES
//WHAT IS A TRANSITIVE DEPENDENCY - an indirect relationship where our project relies on a library/module/package that in turn depends on another library/module/package
//e.g. Proj 1 needs proj 2/is dependent on it, but proj 2 needs/is dependent on proj 3
//Proj 1 becomes dependent on proj 3 at that point

//We moved the source code from the original VigenereCypher class to the Vigenere class in this file 
module atu.classic {
	exports ie.atu.classic.vigenere to atu.software;
	
	//This will initially throw an error - as atu.software cant be resolved to a module
	//Module structure must be a directed acyclic graph
	//This will effectively cause a cycle - atu.software depends on classic and vice versa
	//requires atu.software;
}