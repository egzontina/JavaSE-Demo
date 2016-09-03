package Algorithme;

import java.util.Arrays;

public class RotateArray {

	/**
	 * Problem: Rotate an array of n elements to the right by k steps. For example, with n = 7 and k = 3, the array
	 * [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
	 */

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println("(length=7, order=3) : " + Arrays.toString(rotate(arr, 3)));
		
		int[] arr2 = { 1, 2, 3, 4, 5, 6 };
		System.out.println("(length=6, order=2) : " + Arrays.toString(rotate2(arr2, 2)));

	}

	/**
	 * solution is like a bubble sort. tri à bulle the time is O(n*k).
	 * 
	 */
	public static int[] rotate(int[] arr, int order) {
		if (arr == null || order < 0) {
			throw new IllegalArgumentException("Illegal argument!");
		}

		for (int i = 0; i < order; i++) {
			for (int j = arr.length - 1; j > 0; j--) {
				int temp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
			}
		}
		return arr;
	}
	
	/**
	 * Solution Reversal
	 * do this in O(1) space and in O(n) time
	 * 
	 * 1. Divide the array two parts: 1,2,3,4 and 5, 6
	 * 2. Rotate first part: 4,3,2,1,5,6
	 * 3. Rotate second part: 4,3,2,1,6,5
	 * 4. Rotate the whole array: 5,6,1,2,3,4
	 */
	public static int[] rotate2(int[] arr, int order) {

		if (arr == null || arr.length==0 || order < 0) {
			throw new IllegalArgumentException("Illegal argument!");
		}
		
		if(order == arr.length){
			return arr;
		}
		
		order = order % arr.length;
		
		//length of first part
		int a = arr.length - order; 
	 
		reverse(arr, 0, a-1);
		reverse(arr, a, arr.length-1);
		reverse(arr, 0, arr.length-1);
	 
		return arr;
	}
	 
	public static void reverse(int[] arr, int left, int right){
		if(arr == null || arr.length == 1) 
			return;
	 
		while(left < right){
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}	
	}

}
