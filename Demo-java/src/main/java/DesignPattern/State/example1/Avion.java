package DesignPattern.State.example1;

public class Avion {

	private int carburant = 0;
	
	private EtatAvion etatAvion;

	/* constructeurs */
	
	public Avion() {
		// etat initial	
		etatAvion  = new AuGarage();
	}
	
	
	
	/* Getters and Setters */

	public int getCarburant() {
		return carburant;
	}



	public void setCarburant(int carburant) {
		this.carburant = carburant;
	}


	/* methodes d�l�gu�es */
	 

	public void entrerAuGrage() {
		etatAvion.entrerAuGrage();
	}



	public void sortirDuGrage() {
		etatAvion.sortirDuGrage();
	}

	public void decoler() {
		etatAvion.decoller();
	}

	public void atterir() {
		etatAvion.atterir();
	}

	public void makeAction() {
		etatAvion.makeAction();
	}

	/** Interface interne*/
	
	interface EtatAvion {
		// transition d'�tat - pilote le passage d'un �tat � l'autre
		public void entrerAuGrage();

		public void sortirDuGrage();

		public void decoller();

		public void atterir();

		// autre m�thode - ex�cute un traitement qui d�pent de l'�tat
		public void makeAction();
	}
	
	/** Classe interne*/
	
	class AuGarage implements EtatAvion {

		@Override
		public void entrerAuGrage() {
			System.out.println("Je suis d�ja au garage");
		}

		@Override
		public void sortirDuGrage() {
			System.out.println("Au Garage - Transition d'�tat du garage vers la piste");
			etatAvion = new Enpiste();
		}

		@Override
		public void decoller() {
			System.out.println("Au Garage - Impossible de d�coller");	
		}

		@Override
		public void atterir() {
			System.out.println("Au Garage - Impossible d'att�rir");
			
		}

		@Override
		public void makeAction() {
			System.out.println("Au Garage - Action ");			
		}
		
	}
	
	class Enpiste implements EtatAvion {

		@Override
		public void entrerAuGrage() {
			System.out.println("En Piste - Transition de la piste vers le garage");
			etatAvion = new AuGarage();
			
		}

		@Override
		public void sortirDuGrage() {
			System.out.println("En Piste - Impossible de sortir du garage");			
		}

		@Override
		public void decoller() {
			System.out.println("En Piste - Transition vers En lair");
			// la garde // Condition de transition
			if(carburant>500) {
				etatAvion = new EnLair();
			} else {
				System.out.println("Impossible - Quantit� carburant Insuffissant");
			}
		}

		@Override
		public void atterir() {
			System.out.println("En Piste - Impossible d'atterir");			
		}

		@Override
		public void makeAction() {
			System.out.println("En Piste - Action ");				
		}
		
	}
	
	class EnLair implements EtatAvion {

		@Override
		public void entrerAuGrage() {
			System.out.println("EnLair - Impossible d'entrer au garage");			
			
		}

		@Override
		public void sortirDuGrage() {
			System.out.println("EnLair - Impossible");			
			
		}

		@Override
		public void decoller() {
			System.out.println("EnLair - Impossible");			
		}

		@Override
		public void atterir() {
			System.out.println("EnLair - Transition vers la piste");
			etatAvion = new Enpiste();			
		}

		@Override
		public void makeAction() {
			System.out.println("EnLair - Action ");				
		}
		
	}
}
