package ITwTest.Math;

/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 *
 */
public class ReverseInteger {

	public static void main(String[] args) {
		System.out.println("x = 123 | reverse x = " + reverse(123));
		System.out.println("x = -123 | reverse x = " + reverse(-123));
		
		System.out.println("x = 123 | reverse x = " + reverse2(123));
		System.out.println("x = -123 | reverse x = " + reverse2(-123));
	}
	
	/**
	 * Efficient Approach
	 */
	public static int reverse(int x) {
		//flag marks if x is negative
		boolean flag = false;
		if (x < 0) {
			x = 0 - x;
			flag = true;
		}
	 
		int res = 0;
		int p = x;
	 
		while (p > 0) {
			int mod = p % 10;
			p = p / 10;
			res = res * 10 + mod;
		}
	 
		if (flag) {
			res = 0 - res;
		}
	 
		return res;
	}
	/**
	 * Succinct solution
	 * no necessary to check whether the parameter is positive or negative. 
	 * For instance, -11/10 = -1; -11%10 = -1. 
	 */
	public static int reverse2(int x) {
	    int res = 0;
	    while(x != 0){
	    	res = (res * 10) + ( x % 10);
	        x = x/10;
	    }	 
	    return res;
	}
	

}

/**
 
 
 
 */
