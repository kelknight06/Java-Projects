package lab5;

public class InvalidDataFormatException extends Exception {
	public InvalidDataFormatException() {
		
	}
	public InvalidDataFormatException(String message) {
		super(message);
	}
	public InvalidDataFormatException(Throwable cause) {
		super(cause);
	}
}
