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

package pTransportPackage;
/**
 * There are four packages. 
 * This is the first package.
 * Contains: one class.
 */

public class PublicTransportation {
	/** Using public access rights. 
	* @param ticket_price The price of the ticket.
	* @param num_stops The number of stops.
	*/
	public double ticket_price;
	public int num_stops;
	
	/**
	 * Default constructor.
	 * Used to initialize values.
	 */
	public PublicTransportation() {
		ticket_price=0;
		num_stops=0;
	}
	
	/**
	 * Parameterized constructor.
	 * Used to set given values.
	 */
	public PublicTransportation(double t, int s) {
		this.ticket_price=t;
		this.num_stops=s;
	}
	
	/**
	 * Copy constructor.
	 * Used to assign variables the value of a pre-existing object.
	 */
	public PublicTransportation(PublicTransportation p) {
		this.ticket_price=p.ticket_price;
		this.num_stops=p.num_stops;
	}
	
	/**
	 * Accessor method.
	 * @return ticket_price The price of the ticket.
	 */
	public double getTicketPrice() {
		return ticket_price;
	}
	
	/**
	 * Accessor method.
	 * @return num_stops The number of stops.		
	 */	
	public int getNumStops() {
		return num_stops;
	}
	
	/**
	 * Mutator method.
	 * To set value of ticket price given by user.
	 */
	public void setTicketPrice(double t) {
		this.ticket_price=t;
	}
	
	/**
	 * Mutator method.
	 * To set value of number of stops given by user.
	 */
	public void setNumStops(int n) {
		this.num_stops=n;
	}
	
	/**
	 * toString() method.
	 * @return String value of information including variable values.
	 */
	public String toString() {
		return ("This Public Transportation has " +
				getNumStops() +
				" stops, and costs $" + 
				getTicketPrice() + 
				".");
	}
	
	/**
	 * equals() method. 
	 * Returns false if object passed is null or of a different type than the calling object. 
	 * @return b Boolean value of equality of two objects.
	 */
	public boolean equals(PublicTransportation p) {
		boolean b=false;
		if(p==null || this.getClass()!=p.getClass())
			b=false;
		if(this.ticket_price==p.ticket_price 
			&& this.num_stops==p.num_stops)
			{
				b=true;
			}
		return b;
	}
}

