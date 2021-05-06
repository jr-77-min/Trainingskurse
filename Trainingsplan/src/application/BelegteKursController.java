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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BelegteKursController implements Initializable {
	@FXML private Button btnback;
	@FXML private Label date;
	@FXML private Label zeit;
	@FXML private Label lbstatus;
	@FXML private Label lbID;
	@FXML private Label lbMitglied;
	
	@FXML private Label lbZeiten;
	@FXML private Label lbMontag;
	@FXML private Label lbDienstag;
	@FXML private Label lbMittwoch;
	@FXML private Label lbDonnerstag;
	@FXML private Label lbFreitag;
	
	@FXML private Label lb0;
	@FXML private Label lb1;
	@FXML private Label lb2;
	@FXML private Label lb3;
	@FXML private Label lb4;
	@FXML private Label lb5;
	@FXML private Label lb6;
	@FXML private Label lb7;
	@FXML private Label lb8;
	@FXML private Label lb9;
	@FXML private Label lb10;
	@FXML private Label lb11;
	@FXML private Label lb12;
	@FXML private Label lb13;
	@FXML private Label lb14;
	@FXML private Label lb15;
	@FXML private Label lb16;
	@FXML private Label lb17;
	@FXML private Label lb18;
	@FXML private Label lb19;
	@FXML private Label lb20;
	@FXML private Label lb21;
	@FXML private Label lb22;
	@FXML private Label lb23;
	
	DatenbankVerbindung s = new DatenbankVerbindung();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		lbZeiten.setText("Zeiten");
		lbMontag.setText("Montag");
		lbDienstag.setText("Dienstag");
		lbMittwoch.setText("Mittwoch");
		lbDonnerstag.setText("Donnerstag");
		lbFreitag.setText("Freitag");
		
		
		s.startVerbindung();
		
		lbstatus.setText("Status");
		lbID.setText(s.getId());
		lbMitglied.setText(s.getVor());
		
		btnback.setText("Zurück");
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
	public void actionBack() {
		Stage stage;
		Parent root;
		stage = (Stage)btnback.getScene().getWindow();
		try {
			root = FXMLLoader.load(getClass().getResource("Profil.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	@FXML
	private void auswahlKurs() {
		Stage stage = new Stage();
		stage.setTitle("KursUebersicht");
		stage.show();
		try {
			new KursUebersicht().start(stage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
