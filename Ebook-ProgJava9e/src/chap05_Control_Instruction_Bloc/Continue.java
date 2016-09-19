package chap05_Control_Instruction_Bloc;

import Annexe_Utils.Clavier;

public class Continue {
    public static void main(String args[]) {
        continue1();
        // continue2();
    }

    public static void continue1() {
        int i;
        for (i = 1; i <= 5; i++) {
            System.out.println("debut tour " + i);
            if (i < 4)
                continue;
            System.out.println("fin tour  " + i);
        }
        System.out.println("apres la boucle");
    }

    public static void continue2() {
        double x;
        do {
            System.out.print("donnez un flottant > 0 (0 pour finir) : ");
            x = Clavier.lireDouble();
            if (x < 0) {
                System.out.println(" ce nombre n'est pas > 0");
                continue;
            }
            System.out.println(" Sa racine est " + Math.sqrt(x));
        } while (x != 0);
    }

}
