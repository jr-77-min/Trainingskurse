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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HauptmenueController implements Initializable {
	@FXML private Label lbname;
	@FXML private Label getname;
	@FXML private Label lbdate;
	@FXML private Label zeit;
	
	@FXML private ImageView kalender;
	@FXML private ImageView profil;
	
	private DateFormat df;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		lbname.setText("Name:");
		
		DatenbankVerbindung daten = new DatenbankVerbindung();
		daten.startVerbindung();
		
		getname.setText(daten.getVor()+ " " + daten.getNach());
		df = DateFormat.getDateInstance(DateFormat.LONG);
		lbdate.setText(df.format(new GregorianCalendar().getTime()));
		
		Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {        
	        LocalTime currentTime = LocalTime.now();
	        zeit.setText(currentTime.getHour() + ":" + currentTime.getMinute() + ":" + currentTime.getSecond());
	    }),
	         new KeyFrame(Duration.seconds(1))
	    );
	    clock.setCycleCount(Animation.INDEFINITE);
	    clock.play();
	    
	    kalender.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				Stage stage;
				Parent root;
				stage = (Stage)kalender.getScene().getWindow();
					try {
						root = FXMLLoader.load(getClass().getResource("Kalender.fxml"));
						Scene scene = new Scene(root);
						stage.setScene(scene);
						stage.sizeToScene();
						stage.show();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				System.out.println("Kalender ausgewählt");
			}
		});
	    profil.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				Stage stage;
				Parent root;
				stage = (Stage)profil.getScene().getWindow();
					try {
						root = FXMLLoader.load(getClass().getResource("Profil.fxml"));
						Scene scene = new Scene(root);
						stage.setWidth(600);
						stage.setHeight(450);
						stage.setScene(scene);
						stage.show();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
			}
		});
		
	}
	
}
