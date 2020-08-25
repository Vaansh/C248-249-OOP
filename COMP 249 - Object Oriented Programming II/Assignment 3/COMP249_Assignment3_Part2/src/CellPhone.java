// -----------------------------------------------------
// Assignment 03, Part II
// Written by: Vaansh Lakhwara 40114764
// For COMP 249 Section CC – Summer 2020
// -----------------------------------------------------
/**
 * @author Vaansh Lakhwara 40114764
 * COMP 249
 * Assignment 03, Part II
 * Due Date: August 16, 2020
 */

public class CellPhone 
{
	/**
	 * The CellPhone class consists of the following parameters 
	 * set to private. 
	 * @param serialNum Serial number.
	 * @param brand Brand name.
	 * @param year Year manufactured.
	 * @param price Price of cell phone.
	 */	
	private long serialNum;
	private String brand;
	private int year;
	private double price;

	/**
	 * Default constructor. 
	 * Initializes values of all the variables.
	 */
	public CellPhone()
	{
		serialNum=0;
		brand="A";
		year=0000;
		price=00.0;
	}

	/**
	 * Parameterized constructor.
	 * Sets values of all the variables.
	 * @param serialNum Serial number.
	 * @param brand Brand name.
	 * @param year Year manufactured.
	 * @param price Price of cell phone.
	 */
	public CellPhone(long serialNum, String brand, int year, double price) 
	{
		setSerialNum(serialNum);
		setBrand(brand);
		setYear(year);
		setPrice(price);
	}

	/**
	 * Copy constructor.
	 * Sets values of all the variables from given phone object.
	 * @param serialNum Serial number.
	 * @param phone CellPhone to set values from.
	 */
	public CellPhone(CellPhone phone, long serialNum) 
	{
		setSerialNum(serialNum);
		setBrand(phone.brand);
		setYear(phone.year);
		setPrice(phone.price);
	}

	/**
	 * Clone method.
	 * @param serialNum Serial number.
	 * @return Cloned CellPhone object.
	 */
	public CellPhone clone(long serialNum) 
	{		
		return new CellPhone(this, serialNum);
	}

	/**
	 * This method returns the string value of the CellPhone object.
	 * @return String value
	 */
	public String toString() 
	{
		return ("[" + serialNum + ": " + brand + " " + price + "$ " + year + "]");
	}

	/**
	 * This method checks the equality of two Objects.
	 * @return boolean value of equality condition of the two objects.
	 */
	public boolean equals(Object phone) 
	{
		if(phone==this)
		{
			return true;
		}
		if(phone==null || this.getClass()!=phone.getClass())
		{
			return false;
		}
		CellPhone cell=(CellPhone) phone;
		return (brand==cell.brand && price==cell.price && year==cell.year);
	}

	/**
	 * Mutator method.
	 * To set the serial number.
	 * @param serialNum Serial number.
	 */
	public void setSerialNum(long serialNum) 
	{
		this.serialNum=serialNum;
	}

	/**
	 * Mutator method.
	 * To set the brand.
	 * @param brand  Brand name.
	 */
	public void setBrand(String brand) 
	{
		this.brand=brand;
	}

	/**
	 * Mutator method.
	 * To set the year of creation.
	 * @param year Year manufactured.
	 */
	public void setYear(int year) 
	{
		this.year=year;
	}

	/**
	 * Mutator method.
	 * To set the price.
	 * @param price Price of cell phone.		 
	 */
	public void setPrice(double price) 
	{
		this.price=price;
	}

	/**
	 * Accessor method.
	 * @return serialNum Serial number.
	 */	
	public long getSerialNum() 
	{
		return serialNum;
	}
	
	/**
	 * Accessor method.
	 * return brand Brand name.
	 */	
	public String getBrand() 
	{
		return brand;
	}

	/**
	 * Accessor method.
 	 * @return year Year manufactured.
	 */	
	public int getYear() 
	{
		return year;
	}
	
	/**
	 * Accessor method.
	 * @return price Price of cell phone.		
	 */	
	public double getPrice() 
	{
		return price;
	}
}
