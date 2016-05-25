package Demo;

/**
 * CONVERTIR UNE CHAÎNE DE CARACTÈRES EN PRIMITIF
 * 
 * convertir une chaîne de caractère en primitif, il est préférable d’utiliser la méthode parseX() 
 * des classes Integer, Long, Float, Double et Boolean, où X est le nom de la classe, au lieu de la méthode valueOf(), qui retourne une nouvelle instance.
 * 
 * bien évidemment, si vous souhaitez obtenir un objet, vous devrez utiliser valueOf(). Néanmoins, il est bon de garder à l’esprit qu’une telle conversion est couteuse.
 * 
 * Casting is changing the type of the variable
 * Parsing is 'examining' the string and assigning its logical value to some variable.
 *
 */

public class StringParsing {
	
	
	public static void main(String args[]) {

	}	
	
	
	/** ************************** STRING to INT ************************** */
	/**
	 * Java provides Integer.parseInt() method to parse a numéric String to an
	 * int Integer.valueOf() method is more efficient and useful Same method to
	 * Integer
	 */
	public Integer stringToIntOrInteger(String str) {
		Integer i;
		// int i;
		try {
			i = Integer.valueOf(str); // can return cached value
			// i = Integer.parseInt(input);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			i = null;
		}
		return i;

	}


	/** ************************** STRING to LONG ************************** */
	/**
	 * Three ways to convert String to long in Java By using Long.parseLong()
	 * method : parse given string and return a privite long value By using
	 * Long.valueOf() method : internally call Long.parseLong() but return Long
	 * object By using new Long(String value) constructor : internally use
	 * Long.parseLong() but return Long Object
	 * 
	 * should use Long.valueOf() method to parse String, if you need a Long
	 * object and use parseLong() method if you want to convert String to
	 * primitive long value. Long.valueOf() method also provides caching in
	 * range of -128 to 127. By the way, since we have auto-boxing in Java,
	 * which also used Long.valueOf() method, It's always better to use
	 * parseLong() method because it's readable, reveals the real intention,
	 * handles invalid input and specifically designed to parse String literal
	 * containing long values.
	 * 
	 * string to long, Long.valueOf() should be preferred
	 */
	public void stringToLong() {

		// Some long values as String literal for testing
		String simpleLong = "2223349494943933";
		String longWithPlusSign = "+45523349494943933";
		String longWithMinusSign = "-745523349494943933";
		// String outOfBoundLong = "787888888888888888888888888888888888888883333333333333333333";

		// converting String to long using Long.parseLong() method
		long value1 = Long.parseLong(simpleLong);
		long value2 = Long.parseLong(longWithPlusSign);
		long value3 = Long.parseLong(longWithMinusSign);

		// below will throw NumberFormatException because long value is out of
		// range
		// long value4 = Long.parseLong(outOfBoundLong);

		System.out.printf("String %s converted to long value %d %n",
				simpleLong, value1);
		System.out.printf("String %s converted to long value %d %n",
				longWithPlusSign, value2);
		System.out.printf("String %s converted to long value %d %n",
				longWithMinusSign, value3);

		// System.out.printf("String %s converted to long value %d %n",
		// outOfBoundLong, value4);

		// second method to convert a String literal to long value is
		// by using valueOf() method of Long class

		long value4 = Long.valueOf(simpleLong);
		long value5 = Long.valueOf(longWithPlusSign);
		long value6 = Long.valueOf(longWithMinusSign);

		// long value7 = Long.valueOf(outOfBoundLong); NumberFormatException

		System.out.println("String : " + simpleLong + " long : " + value4);
		System.out
				.println("String : " + longWithPlusSign + " long : " + value5);
		System.out.println("String : " + longWithMinusSign + " long : "
				+ value6);
		// System.out.println("String : " + outOfBoundLong + " long : " +
		// value7);

		/*
		 * Output String 2223349494943933 converted to long value
		 * 2223349494943933 String +45523349494943933 converted to long value
		 * 45523349494943933 String -745523349494943933 converted to long value
		 * -745523349494943933 String : 2223349494943933 long : 2223349494943933
		 * String : +45523349494943933 long : 45523349494943933 String :
		 * -745523349494943933 long : -745523349494943933
		 */

	}
	
