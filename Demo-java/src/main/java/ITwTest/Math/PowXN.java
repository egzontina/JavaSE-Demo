package ITwTest.Math;

public class PowXN {

	/**
	 * Implement pow(x, n) == calculate x to the power of n
	 */
	
	public static void main(String[] args) {
		
		System.out.println("Math.pow( 2.0 , 5 ): " + Math.pow( 2.0 , 5 ));
		System.out.println("myPow(2,5) : " + myPow(2,5));
		System.out.println("myPow1(2,5) : " + myPow1(2,5));
		System.out.println("myPow2(2,5) : " + myPow2(2,5));
	}
	
	/**  Accepted Solution
	 * time complexity is O(nlog(n)) */
	public static double myPow1(double x, int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return x;
	 
		int pn = n > 0 ? n : -n;// positive n
		int pn2 = pn;
	 
		double px = x > 0 ? x : -x;// positive x
		double result = px;
	 
		int k = 1;
		//the key part of solving this problem
		while (pn / 2 > 0) {
			result = result * result;
			pn = pn / 2;
			k = k * 2;
		}
	 
		result = result * myPow1(px, pn2 - k);
	 
		// handle negative result
		if (x < 0 && n % 2 == 1)
			result = -result;
	 
		// handle negative power
		if (n < 0)
			result = 1 / result;
	 
		return result;
	}
	
	/** Best SOLUTION 
 	 * 
	 */
	
	public static double myPow2(double x, int n) {
		if (n < 0) {
			return 1 / myPower2(x, -n);
		} else {
			return myPower2(x, n);
		}
	}
	public static double myPower2(double x, int n) {
		if (n == 0)
			return 1;
	 
		double v = myPower2(x, n / 2);
	 
		if (n % 2 == 0) {
			return v * v;
		} else {
			return v * v * x;
		}
	}
	

	
	/** NOT GOOD  
	 * time complexity is O(n) */
	public static double myPow(double x, int n) {
        if(x == 0) return 0;
        if(n == 0) return 1;
 
        double result=1;
        for(int i=1; i<=n; i++){
            result = result * x;
        }
 
        return result;
    }
	
	
}
