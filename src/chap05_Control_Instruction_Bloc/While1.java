package chap05_Control_Instruction_Bloc;

import chap04_Operator_Expression.Clavier;

public class While1 {
	public static void main(String args[]) {
		int n, som;
		som = 0;
		while (som < 100) {
			System.out.print("donnez un nombre : ");
			n = Clavier.lireInt();
			som += n;
		}
		System.out.println("Somme obtenue : " + som);
	}
}
