package algorithm.Math;

import java.util.Arrays;

public class PlusOne {

	/**
	 * Given a non-negative number represented as an array of digits, plus one to the number. The digits are stored such
	 * that the most significant digit is at the head of the list.
	 * 
	 * we can use a flag to mark if the current digit needs to be changed.
	 */
	public static void main(String[] args) {
		int[] arrays = { 1, 2, 3 };
		System.out.println("plusOne({ 1, 2, 3 }) : " + Arrays.toString(plusOne(arrays)) );
	}

	public static int[] plusOne(int[] digits) {
		int len = digits.length;
		boolean flag = true; // flag if the digit needs to be changed
	 
		for (int i = len - 1; i >= 0; i--) {
			if (flag) {
				if (digits[i] == 9) {
					digits[i] = 0;
				} else {
					digits[i] = digits[i] + 1;
					flag = false;
				}
	 
				if (i == 0 && digits[i] == 0) {
					int[] y = new int[len + 1];
					y[0] = 1;
					for (int j = 1; j <= len; j++) {
						y[j] = digits[j - 1];
					}
					digits = y;
				}
			}
		}
	 
		return digits;
	}
	
}
