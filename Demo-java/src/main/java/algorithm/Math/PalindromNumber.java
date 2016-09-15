package algorithm.Math;

public class PalindromNumber {
	/**
	 * Determine whether an integer is a palindrome
	 * palindrome : est une figure de style désignant un texte ou un mot dont l'ordre des lettres reste le même qu'on le lise de gauche à droite ou de droite à gauche,
	 */
	public static void main(String[] args) {
		System.out.println("1237321 : " + isPalindrome(1237321));
		System.out.println("32123 : " + isPalindrome(32123));
		System.out.println("12372 : " + isPalindrome(12372));
		System.out.println("11 : " + isPalindrome(11));
		System.out.println("10021 : " + isPalindrome(10021));
		
		int x  = Integer.MIN_VALUE;
		System.out.println(x+": " + isPalindrome(x));
	}
	
	public static boolean isPalindrome(int x) {
        //negative numbers are not palindrome
		if (x < 0)
			return false;
 
		// initialize how many zeros
		int div = 1;
		while (x / div >= 10) {
			div *= 10;
		}
 
		while (x != 0) {
			int left = x / div;
			int right = x % 10;
 
			if (left != right)
				return false;
 
			x = (x % div) / 10;
			div /= 100;
		}
 
		return true;
    }
}
