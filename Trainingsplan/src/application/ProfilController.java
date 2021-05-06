package application;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ProfilController implements Initializable {
	@FXML Button btnback;
	@FXML Button btnsta;
	@FXML Button btncourse;
	
	@FXML private Label lbVorname;
	@FXML private Label lbNachname;
	@FXML private Label lbGeburtstag;
	@FXML private Label lbStraße;
	@FXML private Label lbWohnort;
	@FXML private Label lbMitgliedSeit;
	@FXML private Label getVor;
	@FXML private Label getNach;
	@FXML private Label getGeb;
	@FXML private Label getStr;
	@FXML private Label getWohn;
	@FXML private Label getMitSeit;
	@FXML private Label date;
	@FXML private Label zeit;
	
	@FXML private ImageView profilbild;
	@FXML private Pane profPane;
	@FXML private Pane bildPane;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
		date.setText(df.format(new GregorianCalendar().getTime()));
		
		lbVorname.setText("Vorname:");
		lbNachname.setText("Nachname:");
		lbGeburtstag.setText("Geburtstag:");
		lbStraße.setText("Straße:");
		lbWohnort.setText("Wohnort:");
		lbMitgliedSeit.setText("Mitglied seit:");
		
		btnsta.setText("Statistik");
		btncourse.setText("Meine Kurs");
		btnback.setText("Zurück");
		
		DatenbankVerbindung s = new DatenbankVerbindung();
		s.startVerbindung();
		
//		String sDate1 = s.getGeb();
//		try {
//			Date date1 = new SimpleDateFormat("dd.MM.yyyy").parse(sDate1);
//			String sdate = date1.toString();
//			getGeb.setText(sdate);
//		} catch (ParseException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
	    getVor.setText(s.getVor());
	    getNach.setText(s.getNach());
	    getGeb.setText(s.getGeb());
	    getStr.setText(s.getStr()+" "+s.getHnr());
	    getWohn.setText(s.getWohn());
	    getMitSeit.setText("19.04.2020");
	    
		Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {        
	        LocalTime currentTime = LocalTime.now();
	        zeit.setText(currentTime.getHour() + ":" + currentTime.getMinute() + ":" + currentTime.getSecond());
	    }),
	         new KeyFrame(Duration.seconds(1))
	    );
	    clock.setCycleCount(Animation.INDEFINITE);
	    clock.play();
	    //sqlVerbinden();
	}
	@FXML
	public void actionSta(ActionEvent e) {
		Stage stage;
		Parent root;
		stage = (Stage)btnsta.getScene().getWindow();
			try {
				root = FXMLLoader.load(getClass().getResource("Statistik.fxml"));
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.sizeToScene();
				stage.show();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	}
	@FXML
	public void actionKurse(ActionEvent e) {
		Stage stage;
		Parent root;
		stage = (Stage)btncourse.getScene().getWindow();
		try {
			root = FXMLLoader.load(getClass().getResource("KursKalender.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.sizeToScene();
			stage.show();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	}
	@FXML
	public void actionBack(ActionEvent e) {
		Stage stage;
		Parent root;
		stage = (Stage)btnback.getScene().getWindow();
		try {
			root = FXMLLoader.load(getClass().getResource("Hauptmenue.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.sizeToScene();
			stage.show();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	}
}
