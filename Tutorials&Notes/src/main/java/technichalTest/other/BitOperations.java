package technichalTest.other;

public class BitOperations {

	public static void main(String[] args) {
			
		int x;
			int i = 0;
			
			
			
			// opérteur bit à bit 
			
			int a = 1 & 7;
			System.out.println("a : " + a);
			// & : ET bit-à-bit : Retourne 1 si les deux bits de même poids sont à 1
			// 9 & 12 (1001 & 1100) = 8 (1000)
			int b = 9 & 12; 
			
			// OU exclusif
			// Retourne 1 si l'un des deux bits de même poids est à 1 (mais pas les deux)
			// 9 ^ 12 (1001 ^ 1100) = 5 (0101)
			int c = 3 ^ 6;
			
			// http://www.commentcamarche.net/contents/561-java-les-operateurs
			
			System.out.println("b : " + b);
			System.out.println("c : " + c);
			
			// | : Retourne 1 si l'un ou l'autre des deux bits de même poids est à 1 (ou les deux)
			// 9 | 12 (1001 | 1100) = 13 (1101)
			x = 9 | 12;
			System.out.println("9 | 12 :  " + x);
			
			// ^ : OU exclusif : Retourne 1 si seulement l'un des deux bits de même poids est à 1 (mais pas les deux)
			// 9 ^ 12 (1001 ^ 1100) = 5 (0101)
			x = 9 ^ 12;
			System.out.println("9 ^ 12 : " + x);
			
			// Les opérateurs de rotation de bit à bit
			
			// <<
			// Rotation à gauche
			// Décale les bits vers la gauche (multiplie par 2 à chaque décalage). 
			// Les bits qui sortent à gauche sont perdus, tandis que des zéros sont insérés à droite
			// 6 << 1 (110 << 1) = 12 (1100)
			x = 6 << 1;
			System.out.println(" 6 << 1 : " + x);
			

			// >>	Rotation à droite avec conservation du signe
			// Décale les bits vers la droite (divise par 2 à chaque décalage). Les bits qui sortent à droite sont perdus, tandis que le bit non-nul de poids plus fort est recopié à gauche
			// 6 >> 1 (0110 >> 1) = 3 (0011)
			
			// >>> Rotation à droite avec remplissage de zéros
			// Décale les bits vers la droite (divise par 2 à chaque décalage). Les zéros qui sortent à droite sont perdus, tandis que des zéros sont insérés à gauche
			// 3 >>> 1 (0011 >>> 1) = 1 (0001)
			
			// incrémentation
			int x1 = 7;
			int x2 = 7;
			int y1 = x1++; // y est initialisé à 7, puis x est incrémenté à 8
			int y2 = ++x2; // x est incrémenté à 8, puis y est initialisé à 8
			System.out.println("x2 : " + x1);
			System.out.println("x++ : " + y1);
			System.out.println("x2 : " + x2);
			System.out.println("++x : " + y2);
			
			
			// opération bit à bit
			// & : ET bit-à-bit : Retourne 1 si les deux bits de même poids sont à 1
	}

}
