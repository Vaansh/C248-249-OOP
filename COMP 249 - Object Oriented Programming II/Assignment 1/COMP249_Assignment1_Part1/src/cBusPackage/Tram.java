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

public class Tram extends CityBus{
	/** Using public access rights. 
	* @param max_spd The maximum speed.
	*/
	public int max_spd;
	
	/**
	 * Default constructor.
	 * Used to initialize values.
	 */
	public Tram() {
		super();
		max_spd=50;
	}
	
	/**
	 * Parameterized constructor.
	 * Used to set given values.
	 */
	public Tram(double p, int s, long r, int y, String l, String d, int m) {
		super(p, s, r, y, l, d);
		this.max_spd=m;
	}
		
	/**
	 * Copy constructor.
	 * Used to assign variables the value of a pre-existing object.
	 */
	public Tram(Tram t) {
		super(t);
		this.max_spd=t.max_spd;
	}
	
	/**
	 * Accessor method.
	 * @return max_spd The maximum speed.
	 */
	public int getMaxSpeed() {
		return max_spd;
	}
	
	/**
	 * Mutator method.
	 * To set value of maximum speed given by user.
	 */
	public void setMaxSpeed(int y) {
		this.max_spd=y;
	}
	
	/**
	 * toString() method.
	 * @return String value of information including variable values.
	 */
	public String toString() {
		return ("This Tram has " + getNumStops() + 
				" stops, and costs $" + 
				getTicketPrice() + 
				". Its maximum speed is " + 
				getMaxSpeed() +
				"km/h. This City Bus has a Route Number of " + 
				getRouteNumber() + 
				", and began operations in " + 
				getOpYear() + 
				". The name of the driver(s) is/are " + 
				getDriverNames() + 
				" and it operates on line number " +
				getLineName() + 
				".");
	}
		
	/**
	 * equals() method. 
	 * Returns false if object passed is null or of a different type than the calling object. 
	 * @return b Boolean value of equality of two objects.
	 */
	public boolean equals(Tram t) {
		boolean b=false;
		if(t==null || this.getClass()!=t.getClass())
			b=false;
		if(this.ticket_price==t.ticket_price 
			&& this.num_stops==t.num_stops 
			&& this.route_number==t.route_number 
			&& this.begin_operation_year==t.begin_operation_year 
			&& this.max_spd==t.max_spd
			&& this.driver_names.equals(t.driver_names) 
			&& this.line_name.equals(t.line_name))
			{
				b=true;
			}
		return b;
	}
		
}
