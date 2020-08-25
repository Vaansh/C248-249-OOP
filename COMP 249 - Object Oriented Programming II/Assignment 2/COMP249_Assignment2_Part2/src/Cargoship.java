// -----------------------------------------------------
// Assignment 02, Part II
// Written by: Vaansh Lakhwara 40114764
// For COMP 249 Section CC – Summer 2020
// -----------------------------------------------------
/**
 * Vaansh Lakhwara 40114764
 * COMP 249
 * Assignment 02, Part II
 * Due Date: July 26, 2020
 */

public class Cargoship {
	/** Using private access rights. 
	* @param serial_number The serial number.
	* @param name The name of cargo ship.
	* @param creation_year The year of creation.
	* @param owner_country The name of owner's country.
	* @param price The price of cargo ship.
	* @param speed The speed of cargo ship.
	*/
	
	private long serial_number;
	private String name;
	private int creation_year;
	private String owner_country;
	private double price; 
	private int speed;
	
	/**
	 * Default constructor.
	 * Used to initialize values.
	 */
	public Cargoship() {
		this.serial_number=0;
		this.name="";
		this.creation_year=2000;
		this.owner_country="";
		this.price=0;
		this.speed=100;
	}
	
	/**
	 * Parameterized constructor.
	 * Used to set given values.
	 */
	public Cargoship(long sno, String n, int c, String o, double p, int s) {
		this.serial_number=sno;
		this.name=n;
		this.creation_year=c;
		this.owner_country=o;
		this.price=p;
		this.speed=s;
	}
	
	/**
	 * Copy constructor.
	 * Used to assign variables the value of a pre-existing object.
	 */
	public Cargoship(Cargoship c) {
		this.serial_number=c.serial_number;
		this.name=c.name;
		this.creation_year=c.creation_year;
		this.owner_country=c.owner_country;
		this.price=c.price;
		this.speed=c.speed;
	}
	
	/**
	 * toString() method.
	 * @return String value of information including variable values.
	 */
	public String toString(Cargoship c) {
		return (c.serial_number + " " + c.name + " " + c.creation_year + " " + 
				c.owner_country + " " + c.price + " " + c.speed);
	}
	
	/**
	 * Accessor method.
	 * @return serial_number The serial number.		
	 */	
	public long getSerialNumber() {
		return this.serial_number;
	}
	
	/**
	 * Accessor method.
	 * @return name The name of cargo ship.		
	 */	
	public String getName() {
		return this.name;
	}
	
	/**
	 * Accessor method.
	 * @return creation_year The year of creation.		
	 */	
	public int getcreationyear() {
		return this.creation_year;
	}
	
	/**
	 * Accessor method.
	 * @return owner_country The name of owner's country.		
	 */	
	public String getOwnerCountry() {
		return this.owner_country;
	}
	
	/**
	 * Accessor method.
	 * @return price The price of cargo ship.		
	 */	
	public double getPrice() {
		return this.price;
	}
	
	/**
	 * Accessor method.
	 * @return speed The speed of cargo ship.		
	 */	
	public int getSpeed() {
		return this.speed;
	}
	
	/**
	 * Mutator method.
	 * To set value of the serial number.
	 */
	public void setSerialNumber(long s) {
		this.serial_number=s;
	}
	
	/**
	 * Mutator method.
	 * To set the name of cargo ship.
	 */
	public void setName(String n) {
		this.name=n;
	}
	
	/**
	 * Mutator method.
	 * To set the year of creation.
	 */
	public void setCreationYear(int c) {
		this.creation_year=c;
	}
	
	/**
	 * Mutator method.
	 * To set the name of owner's country.
	 */
	public void setOwnerCountry(String o) {
		this.owner_country=o;
	}
	
	/**
	 * Mutator method.
	 * To set the price of cargo ship.
	 */
	public void setPrice(double p) {
		this.price=p;
	}
	
	/**
	 * Mutator method.
	 * To set the speed of cargo ship.
	 */
	public void setSpeed(int s) {
		this.speed=s;
	}
}
