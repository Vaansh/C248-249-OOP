// -----------------------------------------------------
// Assignment 03, Part I
// Written by: Vaansh Lakhwara 40114764
// For COMP 249 Section CC – Summer 2020
// -----------------------------------------------------
/**
 * @author Vaansh Lakhwara 40114764
 * COMP 249
 * Assignment 03, Part I
 * Due Date: August 16, 2020
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream; 
import java.io.FileInputStream; 
import java.io.FileNotFoundException;

/**
 * Class SubDictionary Creator.
 * Contains: main, stringContainsNumber, fix, 
 * storedAndSortedArrayList, and writingIntoTxt methods. 
 */
public class SubDictionaryCreator {

	/**
	 * Main method.
	 * @param args 
	 */
	public static void main(String [] args) {		
		Scanner	keyIn	=	new	Scanner(System.in);
		ArrayList<String> scannedArr = new ArrayList<String>();

		System.out.println("Welcome to the Sub Dictionary Creator Program!");
		System.out.print("Enter the name of the file you wish to open along with the extension: ");
		String fileName = keyIn.next();		

		Scanner scan = null;
		PrintWriter pw = null;

		try 
		{
			scan = new Scanner(new FileInputStream("/Users/vaanshlakhwara/Desktop/required files/" + fileName));
			System.out.println("Opening " + fileName + "...");			
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.out.println("File not found.");
			System.out.println("Please restart the program again.");
			System.exit(0);
		} 

		storedAndSortedArrayList(scannedArr, scan);	//calling storedAndSortedArrayList method.	
		System.out.println();
		System.out.print("Enter the name of the file you wish to store the dictionary in along with the extension: ");
		fileName=keyIn.next();
		keyIn.close();
		try
		{
			pw = new PrintWriter(new FileOutputStream("/Users/vaanshlakhwara/Desktop/required files/" + fileName));
			System.out.println("Working on " + fileName + "...");			
		}catch(FileNotFoundException e) 
		{
			System.out.println(e.getMessage());
			System.out.println("Unable to open file.");
			System.out.println("Please restart the program again.");
			System.exit(0);
		}

		writingIntoTxt(scannedArr, pw);	//calling writingIntoTxt method.

		System.out.println("The program has ended. Thank you!");		
		scan.close();
		pw.close();
	}

	/**
	 * This method checks if the string passed contains a number in it.
	 * @param s String value passed through method.
	 * @return hasNum Boolean value indicating true if string contains number, false otherwise.
	 */
	public static boolean stringContainsNumber(String s)
	{
		String [] num = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		boolean hasNum=false;
		for(String n : num) 
		{
			if(s.contains(n))
			{
				hasNum=true;
				return hasNum;
			}

		}
		return hasNum;
	}

	/**
	 * This method returns the upper case value of the string passed through to 
	 * remove special characters or make any other desired changes.
	 * @param s	String value passed through method.
	 * @return	Fixed value of the passed string, or null.	
	 */
	public static String fix(String s) 
	{	
		/**
		 * @param equal_sign char value of the equal sign.
		 * @param j integer with value 0, used in an else-if condition with a for loop.
		 */
		char equal_sign=61;
		int j=0;					 
		 
		if((s.charAt(s.length()-1)=='?')||(s.charAt(s.length()-1)==':')||(s.charAt(s.length()-1)==',')
				||(s.charAt(s.length()-1)==';')||(s.charAt(s.length()-1)=='!')||(s.charAt(s.length()-1)=='.'))
		{
			return s.substring(0, s.length()-1).toUpperCase();
		}
		
		else if((s.length()==1 && s.charAt(0)==equal_sign)||(s.contains("-")))	
		{
			return null;
		}

		else if(s.length()==1 && ((s.charAt(0)=='a'||s.charAt(0)=='i')
				||(s.charAt(0)=='A'||s.charAt(0)=='I')))
		{
			return String.valueOf(s.charAt(0)).toUpperCase();
		}

		else if(s.length()==1) 
		{
			return null;
		}

		else if(s.contains("'")) 
		{
			for(; j<s.length(); j++) 
			{
				if(s.charAt(j)=='\'') 
				{
					break;
				}
			}
			return s.substring(0, j).toUpperCase();
		}

		else if((stringContainsNumber(s)))
		{
			return null;
		}
		else if (s.equals("1"))
		{
			return null;
		}
		
		else 		
		{
			return s.toUpperCase();
		}
	}  

	/**
	 * This method stores and sorts the array list by checking if redundant values are 
	 * being added. 
	 * @param arrList Array list to be sorted
	 * @param scan Scanner used to read the values from.
	 */
	public static void storedAndSortedArrayList(ArrayList<String> arrList, Scanner scan) 
	{
		while(scan.hasNext()) 
		{
			String s = fix(scan.next());
			if(s!=null && !arrList.contains(s))
			{
				arrList.add(s);
			}
		}
		arrList.sort(null);
	}

	/**
	 * This method eliminates any possibility of numbers being stored in the array list and 
	 * prints the values into print writer accordingly.
	 * @param arrList Array list containing the sorted and fixed values in alphabetical order.
	 * @param pw PrintWriter that holds the name of the text file to write into.
	 */
	public static void writingIntoTxt(ArrayList<String> arrList, PrintWriter pw) 
	{
		char firstChar = arrList.get(0).charAt(0);

		if(firstChar=='0'||firstChar=='1'||firstChar=='2'||firstChar=='3'||firstChar=='4'
				||firstChar=='5'||firstChar=='6'||firstChar=='7'||firstChar=='8'||firstChar=='9') 
		{
			while(firstChar=='0'||firstChar=='1'||firstChar=='2'||firstChar=='3'||firstChar=='4'
					||firstChar=='5'||firstChar=='6'||firstChar=='7'||firstChar=='8'||firstChar=='9') 
			{
				arrList.remove(0);
				firstChar=arrList.get(0).charAt(0);
			}				
		}

		pw.println("The document produced this sub-dictionary, which includes " + arrList.size() + " entries.");	
		pw.println("\n" + firstChar + "\n" + "==");

		char nextChar = firstChar;

		if(arrList.size()!=0)
		{
			for(String s : arrList)
			{		
				firstChar=s.charAt(0);
				if(nextChar!=firstChar) 
				{
					nextChar=firstChar;
					pw.println("\n" + firstChar + "\n" + "==");
				}
				pw.println(s);
			}
		}
	}
}
