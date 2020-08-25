// ------------------------------------------------------- 
// Assignment 2 Question 2
// Written by: Vaansh Lakhwara 40114764
// For COMP 248 Section U – Winter 2020
// -------------------------------------------------------

import java.util.Scanner;

/*
 * The following program uses a for loop 
 * to reverse a given number and count the 
 * number of digits nested in a do-while
 * loop so the code executes at least once 
 * before asking the user if they want to 
 * repeat the program 
 */

public class Question02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//declare long variables to store the input value, the last digit of the number, and to store the input value as an initial value later
		long input, last_number, initial_value;
		
		//declare string to determine whether to repeat loop later
		String repeat;
		
		//declare the scanner object
		Scanner keyIn = new Scanner(System.in);
		
		//display the heading of the program
		System.out.println("Welcome to Our Reversing Number Program \n" + 
				"———————————————————————————————————————\n");
		
		//create a do-while loop so the program runs at least once and then determine whether the user wants to try another number
		do {
			
			//display what kind of input you need the user to provide
			System.out.println("Enter a number with at most 10 digits:");
			
			//store the input value
			input = keyIn.nextInt();
			
			//store the input in another variable to perform operations on later
			initial_value = input;
			
			//declare variables to store the reverse and the length of the number
			long reverse = 0, number_length = 0;

			//use a loop that calculates the reverse of the number and its length
			for(;input!=0;)
			{
				//storing the last digit of the input
				last_number = input%10;
				
				//this adds the last digit to the number each time it loops
				reverse = reverse*10 + last_number;
				
				//divide the input by 10 to get the next digit
				input = input/10;
				
				//stores the length of the input by adding one
				++number_length;
			}
		
			//display the output
			System.out.println("Number of digits is " + number_length);
			System.out.println("Reverse of " + initial_value + " is " + reverse);
			
			//ask the user if they want to try the program again and store the value of their answer
			System.out.println("Do you want to try another number? (yes to repeat, no to stop)");
			repeat = keyIn.next();
		
		}while(repeat.equalsIgnoreCase("yes")); //repeat the entire loop if the user enters "Yes"
		
		//close the scanner
		keyIn.close();
		
		//display the final message
		System.out.println("Thanks and have a great day!");
			
	}

}

