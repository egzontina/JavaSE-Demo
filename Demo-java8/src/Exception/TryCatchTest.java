package Exception;

public abstract class TryCatchTest {
	public static void main(String[] args){
		  try {
		    System.out.println(" =>" + (1/0));
		  } catch (ClassCastException e) {
		    e.printStackTrace();
		  }
		  // lorsque vous devez vous assurer d'avoir fermé un fichier, clos votre connexion à une base de données ou un socket (une connexion réseau). 
		  finally{
		    System.out.println("action faite systématiquement");
		  }
		}
}
