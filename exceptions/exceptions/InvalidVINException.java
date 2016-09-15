package exceptions;

public class InvalidVINException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidVINException() {
	}

	public InvalidVINException(String message) {
		System.out.println(message);
	}

}
