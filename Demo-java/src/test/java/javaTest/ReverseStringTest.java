package javaTest;

import org.junit.Assert;
import org.junit.Test;

import Algorithme.ReverseString;

public class ReverseStringTest {

	@Test
	public void testReversePair() {

	    // Arrange
	    final String s = "abcd";
	    final String expected = "dcba";

	    // Act and Assert
	    doTestReverse(s, expected);
	}

	@Test
	public void testReverseImpair() {

	    // Arrange
	    final String s = "abcde";
	    final String expected = "edcba";

	    // Act and Assert
	    doTestReverse(s, expected);
	}

	@Test
	public void testReverseVide() {

	    // Arrange
	    final String s = "";
	    final String expected = "";

	    // Act and Assert
	    doTestReverse(s, expected);
	}

	@Test
	public void testReverseNulle() {

	    // Arrange
	    final String s = null;
	    final String expected = null;

	    // Act and Assert
	    doTestReverse(s, expected);
	}

	
	private void doTestReverse(final String s, final String expected) {
	    // Act
	    //final String result = ReverseString.reverseWithStringBulder(s);
	    final String result = ReverseString.reverseWithoutStringBulder(s);	    

	    // Assert
	    Assert.assertEquals(expected, result);
	}

}