	public void longToString() {
		long l = 1040;
		String str = Long.toString(l);
	    // convert long to String type
	    System.out.println("convert long " + l + "to String " + str );
		
	}
	
	/** ************************** STRING to DOUBLE  ************************** */
	
	public void stringToDouble() {
		// let's first start converting String to double 
		// there are three ways to convert a String to double in Java 
		// parseDouble(), valueOf() and Double() constructor 
		
		// Using parseDouble() to parse String to double in Java 
		String number = "6.24"; 
		double d = Double.parseDouble(number); 
		System.out.println("String " + number +" is parse to double value : " + d); 
		// now let's use Double.valueOf() method to get double from String 
		String str = "8.23"; 
		double value = Double.valueOf(str); 
		System.out.println("String to double conversion using valueOf : " + value); 
		// another way is by using Double wrapper class constructor 
		// though it will return Double value, autoboxing will convert 
		// it to double primitive value 
		String floating = "122.44"; 
		double converted = new Double(floating); 
		System.out.println("Double value " + converted + " created from String " + floating );
		
	}
	
	public void doubleToString() {
		// Simplest way to convert a double to String 
		double pie = 3.14; 
		String parsed = "" + pie; 
		System.out.println("Double value : " + pie + " String value : " + parsed); 
		// you can also use String.valueOf() to convert double to String 
		double myValue = 88.22; 
		String doubled = String.valueOf(myValue); 
		System.out.println("Double value " + myValue + " converted to String : " + doubled); 
		// another way to get String from double is by using Double.toString() in Java 
		Double code = new Double(5543.3); 
		String decode = code.toString(); 
		System.out.println("double : " + code + " String : " + decode); 
	}

	/** ************************** STRING <--> INTEGER ************************** */

	public void stringToInteger() {
		
		Integer a = 10;
		String aS = a.toString();
		String aS2 = String.valueOf(a);
		
	}
	
	
	/** ************************** STRING <--> FLOAT ************************** */
	
 
	public void stringToFloat() {
		// let's first learn how to convert String to float in Java 
		String decimal = "100.25"; 
		
		// first we can use parseFloat() method to convert String to Float 
		float f = Float.parseFloat(decimal); 
		
		System.out.println("float equvialent of String " + decimal + " is : " + f); 
		
		// remember it's not necessary that String always has floating point 
		// so this is also Ok 
		
		f = Float.parseFloat("200"); 
		System.out.println("String 200 in float is : " + f); 
		
		// another way to convert String to float is by using valueOf() method 
		String pie = "3.14"; 
		float number = Float.valueOf(pie); 
		System.out.println(pie + " in float is : " + number); 
		
		// third way to parse String to float is by using Float constructor 
		// though this will return object of Float wrapper class 
		// autoboxing will convert it to float primitive 
		String multiplier ="1.5"; 
		float constant = new Float(multiplier); 
		System.out.println("String '1.5' is equal to float : " + constant);
		
		/* OUTPUT
		 * float equvialent of String 100.25 is : 100.25 String 200 in float is : 200.0 3.14 in float is : 3.14 String '1.5' is equal to float : 1.5
		 */

	}
	
	public void floatToString() {
		
		float f = 100.25f;
		
		// Now let's do the reverse 
		// Now we have a float primitive and we need to convert it to String in Java 
		// simplest way to do is String concatenation 
		float quarter = .25f; 
		String fromFloat = "" + quarter; 
		System.out.println("float " + f + " is converted to String : " + fromFloat); 
		
		// Second easy way to convert float variable to String is by using toString() 
		// method of Float wrapper class 
		Float half = Float.valueOf(.5f); 
		String str = half.toString(); 
		System.out.println("Float " + half + " is converted to String : " + str); 
		
		// Another way to parse a floating point number as String by using 
		// java.lang.String valueOf(float f) method 
		// this method return float equivalent of String passed in. 
		float onethird = .75f; 
		String floatingpoint = String.valueOf(onethird); 
		System.out.println("float " + onethird + " is equal to String : " + floatingpoint);
		
		/* OUTPUT
		 * float 200.0 is converted to String : 0.25 Float 0.5 is converted to String : 0.5 float 0.75 is equal to String : 0.75
		 */
	
	}

}
