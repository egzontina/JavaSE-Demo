package ITwTest.Math;

import java.util.HashMap;
import java.util.Map;

public class FractionToDecimal {

	/**
	 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
	 * If the fractional part is repeating, enclose the repeating part in parentheses
	 */
	public static void main(String[] args) {
		
//		System.out.println("Given numerator = 1, denominator = 2, reurn " + fractionToDecimal(1,2));
//		System.out.println("Given numerator = 2, denominator = 1, reurn " + fractionToDecimal(2,1));
//		System.out.println("Given numerator = 2, denominator = 3, reurn " + fractionToDecimal(2,3));
//		
		
		fraction(2,3);
	}
	
	public static String fractionToDecimal(int numerator, int denominator) {
		
		if (numerator == 0)
			return "0";
		if (denominator == 0)
			return "";
	 
		String result = "";
	 
		// is result is negative // ^  bitwise exclusive OR : doivent être différent
		if ((numerator < 0) ^ (denominator < 0)) {
			result += "-";
		}
	 
		// convert int to long, retourne la valeur absolue
		long num = numerator; 
		long den = denominator;
		num = Math.abs(num);
		den = Math.abs(den);
	 
		// quotient 
		long res = num / den;
		result += String.valueOf(res);
	 
		// if remainder is 0, return result
		long remainder = (num % den) * 10;
		if (remainder == 0)
			return result;
	 
		// right-hand side of decimal point
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		result += ".";
		while (remainder != 0) {
			// if digits repeat
			if (map.containsKey(remainder)) {
				int beg = map.get(remainder); 
				String part1 = result.substring(0, beg);
				String part2 = result.substring(beg, result.length());
				result = part1 + "(" + part2 + ")";
				return result;
			}
	 
			// continue
			map.put(remainder, result.length());
			res = remainder / den;
			result += String.valueOf(res);
			remainder = (remainder % den) * 10;
		}
	 
		return result;
	}
	
	/**
	 * with java method ad api
	 */
	public static void fraction(int numerator, int denominator) {
		double fraction;
		int fractionValue;
		int decimal;
		double value;

		if (denominator == 0) {
			System.out.println("Can't divide by zero");
		} else {
			fraction = (double) numerator / denominator;
			System.out.println("fraction : " + fraction);
			fractionValue = (int) (fraction * 10);
			System.out.println("fractionValue :" + fractionValue);
			decimal = fractionValue % 10;
			System.out.println("decimal : " + decimal);
			value = decimal * 0.1;
			System.out.println("value : " + value);
			
			System.out.println("");
		}

	}
	

}
