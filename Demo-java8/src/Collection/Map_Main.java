package Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.Person;
import utils.PersonsDB;


public class Map_Main {
	
	public static void main(String[] args) {
		
//		 Map : forEach Prend un BiConsumer 
		// the existing map 
		List<Person> lp = PersonsDB.PERSONS;
		Map<String, Person> map = new HashMap<>() ;
		map.put("p0", lp.get(0));
		map.put("p1", lp.get(1));		
//		map.forEach( (key, value) -> System.out.println(key + " -> " + value.getFirstname()) ) ; // > p0 -> Carson  p1 -> Patty
		 
//		 Map : replace Remplace une valeur avec sa clé 
		// key, newValue 
		map.replace("p0", lp.get(3)) ; 
		// key, oldValue, newValue 
		map.replace("p1", lp.get(1), lp.get(3)) ;
//		map.forEach( (key, value) -> System.out.println(key + " -> " + value.getFirstname()) ) ; // > p1 -> Moe p0 -> Moe
		
//		 Map : replaceAll Transforme toutes les valeurs 
		 Map<String, Boolean> booleanMap = new HashMap<String, Boolean>(2);
	        booleanMap.put("A", Boolean.TRUE);
	        booleanMap.put("B", Boolean.FALSE);
	        booleanMap.put("C", Boolean.TRUE);
	        System.out.println("Hashmap created  --------------- ");
	        booleanMap.forEach((k, v) -> System.out.println(k + " " + v));		
	        System.out.println("Hashmap replaceAll  ------------");
	        booleanMap.replaceAll((k, v) -> Boolean.FALSE);
//	        long startTime = System.currentTimeMillis();	        
	        booleanMap.forEach((k, v) -> System.out.println(k + " " + v));	        
//	        long stopTime = System.currentTimeMillis();	        
//	        System.out.println("Replace took time " + (stopTime-startTime));
	        System.out.println("Hashmap Remove ------------ ");
	        booleanMap.remove("A") ;
	        booleanMap.remove("B", Boolean.FALSE);
//	        booleanMap.forEach((k, v) -> System.out.println(k + " " + v));	
	        
	        
//		 Map : compute Calcule une valeur à partir de la clé et la valeur existante, 
	        //et d’une fonction qui fusionne la paire clé / valeur
	        Map<String, String> stringMap = new HashMap<String, String>();
	        stringMap.put("A", "Amadou");
	        stringMap.put("B", "Babacar");
	        System.out.println("Hashmap Compute ------------ ");
	        stringMap.compute("A", (k, v) -> (k == null) ? "Valeur Null" : k.concat(v)) ;
	        stringMap.compute("B", (k, v) -> (k == null) ? "Valeur Null" : k + "::" +v) ;
	        stringMap.forEach((k, v) -> System.out.println(k + " " + v)); // > A AAmadou   B B::Babacar
	        
//		 Map : merge Calcule une valeur à partir de la clé, de l’actuelle valeur si elle existe, 
	        // et d’une fonction qui fusionne les valeurs
	        System.out.println("Hashmap Merge ------------ ");
	        stringMap.merge( "B", "otherB", (value, otherValue) -> value.concat(", ").concat(otherValue) ) ;
	        stringMap.forEach((k, v) -> System.out.println(k + " " + v)); // > B B::Babacar, otherB
	        
//		 Map : putIfAbsent Ajoute une paire clé / valeur si la clé n’est pas déjà dans la table 
	        System.out.println("Hashmap putIfAbsent ------------ ");
	        stringMap.putIfAbsent("C", "Malick") ;
	        stringMap.forEach((k, v) -> System.out.println(k + " " + v)); // > ... un Malick
	        
//		 Map : computeIfAbsent Si la clé est absente : associe une valeur calculée par exécution de la fonction. 
	        // Dans tous les cas : retourne la valeur (nouvelle ou ancienne)
	        System.out.println("Hashmap computeIfAbsent ------------ ");
	        stringMap.computeIfAbsent( "D", key -> "Malick"+"DIOP");
	        stringMap.forEach((k, v) -> System.out.println(k + " " + v)); // > ... un Malick
	        
//		 Map : computeIfPresent Si la clé est présente : associe une valeur calculée par exécution de la fonction. Retourne la valeur. // the existing map Map<String, Map<String, Person>> map = ... ; // key, newValue map.computeIfPresent( "un", map, (key, value) -> ... // la nouvelle valeur ) .put(".un", john) ;
//
		
	}

}
