package chap23_Lambda_Stream;

public class RefMethInst {
	public static void main(String[] args) {
		Point p1 = new Point(1, 3), p2 = new Point(3, 8), origine = new Point(0, 0), p = new Point(1, 2);
		DistanciableDe distOrig = origine::distance_a;
		// equivalent a : distOrig = pp -> origine.distance_a (pp) ;
		System.out.println("Distance de p1 a origine = " + distOrig.distance_a(p1));
		DistanciableDe dist_p = p::distance_a;
		// equivalent a : dist_p = pp -> p.distance_a (pp) ;
		System.out.println("Distance de p1 a p =       " + dist_p.distance_a(p2));
	}
}
