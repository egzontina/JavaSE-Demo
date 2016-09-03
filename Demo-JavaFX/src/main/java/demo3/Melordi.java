package demo3;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Melordi extends Application {

	public static void main(String[] args) {
		Application.launch(Melordi.class, args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Melordi");

		Group root = new Group();
		Scene scene = new Scene(root, 500, 500, Color.WHITE);

		Instru mon_instru = new Instru();
		// mon_instru.note_on(65);

		// on créé un objet clavier
		Clavier mon_clavier = new Clavier(mon_instru);
		root.getChildren().add(mon_clavier);

		ChangeInstru mon_changeinstru = new ChangeInstru(mon_instru);
        root.getChildren().add(mon_changeinstru);
        
        Son mon_son = new Son(mon_clavier);
        mon_instru.volume.bind(mon_son.slider.valueProperty());//on lie les deux paramètres
        root.getChildren().add(mon_son);
        
        Metronome mon_metronome = new Metronome();
        root.getChildren().add(mon_metronome);
        
		primaryStage.setScene(scene);
		primaryStage.show();

		// on donne le focus à notre objet mon_clavier
		mon_clavier.requestFocus();

	}
}
