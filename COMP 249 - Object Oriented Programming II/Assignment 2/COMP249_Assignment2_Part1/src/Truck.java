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

public class Truck{
	/** Using different access rights. 
	* @param driver_name The name of driver.
	* @param origin_city The name of origin city.
	* @param destination_city The name of destination city.
	* @param gross_weight The value of gross weight.
	* @param unloaded_weight The value of unloaded weight.
	* @param num_of_packages The number of packages.
	* @param package_info Array containing information of packages.
	*/
	private String driver_name, origin_city, destination_city;
	private double gross_weight, unloaded_weight;
	private int num_of_packages;
	protected Package [] package_info = new Package[200];
	
	/**
	 * Default constructor.
	 * Used to initialize values.
	 */
	public Truck() {
		this.driver_name=null;
		this.origin_city=null;
		this.destination_city=null;
		this.gross_weight=-1;
		this.unloaded_weight=-1;
		this.num_of_packages=-1;
	}
	/**
	 * Parameterized constructor.
	 * Used to set given values.
	 * @param d Driver name.
	 * @param u Unloaded weight.
	 * @param o Origin city.
	 * @param c Destination city.
	 */
	public Truck(String d, double u, String o, String c) {
		this.driver_name=d;
		this.unloaded_weight=u;
		this.origin_city=o;
		this.destination_city=c;
	}
	
	/**
	 * Load method.
	 * Throws notAllowedException if truck is not allowed.
	 * @param t Tracking number.
	 * @param w Weight.
	 * @param i Index number.
	 */
	public void load(int t, double w, int i) {
		try{
			if(t%10==0) 
				package_info[i]= new Letter(t,w);
			else if(t%10==1)
				package_info[i]= new Box(t,w);
			else if(t%10==2)
				package_info[i]= new WoodCrate(t,w);
			else if(t%10==3)
				package_info[i]= new MetalCrate(t,w);
			else
				throw new notAllowedException("The truck is not allowed to carry this package.");
		}
		catch(notAllowedException e) {
			System.out.println("Unknown package, invalid tracking number or weight");
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Gross method.
	 * @return gross The total income of truck.
	 */
	public double grossIncome() {
		double gross=0;
		int a=0;
		while(package_info[a].shipping_cost!=0) {
			gross+=package_info[a].shipping_cost;
			a++;
		}
		return gross;
	}

	/**
	 * weightAfterLoading method.
	 * @return totalwt The total weight of packages in pounds.
	 */
	public double weightAfterLoading() {
		double totalwt=unloaded_weight;
		double oz_to_lbs;
		int a=0;
		while(package_info[a].shipping_cost!=0) {
			if(package_info[a].weightType(package_info[a].tracking_number).equals("oz")) {
				oz_to_lbs=package_info[a].toPounds(package_info[a].weight);
				totalwt+=oz_to_lbs;
			}
			else
				totalwt+=package_info[a].weight;
			a++;
		}
		return totalwt;
	}

	/**
	 * toKilograms method.
	 * @param lbs Weight in lbs.
	 * @return 2.2*lbs The total of truck in pounds.
	 */
	public double toKilograms(double lbs) {
		return 2.2*lbs;
	}
	
	/**
	 * toPounds method.
	 * @param kg Weight in kgs.
	 * @return 0.45*kg The total of truck in kilos.
	 */
	public double toPounds(double kg) {
		return 0.45*kg;
	}

	/**
	 * Accessor method.
	 * @return driver_name The name of driver.
	 */
	public String getDriverName() {
		return this.driver_name;
	}
	
	/**
	 * Accessor method.
	 * @return origin_city The name of origin city.
	 */
	public String getOriginCity() {
		return this.origin_city;
	}

	/**
	 * Accessor method.
	 * @return destination_city The name of destination city.
	 */
	public String getDestinationCity() {
		return this.destination_city;
	}

	/**
	 * Accessor method.
	 * @return gross_weight The value of gross weight.
	 */
	public double getGrossWeight() {
		return this.gross_weight;
	}

	/**
	 * Accessor method.
	 * @return unloaded_weight The value of unloaded weight.
	 */
	public double getUnloadedWeight() {
		return this.unloaded_weight;
	}

	/**
	 * Accessor method.
	 * @return num_of_packages The number of packages.
	 */
	public int getNumOfPackages() {
		return this.num_of_packages;
	}

	/**
	 * Accessor method.
	 * @return package_info Array containing information of packages.
	 */
	public Package [] getPackageInfo() {
		return this.package_info;
	}

	/**
	 * Mutator method.
	 * To set the name of driver.
	 * @param d Driver name.
	 */
	public void setDriverName(String d) {
		this.driver_name=d;
	}

	/**
	 * Mutator method.
	 * To set the name of origin city.
	 * @param oc Origin city.
	 */
	public void setOriginCity(String oc) {
		this.origin_city=oc;
	}

	/**
	 * Mutator method.
	 * To set the name of destination city.
	 * @param dc destination city.
	 */
	public void setDestinationCity(String dc) {
		this.destination_city=dc;
	}

	/**
	 * Mutator method.
	 * To set the value of gross weight.
	 * @param g Gross weight.
	 */
	public void setGrossWeight(double g) {
		this.gross_weight=g;
	}

	/**
	 * Mutator method.
	 * To set the value of unloaded weight.
	 * @param c Unloaded weight.
	 */
	public void setUnloadedWeight(double c) {
		this.unloaded_weight=c;
	}

	/**
	 * Mutator method.
	 * To set the number of packages.
	 * @param n Number of packages.
	 */
	public void setNumOfPackages(int n) {
		this.num_of_packages=n;
	}
	
	/**
	 * Mutator method.
	 * To set array containing information of packages.
	 */
	public void setPackageInfo(Package [] p) {
		this.package_info=p;
	}


}
