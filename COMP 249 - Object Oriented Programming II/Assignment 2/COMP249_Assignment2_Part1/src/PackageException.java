/**
 * PackageException class.
 * Child class of Exception.
 * @author Vaansh Lakhwara
 */
public class PackageException extends Exception{

	/**
	 * Universal version identifier for a Serializable class. 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Parameterless constructor.
	 */
	public PackageException() {
		super();
	}

	/**
	 * Constructor that accepts a message.
	 * @param message String value of message.
	 */
	public PackageException(String message) {
		super(message);
	}
}

/**
 * tooHeavyException class.
 * Child class of PackageException.
 */
class tooHeavyException extends PackageException {
	/**
	 * Universal version identifier for a Serializable class.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor that accepts a message.
	 * @param msg String value of message.
	 */
	public tooHeavyException(String msg) {
		super(msg);
	}
}

/**
 * notAllowedException class.
 * Child class of PackageException.
 */
class notAllowedException extends PackageException {
	/**
	 * Universal version identifier for a Serializable class.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor that accepts a message.
	 * @param msg String value of message.
	 */
	public notAllowedException(String msg) {
		super(msg);
	}
}

/**
 * overException class.
 * Child class of PackageException.
 */
class overException extends PackageException {
	/**
	 * Universal version identifier for a Serializable class.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor that accepts a message.
	 * @param msg String value of message.
	 */
	public overException(String msg) {
		super(msg);
	}
}
