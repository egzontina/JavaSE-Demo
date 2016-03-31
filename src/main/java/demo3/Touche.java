package demo3;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * La classe Touche qui modélisera une touche du clavier graphique
 * 
 * @author Malick
 *
 */
public class Touche extends Parent {

	// lettre de la touche, c'est une variable public pour qu'elle puisse être
	// lue depuis les autres classes
	public String lettre;
	// abscisse et ordonnée de la touche
	private int positionX = 0;
	private int positionY = 0;
	// note correspond au numéro MIDI de la note qui doit être jouée quand on
	// appuie sur la touche
	private int note = 0;
	
    private Instru instru;//on déclare un objet de type Instru


	Rectangle fond_touche;
	Text lettre_touche;

	public Touche(String l, int posX, int posY, int n, Instru ins) {
		lettre = new String(l);
		positionX = posX;
		positionY = posY;
		note = n;
        instru = ins;//l'objet de type instru prend la valeur de l'objet passé en paramètre


		fond_touche = new Rectangle(75, 75, Color.WHITE);
		fond_touche.setArcHeight(10);
		fond_touche.setArcWidth(10);
		
		// Light.Distant light = new Light.Distant();
		// light.setAzimuth(-45.0);
		// Lighting li = new Lighting();
		// li.setLight(light);
		// fond_touche.setEffect(li);
		
		// ajout du rectangle de fond de la touche
		this.getChildren().add(fond_touche);

		lettre_touche = new Text(lettre);
		lettre_touche.setFont(new Font(25));
		lettre_touche.setFill(Color.GREY);
		lettre_touche.setX(25);
		lettre_touche.setY(45);
		// ajout de la lettre de la touche
		this.getChildren().add(lettre_touche);

		// positionnement de la touche sur le clavier
		this.setTranslateX(positionX);
		this.setTranslateY(positionY);
		
		this.setOnMouseEntered(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                fond_touche.setFill(Color.LIGHTGREY);
            }
        });
        this.setOnMouseExited(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                fond_touche.setFill(Color.WHITE);
            }
        });
        this.setOnMousePressed(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                appuyer();
            }
        });
        this.setOnMouseReleased(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                relacher();
            }
        });
    }
	
	/**
	 * Appuie sur la touche
	 */
    public void appuyer(){
        fond_touche.setFill(Color.DARKGREY);
        this.setTranslateY(positionY+2);
        instru.note_on(note);

    }
    
    /**
     * Relachement de latouche
     */
    public void relacher(){
        fond_touche.setFill(Color.WHITE);
        this.setTranslateY(positionY);
        instru.note_off(note);

    }
    
	
}
