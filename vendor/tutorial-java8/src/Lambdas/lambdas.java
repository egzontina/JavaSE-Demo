package Lambdas;

import java.util.Arrays;

public class lambdas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		// références de méthodes
		String[] myArray = {"one", "two", "three", "four"};
		Arrays.sort(myArray, String::compareToIgnoreCase);


	}
	
	

}
