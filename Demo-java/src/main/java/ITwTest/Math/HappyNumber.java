package ITwTest.Math;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Write an algorithm to determine if a number is "happy".
 * 
 * 
 *
 * un entier naturel est un "nombre heureux" si, lorsqu'on calcule la somme des carrés de ses chiffres dans son écriture
 * en base dix puis la somme des carrés des chiffres du nombre obtenu et ainsi de suite, on aboutit au nombre 1. 
 */
public class HappyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("isHappy(19) : " + isHappy(19));
System.out.println("isHappy(1) : " + isHappy(1));
System.out.println("isHappy(7) : " + isHappy(7));
System.out.println("isHappy(145) : " + isHappy(145));

	}

	
	public static boolean isHappy(int n) {
		Set<Integer> set = new HashSet<Integer>();

		while (!set.contains(n)) {
			set.add(n);

			n = sum(getDigits(n));
			if (n == 1)
				return true;
		}

		return false;
	}

	
	public static int sum(int[] arr) {
		int sum = 0;
		for (int i : arr) {
			sum = sum + i * i;
		}
		return sum;
	}

	
	public static int[] getDigits(int n) {
		String s = String.valueOf(n);
		int[] result = new int[s.length()];
		int i = 0;

		while (n > 0) {
			int m = n % 10;
			result[i++] = m;
			n = n / 10;
		}

		return result;
	}

}
