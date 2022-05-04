package prob02;

import java.util.Scanner;

public class CalcApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.print("두 정수와 연산자를 입력하시오 >> ");
			String expression = scanner.nextLine();

			if ("quit".equals(expression)) {
				break;
			}

			String[] tokens = expression.split(" ");

			if (tokens.length != 3) {
				System.out.println(">> 알 수 없는 식입니다.");
				continue;
			}

			int lValue = Integer.parseInt(tokens[0]);
			int rValue = Integer.parseInt(tokens[1]);

			Arithmetic arithmetic = null;

			switch (tokens[2]) {
			case "+":
				arithmetic = new Add();
				calculate(arithmetic, lValue, rValue);
				break;
			case "-":
				arithmetic = new Sub();
				calculate(arithmetic, lValue, rValue);
				break;
			case "*":
				arithmetic = new Mul();
				calculate(arithmetic, lValue, rValue);
				break;
			case "/":
				arithmetic = new Div();
				calculate(arithmetic, lValue, rValue);
				break;

			}
		}

		scanner.close();
	}

	public static void calculate(Arithmetic arithmetic, int lValue, int rValue) {
		int result = arithmetic.calculate(lValue, rValue);
		System.out.println(result);
	}
}