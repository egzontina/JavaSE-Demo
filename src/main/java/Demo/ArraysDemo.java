package Demo;

import java.util.Arrays;
import java.util.stream.Stream;

public class ArraysDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * ARRAYS LOOP
	 * *************************************************************************
	 */
	public void arrayLoop() {

		String[] elements = { "a","a","a","a" };   
		for (String s : elements) {
			// Do your stuff here
			System.out.println(s);
		}
		
		for( int i = 0; i <= elements.length - 1; i++)
		{
		
		}
	}

	/**
	 * ARRAYS --> STREAM
	 * *************************************************************************
	 */
	public void arrayToStream() {

		String[] array = { "a", "b", "c", "d", "e" };

		// Arrays.stream
		Stream<String> stream1 = Arrays.stream(array);
		stream1.forEach(x -> System.out.println(x));

		// Stream.of
		Stream<String> stream2 = Stream.of(array);
		stream2.forEach(x -> System.out.println(x));
	}

	/**
	 * DUPLICATION DE TABLEAUX
	 * *************************************************************************
	 * utiliser la méthode System.arraycopy() qui fait appel à du code natif.
	 */
	public int[] method(final int[] myArray) {
		final int length = myArray.length;
		final int[] copyOfMyArray = new int[length];
		System.arraycopy(myArray, 0, copyOfMyArray, 0, length);
		return copyOfMyArray;
	}

	/**
	 * Déclaration des tableaux
	 * *************************************************************************
	 * ********************
	 */
	// TODO
	public int tableau1[] = new int[10];
	// NOT TODO
	public int[] tableau2 = new int[10];

}
