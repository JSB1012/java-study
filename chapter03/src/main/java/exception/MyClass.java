package exception;

import java.io.IOException;

public class MyClass {

	public void danger() throws IOException, MyException {
		System.out.println("some code....1");
		System.out.println("some code....2");
		
		if (10 - 10 == 0) {
			throw new MyException();
		}
		if (5 - 5 == 0) {
			throw new IOException();
		}
		System.out.println("some code....3");
		System.out.println("some code....4");
	}

}
