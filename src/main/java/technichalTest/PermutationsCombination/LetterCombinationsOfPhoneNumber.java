package technichalTest.PermutationsCombination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
	/**
	 * Given a digit string, return all possible letter combinations that the number could represent. (Check out your
	 * cellphone to see the mappings)
	 * 
	 * Input:Digit string "23"
	 * 
	 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce","cf"].
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Input:Digit string '23', Output : " + letterCombinations1("23"));
		// TODO debut
		System.out.println("Input:Digit string '23', Output : " + letterCombinations2("23"));
	}

	
	
	/**
	 * Solution 1 
	 * =============================================================
	 */
	public static List<String> letterCombinations1(String digits) {
	    HashMap<Integer, String> map = new HashMap<Integer, String>();
	    map.put(2, "abc");
	    map.put(3, "def");
	    map.put(4, "ghi");
	    map.put(5, "jkl");
	    map.put(6, "mno");
	    map.put(7, "pqrs");
	    map.put(8, "tuv");
	    map.put(9, "wxyz");
	    map.put(0, "");
	 
	    ArrayList<String> result = new ArrayList<String>();
	 
	    if(digits == null || digits.length() == 0)
	        return result;
	 
	    ArrayList<Character> temp = new ArrayList<Character>();
	    getString(digits, temp, result, map);
	 
	    return result;
	}
	 
	public static void getString(String digits, ArrayList<Character> temp, ArrayList<String> result,  HashMap<Integer, String> map){
	    if(digits.length() == 0){
	        char[] arr = new char[temp.size()];
	        for(int i=0; i<temp.size(); i++){
	            arr[i] = temp.get(i);
	        }
	        result.add(String.valueOf(arr));
	        return;
	    }
	 
	    Integer curr = Integer.valueOf(digits.substring(0,1));
	    String letters = map.get(curr);
	    for(int i=0; i<letters.length(); i++){
	        temp.add(letters.charAt(i));
	        getString(digits.substring(1), temp, result, map);
	        temp.remove(temp.size()-1);
	    }
	}
	
	/**
	 * Solution 2 
	 * =============================================================
	 */
	public static List<String> letterCombinations2(String digits) {
		List<String> result = new ArrayList<String>();
		if (digits == null || digits.length() == 0) {
			return result;
		}

		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");
		map.put(0, "");
		StringBuilder b = new StringBuilder();
		dfs(digits, 0, b, map, result);

		return result;
	}

	public static void dfs(String digits, int step, StringBuilder b, HashMap<Integer, String> map, List<String> result) {
		if (step == digits.length()) {
			result.add(b.toString());
			return;
		}

		Character curr = digits.charAt(step);
		String s = map.get(curr);
		for (int i = 0; i < s.length(); i++) {
			b.append(s.charAt(i));
			dfs(digits, step + 1, b, map, result);
			b.deleteCharAt(b.length() - 1);
		}
	}

}
