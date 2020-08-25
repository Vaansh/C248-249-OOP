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

import java.util.Scanner;

public class CargoTest {
	
	/**
	 * Main method.
	 * Makes this class the driver class.
	 * @param args 
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		String d, c, o;
		double u;
		int t = 0;
		int length;
		String type = null;
		double w = 0;
		int i=0, y=-1;
		int l=0, tr=0;
		double gross=0, net_weight=0;

		/**
		 * Creating new truck.
		 * Initialising scanner.
		 */
		Truck truck = new Truck();
		Scanner keyIn = new Scanner(System.in);

		while(i!=-1) {
			System.out.println("What would you like to do?\n" + 
					"	1. Start a cargo\n" + 
					"		a. Driver name\n" + 
					"		b. Unload weight(kg; lb)\n" + 
					"		c. Originating city\n" + 
					"		d. Destination city\n" + 
					"	2. Load the truck with packages\n" + 
					"		a. Package tracking number\n" + 
					"		b. Package weight(oz; lb)\n" + 
					"		c. Package shipping cost\n" + 
					"	3. Unload a package\n" + 
					"	4. The number of packages loaded\n" + 
					"	5. The gross income earned by shipping of the cargo\n" + 
					"	6. Weight the truck(after it has been completely loaded)\n" + 
					"	7. Drive the truck to destination\n" + 
					"	0. To quit\n" + 
					"Please enter your choice and press <Enter>:");

		
			
			int n = keyIn.nextInt();
			switch(n) {
			/**
			 * Case 1.
			 * Starts a cargo.
			 */
			case 1:
				System.out.println("a. Enter driver's name:");
				d=keyIn.next();
				System.out.println("b. Enter unloaded weight(lb):");
				u=keyIn.nextDouble();
				System.out.println("c. Enter originating city:");
				o=keyIn.next();
				System.out.println("d. Enter destination city:");
				c=keyIn.next();
				System.out.println();
				truck = new Truck(d, u, o, c);
				System.out.println();
				
				break;
				
				

			/**
			 * Case 2.
			 * Load the truck with packages.
			 */	
			case 2: //check if same track num
				try{
					double oz_to_lbs=0;
					System.out.println("Enter package tracking number:");
					t=keyIn.nextInt();
					System.out.println("Enter package weight:");
					w=keyIn.nextDouble();													
										
					length=t%10;
					if(length==0)
						type="Letter";
					else if(length==1)
						type="Box";
					else if(length==2)
						type="Wooden Crate";
					else if(length==3)
						type="Metal Crate";
					
					if(t%10!=0 && t%10!=1 && t%10!=2 && t%10!=3) {
						throw new notAllowedException("The truck is not allowed to carry this package.");
					}
					else if(i>=5) {
						throw new overException("Truck is full.");
					}
					else {
						truck.load(t,w,i);
						i++;
						y++;
					}
					
					System.out.println("Package shipping cost: " + truck.package_info[i-1].calcShipCost(truck.package_info[i-1].getWeight()));
					gross+=truck.package_info[i-1].shipping_cost;

					if(truck.package_info[i-1].weightType(truck.package_info[i-1].tracking_number).equals("oz")) {
						oz_to_lbs=truck.package_info[i-1].toPounds(truck.package_info[i-1].weight);
						net_weight+=oz_to_lbs;
					}
					else
						net_weight+=truck.package_info[i-1].weight;
									
				}
				catch(notAllowedException e) {
					System.out.println("Unknown package, invalid tracking number or weight");
					System.out.println(e.getMessage()); //check src for getmsg 
				}
				catch(overException e) {
					for(int z=0;z<5;z++) {
						System.out.println(("Package type: " + truck.package_info[z].packageType(truck.package_info[z].tracking_number) 
								+ ", Tracking number: " + truck.package_info[z].tracking_number
								+ ", Weight: " + truck.package_info[z].weight));
						}
					System.out.println(e.getMessage());
				}
				finally {
					System.out.println();
				}
				break;
				
			/**
			* Case 3.
			* Unload a package.
			*/
			case 3:
				System.out.println("Enter the tracking number of the package to be unloaded: ");
				int track=keyIn.nextInt();
				for(int q=0; q<=200;q++) {
					if(truck.package_info[q]==null) {
						System.out.println("Package not found.");
						break;
					}

					Package [] pack_temp = new Package[y+1];
					int count=0;
					for(;l<=y;l++) {
						if(truck.package_info[l].tracking_number==track) {
							i--;
							net_weight-=truck.package_info[l].weight;	
							gross-=truck.package_info[l].shipping_cost;	
							System.out.println("The tracking number of the unloaded package is "
									+ truck.package_info[l].tracking_number + " and it weighs "
									+ truck.package_info[l].weight +". It costs "
									+ truck.package_info[l].shipping_cost + ".");
							continue;
						}
						pack_temp[count++]=truck.package_info[l];
						for(int r=0;r<count;r++)
							truck.package_info[r]=pack_temp[r];
						System.out.println();						
					}
					break;
				}
				break;
			
			/** Case 4.
			* The number of packages loaded.
			*/	
			case 4:
				System.out.println("The number of packages loaded are " + i);
				System.out.println();
				
				break;

			/** Case 5.
			* The gross income earned by shipping of the cargo.
			*/	
			case 5: 
				System.out.println("The gross income earned by shipping of the cargo is " + gross);
				System.out.println();
				break;

			/** Case 6.
			* Weight the truck(after it has been completely loaded).
			*/	
			case 6:
				System.out.println("Weight the truck(after it has been completely loaded) is " + net_weight);
				System.out.println();
				break;
				
			/** Case 7.
			* Drive the truck to destination.
			*/
			case 7: 
				System.out.println("Drive the truck to destination: from " + truck.getOriginCity() + " to " 
						+ truck.getDestinationCity());

				for(int b=0; b<=100; b+=25) 
					System.out.println("Progress: " + b + "%");
				System.out.println("Reached " + truck.getDestinationCity());

				for(int m=0; m<=100; m+=25)
					System.out.println("Processing: " + m + "%");
				System.out.println("Processed");
				
				for(int q1=0;q1<200;q1++)
					truck.package_info[q1]=null;
					
				System.out.println();
				break;

			/** Case 0.
			* Quit the program.
			*/
			case 0:
				System.out.println("Thank you. The program has ended.");
				System.exit(0);
				break;
				
				/**
				 //Commented out; extra - in case >200
				
				Package [] package_over = new Package[200];
				
				Truck overTruck = new Truck("ABC", 200, "Montreal", "Ottawa");

				for(int s=0; s<=200; s++) {
					Random rand = new Random();
					int randomTrack=(rand.nextInt((999 - 100) + 1) + 100)*10;
					double randomWeight=(double)(rand.nextInt(15 - 1) + 1);
					overTruck.load(randomTrack, randomWeight, s);
				}
				
				
				int t1;
				double w1;
				int i1=0;
				try{
					double oztolbs=0;
					System.out.println("Enter package tracking number:");
					t1=keyIn.nextInt();
					System.out.println("Enter package weight:");
					w1=keyIn.nextDouble();		
					if(t1%10!=0 && t1%10!=1 && t1%10!=2 && t1%10!=3) {
						throw new notAllowedException("The truck is not allowed to carry this package.");
					}
					else {
						truck.load(t1,w1,i1);
						i++;
					}
					if(i>=200)
						throw new overException("Truck is full.");

				}
				catch(notAllowedException e) {
					System.out.println("Unknown package, invalid tracking number or weight");
					System.out.println(e.getMessage()); //check src for getmsg 
				}
				catch(overException e) {
					System.out.println("The truck is full.");
					for(int z=0;z<=200;z++)
						System.out.println(("The tracking number of the unloaded package is "
								+ truck.package_info[l].tracking_number + " and it weighs "
								+ truck.package_info[l].weight +". It costs "
								+ truck.package_info[l].shipping_cost + "."));
						System.out.println(e.getMessage());
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
				 */
			}
		}
		/**
		 * close scanner.
		 */
		keyIn.close();
	}
}
