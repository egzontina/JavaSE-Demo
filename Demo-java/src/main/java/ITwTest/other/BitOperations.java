package ITwTest.other;

public class BitOperations {

	public static void main(String[] args) {
			
		int x;
			int i = 0;
			
			
			
			// op�rteur bit � bit 
			
			int a = 1 & 7;
			System.out.println("a : " + a);
			// & : ET bit-�-bit : Retourne 1 si les deux bits de m�me poids sont � 1
			// 9 & 12 (1001 & 1100) = 8 (1000)
			int b = 9 & 12; 
			
			// OU exclusif
			// Retourne 1 si l'un des deux bits de m�me poids est � 1 (mais pas les deux)
			// 9 ^ 12 (1001 ^ 1100) = 5 (0101)
			int c = 3 ^ 6;
			
			// http://www.commentcamarche.net/contents/561-java-les-operateurs
			
			System.out.println("b : " + b);
			System.out.println("c : " + c);
			
			// | : Retourne 1 si l'un ou l'autre des deux bits de m�me poids est � 1 (ou les deux)
			// 9 | 12 (1001 | 1100) = 13 (1101)
			x = 9 | 12;
			System.out.println("9 | 12 :  " + x);
			
			// ^ : OU exclusif : Retourne 1 si seulement l'un des deux bits de m�me poids est � 1 (mais pas les deux)
			// 9 ^ 12 (1001 ^ 1100) = 5 (0101)
			x = 9 ^ 12;
			System.out.println("9 ^ 12 : " + x);
			
			// Les op�rateurs de rotation de bit � bit
			
			// <<
			// Rotation � gauche
			// D�cale les bits vers la gauche (multiplie par 2 � chaque d�calage). 
			// Les bits qui sortent � gauche sont perdus, tandis que des z�ros sont ins�r�s � droite
			// 6 << 1 (110 << 1) = 12 (1100)
			x = 6 << 1;
			System.out.println(" 6 << 1 : " + x);
			

			// >>	Rotation � droite avec conservation du signe
			// D�cale les bits vers la droite (divise par 2 � chaque d�calage). Les bits qui sortent � droite sont perdus, tandis que le bit non-nul de poids plus fort est recopi� � gauche
			// 6 >> 1 (0110 >> 1) = 3 (0011)
			
			// >>> Rotation � droite avec remplissage de z�ros
			// D�cale les bits vers la droite (divise par 2 � chaque d�calage). Les z�ros qui sortent � droite sont perdus, tandis que des z�ros sont ins�r�s � gauche
			// 3 >>> 1 (0011 >>> 1) = 1 (0001)
			
			// incr�mentation
			int x1 = 7;
			int x2 = 7;
			int y1 = x1++; // y est initialis� � 7, puis x est incr�ment� � 8
			int y2 = ++x2; // x est incr�ment� � 8, puis y est initialis� � 8
			System.out.println("x2 : " + x1);
			System.out.println("x++ : " + y1);
			System.out.println("x2 : " + x2);
			System.out.println("++x : " + y2);
			
			
			// op�ration bit � bit
			// & : ET bit-�-bit : Retourne 1 si les deux bits de m�me poids sont � 1
	}

}
