package Demo;


public class OthersCasting {

	public static void main(String args[]) {

	}

	
	
	/** ************************** DOUBLE <--> LONG ************************** */
	
	public void doubleToLong() {
		// first example - converting double to long using longValue() method 

		double d = 102.9520;
		long l = (new Double(d)).longValue();
		System.out.println("double value=" + d + ", long=" + l); // double value=102.952, long=102

		// second example - rather simple just cast double to long
		double bill = 293.05;
		long myBill = (long) bill;
		System.out.println("double value=" + bill + ", long=" + myBill); // double value=293.05, long=293
		
		// third example - rounding double value to long in Java
		double dbl = 3421.56;
		long rnd = Math.round(dbl);
		System.out.println("double value=" + dbl + ", long=" + rnd); // double value=3421.56, long=3422

	}
}
