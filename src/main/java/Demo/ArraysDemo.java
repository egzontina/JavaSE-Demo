package Demo;

public class ArraysDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/** DUPLICATION DE TABLEAUX 
	 * ********************************************************************************************* 
	 * utiliser la méthode System.arraycopy() qui fait appel à du code natif.
	 */
	public int[] method(final int[] myArray) {
	    final int length = myArray.length;
	    final int[] copyOfMyArray = new int [length];
	    System.arraycopy(myArray, 0, copyOfMyArray, 0, length);
	    return copyOfMyArray;
	}
	
	/** Déclaration des tableaux
	 * *********************************************************************************************
	 */
	// TODO
	public int tableau1[] = new int[10];
	// NOT TODO
	public int[] tableau2 = new int[10];

}
