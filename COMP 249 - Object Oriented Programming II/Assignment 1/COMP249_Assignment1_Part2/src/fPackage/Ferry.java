package fPackage;
import pTransportPackage.PublicTransportation;

public class Ferry extends PublicTransportation{
	private int build_year;
	private String ship_name;
	
	//default constructor
	public Ferry() {
		super();
		build_year=2020;
		ship_name=null;
	}
				
	//parameterized constructor
	public Ferry(double t, int s, int b, String n) {
		super(t,s);
		this.build_year=b;
		this.ship_name=n;
	}
				
	//copy constructor
	public Ferry(Ferry f) {
		super(f);
		this.build_year=f.build_year;
		this.ship_name=f.ship_name;
	}
	
	//accessor methods
	public int getBuildYear() {
		return build_year;
	}
	
	public String getShipName() {
		return ship_name;
	}
	
	//mutator methods
	public void setBuildYear(int b) {
		this.build_year=b;
	}
	
	public void setShipName(String n) {
		this.ship_name=n;
	}
	
	//toString() method
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
		
	//equals() method
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
