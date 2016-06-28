package chap05_Control_Instruction_Bloc;

import chap04_Operator_Expression.Clavier;

public class Do1 {
	public static void main(String args[]) {
		int n;
		do {
			System.out.print("donnez un nombre >0 : ");
			n = Clavier.lireInt();
			System.out.println("vous avez fourni " + n);
		} while (n <= 0);
		System.out.println("reponse correcte");
	}
}
