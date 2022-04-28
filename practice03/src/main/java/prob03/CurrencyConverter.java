package prob03;

public class CurrencyConverter {

	private static double rate;

	public static void setRate(double rate) {
		CurrencyConverter.rate = rate;
	}

	public static double toDollar(int i) {
		double dollar = (double) i / rate;
		return dollar;
	}

	public static double toKRW(double d) {
		double krw=(double)d * rate;
	return krw;
	}

}
