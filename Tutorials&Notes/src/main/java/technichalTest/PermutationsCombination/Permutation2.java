package technichalTest.PermutationsCombination;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation2 {

	/**
	 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
	 * For example, [1,1,2] have the following unique permutations: [1,1,2], [1,2,1], and [2,1,1].
	 * 
	 * For each number in the array, swap it with every element after it. To avoid duplicate, we need to check the existing sequence first.
	 * 
	 */
	public static void main(String[] args) {
		int[] num = {1,1,2};
		System.out.println("permuteUnique {1,1,2} : " + permuteUnique(num));
		int[] num2 = {1,1,2};
		System.out.println("permuteUnique2 {1,1,2} : " + permuteUnique2(num2));
		int[] num3 = {1,2,3};
		System.out.println("permuteUnique2 {1,2,3} : " + permuteUnique2(num3));
	}
	
	/**
	 * Solution 1 
	 * =========================================================================
	 */
	static public List<List<Integer>> permuteUnique(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		permuteUnique(num, 0, result);
		return result;
	}
	 
	private static void permuteUnique(int[] num, int start, List<List<Integer>> result) {
	 
		if (start >= num.length ) {
			List<Integer> item = convertArrayToList(num);
			result.add(item);
		}
	 
		for (int j = start; j <= num.length-1; j++) {
			if (containsDuplicate(num, start, j)) {
				swap(num, start, j);
				permuteUnique(num, start + 1, result);
				swap(num, start, j);
			}
		}
	}
	 
	private static List<Integer> convertArrayToList(int[] num) {
		List<Integer> item = new ArrayList<Integer>();
		for (int h = 0; h < num.length; h++) {
			item.add(num[h]);
		}
		return item;
	}
	 
	private static boolean containsDuplicate(int[] arr, int start, int end) {
		for (int i = start; i <= end-1; i++) {
			if (arr[i] == arr[end]) {
				return false;
			}
		}
		return true;
	}
	 
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	/**
	 * Solution 2 
	 * =========================================================================
	 * Use set to maintain uniqueness:
	 */
	public static List<List<Integer>> permuteUnique2(int[] num) {
		List<List<Integer>> returnList = new ArrayList<List<Integer>>();
		returnList.add(new ArrayList<Integer>());
	 
		for (int i = 0; i < num.length; i++) {
			Set<List<Integer>> currentSet = new HashSet<List<Integer>>();
			for (List<Integer> l : returnList) {
				for (int j = 0; j < l.size() + 1; j++) {
					l.add(j, num[i]);
					ArrayList<Integer> T = new ArrayList<Integer>(l);
					l.remove(j);
					currentSet.add(T);
				}
			}
			returnList = new ArrayList<List<Integer>>(currentSet);
		}
	 
		return returnList;
	}

}
