package algorithm.Math;

public class Factorial {

	
	public static int fac(int n) {
		int fact = 1;

		if (n < 0) {
			System.out.println("Number should be non-negative.");
		} else {
			for (int i = 1; i <= n; i++) {
				fact = fact * i;
			}
		}
		return fact;
	}
	
	/**
	 * Recursive fonction
	 */
	public static int fac2(int n) {
		int fact = 1;

		if (n < 0) {
			System.out.println("Number should be non-negative.");
		} else if (n == 1 || n == 0) {
			return fact;
		}
		fact = n * fac2(n - 1);

		return fact;
	}
	
}
