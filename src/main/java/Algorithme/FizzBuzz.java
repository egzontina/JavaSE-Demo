package Algorithme;

public class FizzBuzz {

	/**
	 * Write a program that prints the numbers from 1 to 100. But for multiples
	 * of 3 print â€œFizzâ€? instead of the number and for the multiples of 5
	 * print â€œBuzzâ€?. For numbers which are multiples of both three and five
	 * print â€œFizzBuzzâ€?."
	 * 
	 */
	
	public static void main(String[] args){		
		fizzBuzz2();
	}
	
	
	public static void fizzBuzz1() {
		for(int i = 1; i <= 100; i++){
			String test = "";
			test += (i % 3) == 0 ? "fizz" : "";
			test += (i % 5) == 0 ? "buzz" : "";
			System.out.println(!test.isEmpty() ? test : i);
		}
	}
	
	// 	StringBuilder seems a faster approach than += in this case
	public static void fizzBuzz2() {
		StringBuilder builder = new StringBuilder(1000);
        for (int i = 1; i <= 100; i++) {
            final int length = builder.length();
            if (i % 3 == 0) builder.append("Fizz");
            if (i % 5 == 0) builder.append("Buzz");
            if (length == builder.length()) builder.append(i);
            builder.append('\n');
        }
        System.out.println(builder);
	}
	
	// The % 15 version is simpler and easier to read. This version neatly
	public static void fizzBuzz3() {
		String buzz = "buzz";
		String fizz = "fizz";

		for (int i = 1; i <= 100; i++) {
			if (i % 15 == 0) {
				System.out.println(buzz + fizz + " " + i);
			} else if (i % 3 == 0) {
				System.out.println(buzz + " " + i);
			} else if (i % 5 == 0) {
				System.out.println(fizz + " " + i);
			}
		}
	}
		
	public static void fizzBuzz4() {
		for(int i = 0; i < 100; i++) {
			System.out.println( (i % 3 == 0 || i % 5 == 0) 
					? ((i % 3) == 0 ? "fizz" : "") + ((i % 5) == 0 ? "buzz" : "")  
					: i);
		}
	}
	

	

}
