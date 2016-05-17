package technichalTest.cpeLyon.ds1.part3;

public class Spectateur {

	//… Attributes 
	
	private int age;
	private double argentDePoche;
	
	//… contructors 
	
	public Spectateur() {
	}

	public Spectateur(int age, double argentDePoche) {
		super();
		this.age = age;
		this.argentDePoche = argentDePoche;
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
	
	
	
}
