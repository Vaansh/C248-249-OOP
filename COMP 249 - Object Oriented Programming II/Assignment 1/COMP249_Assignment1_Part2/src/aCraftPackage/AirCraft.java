package aCraftPackage;
import pTransportPackage.PublicTransportation;


public class AirCraft extends PublicTransportation{
	private enum ClassType {HELICOPTER, AIRLINE, GLIDER, BALLOON};
	private enum MaintenanceType {WEEKLY, MONTHLY, YEARLY};
	private ClassType [] class_type = ClassType.values();
	private MaintenanceType [] maintenance_type = MaintenanceType.values();
	private ClassType c_type;
	private MaintenanceType m_type;
	
	//default constructor
	public AirCraft() {
		super();
		c_type=ClassType.HELICOPTER;
		m_type=MaintenanceType.YEARLY;
	}
				
	//parameterized constructor
	public AirCraft(double t, int s, ClassType c, MaintenanceType m) {
		super(t,s);
		this.c_type=c;
		this.m_type=m;
		
	}
				
	//copy constructor
	public AirCraft(AirCraft a) {
		super(a);
		this.c_type=a.c_type;
		this.m_type=a.m_type;
	}
	
	//accessor methods
	public ClassType getClassType() {
		return c_type;
	}
	
	public MaintenanceType getMaintenanceType() {
		return m_type;
	}
	
	//mutator methods
	public void setClassType(ClassType c) {
		this.c_type=c;
	}
	
	public void setMaintenanceType(MaintenanceType m) {
		this.m_type=m;
	}
	
	//toString() method
	public String toString() {
		return ("This Ferry has " +
				getNumStops() +
				" stops, and costs $" + 
				getTicketPrice() + 
				". The class type is " +
				getClassType() +
				" and the maintenance type is " +
				getMaintenanceType() +
				".");
	}
			
	//equals() method
	public boolean equals(AirCraft a) {
		boolean b=false;
		if(a==null || this.getClass()!=a.getClass())
			b=false;
		else if(this.ticket_price==a.ticket_price 
				&& this.num_stops==a.num_stops
				&& this.getClassType().equals(a.getClassType())
				&& this.getMaintenanceType().equals(a.getMaintenanceType()))
				{
					b=true;
				}
		return b;
	}
	
}
