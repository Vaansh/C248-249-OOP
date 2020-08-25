// -----------------------------------------------------
// Assignment 03, Part II
// Written by: Vaansh Lakhwara 40114764
// For COMP 249 Section CC – Summer 2020
// -----------------------------------------------------
/**
 * @author Vaansh Lakhwara 40114764
 * COMP 249
 * Assignment 03, Part II
 * Due Date: August 16, 2020
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CellListUtilization 
{
	/**
	 * Main method making this the driver class.
	 * @param args
	 */
	public static void main(String[] args) 
	{
		//declaring scanner
		Scanner scan=null;
		Scanner keyIn = new Scanner(System.in);
				
		String fileName="Cell_Info.txt";				
		CellList list = new CellList();
		
		try 
		{			
			scan = new Scanner(new FileInputStream("/Users/vaanshlakhwara/Desktop/required files/" + fileName));
			System.out.println("Opening " + fileName + "... \n");

			int entry = 1;
			while(scan.hasNextLine())
			{				
				long tempLong = scan.nextLong();				
				String tempString = scan.next();		
				double tempDouble = scan.nextDouble();	
				int tempInt = scan.nextInt();							

				CellPhone phone = new CellPhone(tempLong, tempString, tempInt, tempDouble);

				if(list.contains(phone.getSerialNum()))
				{
					System.out.println("ERROR: List already has a duplicate phone object at entry #" + entry + ". Continuing to next...");
					entry++;
				}
				else
				{
					list.addToStart(phone);
					entry++;
				}
			}
			
			System.out.println("\nValues have been initialized!");
			list.showContents();
			
			String yes;
			
			//testing find functionality
			System.out.print("\nWould you like to use the \"find\" functionality? (\"Y\" or \"Yes\" for yes, anything else for no.): ");
			yes=keyIn.next();
			if(yes.equalsIgnoreCase("y") || yes.equalsIgnoreCase("yes"))
			{
				long sno1, sno2, sno3;			
				System.out.println("\nEnter three distinct serial numbers to search for in the list:"); 
				System.out.print("	Serial Number 1: ");
				sno1=keyIn.nextLong();
				System.out.print("	Serial Number 2: ");
				sno2=keyIn.nextLong();
				System.out.print("	Serial Number 3: ");
				sno3=keyIn.nextLong();

				System.out.println("Result:");
				if(sno1==sno2 || sno2==sno3 || sno1==sno3)
				{
					System.out.println("Distinct values not entered. Program has ended. Thank you!");
					System.exit(0);				
				}

				if(list.find(sno1)==null)
				{
					System.out.println("Serial number " + sno1 + " not found.");
				}
				else
				{
					System.out.println("Serial number " + sno1 + " found after " + list.iteration + " iterations.");
				}						

				if(list.find(sno2)==null)
				{
					System.out.println("Serial number " + sno2 + " not found.");
				}
				else
				{
					System.out.println("Serial number " + sno2 + " found after " + list.iteration + " iterations.");
				}

				if(list.find(sno3)==null)
				{
					System.out.println("Serial number " + sno3 + " not found.");
				}
				else
				{
					System.out.println("Serial number " + sno3 + " found after " + list.iteration + " iterations.");
				}
				System.out.println("The \"find()\" method of CellList class has been tested!");
			}
			
			//test constructors and methods for CellPhone class
			System.out.print("\nWould you like to test each of the constructors and methods for CellPhone class? (\"Y\" or \"Yes\" for yes, anything else for no.): ");
			yes=keyIn.next();
			if(yes.equalsIgnoreCase("y") || yes.equalsIgnoreCase("yes"))
			{
				System.out.println("\nUsing default constructor for CellPhone...");
				CellPhone cell1 = new CellPhone();
				System.out.println(cell1.toString());
				System.out.println("The toString() method and the default constructor have been tested!");

				System.out.println("\nUsing parameterized constructor for CellPhone...");
				CellPhone cell2 = new CellPhone(1, "B", 2000, 99.99);
				System.out.println(cell2.toString());
				System.out.println("The parameterized constructor have been tested!");

				System.out.println("\nUsing copy constructor for CellPhone...");
				CellPhone cell3 = new CellPhone(cell1, 2);
				System.out.println(cell3.toString());
				System.out.println("The copy constructor have been tested!");

				System.out.println("\nTesting clone() method of CellPhone class...");
				CellPhone cloneOfCell2 = cell2.clone(3);
				System.out.println(cloneOfCell2.toString());
				System.out.println("The clone() method has been tested!");

				System.out.println("\nTesting equals() method of CellPhone class...");
				boolean test;
				test = cell1.equals(cell3);
				if(test)
				{
					System.out.println("cell1 is: " + cell1.toString());
					System.out.println("cell3 is: " + cell3.toString());
					System.out.println(test);
					System.out.println("Cell1 and Cell3 are equal, equals() method for true condition has been tested\n");
				}

				test=cell2.equals(cell3);
				if(!test)
				{
					System.out.println("cell2 is: " + cell2.toString());
					System.out.println("cell3 is: " + cell3.toString());
					System.out.println(test);
					System.out.println("Cell2 and Cell3 are not equal, equals() method for false condition has been tested\n");
				}
				System.out.println("The equals() method has been tested for both true and false conditions!");
				
				System.out.println("\nTesting mutator and accessor methods of CellPhone class...");
				System.out.println("Serial number of cell2 is: " + cell2.getSerialNum() );
				System.out.println("Changing serial number of cell2 to 4");
				cell2.setSerialNum(4);
				System.out.println("Serial number of cell2 is: " +  cell2.getSerialNum() + "\n");
				
				System.out.println("Brand of cell2 is: " + cell2.getBrand() );
				System.out.println("Changing brand of cell2 to C");
				cell2.setBrand("C");
				System.out.println("Brand of cell2 is: " +  cell2.getBrand() + "\n");
				
				System.out.println("Year of cell2 is: " + cell2.getYear());
				System.out.println("Changing year of cell2 to 2020");
				cell2.setYear(2020);
				System.out.println("Year of cell2 is: " + cell2.getYear() + "\n");
				
				System.out.println("Price of cell2 is: " + cell2.getPrice() );
				System.out.println("Changing price of cell2 to 100.10");
				cell2.setPrice(100.10);
				System.out.println("Price of cell2 is: " + cell2.getPrice() );
				
				System.out.println("The mutator and accessor methods have been tested!");
			}
			
			//test constructors and methods for CellList class
			System.out.print("\nWould you like to test each of the constructors and methods for CellList class? (\"Y\" or \"Yes\" for yes, anything else for no.): ");
			yes=keyIn.next();
			if(yes.equalsIgnoreCase("y") || yes.equalsIgnoreCase("yes"))
			{
				System.out.println("\nUsing default constructor for CellList...");
				CellList list1 = new CellList(); 
				list1.showContents();
				System.out.println("showContents() method and the default constructor have been tested!");

				System.out.println("\nUsing copy constructor for CellList...");
				CellList list2 = new CellList(list); 
				list2.showContents();
				System.out.println("The copy constructor has been tested!");
				
				System.out.println("\nTesting addToStart() method of CellList class...");
				System.out.println("Creating cellTest1 CellPhone to test addToStart() method...");
				CellPhone cellTest1 = new CellPhone(6, "D", 1969, 420.69);				
				list2.addToStart(cellTest1);
				list2.showContents();
				System.out.println("The addToStart() method has been tested!");
				
				System.out.println("\nTesting insertAtIndex() method of CellList class...");
				System.out.println("Creating cellTest2 CellPhone to test insertAtIndex() method...");
				CellPhone cellTest2 = new CellPhone(8, "E", 2012, 40.69);				
				System.out.println("Program will crash, testing to insert at negative index number...");
				list2.insertAtIndex(cellTest2, -1);
				list2.insertAtIndex(cellTest2, 2);
				list2.showContents();
				System.out.println("The insertAtIndex() method has been tested!");
				
				System.out.println("\nTesting deleteFromIndex() method of CellList class...");							
				list2.deleteFromIndex(2);
				list2.showContents();
				System.out.println("The deleteFromIndex() method has been tested!");
				
				System.out.println("\nTesting deleteFromStart() method of CellList class...");							
				list2.deleteFromStart();
				list2.showContents();
				System.out.println("The deleteFromStart() method has been tested!");
				
				System.out.println("\nTesting replaceAtIndex() method of CellList class...");				
				System.out.println("Creating cellTest3 CellPhone to test addToStart() method...");				
				CellPhone cellTest3 = new CellPhone(10, "F", 2002, 420.00);
				System.out.println("Testing special case where index is <0...");
				list2.replaceAtIndex(cellTest3, -5);
				System.out.println("Testing normal case where index is 2...");
				list2.replaceAtIndex(cellTest3, 2);
				list2.showContents();
				System.out.println("The replaceAtIndex() method has been tested!");
				
				System.out.println("\nTesting contains() method of CellList class...");							
				System.out.println("For true condition...");
				if(list2.contains(10))
				{
					System.out.println(Boolean.valueOf(list2.contains(10)));
					System.out.println("The contains() method has been tested for true condition.");
				}
				System.out.println("For false condition...");
				if(!list2.contains(-5))
				{
					System.out.println(Boolean.valueOf(list2.contains(-5)));
					System.out.println("The contains() method has been tested for false condition.");
				}				
				System.out.println("The contains() method has been tested both true and false conditions!");
				
				System.out.println("\nTesting equals() method of CellList class...");							
				System.out.println("Creating two empty lists to test equals() method...");
				CellList listTest1 = new CellList();
				CellList listTest2 = new CellList();
				System.out.println("For true condition...");
				if(listTest1.equals(listTest2))
				{
					System.out.println(Boolean.valueOf(listTest1.equals(listTest2)));
					System.out.println("The equals() method has been tested for true condition.");
				}
				System.out.println("For false condition...");
				if(!listTest1.equals(list2))
				{
					System.out.println(Boolean.valueOf(listTest1.equals(list2)));
					System.out.println("The equals() method has been tested for false condition.");
				}
				System.out.println("The equals() method has been tested for both true and false condition!");						
			}
			
			System.out.println("\n===THE PROGRAM HAS ENDED, THANK YOU!===");
			scan.close();
			keyIn.close();
			System.exit(0);
		} catch (FileNotFoundException e) 
		{		
			System.out.println(e.getMessage());
			System.out.println("File not found, restart the application to continue.");	//does not happen in this case, since file exists.
			System.exit(0);
		}		
	}
}
