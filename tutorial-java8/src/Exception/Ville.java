package Exception;

public class Ville {

	//throws NombreHabitantException nous indique que si une erreur est capturée, celle-ci sera traitée en tant qu'objet de la classe NombreHabitantException
	public Ville(String pNom, int pNbre, String pPays) throws  NombreHabitantException,  NomVilleException
			  {  
			    if(pNbre < 0)
			        throw new NombreHabitantException(pNbre); 
			    //throws : ce mot clé permet de signaler à la JVM qu'un morceau de code, une méthode, une classe… est potentiellement dangereux et qu'il faut utiliser un bloc try{…}catch{…}.
			    if(pNom.length() < 3)
			        throw new NomVilleException("le nom de la ville est inférieur à 3 caractères ! nom = " + pNom);
			    else
			    {
//			      nbreInstance++;  
//			      nbreInstanceBis++;
//
//			      nomVille = pNom;
//			      nomPays = pPays;
//			      nbreHabitant = pNbre;
//			      this.setCategorie();
			    }
			  }
	
	public static void main(String[] args)
	{
	  Ville v = null;
	  try {                   
	    v = new Ville("Rennes", 12000, "France");         
	  } 
	//Gestion de plusieurs exceptions différentes
	  catch (NombreHabitantException | NomVilleException e2){ 
	    System.out.println(e2.getMessage());		     
	  }
	  finally{
	    if(v == null) {
//	      v = new Ville();
	    }
	  }
	  System.out.println(v.toString());
	}
	
}
