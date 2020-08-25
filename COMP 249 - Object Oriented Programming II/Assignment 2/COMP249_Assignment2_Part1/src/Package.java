// -----------------------------------------------------
// Assignment 02, Part I
// Written by: Vaansh Lakhwara 40114764
// For COMP 249 Section CC – Summer 2020
// -----------------------------------------------------
/**
 * Vaansh Lakhwara 40114764
 * COMP 249
 * Assignment 02, Part I
 * Due Date: July 26, 2020
 */

public abstract class Package {
	/** Using protected access rights. 
	* @param tracking_number The tracking number of package.
	* @param weight The weight of package.
	* @param shipping_cost The value of shipping cost.
	*/
	protected int tracking_number;
	protected double weight, shipping_cost=0;
	
	/**
	 * Parameterized constructor.
	 * Used to initialize values.
	 * @param t Tracking number.
	 * @param w Weight.
	 */
	public Package(int t, double w) {
		this.tracking_number=t;
		this.weight=w;
		this.shipping_cost=calcShipCost(w);
	}
	
	/**
	 * Abstract method.
	 * Used to calculate shipping cost.
	 * @param w weight
	 * @return sc Shipping cost.
	 */
	abstract double calcShipCost(double w);
	
	/**
	 * weightType
	 * @return String value of unit of quantity. 
	 * @param tno Tracking number.
	 */
	public String weightType(int tno) {
		int length=tno%10;
		if(length==0)
			return "oz";
		else if(length==1 || length==2 || length==3)
			return "lbs";
		else
			return "Invalid";
	}
	
	public String packageType(int tno) {
		int length=tno%10;
		if(length==0)
			return "Letter";
		else if(length==1)
			return "Box";
		else if(length==2)
			return "Wooden Crate";
		else
			return "Metal Crate";
	}
	
	/**
	 * toPounds method.
	 * @param lbs The total of package in lbs.
	 * @return lbs*16 The total of package in oz.
	 */
	public double toOunces(double lbs) {
		return (lbs*16);
	}
	
	/**
	 * toPounds method.
	 * @param oz The total of package in ounces.
	 * @return oz*0.0625 The total of package in pounds.
	 */
	public double toPounds(double oz) {
		return (oz*0.0625);
	}
	
	/**
	 * Accessor method.
	 * @return tracking_number The tracking number of package.
	 */
	public int getTrackingNumber() {
		return this.tracking_number;
	}
	
	/**
	 * Accessor method.
	 * @return weight The weight of package.
	 */
	public double getWeight() {
		return this.weight;
	}
	
	/**
	 * Accessor method.
	 * @return shipping_cost The value of shipping cost.
	 */
	public double getShippingCost() {
		return this.shipping_cost;
	}

	/**
	 * Mutator method.
	 * To set the tracking number of package.
	 */
	public void setTrackingNumber(int t) {
		this.tracking_number=t;
	}
	
	/**
	 * Mutator method.
	 * To set the weight of package.
	 * @param w Weight.
	 */
	public void setWeight(double w) {
		this.weight=w;
	}
	
	/**
	 * Mutator method.
	 * To set the value of shipping cost.
	 * @param s Shipping cost.
	 */
	public void setShippingCost(double s) {
		this.shipping_cost=s;
	}
	
	
}
