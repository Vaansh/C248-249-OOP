// ------------------------------------------------------- 
// Assignment 1 Question 1
// Written by: Vaansh Lakhwara 40114764
// For COMP 248 Section U – Winter 2020
// --------------------------------------------------------

import java.util.Scanner;

/*
 * The following program stores four numbers in variables given by the user using 
 * the scanner object and displays the sum and product of the fraction values in 
 * fraction and decimal by storing it as a string and a double data type
 */

public class Asgn01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//declaring 4 variables (numerators, denominators) for the test
		int num1, den1, num2, den2;
		
		//declaring 4 variables to store the values to be displayed
		double product, sum;
		String fProduct, fSum;
		
		//declaring the scanner object
		Scanner keyIn = new Scanner(System.in);
		
		//displaying heading
		System.out.println("\\————————————————————————————————\\\n" + "/	Fraction Manipulator	 /\n" + "\\————————————————————————————————\\\n"); 
		
		
		//displaying and storing values for first fraction
		System.out.println("Enter numerators and non zero denominators \n" + "		* For the 1st fraction: ");
		num1 = keyIn.nextInt();
		den1 = keyIn.nextInt();
		
		//displaying and storing values for second fraction
		System.out.println("		* For the 2nd fraction: ");
		num2 = keyIn.nextInt();
		den2 = keyIn.nextInt();
		
		//calculating product in fraction as string and decimal as double
		fProduct = (num1*num2) + "/" + (den1*den2);
		product =  ((double)(num1*num2)/(double)(den1*den2)); //explicit type casting 
		
		//calculating sum in fraction as string and decimal as double
		fSum = (num1*den2+num2*den1) + "/" + (den1*den2);
		sum =  ((double)(num1*den2+num2*den1)/(double)(den1*den2));//explicit type casting 
		
		//displaying final output to the user
		System.out.println("\nThe product of " + num1 + "/" + den1 + " and " + num2 + "/" + den2 +" is " + fProduct + " or " + product);
		System.out.println("\nThe sum of " + num1 + "/" + den1 + " and " + num2 + "/" + den2 +" is " + fSum + " or " + sum + "\n");
	
		System.out.print("All done!!!");
		
		//closing the scanner object
		keyIn.close();
	}

}
