// ------------------------------------------------------- 
// Assignment 03 Question 01 - Class: Employee
// Written by: Vaansh Lakhwara 40114764
// For COMP 248 Section U – Winter 2020
// --------------------------------------------------------

/*
 * The following class is the Employee class that contains
 * two different constructors and different methods
 * that are called in the driver class later
 */

public class Employee {
	
	//declaring appropriate variables
	String emp_name;
	Date hiring_date;
	
	//Constructor 1
	public Employee() {
		emp_name = "Bruce Lee";
		hiring_date = new Date();
	} 
	
	//Constructor 2
	public Employee(String aName, Date aDate) {
		emp_name = aName;
		hiring_date = aDate;
	}
	
	//seniority method that compares the seniority between two different employees
	public int seniority(Employee e) {
		if(this.getHireDate().getYear()<e.getHireDate().getYear())
			return -1;
		else if(this.getHireDate().getYear()>e.getHireDate().getYear())
			return 1;
		else {
			if(this.getHireDate().getMonth()<e.getHireDate().getMonth())
				return -1;
			else if(this.getHireDate().getMonth()>e.getHireDate().getMonth())
				return 1;
			else {
				if(this.getHireDate().getDay()<e.getHireDate().getDay())
					return -1;
				else if(this.getHireDate().getDay()>e.getHireDate().getDay())
					return 1;
				else
					return 0;
			}
		}
		
	}
	
	//equals method that compares the hiring date of two employees and returns the boolean value
	public boolean equals(Employee e) {
		if(this.getHireDate().equals(e.getHireDate()))
			return true;
		else
			return false;
	}
	
	//getName method that returns the name of the employee
	public String getName() {
		return emp_name;
	}
	
	//getHireDate method that returns the hiring date of the employee
	public Date getHireDate() {
		return hiring_date;
	}
	
	//setHireDate that sets the hiring date of the employee
	public void setHireDate(Date date) {
		hiring_date = date;
	}
	
	//setName that sets the name of the employee
	public void setName(String name) {
		emp_name = name;
	}
}
