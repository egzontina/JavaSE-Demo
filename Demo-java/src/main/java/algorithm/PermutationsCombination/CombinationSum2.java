package algorithm.PermutationsCombination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CombinationSum2 {

	/**
	 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T. Each number in C may only be used ONCE in the combination.
	 * 
	 * This problem is an extension of Combination Sum. The difference is one number in the array can only be used ONCE.
	 * 
	 * Note:
	 * 
	 * 1) All numbers (including target) will be positive integers.
	 * 
	 * 2) Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
	 * 
	 * 3) The solution set must not contain duplicate combinations.
	 * 
	 */
	public static void main(String[] args) {
		int[] candidates = {2,3,6,7};
		System.out.println("combinationSum({2,3,6,7}, 7) : " + combinationSum2(candidates, 7));
	}

	public static List<ArrayList<Integer>> combinationSum2(int[] num, int target) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    if(num == null || num.length == 0)
	        return result;
	 
	    Arrays.sort(num);            
	 
	    ArrayList<Integer> temp = new ArrayList<Integer>();    
	    getCombination(num, 0, target, temp, result);
	 
	    HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>(result);
	 
	    //remove duplicate lists
	    result.clear();
	    result.addAll(set);
	 
	    return result;
	}
	 
	public static void getCombination(int[] num, int start, int target, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> result){
	    if(target == 0){
	        ArrayList<Integer> t = new ArrayList<Integer>(temp);
	        result.add(t);
	        return;
	    }
	 
	    for(int i=start; i<num.length; i++){
	        if(target < num[i])
	            continue;
	 
	        temp.add(num[i]);
	        getCombination(num, i+1, target-num[i], temp, result);
	        temp.remove(temp.size()-1);
	    }
	}
	
}
