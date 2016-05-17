package technichalTest.cpeLyon.ds1.part1;

public abstract  class FigureGeometrique {

	protected String couleurContour = "magenta";
    protected String couleurSurface = "jaune";

    private static int nbFigures = 0;

    FigureGeometrique() {
    }

    FigureGeometrique(String coulSurf, String coulCont) {
        couleurSurface = coulSurf;
        couleurContour = coulCont;
        nbFigures++;
    }

    FigureGeometrique(FigureGeometrique autre) {
    	this(autre.couleurSurface, autre.couleurContour);
    }


    //… Dessiner
    
    public  void dessine(){
        System.out.println("Une forme " + couleurSurface);
    }
    
    //… les getters et setters des attributs 
    
	public String getCouleurContour() {
		return couleurContour;
	}

	public void setCouleurContour(String couleurContour) {
		this.couleurContour = couleurContour;
	}

	public String getCouleurSurface() {
		return couleurSurface;
	}

	public void setCouleurSurface(String couleurSurface) {
		this.couleurSurface = couleurSurface;
	}

	public static int getNbFigures() {
		return nbFigures;
	}

	public static void setNbFigures(int nbFigures) {
		FigureGeometrique.nbFigures = nbFigures;
	}

    
}
