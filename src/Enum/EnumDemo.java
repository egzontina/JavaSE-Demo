package Enum;
import java.util.EnumMap;
import java.util.Map;

public class EnumDemo {

	private enum Currency {
		USD, AUD, GBP, EURO
	}

	public static void main(String args[]) {

	}

	/** ************ STRING to enum Conversion Example ************ */
	/**
	 * Java program for creating Enum instance from String in Java. This program
	 * demonstrate how to use Enum.valueOf() method to convert enum instance
	 * into String. beware that String must be same as declared Enum instances
	 * and they are case sensitive as well. "UsD" instead of "USD" will throw
	 * IllegalArgumentException
	 */
	public void StringToEnum() {

		// Converting String to Enum in Java
		String usd = "USD";

		// Enum to String using Enum.valueOf()
		Enum currency = Enum.valueOf(Currency.class, usd);

		// Enum to String using Currency.valueOf()
		currency = Currency.valueOf(usd);

		System.out.println("String to Enum Example : " + currency);

		// This Enum to String conversion will throw Exception
		String INR = "INR";
		// java.lang.IllegalArgumentException: No enum const class
		Currency rupee = Currency.valueOf("INR");
	}

	/** ************************** ENUM to STRING ***************************************** */
	/**
	 * converting Enum into String in Java two examples by using name() and
	 * toString() method to get a meaningful String representation from an Enum
	 * instance in Java
	 */
	public void enumToString() {

		// Converting Enum to String by using name() method
		// by default print mehtod calls toString() of enum
		ColdDrink[] drinks = ColdDrink.values();
		for (ColdDrink drink : drinks) {
			System.out.printf("String to Enum example using name :  %s%n",
					drink.name());
		}

		// Converting Enum to String using toString() method
		for (ColdDrink drink : drinks) {
			System.out.println("String to enum conversion using toString() : "
					+ drink);
		}

	}

	private enum Weekdays {
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
	}

	private enum ColdDrink {
		PEPSI("Pepsi"), COKE("Coca Cola"), SPRITE("Sprite");
		private String brandname;

		private ColdDrink(String brand) {
			this.brandname = brand;
		}

		@Override
		public String toString() {
			return brandname;
		}
	}

	/** ************************** Java Enum Code Example - SoftDrink ************************** */
	/**
	 * Java program to show How to use Enum in Java via a Simple Example
	 * 
	 */
	public void testJavaEnumExample() {

		// EnumMap is a special high performance map to store Enum constrants
		Map<SoftDrink, Integer> store = new EnumMap<SoftDrink, Integer>(
				SoftDrink.class);

		// Let's initialize store, by storing 10 canes of each drink
		// Enum provides an implicit values() method, which can be used to
		// iterate over Enum
		for (SoftDrink drink : SoftDrink.values()) {
			store.put(drink, 10);
		}

		// let's print what is in EnumStore
		for (Map.Entry<SoftDrink, Integer> entry : store.entrySet()) {
			// logger.debug(entry.getKey() + " Qty: " + entry.getValue() +
			// " Price: " + entry.getKey().getPrice());
		}
	}

	public enum SoftDrink {
		COKE("Coke", 75), PEPSI("Pepsi", 75), SODA("Soda", 90), LIME("Lime", 50);

		// Java Enum can have member variables
		private String title;
		private int price; // in cents

		// You can declare constructor for Enum in Java
		private SoftDrink(String title, int price) {
			this.title = title;
			this.price = price;
		}

		// Enum can have methods in Java
		public String getTitle() {
			return title;
		}
		public int getPrice() {
			return price;
		}

		// Enum can override methods in Java
		@Override
		public String toString() {
			return title;
		}
	}

	/*
	 * Output DEBUG JavaEnumExample - Coke Qty: 10 Price: 75 DEBUG
	 * JavaEnumExample - Pepsi Qty: 10 Price: 75 DEBUG JavaEnumExample - Soda
	 * Qty: 10 Price: 90 DEBUG JavaEnumExample - Lime Qty: 10 Price: 50
	 */
	/*
	 * used EnumMap to store Enum constant, this is the high performance Map
	 * implementation, which can only be used with enum keys in Java. Since Enum
	 * can be compared using == operator as well as equals() method
	 */
	
	/** ************************** ITERATE Java Enum  ************************** */
	/**
	 *  Java program to iterate over enum using for loop and values method. * values() method of enum returns all enum instances as array for iteration. *
	 */
	public void testEnumLanguage() {
		System.out.println("Java Enum Iterate Example using for loop");
		for (Language pl : Language.values()) {
			System.out.println(pl.name() + " : " + pl.rank);
		}
		/*
		 * Output: 
		 * Java Enum Iterate Example using for 
		 * loop JAVA : 1 
		 * PYTHON : 2 
		 * PERL : 3 
		 * SCALA : 4
		 */

	}

	public enum Language {
		JAVA(1), PYTHON(2), PERL(3), SCALA(4);
		private int rank;

		private Language(int rank) {
			this.rank = rank;
		}

		public int getRank() {
			return rank;
		}
	};
	
	/** ************************** Enum in Switch case  ************************** */

	public enum enumDay {

        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
    }
	
	public void testEnumDay() {
		enumDay[] daysOfWeek = enumDay.values();

        for (enumDay today : daysOfWeek) {

            //Using Enum in Switch case statement

            switch (today) {
                case MONDAY:
                    System.err.println("Today is Monday learn example of How to use Java Enum in Switch");
                    break;
                case TUESDAY:
                    System.err.println("Tuesday, apply Enum in Switch just link primitive int");
                    break;
                case WEDNESDAY:
                    System.err.println("Wednesday, I confirm Java Enum can be used in Switch case");
                    break;
                case THURSDAY:
                    System.err.println("Thursday, Java Enum values() method return all enum in an array");
                    break;
                case FRIDAY:
                    System.err.println("Friday, Enum can also be used in case statement");
                    break;
                case SATURDAY:
                    System.err.println("Saturday, Enum in Java are compile time constant");
                    break;
                case SUNDAY:
                    System.err.println("Sunday, Using Enum in Switch is very easy");
                    break;
              }
        }
	}
	
}
