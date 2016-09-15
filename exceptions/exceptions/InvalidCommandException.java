package exceptions;

public class InvalidCommandException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidCommandException() {
	}

	public InvalidCommandException(String message) {
		System.out.println(message);
	}

}
