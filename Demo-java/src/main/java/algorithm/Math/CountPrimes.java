package algorithm.Math;

import java.util.ArrayList;
import java.util.List;

public class CountPrimes {

	/**
	 * Count the number of prime numbers less than a non-negative number, n
	 * @param args
	 */
	public static void main(String[] args) {
		

	}
	
	/** This solution exceeds time limit. */
	public static  int countPrimes(int n) {
	    n = n-1;
	 
	    List<Integer> primes = new ArrayList<Integer>();
	 
	    if(n<=1) 
	        return 0;
	    if(n==2)
	        return 1;
	    if(n==3)
	        return 2;
	 
	    primes.add(2);
	    primes.add(3);
	 
	    for(int i=4; i<=n; i++){
	        boolean isPrime = true;
	        for(int p: primes){
	            int m = i%p;
	            if(m==0){
	                isPrime = false;
	                break;
	            }
	        }
	 
	        if(isPrime){
	            primes.add(i);
	        }
	    }
	 
	    return primes.size();
	}
	
	public static int countPrimes2(int n) {
		if (n <= 2)
			return 0;
	 
		// init an array to track prime numbers
		boolean[] primes = new boolean[n];
		for (int i = 2; i < n; i++)
			primes[i] = true;
	 
		for (int i = 2; i <= Math.sqrt(n - 1); i++) {
		// or for (int i = 2; i <= n-1; i++) {
			if (primes[i]) {
				for (int j = i + i; j < n; j += i)
					primes[j] = false;
			}
		}
	 
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (primes[i])
				count++;
		}
	 
		return count;
	}

}
