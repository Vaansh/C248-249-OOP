// ------------------------------------------------------- 
// Assignment 03 Question 01 - Class: EmployeeDriver
// Written by: Vaansh Lakhwara 40114764
// For COMP 248 Section U – Winter 2020
// --------------------------------------------------------

import java.util.Scanner;

/*
 * The following class is the Driver class that
 * asks the user for input, stores the information
 * of the two employees and calls methods
 * from the Date and Employee classes
 */

public class EmployeeDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//declare variables to store the dates and names of the two employees
		String name1, name2, month1, month2;
		int day1, day2, year1, year2;
		
		//declare scanner
		Scanner keyIn = new Scanner(System.in);
		
		//prompt user for input for employee1
		System.out.print("Name of employee 1: ");
		name1=keyIn.next();
		
		System.out.print("Enter the month of the hiring date of employee 1: ");
		month1 = keyIn.next();
		
		System.out.print("Enter the day of the hiring date of employee 1: ");
		day1=keyIn.nextInt();
		
		System.out.print("Enter the year of the hiring date of employee 1: ");
		year1=keyIn.nextInt();
		System.out.println();
		
		//prompt user for input for employee2
		System.out.print("Name of employee 2: ");
		name2=keyIn.next();
		
		System.out.print("Enter the month of the hiring date of employee 2: ");
		month2 = keyIn.next();
		
		System.out.print("Enter the day of the hiring date of employee 2: ");
		day2=keyIn.nextInt();
		
		System.out.print("Enter the year of the hiring date of employee 2: ");
		year2=keyIn.nextInt();
		System.out.println();
		
		//create Date objects for both 
		Date d1 = new Date(month1, day1, year1);
		Date d2 = new Date(month2, day2, year2);
			
		//create Employee objects for both 
		Employee e1 = new Employee(name1, d1);
		Employee e2 = new Employee(name2, d2);
		
		//print the first required output
		System.out.println("The first employee (e1):");
		System.out.println(e1.emp_name + " " + d1.getMonthName() + " " + d1.getDay() + ", " + d1.getYear());
		System.out.println();
		
		System.out.println("The first employee (e2):");
		System.out.println(e2.emp_name + " " + d2.getMonthName() + " " + d2.getDay() + ", " + d2.getYear());
		System.out.println();
		
		//close the scanner
		keyIn.close();
		
		//use nested if-else statements to determine who is more senior by comparing the values returned by the method
		String sr = e1.emp_name, jr=e2.emp_name;
		if(e1.seniority(e2) == -1) {
			System.out.println(sr + " is more senior than " + jr + "\n");
		}
		else if(e1.seniority(e2) == 1) {
			sr = e2.emp_name;
			jr = e1.emp_name;
			System.out.println(sr + " is more senior than " + jr + "\n");
		}
		else
			System.out.println(sr + " & " + jr + " were hired on the same day." + "\n");
		
		//create an instance of e1 and call it e3
		Date d3 = new Date(d1.getMonthName(), d1.getDay(), d1.getYear());
		Employee e3 = new Employee(e1.emp_name,e1.hiring_date);
		
		System.out.println("The duplicated employee (e3):");
		System.out.println(e3.emp_name + " " + d1.getMonthName() + " " + d1.getDay() + ", " + d1.getYear() + "\n");
		
		//display final output
		System.out.println("e1.equals(e3) => " + e1.equals(e3));
		System.out.println("e2.equals(e3) => " + e2.equals(e3));
		System.out.println("(e1 == e3) => " + (e1 == e3));
		System.out.println("(e2 == e3) => " + (e2 == e3));

	}

}
