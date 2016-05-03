package library.exceptions;

public class NoSuchEntryException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	
	public NoSuchEntryException(String entityName) {
		super("No such "+ entityName);
	}

}
