package technichalTest.eurogiciel;

public class Exo1 {

	/**
	 * Fizz buzz avec five et seven à la place
	 * afficher le résultat en une chaine de caractère 
	 * @param args
	 */
	public static void main(String[] args) {
		afficherCompteur();
	}
	
	public static void afficherCompteur() {
		StringBuilder builder = new StringBuilder(1000);
        for (int i = 1; i <= 100; i++) {
            
        	final int length = builder.length();
            
        	if (i % 5 == 0) builder.append("five");
            if (i % 7 == 0) builder.append("seven");
            
            if (length == builder.length()) { 
            	builder.append(i); 
            } 
            builder.append(" ");
        }
        System.out.println(builder);
	}
	
	
}
