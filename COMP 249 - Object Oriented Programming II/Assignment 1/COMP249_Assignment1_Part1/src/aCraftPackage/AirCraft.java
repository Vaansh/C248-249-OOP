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

package aCraftPackage;
import pTransportPackage.PublicTransportation;
/**
 * There are four packages. 
 * This is the fourth package.
 * Contains: one child class.
 */

public class AirCraft extends PublicTransportation{
	/** Using public access rights.
	 * AirCraft class types that can be used.
	 */
	public enum ClassType {
	    /**
	     * Helicopter class type.
	     */
		HELICOPTER, 
		/**
	     * Airline class type.
	     */
		AIRLINE,
		/**
	     * Glider class type.
	     */
		GLIDER,
		/**
	     * Balloon class type.
	     */
		BALLOON
		}
		
	/**
	 * AirCraft maintenance types that can be used.
	 */
	public enum MaintenanceType {
		/**
	     * Weekly maintenance type.
	     */
		WEEKLY,
		/**
	     * Monthly maintenance type.
	     */
		MONTHLY,
		/**
	     * Yearly maintenance type.
	     */
		YEARLY
		}
	
	/** Using public access rights.
	* @param class_type Array that contain values of ClassType enum.
	* @param maintenance_type Array that contains values of MaintenanceType enum.
	* @param c_type Variable that can only store values inside ClassType enum.
	* @param m_type Variable that can only store values inside MaintenanceType enum.
	*/
	public ClassType [] class_type = ClassType.values();
	public MaintenanceType [] maintenance_type = MaintenanceType.values();
	public ClassType c_type;
	public MaintenanceType m_type;
	
	/**
	 * Default constructor.
	 * Used to initialize values.
	 */
	public AirCraft() {
		super();
		c_type=class_type[0];
		m_type=maintenance_type[0];
	}
				
	/**
	 * Parameterized constructor.
	 * Used to set given values.
	 */
	public AirCraft(double t, int s, ClassType c, MaintenanceType m) {
		super(t,s);
		this.c_type=c;
		this.m_type=m;
		
	}
				
	/**
	 * Copy constructor.
	 * Used to assign variables the value of a pre-existing object.
	 */
	public AirCraft(AirCraft a) {
		super(a);
		this.c_type=a.c_type;
		this.m_type=a.m_type;
	}
	
	/**
	 * Accessor method.
	 * @return c_type Variable that can only store values inside ClassType enum.
	 */
	public ClassType getClassType() {
		return c_type;
	}
	
	/**
	 * Accessor method.
	 * @return m_type Variable that can only store values inside MaintenanceType enum.
	 */
	public MaintenanceType getMaintenanceType() {
		return m_type;
	}
	
	/**
	 * Mutator method.
	 * To set value of ClassType given by user.
	 */
	public void setClassType(ClassType c) {
		this.c_type=c;
	}
	
	/**
	 * Mutator method.
	 * To set value of MaintenanceType given by user.
	 */
	public void setMaintenanceType(MaintenanceType m) {
		this.m_type=m;
	}
	
	/**
	 * toString() method.
	 * @return String value of information including variable values.
	 */
	public String toString() {
		return ("This Aircraft has " +
				num_stops +
				" stops, and costs $" + 
				ticket_price + 
				". The class type is " +
				c_type +
				" and the maintenance type is " +
				m_type +
				".");
	}
			
	/**
	 * equals() method. 
	 * Returns false if object passed is null or of a different type than the calling object. 
	 * @return b Boolean value of equality of two objects.
	 */
	public boolean equals(AirCraft a) {
		boolean b=false;
		if(a==null || this.getClass()!=a.getClass())
			b=false;
		else if(this.ticket_price==a.ticket_price 
				&& this.num_stops==a.num_stops
				&& this.c_type.equals(a.c_type)
				&& this.m_type.equals(a.m_type))
				{
					b=true;
				}
		return b;
	}
	
}
