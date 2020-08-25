package cBusPackage;

public class Metro extends CityBus{
	private int num_vehicles;
	private String city;
	
	//default constructor
	public Metro() {
		super();
		num_vehicles=0;
		city=null;
	}
			
	//parameterized constructor
	public Metro(double p, int s, long r, int y, String l, String d, int n, String c) {
		super(p, s, r, y, l, d);
		this.num_vehicles=n;
		this.city=c;
	}
			
	//copy constructor
	public Metro(Metro m) {
		super(m);
		this.num_vehicles=m.num_vehicles;
		this.city=m.city;
	}
	
	//accessor methods
	public int getNumVehicles() {
		return num_vehicles;
	}
	
	public String getCity() {
		return city;
	}
	
	//mutator methods
	public void setNumVehicles(int n) {
		this.num_vehicles=n;
	}
	
	public void setCity(String c) {
		this.city=c;
	}
	
	//toString() method
	public String toString() {
		return ("This Metro has " + getNumStops() + 
				" stops, and costs $" + 
				getTicketPrice() + 
				". There are " + 
				getNumVehicles() + 
				" number of vehicles. This City Bus has a Route Number of " + 
				getRouteNumber() + 
				", and began operations in " + 
				getOpYear() + 
				". The name of the driver(s) is/are " + 
				getDriverNames() + 
				" and it operates on line number " +
				getLineName() + 
				" in the city " + 
				getCity() + 
				".");
	}
		
	//equals() method
	public boolean equals(Metro m) {
		boolean b=false;
		if(m==null || this.getClass()!=m.getClass())
			b=false;
		if(this.ticket_price==m.ticket_price 
			&& this.num_stops==m.num_stops 
			&& this.route_number==m.route_number 
			&& this.begin_operation_year==m.begin_operation_year
			&& this.num_vehicles==m.num_vehicles
			&& this.driver_names.equals(m.driver_names) 
			&& this.line_name.equals(m.line_name)			
			&& this.city.equals(m.city))
			{
				b=true;
			}
		return b;
	}	
}
