// -----------------------------------------------------
// Assignment 01, Part I
// Written by: Vaansh Lakhwara 40114764
// For COMP 249 Section CC – Summer 2020
// -----------------------------------------------------
/**
 * Vaansh Lakhwara 40114764
 * COMP 249
 * Assignment 01, Part I
 * Due Date: July 12, 2020
 */

package cBusPackage;
/**
 * There are four packages. 
 * This is the second package.
 * Contains: one child class, two multilevel 
 * inherited child classes and a driver class.
 * This is a multilevel inherited child class.
 */

public class Metro extends CityBus{
	/** Using public access rights. 
	* @param num_vehicles The number of vehicles.
	* @param city The name of city.
	*/
	public int num_vehicles;
	public String city;
	
	/**
	 * Default constructor.
	 * Used to initialize values.
	 */
	public Metro() {
		super();
		num_vehicles=0;
		city=null;
	}
	
	/**
	 * Parameterized constructor.
	 * Used to set given values.
	 */
	public Metro(double p, int s, long r, int y, String l, String d, int n, String c) {
		super(p, s, r, y, l, d);
		this.num_vehicles=n;
		this.city=c;
	}
			
	/**
	 * Copy constructor.
	 * Used to assign variables the value of a pre-existing object.
	 */
	public Metro(Metro m) {
		super(m);
		this.num_vehicles=m.num_vehicles;
		this.city=m.city;
	}
	
	/**
	 * Accessor method.
	 * @return num_vehicles The number of vehicles.		
	 */
	public int getNumVehicles() {
		return num_vehicles;
	}
	
	/**
	 * Accessor method.
	 * @return city The name of city.	
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Mutator method.
	 * To set value of number of vehicles given by user.
	 */
	public void setNumVehicles(int n) {
		this.num_vehicles=n;
	}
	
	/**
	 * Mutator method.
	 * To set value of name of city given by user.
	 */
	public void setCity(String c) {
		this.city=c;
	}
	
	/**
	 * toString() method.
	 * @return String value of information including variable values.
	 */
	public String toString() {
		return ("This Metro has " + getNumStops() + 
				" stops, and costs $" + 
				getTicketPrice() + 
				". There are " + 
				getNumVehicles() + 
				" number of vehicles. This City Bus has a Route Number of " + 
				getRouteNumber() + 
				", and began operations in " + 
				getOpYear() + 
				". The name of the driver(s) is/are " + 
				getDriverNames() + 
				" and it operates on line number " +
				getLineName() + 
				" in the city " + 
				getCity() + 
				".");
	}
	
	/**
	 * equals() method. 
	 * Returns false if object passed is null or of a different type than the calling object. 
	 * @return b Boolean value of equality of two objects.
	 */
	public boolean equals(Metro m) {
		boolean b=false;
		if(m==null || this.getClass()!=m.getClass())
			b=false;
		if(this.ticket_price==m.ticket_price 
			&& this.num_stops==m.num_stops 
			&& this.route_number==m.route_number 
			&& this.begin_operation_year==m.begin_operation_year
			&& this.num_vehicles==m.num_vehicles
			&& this.driver_names.equals(m.driver_names) 
			&& this.line_name.equals(m.line_name)			
			&& this.city.equals(m.city))
			{
				b=true;
			}
		return b;
	}	
}
