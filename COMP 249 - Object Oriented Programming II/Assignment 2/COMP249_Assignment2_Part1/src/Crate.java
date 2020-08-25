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

public class Crate extends Package{
	double sc;
	
	/**
	 * Parameterized constructor.
	 * Calls parameterized super() method from parent class.
	 * @param t Tracking number.
	 */
	public Crate(int t, double w) {
		super(t,w);
	}
	
	/**
	 * Method that accepts one parameter.
	 * To set the weight of letter.
	 */
	public void setWeight(double w) {
		this.setWeight(w);
	}
	
	/**
	 * Calculates shipping cost.
	 * Returns 0 because it is overridden in child classes. 
	 * @return 0 Value of 0.
	 */
	@Override
	double calcShipCost(double w) {
		return 0;
	}
}
