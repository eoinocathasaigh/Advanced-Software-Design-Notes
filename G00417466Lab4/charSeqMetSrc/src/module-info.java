module atu.character.service {
	//WHAT IS THE PURPOSE OF THIS LAB
	//This lab helps to demonstrate the deadly diamond when it comes to inheritance
	//Deadly Diamond - problem that occurs with multiple inheritance, creates ambiguity/confusion when a class inherits from 2 other classes that share a common ancestor
	//Causes confusion about which inherited method to use and can cause errors
	
	//We are going to examine this problem and look at how to fix it using a BUILDER PATTERN
	
	//This will specify we're exporting the packages to be used by the other classes/projects
	//As well as that we specify that we're also providing the Levenshtein class
	//We provide a serviceable interface with an implementation - think of it as our service provider
	exports ie.atu.character;
	provides ie.atu.character.Measurable with ie.atu.character.Levenshtein;
}