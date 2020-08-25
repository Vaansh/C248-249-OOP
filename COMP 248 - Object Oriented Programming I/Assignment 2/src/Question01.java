// ------------------------------------------------------- 
// Assignment 2 Question 1
// Written by: Vaansh Lakhwara 40114764
// For COMP 248 Section U – Winter 2020
// -------------------------------------------------------

import java.util.Scanner;
/*
 * The following program uses multiple if-else statements to 
 * categorize and assign the variables the values accordingly 
 * and display the output to the user
 */

public class Question01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//declaring the variables
		double fare_perkm, total_distance, rushhr_ratio, total_cost;
		int car_option, day_option, time_option;
		
		//declaring scanner object
		Scanner keyIn = new Scanner(System.in);
		
		//displaying the heading
		System.out.println("-------****-------****-------****-------****-----****----- \n" + 
				"	Welcome to Montreal Taxi Fare Estimator! \n" + 
				"-------****-------****-------****-------****-----****----- ");
	
		//getting the car model from user
		System.out.println("\nPlease select your taxi car model:\n" + 
				"       1 – base car\n" + 
				"       2 – limo car\n" + 
				"\n" + 
				"Please enter the digit corresponding to your case:(1 or 2)");
		
		//assigning the value to the variable
		car_option = keyIn.nextInt();

		//determining the fare per kilometer using the if-else statement
		if(car_option == 1)
			fare_perkm = 0.81;
		else
			fare_perkm = 1.55;
		
		//getting the day type from user
		System.out.println("\nPlease select which day you will be using the taxi service: \n" + 
				"	1 - Weekday\n" +
				"	2 - Weekend");
		
		//assigning the value to the variable
		day_option = keyIn.nextInt();
	
		//determining the rush hour ratio using nested if-else statements depending on day type selected earlier
		if(day_option == 1)
		{
			System.out.println("\nPlease select the time you will be using the taxi service: \n" + 
					"	1 - During 8am - 10am and 4pm - 5pm\n" +
					"	2 - From midnight 12am to 6am\n" +
					"	3 - None of the above");
			time_option = keyIn.nextInt();
			
			if(time_option == 1)
				rushhr_ratio = 1.5;
			
			else if(time_option == 2)
				rushhr_ratio = 2;
			
			else
				rushhr_ratio = 1;
		}
		else 
		{
			System.out.println("\nPlease select the time you will be using the taxi service: \n" + 
					"	1 - Between midnight 12am and 6am\n" +
					"	2 - None of the above");
			time_option = keyIn.nextInt();
			
			if(time_option == 1)
				rushhr_ratio = 2;
			
			else
				rushhr_ratio = 1.3;
			
		}
			
		//getting the estimated input from the user
		System.out.println("\nPlease enter the estimated distance (km) of your ride:");
		total_distance = keyIn.nextDouble();
		
		//calculating the total cost and storing it in the variable declared above
		total_cost = fare_perkm*total_distance*rushhr_ratio;
		
		//displaying total cost
		System.out.println("\nYour estimated fare is $" + total_cost + 
				"\nThank you for using our service! ");
		
		//closing the scanner
		keyIn.close();
	}

}





