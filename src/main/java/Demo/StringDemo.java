package Demo;
import java.util.StringJoiner;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringDemo {

	public static void main(String[] args) {
		
		String newLine = System.getProperty("line.separator");
		
		// Stream Un stream sur les lettres qui composent une String 
		String s = "bonjour" ;		 
		IntStream stream = s.chars() ;
		System.out.println("stream foreach map :") ;
//		stream.forEach(System.out::println);  // NOT OK	
//		stream.map(Character::toUpperCase).forEach(System.out::print) ; // NOT OK
		stream.map(Character::toUpperCase).mapToObj(c -> (char)c).forEach(System.out::print); // ok
		System.out.println(newLine);
		s.chars().map(Character::toUpperCase).forEach(c -> System.out.print((char)c)); // mieux
		System.out.println(newLine);
				
		
		// expressions régulières Construction de Stream à partir d’une regexp
		// book est une grrrande chaîne 
		// TODO
//		Stream<String> words = Pattern.compile("[^p{javaLetter}]") .splitAsStream(book) ;
		
		// concaténation Le spécialiste Java 8 écrit 
		StringJoiner sj = new StringJoiner(", ") ; 
		sj.add("one").add("two").add("three") ; 
		String s1 = sj.toString() ; 
		System.out.println("sj : " + s1) ;
		
		System.out.println(newLine);
		
		StringJoiner sj3 = new StringJoiner(", ", "{", "}") ; 
		sj3.add("one").add("two").add("three") ; 
		String s3 = sj3.toString() ; 
		System.out.println("sj3 : " + s3) ;
		
		System.out.println(newLine);
		
		StringJoiner sj4 = new StringJoiner(", ", "{", "}") ; 
		// on ne met rien dedans 
		String s4 = sj4.toString() ; 
		System.out.println("sj4 : " + s4) ;
		
		System.out.println(newLine);
		
		// concaténation S’utilise aussi à partir de String directement Ce qui affiche 
		// From the String class, with a vararg 
		String s5 = String.join(", ", "one", "two", "three"); 
		System.out.println("s5 : " + s5) ; 
		String s6 = String.join(", ", "{",  "one", "two", "three", "}"); 
		System.out.println("s6 : " + s6) ; 
		// From the String class, with an Iterable 
		String [] tab = {"one", "two", "three"} ; 
		String s7 = String.join(", ", tab) ; 
		System.out.println("s7 : " + s7) ;
		
		String s8 = String.join(" ", "one", "two", "three"); 
		System.out.println("s8 : " + s8) ;
		
		
		/** parsing string */
		
		
	}

}
