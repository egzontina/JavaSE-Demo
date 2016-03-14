package Demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * CONCATÉNATION DE CHAÎNES DE CARACTÈRES
 * @author A614412
 *
 */
public class StringConcatenation {

	public static void main(String[] args){		
		concatainWithStringJoiner();
	}
	
	public static void concatainWithStringBuilder() {	
		final String name = "test";
		final StringBuilder string = new StringBuilder("Hello, ");
	    string.append(name);
	    string.append(" from Soat");
	    
	    System.out.println(string);
	}
	
	/**
	 * java 8 stringJoiner
	 */
	public static void concatainWithStringJoiner() {
	StringJoiner spaceJoiner = new StringJoiner(" ");
	String spaceJoinedStrings = spaceJoiner.add("test").add("whatever").toString();
	System.out.println("space Joiner : " + spaceJoinedStrings);
	
	StringJoiner commaJoiner = new StringJoiner(",");	
	String commaJoinedStrings = commaJoiner.add("test").add("whatever").toString();
	// assertEquals("test,whatever", joinedStrings);
	System.out.println("comma Joiner : " + commaJoinedStrings);
	
	/** Join strings prefix & suffix */
	StringJoiner prefixAndSufixJoiner = new StringJoiner(",", "[", "]");
    String joinedPrefixAndSufixString = prefixAndSufixJoiner.add("test").add("whatever").toString();
    // assertEquals("[test,whatever]", joinedStrings1);
    System.out.println("PrefixAndSufix Joiner  : " + joinedPrefixAndSufixString);
	   
    /** Join a list of strings */
    List<String> stringList = new ArrayList<>();
    stringList.add("Cirrus");
    stringList.add("Alto");
    stringList.add("Stratus");
    stringList.add("Vertical Growth");
    stringList.add("Special Clouds");
    String stringListJoined = String.join(",", stringList);
    // assertEquals("Cirrus,Alto,Stratus,Vertical Growth,Special Clouds",stringListJoined);
    System.out.println("List Joined : " + stringListJoined);
    
    
    /** Join list skipping null */
    List<String> stringList2 = new ArrayList<>();
    stringList2.add("Cirrus");
    stringList2.add("Alto");
    stringList2.add(null);
    stringList2.add(null);
    stringList2.add("Stratus");
    stringList2.add("Vertical Growth");
    stringList2.add("Special Clouds");
    stringList2.add(null);
    System.out.println("List  : " + stringList2);
    System.out.println("List toString() : " + stringList2.toString());
    
    String stringListJoinedSkipNull = stringList2.stream().filter(Objects::nonNull).collect(Collectors.joining(","));   
    // assertEquals("Cirrus,Alto,Stratus," + "Vertical Growth,Special Clouds", stringListJoined2);
    System.out.println("List Joined  skip null : " + stringListJoinedSkipNull);
    
    /** Join list replacing null */ 
    String stringListJoinedReplaceNull = stringList2.stream()
    		.map(s -> { return s == null ? "[unknown]" : s; })
    		.collect(Collectors.joining(" and "));

    // assertEquals("Cirrus and Alto and [unknown] and [unknown] " + "and Stratus and Vertical Growth "+ "and Special Clouds and [unknown]", stringListJoinedReplaceNull);
    System.out.println("List Joined  skip null : " + stringListJoinedReplaceNull);
	
	}

}

/*
  En java les strings sont des objets immuables = non mutable = ils ne sont pas modifiables
  lorsqu'on construit une string en ajoutant des caractères à chaque fois on recrée une nouvelle instance de string
  
  objet de type StringBuffer et StringBuilder est mutable (sa valeur peut changer au cours du temps).
  
  L’utilisation de l’opérateur ‘+’ doit donc être limitée à la concaténation de 2 ou 3 opérandes.
  utiliser StringBuilder ( pas « thread-safe ».) et ses méthodes append() ou StringBuffer ( à préférez si pas de synchronisation )
  Dans tous les autres cas, il est conseillé d’utiliser un StringBuilder
  
  StringBuffer : est synchronisé pour garantir que les caractères seront insérés dans l'ordre chronologique des appels aux méthodes  append() ou insert().
  environnement multithreadé
  
  StringBuilder : n'est pas synchronisé (on y gagne en performance) mais il n'y a plus de garantie quand à la cohérence de la chaine obtenue à la fin.
  mais pas de soucis tant qu'on travaille à l'intérieur d'un seul thread (ce qui est le cas la plupart du temps). 
  C'est donc cette classe qu'il faut privilégier pour construire une séquence de caractère.
  
  StringJoiner :
  
  
 */
