package ITwTest.Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Subsets {

	/**
	 * Given a set of distinct integers, S, return all possible subsets Note: 
	 * 
	 * 1) Elements in a subset must be in non-descending order. 
	 * 2) The solution set must not contain duplicate subsets.
	 * 
	 * Given a set S of n distinct integers, there is a relation between Sn and Sn-1. The subset of Sn-1 is the union of
	 * {subset of Sn-1} and {each element in Sn-1 + one more element}.
	 * 
	 */
	public static void main(String[] args) {
		
		List<Integer> S = new ArrayList<>(Arrays.asList(1,3,7)); 
		System.out.println("LIST - given S : " + S);
		System.out.println("LIST - Returned : " + subsets(S));
		
		int[] S2 = { 1, 3, 7 };
		System.out.println("ARRAYS - given S : " + S);
		System.out.println("ARRAYS - Returned : " + subsetsWithDup(S2));
	}

	public static List<List<Integer>> subsets(List<Integer> S) {
		if (S == null)
			return null;

		Collections.sort(S);

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		for (int i = 0; i < S.size(); i++) {
			List<List<Integer>> temp = new ArrayList<List<Integer>>();

			// get sets that are already in result
			for (List<Integer> a : result) {
				temp.add(new ArrayList<Integer>(a));
			}

			// add S[i] to existing sets
			for (List<Integer> a : temp) {
				a.add(S.get(i));
			}

			// add S[i] only as a set
			List<Integer> single = new ArrayList<Integer>();
			single.add(S.get(i));
			temp.add(single);

			result.addAll(temp);
		}

		// add empty set
		result.add(new ArrayList<Integer>());

		return result;
	}

	
	public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		if (num == null)
			return null;
	 
		Arrays.sort(num);
	 
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> prev = new ArrayList<ArrayList<Integer>>();
	 
		for (int i = num.length-1; i >= 0; i--) {
	 
			//get existing sets
			if (i == num.length - 1 || num[i] != num[i + 1] || prev.size() == 0) {
				prev = new ArrayList<ArrayList<Integer>>();
				for (int j = 0; j < result.size(); j++) {
					prev.add(new ArrayList<Integer>(result.get(j)));
				}
			}
	 
			//add current number to each element of the set
			for (ArrayList<Integer> temp : prev) {
				temp.add(0, num[i]);
			}
	 
			//add each single number as a set, only if current element is different with previous
			if (i == num.length - 1 || num[i] != num[i + 1]) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(num[i]);
				prev.add(temp);
			}
	 
			//add all set created in this iteration
			for (ArrayList<Integer> temp : prev) {
				result.add(new ArrayList<Integer>(temp));
			}
		}
	 
		//add empty set
		result.add(new ArrayList<Integer>());
	 
		return result;
	}
	
}
