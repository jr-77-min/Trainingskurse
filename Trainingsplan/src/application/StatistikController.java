package application;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.time.LocalTime;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

public class StatistikController implements Initializable {
	@FXML private Label besuchteKurse;
	@FXML private Label dauerKurse;
	@FXML private Label anzahlKurse;
	@FXML private Label lieblingskurs;
	
	@FXML private Label getbesucht;
	@FXML private Label getdauer;
	@FXML private Label getanzahl;
	@FXML private Label getlieblings;
	
	@FXML private Button btnback;
	
	@FXML private Label date;
	@FXML private Label zeit;
	
	@FXML private BarChart<String, Number> bc;
	@FXML private NumberAxis xAxis;
	@FXML private CategoryAxis yAxis;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnback.setText("Zurück");
		
		besuchteKurse.setText("Anzahl besuchter Kurse");
		dauerKurse.setText("Dauer besuchter Kurse");
		anzahlKurse.setText("Anzahl besuchter Kurse letzen Monat");
		lieblingskurs.setText("Lieblingskurse");
		
		xAxis.setLabel("Anzahl");
        xAxis.setTickLabelRotation(90);
        yAxis.setLabel("Kurs");


        XYChart.Series<String, Number> series1 = new Series<String, Number>();
        XYChart.Series<String, Number> series2 = new Series<String, Number>();
        XYChart.Series<String, Number> series3 = new Series<String, Number>();
        XYChart.Series<String, Number> series4 = new Series<String, Number>();
        XYChart.Series<String, Number> series5 = new Series<String, Number>();
        XYChart.Series<String, Number> series6 = new Series<String, Number>();
        series1.getData().add(new XYChart.Data( "", 6));
        series2.getData().add(new XYChart.Data("", 5));
        series3.getData().add(new XYChart.Data("", 5));
        series4.getData().add(new XYChart.Data("", 5));
        series5.getData().add(new XYChart.Data("", 5));
        series6.getData().add(new XYChart.Data("", 5));
        bc.getData().add(series1);
        bc.getData().add(series2);
        bc.getData().add(series3);
        bc.getData().add(series4);
        bc.getData().add(series5);
        bc.getData().add(series6);

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {        
	        LocalTime currentTime = LocalTime.now();
	        zeit.setText(currentTime.getHour() + ":" + currentTime.getMinute() + ":" + currentTime.getSecond());
	    }),
	         new KeyFrame(Duration.seconds(1))
	    );
	    clock.setCycleCount(Animation.INDEFINITE);
	    clock.play();
	    
	    DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
		date.setText(df.format(new GregorianCalendar().getTime()));
		
	}
	@FXML
	public void actionBack(ActionEvent event) {
		Stage stage;
		Parent root;
		stage = (Stage)btnback.getScene().getWindow();
			try {
				root = FXMLLoader.load(getClass().getResource("Profil.fxml"));
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	}

}
