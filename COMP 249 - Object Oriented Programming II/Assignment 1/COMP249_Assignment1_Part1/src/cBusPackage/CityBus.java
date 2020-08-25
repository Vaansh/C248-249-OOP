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
import pTransportPackage.PublicTransportation;
/**
 * There are four packages. 
 * This is the second package.
 * Contains: one child class, two multilevel 
 * inherited child classes and a driver class.
 * This is the child class.
 */

public class CityBus extends PublicTransportation{
	/** Using protected access rights enables 
	 * variable access in all classes in same package.
	 * @param route_number The number of the route.
	 * @param begin_operation_year Indicates year that operation began.
	 * @param line_name Name of the line.
	 * @param driver_names Names of the drivers.
	 */
	protected long route_number;
	protected int begin_operation_year;
	protected String line_name, driver_names;
	
	/**
	 * Default constructor.
	 * Used to initialize values.
	 */
	public CityBus() {
		super();
		route_number=0;
		begin_operation_year=2020;
		line_name=null;
		driver_names=null;
	}
	
	/**
	 * Parameterized constructor.
	 * Used to set given values.
	 */
	public CityBus(double p, int s, long r, int y, String l, String d) {
		super(p,s);
		this.route_number=r;
		this.begin_operation_year=y;
		this.line_name=l;
		this.driver_names=d;
	}
	
	/**
	 * Copy constructor.
	 * Used to assign variables the value of a pre-existing object.
	 */
	public CityBus(CityBus c) {
		super(c);
		this.route_number=c.route_number;
		this.begin_operation_year=c.begin_operation_year;
		this.line_name=c.line_name;
		this.driver_names=c.driver_names;
	}
	
	/**
	 * Accessor method.
	 * @return route_number The number of the route.		
	 */
	public long getRouteNumber() {
		return route_number;
	}
	
	/**
	 * Accessor method.
	 * @return begin_operation_year Indicates year that operation began.	
	 */
	public int getOpYear() {
		return begin_operation_year;
	}
	
	/**
	 * Accessor method.
	 * @return line_name Name of the line.		
	 */
	public String getLineName() {
		return line_name;
	} 
	
	/**
	 * Accessor method.
	 * @return driver_names Names of the drivers.		
	 */
	public String getDriverNames() {
		return driver_names;
	} 
	
	/**
	 * Mutator method.
	 * To set value of route number given by user.
	 */
	public void setRouteNumber(long r) {
		this.route_number=r;
	}
	
	/**
	 * Mutator method.
	 * To set value of year that operation began given by user.
	 */
	public void setOpYear(int y) {
		this.begin_operation_year=y;
	}
	
	/**
	 * Mutator method.
	 * To set value of line name given by user.
	 */
	public void setLineName(String l) {
		this.line_name=l;
	}
	
	/**
	 * Mutator method.
	 * To set value of driver names given by user.
	 */
	public void setDriverNames(String d) {
		this.driver_names=d;
	}
	
	/**
	 * toString() method.
	 * @return String value of information including variable values.
	 */
	public String toString() {
		return ("This City Bus has " + getNumStops() + 
				" stops, and costs $" + 
				getTicketPrice() + 
				". It has a Route Number of " +  
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
	public boolean equals(CityBus c) {
		boolean b=false;
		if(c==null || this.getClass()!=c.getClass())
			b=false;
		if(this.ticket_price==c.ticket_price 
			&& this.num_stops==c.num_stops 
			&& this.route_number==c.route_number 
			&& this.begin_operation_year==c.begin_operation_year 
			&& this.driver_names.equals(c.driver_names) 
			&& this.line_name.equals(c.line_name))
			{
				b=true;
			}
		return b;
	}		
}
