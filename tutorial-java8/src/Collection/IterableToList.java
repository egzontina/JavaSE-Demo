package Collection;

import java.util.ArrayList;
import java.util.Collection;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class IterableToList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// In JDK 8, without depending on additional libs:
		
			
	}
	
	// from Iterable to Collection
	// write your own utility method
	// I'd prefer this approach over importing a large 3rd party collections-library GOGLE GUAVA
	// 4 lines of function code is much more preferable over 2 MB of compiled library code for which 99% of it goes unused.
	public static <E> Collection<E> makeCollection(Iterable<E> iter) {
	    Collection<E> list = new ArrayList<E>();
	    for (E item : iter) {
	        list.add(item);
	    }
	    return list;
	}

	public static <E> Collection<E> makeListFromItarable(Iterable<E> source) {
		Collection<E> target = new ArrayList<>();
		source.forEach(target::add);
		return target;
	}
	
}
