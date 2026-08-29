package lab5;

public class InvalidScoreException extends Exception {

	public InvalidScoreException() {
	}
	public InvalidScoreException(String message) {
		super(message);
	}
	public InvalidScoreException(Throwable cause) {
		super(cause);
	}

}
