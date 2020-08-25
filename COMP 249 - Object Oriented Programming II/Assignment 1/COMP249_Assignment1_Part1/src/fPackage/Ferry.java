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

package fPackage;
import pTransportPackage.PublicTransportation;
/**
 * There are four packages. 
 * This is the third package.
 * Contains: one child class.
 */

public class Ferry extends PublicTransportation{
	/** Using public access rights. 
	* @param build_year The year the ferry was built.
	* @param ship_name The name of the ship.
	*/
	public int build_year;
	public String ship_name;
	
	/**
	 * Default constructor.
	 * Used to initialize values.
	 */
	public Ferry() {
		super();
		build_year=2020;
		ship_name=null;
	}
				
	/**
	 * Parameterized constructor.
	 * Used to set given values.
	 */
	public Ferry(double t, int s, int b, String n) {
		super(t,s);
		this.build_year=b;
		this.ship_name=n;
	}
				
	/**
	 * Copy constructor.
	 * Used to assign variables the value of a pre-existing object.
	 */
	public Ferry(Ferry f) {
		super(f);
		this.build_year=f.build_year;
		this.ship_name=f.ship_name;
	}
	
	/**
	 * Accessor method.
	 * @return build_year The year the ferry was built.		
	 */
	public int getBuildYear() {
		return build_year;
	}
	
	/**
	 * Accessor method.
	 * @return ship_name The name of the ship.		
	 */
	public String getShipName() {
		return ship_name;
	}
	
	/**
	 * Mutator method.
	 * To set value of year the ferry was built given by user.
	 */
	public void setBuildYear(int b) {
		this.build_year=b;
	}
	
	/**
	 * Mutator method.
	 * To set value of name of the ship given by user.
	 */
	public void setShipName(String n) {
		this.ship_name=n;
	}
	
	/**
	 * toString() method.
	 * @return String value of information including variable values.
	 */
	public String toString() {
		return ("This Ferry has " +
				getNumStops() +
				" stops, and costs $" + 
				getTicketPrice() + 
				". It was built in the year " +
				getBuildYear() +
				" and is named " + 
				getShipName() +
				".");
	}
		
	/**
	 * equals() method. 
	 * Returns false if object passed is null or of a different type than the calling object. 
	 * @return b Boolean value of equality of two objects.
	 */
	public boolean equals(Ferry f) {
		boolean b=false;
		if(f==null || this.getClass()!=f.getClass())
			b=false;
		if(this.ticket_price==f.ticket_price 
			&& this.num_stops==f.num_stops
			&& this.build_year==f.build_year
			&& this.ship_name.equals(f.ship_name))
			{
				b=true;
			}
		return b;
	}
}
