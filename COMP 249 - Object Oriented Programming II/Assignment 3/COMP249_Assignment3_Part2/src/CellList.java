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
import java.util.NoSuchElementException;

public class CellList 
{
	/**
	 * The CellPhone class consists of the following parameters 
	 * set to protected. 
	 * @param iteration Number of iterations before finding the 
	 * desired CellNode in the CellList 
	 */
	protected int iteration = 0;	  

	private class CellNode
	{
		/**
		 * Inner Private class.
		 * Privacy Leak: CellNode may be used ONLY inside CellList.
		 * @param phone Data of CellPhone class.
		 * @param next Link to next CellNode.
		 */
		CellPhone phone;
		CellNode next;

		/**
		 * Default constructor. 
		 * Initializes values of all the variables.
		 */
		public CellNode() 
		{
			phone=null;
			next=null;
		}

		/**
		 * Parameterized constructor.
		 * Sets values of all the variables.
		 * @param phone Data of CellPhone class.
		 * @param node Link to next CellNode.
		 */
		public CellNode(CellPhone phone, CellNode node)
		{
			this.phone=phone;
			this.next=node;
		}

		/**
		 * Copy constructor.
		 * Sets values of all the variables from given CellNode and serial number.
		 * @param serialNum Serial number.
		 * @param d CellNode to set values from.
		 */
		public CellNode(CellNode d, long serialNum)
		{
			this.phone=d.phone.clone(serialNum);
			this.next=d.next;
		}

		/**
		 * Clone method.
		 */
		public CellNode clone()
		{
			return new CellNode(new CellPhone(this.phone, this.phone.getSerialNum()),this.next);
		}

		/**
		 * This method returns the string value of the CellNode.
		 * @return Cloned CellPhone object.
		 */
		public String toString()
		{
			return phone + "";
		}

		/**
		 * Mutator method.
		 * To set the CellPhone.
		 * @param cp Value of CellPhone to be set.
		 */
		public void setCellPhone(CellPhone cp)
		{
			this.phone=cp;
		}

		/**
		 * Mutator method.
		 * To set the CellNode.
		 * @param cn Value of CellNode to be set.
		 */
		public void setCellNode(CellNode cn)
		{
			this.next=cn;
		}

		/**
		 * Accessor method.
		 * @param phone Data of CellPhone class.	
		 */	
		public CellPhone getCellPhone()
		{
			return phone;
		}

		/**
		 * Accessor method.
		 * @param next Link to next CellNode.	
		 */			
		public CellNode getCellNode()
		{
			return next;
		}
	}

	/**
	 * Private attributes.
	 * @param head First CellNode in CellList.
	 * @param size Size of CellList. 
	 */
	private CellNode head;
	private int size=0;

	/**
	 * Default constructor. 
	 * Initializes values of all the variables.
	 */
	public CellList()
	{
		head=null;
	}

	/**
	 * Copy constructor.
	 * Sets values of all the variables from given CellNode and serial number.
	 * @param serialNum Serial number.
	 * @param d CellNode to set values from.
	 */
	public CellList(CellList list)
	{
		if(list==null)
			throw new NullPointerException();
		if(list.head==null)
			head=null;
		else
			head = copy(list.head);
	}

	/**
	 * Private to prevent privacy leak.
	 * @param node CellNode to be copied.
	 * @return newHead the copied head pointer CellNode
	 * with the link to the next CellNode of the list.
	 */
	private CellNode copy(CellNode node)
	{
		CellNode temp = node;
		CellNode newHead = null;
		CellNode end = null;	//Points to end of new list. 		
		newHead = new CellNode(temp.getCellPhone().clone(temp.getCellPhone().getSerialNum()), null);		
		end = newHead;
		size++;
		temp = temp.next;
		while (temp != null)
		{
			end.next = new CellNode(temp.getCellPhone().clone(temp.getCellPhone().getSerialNum()), null);			
			end = end.next;
			temp = temp.next;
			size++;
		}		
		return newHead;
	}

	/**
	 * Method that adds first CellNode to CellList.
	 * @param phone CellPhone to be added to the start of the CellList.
	 */
	public void addToStart(CellPhone phone) 
	{
		head = new CellNode(phone, head);
		size+=1;
	}

	/**
	 * Method that inserts CellNode to designated CellList index.
	 * @param phone CellPhone to be added to the start of the CellList.
	 * @param indexInsert Index of the CellList to insert phone into.
	 */
	public void insertAtIndex(CellPhone phone, int indexInsert)
	{	
		CellNode temp, temp2;
		try
		{
			temp=head;
			int a=0;

			if(indexInsert<0 || indexInsert>size-1) 
			{
				throw new NullPointerException();				
			}
			else
			{	
				if(indexInsert==0)
				{
					System.out.println("Inserting element at #" + indexInsert);
					addToStart(phone);
				}
				else
				{						
					while(a!=indexInsert-1)
					{
						temp=temp.next;
						a++;					    		
					}						
					System.out.println("Inserting element at #" + indexInsert);
					temp2=temp.next;
					CellNode newNode = new CellNode(phone, temp2);
					temp.next=newNode;
					size+=1;

					//prevent any leak
					temp2=null;						
					temp=null;
					newNode=null;

					return;
				}															
			}
		} catch(NullPointerException e)
		{				
			System.out.println("Invalid index number. Please enter a number between 0 and " + (size-1) + ".");				
		}

	}

