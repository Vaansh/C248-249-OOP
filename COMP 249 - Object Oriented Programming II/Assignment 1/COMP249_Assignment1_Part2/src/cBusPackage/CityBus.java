package cBusPackage;
import pTransportPackage.PublicTransportation;

public class CityBus extends PublicTransportation{
	protected long route_number;
	protected int begin_operation_year;
	protected String line_name, driver_names;
	
	//default constructor
	protected CityBus() {
		super();
		route_number=0;
		begin_operation_year=2020;
		line_name=null;
		driver_names=null;
	}
	
	//parameterized constructor
	protected CityBus(double p, int s, long r, int y, String l, String d) {
		super(p,s);
		this.route_number=r;
		this.begin_operation_year=y;
		this.line_name=l;
		this.driver_names=d;
	}
	
	//copy constructor
	protected CityBus(CityBus c) {
		super(c);
		this.route_number=c.route_number;
		this.begin_operation_year=c.begin_operation_year;
		this.line_name=c.line_name;
		this.driver_names=c.driver_names;
	}
	
	//accessor methods
	protected long getRouteNumber() {
		return route_number;
	}
	
	protected int getOpYear() {
		return begin_operation_year;
	}
	
	protected String getLineName() {
		return line_name;
	} 
	
	protected String getDriverNames() {
		return driver_names;
	} 
	
	//mutator methods
	protected void setRouteNumber(long r) {
		this.route_number=r;
	}
	
	protected void setOpYear(int y) {
		this.begin_operation_year=y;
	}
	
	protected void setLineName(String l) {
		this.line_name=l;
	}
	
	protected void setDriverNames(String d) {
		this.driver_names=d;
	}
	
	//toString() method
	public String toString() {
		return ("This City Bus has " + getNumStops() + 
				" stops, and costs $" + 
				getTicketPrice() + 
				". It has a Route Number of " +  
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
	protected boolean equals(CityBus c) {
		boolean b=false;
		if(c==null || this.getClass()!=c.getClass())
			b=false;
		if(this.ticket_price==c.ticket_price 
			&& this.num_stops==c.num_stops 
			&& this.route_number==c.route_number 
			&& this.begin_operation_year==c.begin_operation_year 
			&& this.driver_names.equals(c.driver_names) 
			&& this.line_name.equals(c.line_name))
			{
				b=true;
			}
		return b;
	}		
}
