package chap11_Threads;
public class TstThr3 {
	public static void main(String args[]) {
		Ecrit3 e1 = new Ecrit3("bonjour ", 10, 5);
		Ecrit3 e2 = new Ecrit3("bonsoir ", 12, 10);
		Ecrit3 e3 = new Ecrit3("\n", 5, 15);

		Thread t1 = new Thread(e1);
		t1.start();
		Thread t2 = new Thread(e2);
		t2.start();
		Thread t3 = new Thread(e3);
		t3.start();
	}
}

class Ecrit3 implements Runnable {
	public Ecrit3(String texte, int nb, long attente) {
		this.texte = texte;
		this.nb = nb;
		this.attente = attente;
	}

	public void run() {
		try {
			for (int i = 0; i < nb; i++) {
				System.out.print(texte);
				Thread.sleep(attente); // attention Thread.sleep
			}
		} catch (InterruptedException e) {
		} // impose par sleep
	}

	private String texte;
	private int nb;
	private long attente;
}

/*
 * bonjour bonsoir bonjour bonsoir bonjour bonjour bonsoir bonjour bonjour
 * bonsoir bonjour bonjour bonsoir bonjour bonjour bonsoir bonsoir bonsoir
 * bonsoir bonsoir bonsoir bonsoir
 */
