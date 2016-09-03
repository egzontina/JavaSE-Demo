package technichalTest.cpeLyon.ds1.part3;

public class Spectateur {

	//… Attributes 
	
	private int age;
	private double argentDePoche;
	
	//… contructors 
	
	public Spectateur() {
		this.age = 18;
		this.argentDePoche = 10; 
		System.out.println(toString());
	}

	public Spectateur(int age, double argentDePoche) {
		this.age = age;
		this.argentDePoche = argentDePoche;
		System.out.println(toString());
	}
	
	//… getters and setters 

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getArgentDePoche() {
		return argentDePoche;
	}

	public void setArgentDePoche(double argentDePoche) {
		this.argentDePoche = argentDePoche;
	}
	
	//… toString
	
	@Override
	public String toString() {
		return "[Spectateur] (j'entre en scène :  j'ai " + age + " ans et " + argentDePoche + " euros en poche)";
	}
	

	

	
	
	
}
