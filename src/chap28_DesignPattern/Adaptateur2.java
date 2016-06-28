package chap28_DesignPattern;
interface Pixel2 {
	void affiche();

	void deplace(int dx, int dy);
}

class PointX2 {
	public PointX2(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void montre() {
		System.out.println("Coordonnees = " + x + " " + y);
	}

	public void deltaX(int dx) {
		x += dx;
	}

	public void deltaY(int dy) {
		y += dy;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	private int x, y;
}

class PointXAdapte2 extends PointX2 implements Pixel2 {
	public PointXAdapte2(PointX2 px) {
		super(px.getX(), px.getY());
	}

	public void affiche() {
		super.montre();
	}

	public void deplace(int dx, int dy) {
		deltaX(dx);
		deltaY(dy);
	}
}

public class Adaptateur2 {
	public static void main(String args[]) { // code existant utilisant déja des
												// implementations de Pixel2
												// .....
		PointX2 px = new PointX2(3, 5);
		PointXAdapte2 pa = new PointXAdapte2(px);
		// il peut maintenant utiliser des objets de type PointX2, encapsules
		// dans
		// des objets de type PointXAdapte2, comme des implementations de Pixel2
		pa.affiche();
		pa.deplace(2, 1);
		pa.affiche();
	}
}