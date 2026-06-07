//The point of this project is to utilise the jar package we created previously
//To add it/use it in this project we need to:
//Right click project name -> properties -> java build path -> libraries -> modulePath -> click "Add External Jar" -> navigate to the jars directory & select "crypto.jar"
module atu.consumer {
	//Here we tell this module what inherited modules are required in this application
	requires atu.software;
}