	/**
	 * Method that deletes indexed CellNode in the CellList. 
	 * @param indexDelete
	 */
	public void deleteFromIndex(int indexDelete)
	{
		try 
		{
			CellNode temp=head;
			int a=0;

			if(indexDelete<0 || indexDelete>size-1) 
			{
				throw new NoSuchElementException();				
			}
			else
			{
				if(size==0)
				{
					throw new NullPointerException();
				}				

				if(size==1)
				{
					if(indexDelete==0)
					{
						head=null;
						size--;
						return;
					}
					else
					{
						throw new NullPointerException();
					}				
				}
				else
				{
					while(a!=indexDelete-1)
					{
						temp=temp.next;
						a++;					    		
					}	
					System.out.println("Deleting element at #" + indexDelete);

					temp.next=temp.next.next;										

					size-=1;

					temp=null;					

					return;										
				}																	
			}
		}catch(NullPointerException e)
		{				
			System.out.println("Invalid index number. Please enter a number between 0 and " + (size-1) + ".");				
		}
		catch(NoSuchElementException e)
		{
			System.out.println(e.getMessage());
			System.out.println("Invalid index number. Please restart to continue.");
			System.exit(0);
		}
		return;		
	}

	/**
	 * Method that deletes first CellNode in CellList, if it exists.
	 */
	public void deleteFromStart() {
		if (size > 1)
		{
			System.out.println("Deleting first element...");
			head = head.next;
			size--;
		}
		else if (size == 1)
		{
			System.out.println("Deleting first element...");
			head = null;
			size--;
		}
		else
		{
			System.out.println("No more elements to delete");
		}
	}

	/**
	 * Method that replaces distinct element.
	 * @param phone
	 * @param indexReplace
	 */
	public void replaceAtIndex(CellPhone phone, int indexReplace)
	{
		if (indexReplace < 0 || indexReplace >= size)
		{
			System.out.println("ERROR: Invalid index...");
			return;
		}
		else
		{
			if(find(phone.getSerialNum())==null) 
			{
				System.out.println("Replacing element at index #" + indexReplace);
				deleteFromIndex(indexReplace);
				insertAtIndex(phone, indexReplace);
			}
			else
			{
				System.out.println("Enter unique CellPhone...");
			}
		}
	}

	/**
	 * Method finds and returns corresponding CellNode to the passed 
	 * serial number.
	 * @param serialNumber Serial number to be searched for.
	 * @return CellNode corresponding to serial number.
	 */
	public CellNode find(long serialNumber) {

		CellNode dummy = head;
		while (dummy != null)
		{
			if (dummy.phone.getSerialNum() == serialNumber)
			{
				return dummy;
			}
			else
			{		
				dummy = dummy.next;
				iteration++;
			}
		}
		//returns null if not found in CellList
		iteration=0;
		return null;
	}
	
	/**
	 * Method used to find if the serial number exists in CellList.
	 * @param serialNum Serial number.
	 * @return boolean value of whether serial number exists in
	 * CellList.
	 */
	public boolean contains(long serialNum)
	{
		if(size==0)
		{
			System.out.println("Empty list, time to initiate values! :)");
			return false;
		}
		else
		{
			if (find(serialNum)==null)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
	}
	
	/**
	 * Method that prints the contents of the list in a systematic form. 
	 */
	public void showContents()
	{
		int count=0;
		CellNode dummy=head;
		
		if (head == null)
		{
			System.out.println("List is empty..." );
			return;
		}
		
		if(head!=null)
		{
			System.out.println("List size is: " + size + ". Contents are:");
			System.out.println("===============================");
			while(dummy!=null)
			{
				if(count!=0 && count%3==0)
				{
					System.out.println();
				}				
				System.out.print(dummy.phone.toString()+" --->");
				dummy=dummy.next;
				count++;
			}
			System.out.println(" X");
		}		
	}

	/**
	 * Method that returns boolean value of equality of the CellList. 
	 * @param list Object passed through method.
	 * @return boolean value of equality.
	 */
	public boolean equals(Object list)
	{
		if (this==list)
		{
			return true;
		}
		if (list==null || getClass()!=list.getClass())
		{
			return false;
		}
		CellList cellList = (CellList) list;

		boolean eq;
		CellNode l1 = head;
		CellNode l2 = cellList.head;
		if (l1==null || l2==null)
		{
			if (l1==null && l2==null)
			{
				eq=true;
			}
			else
			{
				eq=false;
			}
		}
		else
		{
			eq=l1.equals(l2);
		}
		return (size == cellList.size && eq);
	}
}
