module atu.character.metrics {
	//This creates a dependency - we need this to work
	requires atu.character.service;
	//We are exporting one of our own packages & our own implementation of measurable
	exports ie.atu.sw.hamming;
	provides ie.atu.character.Measurable with ie.atu.sw.hamming.HammingImpl;
}