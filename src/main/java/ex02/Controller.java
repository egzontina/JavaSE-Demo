package ex02;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ex02.service.YahooService;
import ex02.service.dtos.HistoricQuote;
import ex02.service.dtos.YahooResponse;

/**
 * Controlleur de la scene définit dans screen
 * 
 * implémenter Initializable permet de lancer la méthode initialize() à
 * l’instanciation de la classe
 * 
 * @author Malick
 */
public class Controller implements Initializable {

	@FXML
	private TextField code;

	@FXML
	private ChoiceBox duration;

	@FXML // bind le tableau definit dans le xml par l'id "tableView"
	private TableView<HistoricQuote> tableView;

	@FXML // bind date column to format it
	private TableColumn columnDate;

	@FXML
	private HBox hboxTable;

	@FXML
	private HBox hboxGraph;

	private YahooService yahooService;

	private ExecutorService executorService;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		yahooService = new YahooService();
		// format date column
		columnDate.setCellValueFactory(value -> new SimpleStringProperty(new SimpleDateFormat("dd-MM-yyyy")
				.format(((HistoricQuote) ((TableColumn.CellDataFeatures) value).getValue()).getDate())));
	}

	/**
	 * Action effectuée au clic sur le button run
	 * 
	 * @param event
	 */
	public void run(ActionEvent event) {

		// Fênetre de loading
		final Stage progressBar = openLoadingWindow();

		executorService = Executors.newSingleThreadExecutor();

		// définit une TÄCHE Runnable
		Task<YahooResponse> task = new Task<YahooResponse>() {
			@Override
			protected YahooResponse call() throws Exception {
				// appel au service de Yahoo en récupérant les données saisies
				// dans le formulaire
				return yahooService.getHistoric(code.getText(), (Integer) duration.getValue());
			}
		};
		// si la tâche échoue, on ferme la fenêtre de loading
		task.setOnFailed(workerStateEvent -> getResponse(progressBar, false));
		// si la tâche réussie, on ferme la fenêtre de loading et on remplit le tableau et le graphique
		task.setOnSucceeded(workerStateEvent -> {
			YahooResponse yahooResponse = (YahooResponse) workerStateEvent.getSource().getValue();
			if (yahooResponse != null && yahooResponse.getQuery().getCount() > 0) {
				getResponse(progressBar, true);
				List<HistoricQuote> quotes = yahooResponse.getQuery().getResults().getQuote();
				fillTableView(quotes);

				quotes.sort((h1, h2) -> {
					if (h1.getDate().getTime() == h2.getDate().getTime())
						return 0;
					return h1.getDate().getTime() < h2.getDate().getTime() ? -1 : 1;
				});

				fillGraph(quotes);
			} else
				getResponse(progressBar, false);
		}

		);
		executorService.submit(task);
		executorService.shutdown();
	}

	/**
	 * appelé dans la méthode run()
	 * 
	 * @param quotes
	 *            : la liste des valeurs retournée par le service de Yahoo.
	 * 
	 */
	private void fillGraph(List<HistoricQuote> quotes) {
		// FXCollections qui sera la liste des séries de notre graphique
		ObservableList<XYChart.Series<String, Float>> lineChartData = FXCollections.observableArrayList();

		final XYChart.Series<String, Float> series = createSerie(quotes);
		lineChartData.add(series);

		// Création de l’axe des Y
		NumberAxis yAxis = createYAxis(quotes);
		// Création de l’axe des X qui sera une simple suite de String; un point
		// étant égal à une date
		final CategoryAxis xAxis = new CategoryAxis();
		xAxis.setLabel("Temps");
		// Création du graphique
		LineChart chart = new LineChart(xAxis, yAxis, lineChartData);
		chart.setPrefWidth(1010);
		chart.setPrefHeight(400);
		// On clean la HBox créé dans le FXML pour éviter l’empilement de
		// graphique à chaque run
		hboxGraph.getChildren().clear();
		// Ajout du graphique à la HBox
		hboxGraph.getChildren().add(chart);
	}

	/**
	 * Création de l'axe Y en lui spécifiant le point minimum et maximum du
	 * graphique ainsi que l’unité entre deux graduations
	 * 
	 * @param quotes
	 * @return
	 */
	private NumberAxis createYAxis(List<HistoricQuote> quotes) {
		Optional<HistoricQuote> max = quotes.stream().max((h1, h2) -> {
			if (h1.getHigh() == h2.getHigh())
				return 0;
			return h1.getHigh() < h2.getHigh() ? -1 : 1;
		});
		Optional<HistoricQuote> min = quotes.stream().min((h1, h2) -> {
			if (h1.getLow() == h2.getLow())
				return 0;
			return h1.getHigh() < h2.getHigh() ? -1 : 1;
		});
		return new NumberAxis("Variation", min.get().getLow(), max.get().getHigh(), 0.2);
	}

	/**
	 * Création d’une série de point (XY)
	 * 
	 * @param quotes
	 * @return
	 */
	private XYChart.Series<String, Float> createSerie(List<HistoricQuote> quotes) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		// nouvelle FXCollections qui va contenir la liste des points de la
		// courbe
		final ObservableList<XYChart.Data<String, Float>> observableList = FXCollections.observableArrayList();
		quotes.stream().forEach(historic -> {
			// Chaque point est créé avec la date en X et les prix de cloture en
			// Y
			XYChart.Data<String, Float> data = new XYChart.Data<String, Float>(dateFormat.format(historic.getDate()),
					historic.getClose());
			// ajout du point à la liste
			observableList.add(data);
		});
		// Création de la série avec un titre et la liste des points
		return new XYChart.Series<String, Float>("Evolution du cours", observableList);
	}

	private void fillTableView(List<HistoricQuote> quotes) {
		// La création de notre FXCollections (avec le même type que la
		// TableView)
		final ObservableList<HistoricQuote> items = FXCollections.observableArrayList();
		// L’ajout des cinq éléments voulus
		quotes.stream().limit(5l).forEach(historic -> items.add(historic));
		// L’ajout de la liste dans le tableau
		tableView.setItems(items);
	}

	/**
	 * Barre de progression à l'appel du web service
	 * 
	 * @return
	 */
	private Stage openLoadingWindow() {
		final Stage progressBar = new Stage();
		progressBar.initModality(Modality.WINDOW_MODAL);
		progressBar.initOwner(code.getScene().getWindow());
		progressBar.setScene(new Scene(new Group(JfxUtils.loadFxml("/fxml/ex02/loading.fxml"))));
		progressBar.show();
		return progressBar;
	}

	private void getResponse(Stage progressBar, boolean visible) {
		progressBar.close();
		hboxTable.setVisible(visible);
		hboxGraph.setVisible(visible);
	}

}
