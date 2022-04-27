package chapter03;

public class ArrayUtil {

	public static double[] intToDouble(int[] a) {
		double[] result = new double[a.length];
		for (int i = 0; i < a.length; i++) {
			result[i] = a[i];
		}

		return result;
	}

	public static int[] doubleToint(double[] ds) {
		int[] result2 = new int[ds.length];
		for (int i = 0; i < ds.length; i++) {
			result2[i] = (int) ds[i];
		}
		return result2;
	}

	public static int[] concat(int[] is1, int[] is2) {
		int[] result3 = new int[is1.length + is2.length];
		System.arraycopy(is1, 0, result3, 0, is1.length);
		System.arraycopy(is2, 0, result3, is1.length, is2.length);
		return result3;
	}

}