package exception;

public class MyException extends Exception {
	private static final long seriaLVersionUID = 1;
	public MyException() {
		super("MyException Occurs...");
	}
	public MyException(String message) {
		super(message);
	}

}
