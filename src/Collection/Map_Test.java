package Collection;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import utils.Person;

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Map_Test {


	   public static void main(String[] args) {
		      
		   	  Map<Integer, String> map = new HashMap<Integer, String>();
		      map.put(1, "toto");
		      map.put(2, "titi");
		      map.put(3, "tutu");
		      map.put(4, "tete");
		      map.put(5, "tata");
		      
		      System.out.println("Parcours d'une Map avec keySet : ");
		      parcourAvecKeySet(map);
		      System.out.println("-----------------------------------");
		      
		      System.out.println("Parcours d'une Map avec setEntry : ");
		      parcourAvecSetEntry(map);
		      System.out.println("-----------------------------------");
		      
		      System.out.println("Parcours de la liste des valeurs d'une Map avec values : ");
		      parcourAvecValues(map);
		      System.out.println("-----------------------------------");
		      
		      		      
		   }
	   
	
	/**
	 * PARCOURS UNE MAP
	 * ************************************************************************************************************** 
	 * Si vous avez uniquement besoin des valeurs, préférez de loin la méthode values() Si vous n'avez que les clés à
	 * manipuler, utilisez la méthode keySet() Si vous avez besoin à la fois des clés et des valeurs de vos données,
	 * utilisez entrySet()
	 * 
	 */ 
	   
	public static void parcourAvecKeySet(Map<Integer, String> map) {
		// Nous récupérons un Set contenant des entiers
		Set<Integer> setInt = map.keySet();
		// Utilisation d'un itérateur générique
		Iterator<Integer> it = setInt.iterator();
		// ensuite vous savez faire
		while (it.hasNext()) {
			int key = it.next();
			System.out.println("Valeur pour la clé " + key + " = " + map.get(key));
		}
	}
	   
	public static void parcourAvecSetEntry(Map<Integer, String> map) {
		// nous récupérons une collection SET d'objets qui contiendra tous les couples clé - valeur de notre Map
		Set<Entry<Integer, String>> setEntry = map.entrySet();
		// Utilisation d'un iterateur générique
		Iterator<Map.Entry<Integer, String>> itEntry = setEntry.iterator();
		while (itEntry.hasNext()) {
			Map.Entry<Integer, String> entry = itEntry.next();
			System.out.println("Valeur pour la clé " + entry.getKey() + " = " + entry.getValue());
			// iterator.remove(); // to remove an entry // RETIRER UN ÉLÉMENT D’UNE MAP
		}
		
		
	}

	public static void parcourAvecValues(Map<Integer, String> map) {
		// recupère la liste de nos valeurs
		Collection<String> col = map.values();
		// Utilisation d'un iterateur générique
		Iterator<String> itString = col.iterator();
		while (itString.hasNext()) {
			String value = itString.next();
			System.out.println("Valeur : " + value);
		}
	}
	
	/** 
	* TRIER UNE MAP
	* ********************************************************************************************** 
	* JAVA 7
	* */
	public static void sortMap(Map<Integer, String> unsortedMap) {
		// TreeMap - using String.CASE_INSENSITIVE_ORDER which is a Comparator that orders Strings by compareToIgnoreCase
		Map<Integer, String> sortedMap = new TreeMap<Integer, String>();
//		Map<String, Integer> sortedMap = new TreeMap<String, Integer>(String.CASE_INSENSITIVE_ORDER);
		sortedMap.putAll(unsortedMap);
		
		
	}
	
	/*
	 * This approach is very useful, if you would do a lot of search operations for the collection. The sorted data
	 * structure will give time complexity of O(logn), which is lower than O(n).
	 * 
	 */
	public static void sortMapWithComprator(Map<Person, String> unsortedMap) {
		
		Comparator<Person> personComparator = new Comparator<Person>() {
			public int compare(Person o1, Person o2) {
				return o1.toString().compareTo(o2.toString());
			}
		};
		// TreeMap - In general, defined comparator
		Map<Person, String> sortedMap2 = new TreeMap<Person, String>(personComparator);
		sortedMap2.putAll(unsortedMap);
	}



	   
}
