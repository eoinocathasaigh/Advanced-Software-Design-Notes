module atu.character.builder {
	//WHAT DOES THIS MODULE DO - CONSUMER
	//We need to consume the 2 previous projects
	//Thus we need to specify that we need the other 2 modules
	requires atu.character.metrics;
	requires atu.character.service;
	
	//We basically say we need measurable without specifying how to get it
	//The runtime has to figure that out - polymorphic
	//System understands that some of our previous requirements have Measurable so it looks for it there
	uses ie.atu.character.Measurable;
}