package Demo;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Example of using BigDecimal to perform monetary calculations
 * 
 * Example of typical calculations with monetary values, implemented with
 * <tt>BigDecimal</tt>.
 * 
 * http://www.javapractices.com/topic/TopicAction.do?Id=13
 * http://www.javaworld.com/article/2075315/core-java/make-cents-with-bigdecimal.html
 * @author Malick
 *
 */
public class BigDecimalDemo {

	public static void main(String[] args) {

		// creates and displays a BigDecimal amount
		BigDecimal amount = new BigDecimal("1115.37");
		System.out.println(amount.toString());

		// Formatting currency
		NumberFormat nfUS = NumberFormat.getCurrencyInstance(Locale.US);
		double doubleAmount = amount.doubleValue();
		String sUS = nfUS.format(doubleAmount);
		System.out.println(sUS);

		NumberFormat nfFR = NumberFormat.getCurrencyInstance(Locale.FRANCE);
		String sFR = nfFR.format(doubleAmount);
		System.out.println(sFR);
		
		// TODO to continue
	}

}
