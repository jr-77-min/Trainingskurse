package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class KursUebersichtController extends DatenbankVerbindung implements Initializable {
	@FXML private Label titel;
	@FXML private Label status;
	@FXML private Label trainer;
	@FXML private Label geraete;
	@FXML private Label uhrzeit;
	@FXML private Label dauer;
	@FXML private Label raum;
	@FXML private Label verfuegbarkeit;
	
	@FXML private Label getStatus;
	@FXML private Label getTrainer;
	@FXML private Label getGeraete;
	@FXML private Label getUhrzeit;
	@FXML private Label getDauer;
	@FXML private Label getRaum;
	@FXML private Label getVerfuegbarkeit;
	@FXML private Label getKursname;
	
	@FXML private Button anmelden;
	@FXML private Button abmelden;
	
	private String staanmelden;
	private String btnanmelden;
	
	private GridPane pane;
	private KalenderController grid;
	
	private DatenbankVerbindung s;
	private Pane beleg;
	
//	public String anString() {
//		String a = "";
//		if(s.getStatus() == 1) {
//			return a = "Angemeldet";
//		}else if(s.getStatus() == 0) {
//			return a = "Abgemeldet";
//		}else
//		return a; //anString()
//	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		status.setText("Status");
		getStatus.setText("Angemeldet");
		titel.setText("Kursdetails:");
		trainer.setText("Trainer:");
		geraete.setText("Geräte:");
		uhrzeit.setText("Uhrzeit:");
		dauer.setText("Dauer:");
		raum.setText("Raum:");
		verfuegbarkeit.setText("Verfügbare Plätze:");
		anmelden.setText("Anmelden");
		abmelden.setText("Abmelden");

		getTrainer.setText(getTrainer());
		getUhrzeit.setText(getStartUhrZeit());
		getGeraete.setText("/");
		getDauer.setText(getDauer());
		getRaum.setText(getRaum());
		getVerfuegbarkeit.setText(getVerPlaetze());
		getKursname.setText(getTrainFok());
		
		btnanmelden = getStatus.getText();
		staanmelden = "Angemeldet";
		if(staanmelden.equals(btnanmelden)) {
			anmelden.disableProperty();
		}
			
	}
	@FXML
	public void abAction(ActionEvent event) {
		getStatus.setText("Abgemeldet");
//		pane = (GridPane)event.getSource();
		
		
//		s.kursBelegung(s.getId(), s.getKurs_id(), s.getStatus());
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Abgemeldet");
		alert.setHeaderText(null);
		alert.setContentText("Sie haben sich erfolgreich abgemeldet!");
		alert.showAndWait();
		Stage stage;
		stage = (Stage)abmelden.getScene().getWindow();
		stage.close();
	}
	@FXML
	public void anAction(ActionEvent event) {
		getStatus.setText("Angemeldet");
		//s.belegteKurseAbmelden(s.getId(), s.getKurs_id());
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Angemeldet");
		alert.setHeaderText(null);
		alert.setContentText("Sie haben sich erfolgreich angemeldet!");
		alert.showAndWait();
		
		Stage stage;
		stage = (Stage)anmelden.getScene().getWindow();
		stage.close();
		
	}
	public void erstelleKurs() {
		beleg = new Pane();
		
		pane.setColumnIndex(beleg, grid.getTagKurs());
		pane.setRowIndex(beleg, grid.getZeitKurs());
		pane.setRowSpan(beleg, 2);
	}
}
