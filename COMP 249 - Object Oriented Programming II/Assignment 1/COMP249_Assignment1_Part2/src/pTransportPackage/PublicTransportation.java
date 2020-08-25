package pTransportPackage;

public class PublicTransportation {
	protected double ticket_price;
	protected int num_stops;
	
	//default constructor
	public PublicTransportation() {
		ticket_price=0;
		num_stops=0;
	}
	
	//parameterized constructor
	public PublicTransportation(double t, int s) {
		this.ticket_price=t;
		this.num_stops=s;
	}
	
	//copy constructor
	public PublicTransportation(PublicTransportation p) {
		this.ticket_price=p.ticket_price;
		this.num_stops=p.num_stops;
	}
	
	//accessor methods
	public double getTicketPrice() {
		return ticket_price;
	}
	
	public int getNumStops() {
		return num_stops;
	}
	
	//mutator methods
	public void setTicketPrice(double t) {
		this.ticket_price=t;
	}
	
	public void setNumStops(int n) {
		this.num_stops=n;
	}
	
	//toString() method
	public String toString() {
		return ("This Public Transportation has " +
				getNumStops() +
				" stops, and costs $" + 
				getTicketPrice() + 
				".");
	}
	
	//equals() method
	public boolean equals(PublicTransportation p) {
		boolean b=false;
		if(p==null || this.getClass()!=p.getClass())
			b=false;
		if(this.ticket_price==p.ticket_price 
			&& this.num_stops==p.num_stops)
			{
				b=true;
			}
		return b;
	}
}

