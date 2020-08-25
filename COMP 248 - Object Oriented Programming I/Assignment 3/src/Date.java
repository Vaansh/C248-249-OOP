// ------------------------------------------------------- 
// Assignment 03 Question 01 - Class: Date
// Written by: Vaansh Lakhwara 40114764
// For COMP 248 Section U – Winter 2020
// --------------------------------------------------------

/*
 * The following class is the Date class that contains
 * three different constructors and different methods
 * that are called in the driver class later
 */

public class Date{
	
	//declaring appropriate variables
	int day;
	String month;
	int year;
	
	//Constructor 1
	public Date(){
		day = 5;
		month = "October";
		year = 2019;
	}
	
	//Constructor 2
	public Date(String monthString, int day, int year){
		this.day = day;
		this.month = monthString;
		this.year = year;
	}
	
	//Constructor 3
	public Date(int monthInt, int day, int year) {
		this.day = day;
		this.month = monthString(monthInt);
		this.year = year;
	}
	
	//equals method that returns boolean value
	public boolean equals(Date otherDate) {
		return(this.day == otherDate.day && this.month.equals(otherDate.month) && this.year == otherDate.year);
	}
	
	//dateOK method for two different types of inputs (String, integer, integer & integer, integer, integer)
	private boolean dateOK(String okMonth, int okDay, int okYear){
		if(okYear<1000 || okYear>9999)
			return false;
		
		int lastDayOfMonth = 31;
		if(okMonth == "April" || okMonth == "June" || okMonth == "September" || okMonth == "November" )
			lastDayOfMonth = 30;
		if(okMonth == "February")
			lastDayOfMonth = (isLeap(okYear)?29:28);
		
		if(okDay<0 || okDay>lastDayOfMonth)
			return false;
		
		return true;
	}
		
    private boolean dateOK(int okMonth, int okDay, int okYear) {
		return dateOK(monthString(okMonth),okDay, okYear);
	}	
 
 	//method that checks if it is a leap year
	private boolean isLeap(int okYear) {
		if(okYear%4 == 0||okYear%400 == 0)
			return true;
		if(okYear%100 == 0)
			return false;
		return false;
	}
		
	//monthInt method that converts string value of month to integer value of month
	private int monthInt(String okMonth){
		if(okMonth == "January") 
			return 1;
		if(okMonth == "February") 
			return 2;
		if(okMonth == "March") 
			return 3;
		if(okMonth == "April") 
			return 4;
		if(okMonth == "May") 
			return 5;
		if(okMonth == "June") 
			return 6;
		if(okMonth == "July") 
			return 7;
		if(okMonth == "August") 
			return 8;
		if(okMonth == "September") 
			return 9;
		if(okMonth == "October") 
			return 10;
		if(okMonth == "November") 
			return 11;
		if(okMonth == "December") 
			return 12;
		else
			return 0;
	}
		
	//monthString method that converts integer value of month to string value of month
	private String monthString(int okMonth){
		if(okMonth == 1)
			return "January"; 
		if(okMonth == 2)
			return "February";
		if(okMonth == 3) 
			return "March";
		if(okMonth == 4) 
			return "April";
		if(okMonth == 5) 
			return "May";
		if(okMonth == 6)
			return "June";
		if(okMonth == 7) 
			return "July";
		if(okMonth == 8) 
			return "August";
		if(okMonth == 9) 
			return "September";
		if(okMonth == 10) 
			return "October";
		if(okMonth == 11) 
			return "November";
		if(okMonth == 12)	 
			return "December";
		else
			return "";
		}
	
	//setDate method that sets the date with two different types of inputs (String, integer, integer & integer, integer, integer)
	public void setDate(String okMonth, int okDay, int okYear) {
		if(!dateOK(okMonth, okDay, okYear))
			return;
		this.month = okMonth;
		this.day = okDay;
		this.year = okYear;
	}
	
	public void setDate(int okMonth, int okDay, int okYear) {
		if(!dateOK(okMonth, okDay, okYear))
			return;
		this.month = monthString(okMonth);
		this.day = okDay;
		this.year = okYear;
	}
	
	//getDay method that returns the integer value of the day
	public int getDay() {
		return day;
	}
	
	//getMonth method that returns the integer value of the month
	public int getMonth() {
		return monthInt(month);
	}
	
	//getMonth name that returns the string value of the month (used in driver class)
	public String getMonthName() {
		return month;
	}
	
	//getYear method that returns the integer value of the year
	public int getYear() {
		return year;
	}
	
	//setDay method that stores the integer value of day
	public void setDay(int okDay) {
		day = okDay;
	}
	
	//setMonth method that stores the integer value of month
	public void setMonth(int okMonth) {
		 setMonth(monthString(okMonth));
	}
	
	//setMonth method that stores the String value of month
	public void setMonth(String okMonth) {
		 setMonth(monthInt(okMonth));
	}
	
	//setYear method that stores the integer value of year
	public void setYear(int okYear) {
		year = okYear;
	}
}
