// -----------------------------------------------------
// Assignment 01, Part I
// Written by: Vaansh Lakhwara 40114764
// For COMP 249 Section CC – Summer 2020
// -----------------------------------------------------
/**
 * Vaansh Lakhwara 40114764
 * COMP 249
 * Assignment 01, Part I
 * Due Date: July 12, 2020
 */

package cBusPackage;
import aCraftPackage.AirCraft;
import aCraftPackage.AirCraft.ClassType;
import aCraftPackage.AirCraft.MaintenanceType;
import fPackage.Ferry;
import pTransportPackage.PublicTransportation;
/**
 * There are four packages. 
 * This is the second package.
 * Contains: one child class, two multilevel 
 * inherited child classes and a driver class.
 * This is the driver class.
 */

public class driver {
	/**
	  * @param args the command line arguments
	  */
	public static void main(String[] args) {
		
		/**
		* @param transport_array Array that stores public transportation objects.
		*/
		PublicTransportation transport_array [] = new PublicTransportation[15];
		
		/**
		 * Creating objects to store in the arrays.
		 */
		PublicTransportation p1 = new PublicTransportation(70, 5);
		PublicTransportation p2 = new PublicTransportation(70, 5);
		PublicTransportation p3 = new PublicTransportation(35, 8);
		CityBus c1 = new CityBus(80, 3, 1101, 2008, "West San transit", "Samuel, Aziz and Ben");
		CityBus c2 = new CityBus(50, 4, 2101, 2010, "West San transit", "Jeff and Max");
		CityBus c3 = new CityBus(60, 2, 3101, 2010, "West San transit", "Dan and MinMin");
		Tram t1 = new Tram(50, 5, 2103, 2002, "East San transit", "Sam, Michael and Dennis", 120);
		Tram t2 = new Tram(65, 3, 2203, 2006, "East San transit", "	John and Dennis", 150);
		Metro m1 = new Metro(90, 6, 3141, 2012, "North San transit", "Sam, Michael and Dennis", 13, "Vancouver");
		Metro m2 = new Metro(100, 4, 3242, 2012, "North San transit", "Sam, Michael and Dennis", 13, "Vancouver");
		Metro m3 = new Metro(105, 5, 3343, 2012, "North San transit", "Sam, Michael and Dennis", 13, "Vancouver");
		Ferry f1 = new Ferry(110, 1, 1997, "Carnival");Ferry f2 = new Ferry(200, 2, 2007, "Royal Carribean");
		AirCraft a1 = new AirCraft(300, 2, ClassType.HELICOPTER, MaintenanceType.MONTHLY);
		AirCraft a2 = new AirCraft(500, 1, ClassType.AIRLINE, MaintenanceType.WEEKLY);
		
		/**
		 * Storing objects in the arrays.
		 */
		transport_array[0]=p1;
		transport_array[1]=p2;
		transport_array[2]=p3;
		transport_array[3]=c1;
		transport_array[4]=c2;
		transport_array[5]=c3;
		transport_array[6]=t1;
		transport_array[7]=t2;
		transport_array[8]=m1;
		transport_array[9]=m2;
		transport_array[10]=m3;
		transport_array[11]=f1;
		transport_array[12]=f2;
		transport_array[13]=a1;
		transport_array[14]=a2;
		
		/**
		 * Testing toString() function.
		 */
		System.out.println(p1.toString());
		System.out.println(c1.toString());
		System.out.println(t1.toString());
		System.out.println(m1.toString());
		System.out.println(f1.toString());
		System.out.println(a1.toString());
		System.out.println();
		
		/**
		 * Testing equals() function where boolean value is true. 
		 * Implemented using if-else statement. 
		 */
		if(p1.equals(p2))
			System.out.println("The two public transportations compared are the same.");
		else
			System.out.println("The two public transportations compared are different.");
		System.out.println();
		
		/**
		 * Testing equals() function where boolean value is false. 
		 * Implemented using if-else statement. 
		 */
		if(c1.equals(c2))
			System.out.println("The two city buses compared are the same.");
		else
			System.out.println("The two city buses compared are different.");
		System.out.println();
		
		/**
		 * Loop that traces array using a for loop. 
		 * Finds the least and most expensive values. 
		 */
		int most_expensive_index=0, least_expensive_index=0;
		double most_expensive=transport_array[0].getTicketPrice(), least_expensive=transport_array[0].getTicketPrice();
		
		for(int i=0; i<transport_array.length;i++) { 
			if(transport_array[i].getTicketPrice()>most_expensive) {
				most_expensive=transport_array[i].getTicketPrice();
				most_expensive_index=i;
			}
			if(transport_array[i].getTicketPrice()<least_expensive) {
				least_expensive=transport_array[i].getTicketPrice();
				least_expensive_index=i;
			}
		}
		
		/**
		 * Print details of least and most expensive options.
		 */ 
		System.out.println("This is the most expensive public transportation option available. " + transport_array[most_expensive_index].toString());
		System.out.println("This is the least expensive public transportation option available. " + transport_array[least_expensive_index].toString());
		System.out.println();
		
		/**
		 * Print statement indicating end of program. 
		 */
		System.out.print("The Program has ended. Thank you!");
	}
}
