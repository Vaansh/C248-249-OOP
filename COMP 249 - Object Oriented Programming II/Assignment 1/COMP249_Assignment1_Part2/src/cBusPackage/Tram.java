package cBusPackage;

public class Tram extends CityBus{
	private int max_spd;
	
	//default constructor
	public Tram() {
		super();
		max_spd=50;
	}
		
	//parameterized constructor
	public Tram(double p, int s, long r, int y, String l, String d, int m) {
		super(p, s, r, y, l, d);
		this.max_spd=m;
	}
		
	//copy constructor
	public Tram(Tram t) {
		super(t);
		this.max_spd=t.max_spd;
	}
	
	//accessor methods
	public int getMaxSpeed() {
		return max_spd;
	}
	
	//mutator methods
	public void setMaxSpeed(int y) {
		this.max_spd=y;
	}
	
	//toString() method
	public String toString() {
		return ("This Tram has " + getNumStops() + 
				" stops, and costs $" + 
				getTicketPrice() + 
				". Its maximum speed is " + 
				getMaxSpeed() +
				"km/h. This City Bus has a Route Number of " + 
				getRouteNumber() + 
				", and began operations in " + 
				getOpYear() + 
				". The name of the driver(s) is/are " + 
				getDriverNames() + 
				" and it operates on line number " +
				getLineName() + 
				".");
	}
		
	//equals() method
	public boolean equals(Tram t) {
		boolean b=false;
		if(t==null || this.getClass()!=t.getClass())
			b=false;
		if(this.ticket_price==t.ticket_price 
			&& this.num_stops==t.num_stops 
			&& this.route_number==t.route_number 
			&& this.begin_operation_year==t.begin_operation_year 
			&& this.max_spd==t.max_spd
			&& this.driver_names.equals(t.driver_names) 
			&& this.line_name.equals(t.line_name))
			{
				b=true;
			}
		return b;
	}
		
}
