package ITwTest.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exo5 {

	public static void main(String[] args) {
		/*
		 * When list declared, I still can add to ArrayList new elements, remove
		 * elements and update it. when an array is declared as final, the state
		 * of the object stored in the array can be modified
		 */
		final List<String> stList = new ArrayList<String>(Arrays.asList("a", "b", "c"));
		System.out.println(stList);

		stList.add("d");

		System.out.println(stList);

		/*
		 * what is effect making it's final? This means that i cannot rebind the
		 * variable to point to a different collection instance you can't
		 * re-assign its reference.
		 */
		final List<Integer> list = new ArrayList<Integer>();
		// list = new ArrayList<Integer>(); 
		// Since `list' is final, this won't compile
		// The final local variable list cannot be assigned. It must be blank
		// and not using a compound assignment

		/*
		 * if If i wish, you can prevent insertion, removal etc by using
		 * Collections.unmodifiableList()
		 * 
		 */
		final List<Integer> list2 = Collections.unmodifiableList(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
		System.out.println("list2 unmodifiableList :" + list2);
		list2.add(4); // throw exception
		System.out.println("list2 add() : " + list2);

		/*
		 * Which advantages/disadvantages we can get by making ArrayList (or
		 * other Collection) final?
		 */

	}
}
