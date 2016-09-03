package Demo;
public class StructureConditionnelle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/** ==================================== La structure if… else ==================================== */
		int i = 58;
		if(i < 100 && i > 100) { 
		  System.out.println("Le nombre est bien dans l'intervalle.");
		} else {
		  System.out.println("Le nombre n'est pas dans l'intervalle.");
		}
		
		/** ==================================== La structure switch... case ... default ==================================== */
		int note = 10;
		switch (note){
		  case 0:
		    System.out.println("Ouch !");
		    break;
		  case 10:
		    System.out.println("Vous avez juste la moyenne.");
		    break;
		  case 20:
		    System.out.println("Parfait !");
		    break;
		  default:
		    System.out.println("Il faut davantage travailler.");
		}
		
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
		
		/** ==================================== La condition ternaire ==================================== */		
		int x = 10, y = 20;
		
		int max = (x < y) ? y : x ; //Maintenant, max vaut 20
		System.out.println("max : " + max);
		
		max = (x < y) ? ((y < 10) ? y % 10 : y * 2) : x ; //Max vaut 40
		System.out.println("max : " + max);
	}

}
