package algorithm;

/**
 * Java program to find all permutations of a given String using recursion and
 * loop. For example, given a String "XYZ", this program will print all 6
 * possible permutations of * input e.g. XYZ, XZY, YXZ, YZX, ZXY, XYX
 * 
 *  un annagramme c’est juste un élément de l’ensemble de toutes les permutations possibles d’une chaine de caractères donnée. 
 *  
 *  Une permutation circulaire, c'est un décalage, dont l'élément "poussé hors du tableau" est réinséré de l'autre côté.
 */

public class StringAnagramPermutations {

	public static void main(String args[]) {
		
		System.out.println("PERMUTATION \n");
		permutation("123");
		
		// FIXME to debug
		System.out.println("ANAGRAME \n");
		anagram1("ABC", 0);
	} 
	
	/** 
	 * A method exposed to client to calculate permutation of String in Java.
	 */
	public static void permutation(String input) {
		permutation("", input);
	} 
	
	/**  Recursive method which actually prints all permutations of given
	 * String, but since we are passing an empty String as current permutation
	 * to start with, I have made this method private and didn't exposed it to
	 * client.
	 */

	private static void permutation(String perm, String word) {
		if (word.isEmpty()) {
			System.err.println(perm + word);
		} else {
			for (int i = 0; i < word.length(); i++) {
				permutation(
						perm + word.charAt(i),
						word.substring(0, i)
								+ word.substring(i + 1, word.length()));

			}
		}
	}
	
	
	// cherche les anagrammes de l’ensemble des caracteres situés à partir de la position first jusqu’à la position n
	private static void anagram1(String word, int first) {
		// Fixer la lettre à la position de départ,
		// Trouver toutes les permutations circulaires à partir de cette lettre jusq’à la dernière
		// Et pour chaque permutation, chercher les anagrammes à partir de la lettre suivante
					
		char T[] = word.toCharArray();
			
        if ((T.length - first) <= 1){
            System.out.println(T);
          }else {
            for (int i = 0; i < T.length-first ; i++) {
            anagramRound(T, first);
            anagram1(word, first+1);
            }
          }
	}
	// permet de faire une permutation circulaire, a partir de la position i du tableau.
	private static void anagramRound(char T[],int i){
	    //  Sauvegarder le premier element  
		char temp = T[i];
		// Decaler tous les elements d’un rang vers la gauche, a partir de la position i+1
	      for(int j=i;j < T.length-1;j++){
	          T[j] = T[j+1];

	      }
	      // Remettre le premier element à la dernière position
	      T[T.length-1]= temp;
	}
	
}
