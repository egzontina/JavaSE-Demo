package chap05_Control_Instruction_Bloc;

import Annexe_Utils.Clavier;

public class Switch1 {
    /**
     * Main Method
     * 
     * @param args
     */
    public static void main(String[] args) {

    }

    /**
     * 
     */
    public static void switch1() {
        int n;
        System.out.print("donnez un nombre entier : ");
        n = Clavier.lireInt();
        switch (n) {
        case 0:
            System.out.println("nul");
            break;
        case 1:
            System.out.println("un");
            break;
        case 3:
            System.out.println("trois");
            break;
        }
        System.out.println("Au revoir");
    }

    /**
     * 
     */
    public static void switch2() {
        int n;
        System.out.print("donnez un nombre entier : ");
        n = Clavier.lireInt();
        switch (n) {
        case 0:
            System.out.println("nul");
        case 1:
            System.out.println("un");
        case 3:
            System.out.println("trois");
        }
        System.out.println("Au revoir");
    }

    /**
     * 
     */
    public static void switch3() {
        int n;
        System.out.print("donnez un nombre entier : ");
        n = Clavier.lireInt();
        switch (n) {
        case 0:
            System.out.println("nul");
            break;
        case 1:
        case 2:
            System.out.println("petit");
        case 3:
        case 4:
        case 5:
            System.out.println("moyen");
            break;
        default:
            System.out.println("grand");
        }
        System.out.println("Au revoir");
    }
    
    /**
     * 
     */
    public static void switch4() {
        String chaine = "Bonjour";
        switch(chaine) {
          case "Bonjour":
            System.out.println("Bonjour monsieur !");
            break;
          case "Bonsoir":
            System.out.println("Bonsoir monsieur !");
            break;
          default:
            System.out.println("Bonjoir ! :p");
        }
    }
}
