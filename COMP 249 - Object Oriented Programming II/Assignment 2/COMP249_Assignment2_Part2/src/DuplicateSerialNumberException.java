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

public class DuplicateSerialNumberException extends Exception {	
	/**
	 * Universal version identifier for a Serializable class. 
	 */
	private static final long serialVersionUID = 1L;
	public static final String msg = "Duplicate serial number. re-enter serial number .";
	
	/**
	 * Parameterless constructor.
	 */
	public DuplicateSerialNumberException() {
		super(msg);
	}

	/**
	 * Constructor that accepts a message.
	 * @param message String value of message.
	 */
	public DuplicateSerialNumberException(String message) {
		super(message);
	}

}
