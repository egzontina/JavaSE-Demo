package demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * ”Hello World” application
 * 
 * @author Malick
 *
 */
public class HelloWorld extends Application {

	/**
	 * main() method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * The start() method is the main entry point for all JavaFX applications.
	 */
	@Override
	public void start(Stage primaryStage) {

		// primaryStage = windows = Stage class is the top-level JavaFX user
		// interface container

		// button, child node
		Button btn = new Button();
		btn.setText("Say 'Hello World'");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Hello World!");
			}
		});

		// StackPane = the root node
		StackPane root = new StackPane();
		root.getChildren().add(btn);

		// Scene class is the container for all content
		// represented as a hierarchical scene graph of nodes
		Scene scene = new Scene(root, 300, 250);

		primaryStage.setTitle("Hello World!");
		primaryStage.setScene(scene);
		// makes the scene visible in a given pixel size
		primaryStage.show();
	}

}
