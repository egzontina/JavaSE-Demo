package Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Test_Collection {

	public static void main(String[] args) {
	     //nous créons une collection basique
	    /* 
		List<String> list = new ArrayList<String>(Arrays.asList("1","2","3","4","5","6","7"));
	     list.add("8");
	     System.out.println("=============== BEFORE IERATION ===================================");
	     System.out.println(list);
	     */
		/*
	     System.out.println("=============== TRI de collection ===================================");
	     trierCollection();
	     */
//		System.out.println("=============== TEST ArrayList() ===================================");
//		arrayListTest();
		System.out.println("=============== CONVERT  Array To List ===================================");
		arrayToList();
		arrayToListJava8();
		listToArray();
	   }


	
	/** *********************************************************************************************
	CLONER UNE COLLECTION
	*********************************************************************************************** */

	// TODO
	public void cloneList() {

		// Collections.Utils
		// StringUtils (version apache ou spring)

		// addAll : copie une collection sur ue autre
	}
	
	/** *********************************************************************************************
	CONVERSION TABLEAU <--> COLLECTION
	*********************************************************************************************** */

	/** Convert an array to list */
	public static void arrayToList() {
		Integer[] values = { 1, 3, 7 };
		// WAY 1 // none extensible
		List<Integer> list = Arrays.asList(values);
		// WAY 2 // extensible
		List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(values));
		list2.add(1);
		System.out.println(String.format("arrayToList() List java 7: %s", list.toString()));
		System.out.println(String.format("arrayToList() List2 java 7: %s", list2.toString()));

	}	
	/** Convert an array to list with JAVA 8 */
	public static void arrayToListJava8() {
		int[] spam = new int[] { 1, 2, 3 };
		List<Integer> list = Arrays.stream(spam).boxed().collect(Collectors.toList());
		System.out.println(String.format("arrayToList() list Java 8: %s", list));
	}
	
	/** Convert List to Array*/
	public static void listToArray() {
		List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
		Integer[] arrays = list.toArray(new Integer[] {} );
		
		System.out.println(String.format("listToArray() list : %s", list));
		System.out.println(String.format("listToArray() Arrays : %s", Arrays.toString(arrays)));
	}
	
	/** 
	 * ARRAY LIST
	 * ********************************************************************************************** 
	 * pas synchronisés, not use in multi-thread (use vector in place)
	 * */
	
	public static void arrayListTest() {
		List<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c", "d", "e", "f", "g"));
		System.out.println("List : "+list);
		// ajout element
		list.add("h");
		System.out.println("List add : "+list);
		// On met la liste dans le désordre
		Collections.shuffle(list);
		System.out.println("List shuffle() : "+list);

		// On la remet dans l'ordre
		Collections.sort(list);
		System.out.println("List sort() : "+list);

		Collections.rotate(list, -1);
		System.out.println("List rotate() : "+list);

		// On récupère une sous-liste
		List<String> sub = list.subList(2, 5);
		System.out.println("sublis() : "+sub);
		Collections.reverse(sub);
		System.out.println("sublist reverse : "+ sub);

		// On récupère un ListIterator(parcourir la liste dans les deux sens, ..)
		ListIterator<String> it = list.listIterator();
		while (it.hasNext()) {
			String str = it.next();
			if (str.equals("d"))
				it.set("z");
		}
		while (it.hasPrevious())
			System.out.print(it.previous());
	}
	
	/** 
	 * TREE SET
	 * ********************************************************************************************** 
	 * 
	 */
	public static void testTreeSet() {
		TreeSet<Double> set = new TreeSet<Double>();
	      set.add(12.52d);
	      set.add(-5d);
	      set.add(102.56d);
	      set.add(75d);
	      set.add(-52d);
	      // malgré l'insertion dans le désordre - L'affichage se fait dans l'ordre
	      System.out.println(set);
	      
	      Double d = set.ceiling(12.52d);
	      System.out.println(d); //Retourne bien 12.52
	      
	      d = set.higher(12.52d);
	      System.out.println(d); //Retourne bien 75.0
	      
	      //on extrait une sous-section de notre objet
	      NavigableSet<Double> nSet = set.subSet(12.52d, true, 75d, false);
	      System.out.println(nSet);//Mais ne contient qu'un élément... ^^
	      
	      //On retire le plus petit élément
	      set.pollFirst();
	      System.out.println(set);
	      
	      //On retire le plus grand élément
	      set.pollLast();
	      System.out.println(set);
	}
	/** 
	 * HASH SET
	 * ********************************************************************************************** 
	 * utilise le principe de "table de hachage".
	 * rangées en fonction du code de hachage (hashcode())
	 */
	public static void testHashSet() {
	      HashSet<Double> set = new HashSet<Double>();
	      set.add(12.52d);
	      set.add(-5d);
	      set.add(102.56d);
	      set.add(75d);
	      set.add(-52d);
	      //malgré l'insertion dans le désordre - L'affichage se fait dans l'ordre
	      System.out.println(set);
	      
	      Iterator<Double> it = set.iterator();
	      while(it.hasNext()){
	         Double d = it.next();
	      }
	}
	
	
	/** *********************************************************************************************
	Utilisation des collections en Java
	toujours faire référence aux collections en utilisant les interfaces, seule l’étape de construction faisant référence à l’implémentation.
	*/
	// TODO
	List<Object> list555 = new ArrayList<Object>();
	Set<Object> set = new HashSet<Object>();
	Map<Object, Object> map = new TreeMap<Object, Object>();
	// NOT TODO
	ArrayList<Object> list556 = new ArrayList<Object>();

}
