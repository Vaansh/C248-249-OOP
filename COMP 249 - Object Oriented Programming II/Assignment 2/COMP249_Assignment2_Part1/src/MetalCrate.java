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

public class MetalCrate extends Crate {
	
	/**
	 * Parameterized constructor.
	 * Calls parameterized super() method from parent class.
	 * @param t Tracking number.
	 * @param w Weight.
	 */
	public MetalCrate(int t, double w) {
		super(t, w);
	}
	
	double sc;
	
	/**
	 * Method that accepts one parameter.
	 * To set the weight of letter.
	 */
	public void setWeight(double w) {
		this.setWeight(w);
	}

	/**
	 * Calculates shipping cost.
	 * Returns tooHeavyException if package too heavy. 
	 * @return sc Shipping cost.
	 */
	@SuppressWarnings("finally")
	@Override
	public double calcShipCost(double w) {
		try {
			if(this.weightType(getTrackingNumber()).equals("oz")) {
				if(w>1280) {					
					throw new tooHeavyException("Package is too heavy.");
				}
				else {
					sc=(2.5*w);
					this.shipping_cost=sc;
				}
			}
			else 
				if(w>80) {
					throw new tooHeavyException("Package is too heavy.");
				}
				else {
					sc=(2.5*toOunces(w));
					this.shipping_cost=sc;
				}
		}
		catch(tooHeavyException h) {
			System.out.println("Package Type: Metal Crate" 
					+ ",	Tracking Number: " + tracking_number
					+ ", Weight: " + weight);
			System.out.println(h.getMessage());
		}
		finally {
			setShippingCost(sc);
			return sc;
		}
	}
}
