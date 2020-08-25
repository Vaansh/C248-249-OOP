// -----------------------------------------------------
// Assignment 02, Part II
// Written by: Vaansh Lakhwara 40114764
// For COMP 249 Section CC – Summer 2020
// -----------------------------------------------------
/**
 * Vaansh Lakhwara 40114764
 * COMP 249
 * Assignment 02, Part II
 * Due Date: July 26, 2020
 */

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class CargoshipInventory1 {
	/** Using different access rights. 
	* @param wsArr Array storing information about cargo ships.
	* @param sno The serial number.
	* @param n The name of cargo ship.
	* @param c The year of creation.
	* @param o The name of owner's country.
	* @param p The price of cargo ship.
	* @param s The speed of cargo ship.
	*/
	
	static Cargoship[] wsArr;
	private static long sno=0;
	private static String n="";
	private static int c=0;
	private static String o="";
	private static double p=0;
	private static int s=0;
	private static Scanner scanning;

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		/**
		 * Attributes.
		 * @param file_name Name of file.
		 * @param scan Name of object of Scanner created. 
		 */
		String file_name;
		Scanner scan = new Scanner(System.in);

		System.out.print("Please enter the name of the output file,"
				+ " which will have correct information: ");
		file_name=scan.next();		
		
		/**
		 * @param fileObject Name of object of File created.
		 */		
		File fileObject = new File("/Users/vaanshlakhwara/Desktop/Summer 2 2020/COMP 249/" + file_name);
		while (fileObject.exists()) {
			System.out.println("Error: There is an existing file called: "
					+ file_name + ". \n That file already has a size of "
					+ fileObject.length() + " bytes. \n");

			System.out.print("Please enter another file name to create: ");
			file_name=scan.next();
			fileObject = new File("/Users/vaanshlakhwara/Desktop/Summer 2 2020/COMP 249/" + file_name);
		}	
		
		/**
		 * @param f Name of object of FileWriter created.
		 */		
		FileWriter f =new FileWriter(fileObject);

		System.out.println();
		System.out.println("Attempting to open file: " + file_name);
		
		/**
		 * @param fileIn Name of object of Scanner created.
		 * @param arrLen Name of object of Scanner created.
		 */		
		Scanner fileIn = null;
		Scanner arrLen = null;
		try {
			fileIn = new Scanner(new FileReader("/Users/vaanshlakhwara/Desktop/Summer 2 2020/COMP 249/Initial_Cargoship_Info.txt"));
			arrLen = new Scanner(new FileReader("/Users/vaanshlakhwara/Desktop/Summer 2 2020/COMP 249/Initial_Cargoship_Info.txt"));
			
			/**
			 * @param count Length of arrLen Scanner.
			 * @param wsArr Array storing information about cargo ships.
			 */
			int count=count(arrLen);
			wsArr=new Cargoship[count];			
			System.out.println();
			System.out.println("Detecting number of records in file: Initial_Warship_Info.txt");
			System.out.println();
			System.out.println("The file has " + count + " Records");			
			
			/**
			 * Calling fixInventory() method.
			 * @param fileIn Name of object of Scanner created.
			 * @param f Name of object of FileWriter created.
			 * @param file_name Name of file.
			 */			
			CargoshipInventory1.fixInventory(fileIn, f, file_name);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static int count(Scanner arr){
		/**
		 * Private static method to count length of array created.
		 * @param arr Array input.
		 * @return count Length of array input.
		 */
		
		/**
		 * @param count Length of array input.
		 */
		int count=0;
		while (arr.hasNextLine()) {
			count++;
			arr.nextLine();
		}
		return count;
	}
	
	public static void fixInventory(Scanner fileIn, FileWriter f, String file) throws DuplicateSerialNumberException, IOException {
		/**
		 * @param fileIn Name of object of Scanner created.
		 * @param f Name of object of FileWriter created.
		 * @param file Name of file.
		 * @throws DuplicateSerialNumberException
		 * @throws IOException
		 */
		
		/**
		 * @param updatedArr Updated array.
		 * @param u Integer used to insert values at indices. 
		 * @param wsArr Array storing information about cargo ships.
		 * @param sno The serial number.
		 * @param n The name of cargo ship.
		 * @param c The year of creation.
		 * @param o The name of owner's country.
		 * @param p The price of cargo ship.
		 * @param s The speed of cargo ship.
		 */
		Cargoship[] updatedArr = new Cargoship[wsArr.length];
		int u=0; 
		long s_correct; 
		scanning = new Scanner(System.in);
		while (fileIn.hasNext()==true) {
			sno=fileIn.nextLong();
			n=fileIn.next();				
			c=fileIn.nextInt();
			o=fileIn.next();
			p=fileIn.nextDouble();
			s=fileIn.nextInt();
			wsArr[u]= new Cargoship(sno, n, c, o, p, s);
			++u;
		}
		
		/**
		 * @param m Integer used for manipulating array values.
		 * @param n Integer used for manipulating array values.
		 * @param i Integer used for manipulating array values.
		 * @param a Integer used for manipulating array values.
		 * @param s_correct Setting serial number.
		 */		
		int m=0, n=0;
		
		/**
		 * Copying arrays. 
		 */
		for(int i=0; i<wsArr.length;i++)
			updatedArr[i]=new Cargoship(wsArr[i]);
		
		for(int i=0;i<wsArr.length;i++) {
			for(int a=0;a<wsArr.length;a++) {
				if(updatedArr[i].getSerialNumber()==wsArr[a].getSerialNumber() && (i!=a)) {
					System.out.print("Duplicate serial number "
							+ updatedArr[i].getSerialNumber() + " detected in # " 
							+ i + ". Please enter the correct serial number: ");
					s_correct = scanning.nextLong();
					updatedArr[i].setSerialNumber(s_correct);
					for(;m<updatedArr.length;m++)
						if(updatedArr[i].getSerialNumber()==updatedArr[m].getSerialNumber() && i!=m) {							
							n++;							
						}
					m=0;
					if(n>0) {
						System.out.println("Error... Duplicate Entry of Serial Number."
								+ " The entered serial number exists for another record.");
						n=0;
					}						
					updatedArr[i].setSerialNumber(s_correct);
					updatedArr[i].setCreationYear(wsArr[i].getcreationyear());
					updatedArr[i].setName(wsArr[i].getName());
					updatedArr[i].setOwnerCountry(wsArr[i].getOwnerCountry());
					updatedArr[i].setPrice(wsArr[i].getPrice());
					updatedArr[i].setSpeed(wsArr[i].getSpeed());
					a=-1;
				}
			}
		}
		
		/**
		 * If length lower than 2.
		 * Exit.
		 */		
		if(wsArr.length < 2){
			System.out.println("No fixing needed"
					+ ". Thank you for using the program.");
			System.exit(0);
		}
		
		/**
		 * Printing Header and original file.
		 * @param i Integer used to specify index while printing. 
		 */		
		System.out.println();
		System.out.println("Here are the contents of file Initial_Warship_Info.txt AFTER copying operation: ");
		System.out.println("==============================================================================");
		for(int i=0; i<wsArr.length; i++) {
			System.out.println(wsArr[i].toString(wsArr[i]));
		}
		
		/**
		 * Updating values
		 */	
		for(int i=0; i<updatedArr.length;i++) {
			f.write(updatedArr[i].toString(updatedArr[i])+"\n");
		}
		f.flush();
		
		/**
		 * Printing Header and new file.
		 * @param file Name of file created. 
		 */		
		System.out.println();
		System.out.println("Here are the contents of file " + file + ":");
		System.out.println("==============================================================================");
		for(int i=0; i<updatedArr.length;i++) {
			System.out.println(updatedArr[i].toString(updatedArr[i]));
		}
		System.out.println();
	}
}
