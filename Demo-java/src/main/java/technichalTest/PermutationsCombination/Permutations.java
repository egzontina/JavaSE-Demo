package technichalTest.PermutationsCombination;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	/**
	 * Given a collection of numbers, return all possible permutations. 
	 * For example, [1,2,3] 
	 * have the following permutations: [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
	 */
	public static void main(String[] args) {
		int[] num = {1,2,3};
		System.out.println("permute {1,2,3} : " + permute(num));
		int[] num2 = {1,2,3};
		System.out.println("permute2 {1,2,3} : " + permute2(num2));
	}
	
	/**
	 * Solution 1 : 
	 * Loop through the array, in each iteration, a new number is added to different locations of results of previous iteration. Start from an empty List.
	 */
	public static List<List<Integer>> permute(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
	 
		//start from an empty list
		result.add(new ArrayList<Integer>());
	 
		for (int i = 0; i < num.length; i++) {
			//list of list in current iteration of the array num
			List<List<Integer>> current = new ArrayList<List<Integer>>();
	 
			for (List<Integer> l : result) {
				// # of locations to insert is largest index + 1
				for (int j = 0; j < l.size()+1; j++) {
					// + add num[i] to different locations
					l.add(j, num[i]);
	 
					List<Integer> temp = new ArrayList<Integer>(l);
					current.add(temp);
	 
					//System.out.println(temp);
	 
					// - remove num[i] add
					l.remove(j);
				}
			}
	 
			result = new ArrayList<List<Integer>>(current);
		}
	 
		return result;
	}
	
	/**
	 * Solution 2 
	 * recursively solve this problem. Swap each element with each element after it.
	 */
	public static ArrayList<ArrayList<Integer>> permute2(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		permute2(num, 0, result);
		return result;
	}
	 
	static void permute2(int[] num, int start, ArrayList<ArrayList<Integer>> result) {
	 
		if (start >= num.length) {
			ArrayList<Integer> item = convertArrayToList(num);
			result.add(item);
		}
	 
		for (int j = start; j <= num.length - 1; j++) {
			swap(num, start, j);
			permute2(num, start + 1, result);
			swap(num, start, j);
		}
	}
	 
	private static ArrayList<Integer> convertArrayToList(int[] num) {
		ArrayList<Integer> item = new ArrayList<Integer>();
		for (int h = 0; h < num.length; h++) {
			item.add(num[h]);
		}
		return item;
	}
	 
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
