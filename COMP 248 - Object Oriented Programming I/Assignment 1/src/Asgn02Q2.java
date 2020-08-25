// ------------------------------------------------------- 
// Assignment 1 Question 2
// Written by: Vaansh Lakhwara 40114764
// For COMP 248 Section U – Winter 2020
// --------------------------------------------------------

import java.util.Scanner;

/*
 * Using the length, substring and toUpperCase functions, we convert 
 * and store the input from the user (name of their favorite city) to 
 * display the name with all the letters in upper case, the second 
 * letter in upper case, with the second last letter in upper case 
 * and the middle letter in upper case
 */

public class Asgn02Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//declare variables to store the entered data and the output values
		String city, uName, secondUp, secondLastUp, middleUp;
		
		//declare integer to determine the number of letters in the word
		int cLength;
		
		//declare our object scanner
		Scanner keyIn = new Scanner(System.in);
		
		//print the heading
		System.out.print("		City Name Manipulator\n" + "		---------------------\n" );
		
		//present the input you need from the user
		System.out.print("Please enter the name of your favourite city in lower case: " );
		
		//store the input in the string variable declared above
		city = keyIn.next();
		
		//calculate the length of the string
		cLength = city.length();
		
		//convert the city name into upper case
		uName = city.toUpperCase();
		
		//convert the second letter to upper case and join the rest of the string using substring
		secondUp = city.substring(0, 1)+(city.substring(1, 2).toUpperCase()+(city.substring(2,cLength)));
		
		//convert the second last letter to upper case and join the rest of the string using substring
		secondLastUp = city.substring(0, cLength-2)+(city.substring(cLength-2, cLength-1).toUpperCase()+(city.substring(cLength-1,cLength)));
		
		//convert the middle letter to upper case and join the rest of the string using substring
		middleUp = city.substring(0, cLength/2)+(city.substring(cLength/2, cLength/2+1).toUpperCase()+(city.substring(cLength/2+1,cLength)));

		//display the name of the city entered along with the number of characters it has
		System.out.println("\nYou entered " + city + " which has " + cLength + " characters\n");
		
		//display the rest of the output along with the values stored in the variables
		System.out.println("Here is the city name");
		System.out.println("	*with all letters in upper case: " + uName);
		System.out.println("	*with the second letter in upper case: " + secondUp);
		System.out.println("	*with the second to last letter in upper case: " + secondLastUp);
		System.out.println("	*with the middle letter in upper case: " + middleUp);

		//close the scanner
		keyIn.close();
	}

}
