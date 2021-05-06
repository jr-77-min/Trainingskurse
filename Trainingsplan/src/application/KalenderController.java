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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class KalenderController implements Initializable {
	@FXML private Button btnback;
	@FXML private Label date;
	@FXML private Label zeit;
	
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
	
	@FXML private Label lbID;
	@FXML private Label lbmitglied;
	@FXML private Label lbStatus;
	
	@FXML private Button btn1;
	@FXML private Button btn2;
	@FXML private Button btn3;
	@FXML private Button btn4;
	@FXML private Button btn5;
	@FXML private Button btn6;
	@FXML private Button btn7;
	@FXML private Button btn8;
	@FXML private Button btn9;
	@FXML private Button btn10;
	@FXML private Button btn11;
	@FXML private Button btn12;
	@FXML private Button btn13;
	@FXML private Button btn14;
	@FXML private Button btn15;
	@FXML private Button btn16;
	@FXML private Button btn17;
	@FXML private Button btn18;
	@FXML private Button btn19;
	@FXML private Button btn20;
	@FXML private Button btn21;
	@FXML private Button btn22;
	@FXML private Button btn23;
	@FXML private Button btn24;
	@FXML private Button btn25;
	@FXML private Button btn26;
	@FXML private Button btn27;
	@FXML private Button btn28;
	@FXML private Button btn29;
	@FXML private Button btn30;
	@FXML private Button btn31;
	@FXML private Button btn32;
	@FXML private Button btn33;
	@FXML private Button btn34;
	@FXML private Button btn35;
	
	private String wertButton;
	
	private Integer zeitKurs;
	private Integer tagKurs;
	public String getZeitK() {
		return zeitK;
	}
	public void setZeitK(String zeitK) {
		this.zeitK = zeitK;
	}
	public String getTagK() {
		return tagK;
	}
	public void setTagK(String tagK) {
		this.tagK = tagK;
	}

	private String zeitK;
	private String tagK;
	
	protected DatenbankVerbindung s;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		lbZeiten.setText("Zeiten");
		lbMontag.setText("Montag");
		lbDienstag.setText("Dienstag");
		lbMittwoch.setText("Mittwoch");
		lbDonnerstag.setText("Donnerstag");
		lbFreitag.setText("Freitag");
		
		btn1.setText("Fettverbrennung"); btn6.setText("Beweglichkeit"); btn11.setText("Krafttraining"); btn16.setText("Kraftausdauer"); btn21.setText("Fettverbrennung"); btn26.setText("Entspannung"); btn31.setText("Beweglichkeit");
		btn2.setText("Kraftausdauer"); btn7.setText("Fettverbrennung"); btn12.setText("Fettverbrennung"); btn17.setText("Entspannung"); btn22.setText("Fettverbrennung"); btn27.setText("Fettverbrennung"); btn32.setText("Ausdauer");
		btn3.setText("Ausdauer"); btn8.setText("Beweglichkeit"); btn13.setText("Entspannung"); btn18.setText("Fettverbrennung"); btn23.setText("Entspannung"); btn28.setText("Kraftausdauer"); btn33.setText("Beweglichkeit");
		btn4.setText("Entpannung"); btn9.setText("Ausdauer"); btn14.setText("Entspannung"); btn19.setText("Ausdauer"); btn24.setText("Fettverbrennung"); btn29.setText("Fettverbrennung"); btn34.setText("Ausdauer");
		btn5.setText("Ausdauer"); btn10.setText("Beweglichkeit"); btn15.setText("Fettverbrennung"); btn20.setText("Fettverbrennung"); btn25.setText("Krafttraining"); btn30.setText("Fettverbrennung"); btn35.setText("Beweglichkeit");
		
		s = new DatenbankVerbindung();
		s.startVerbindung();
		
		lbStatus.setText("Status");
		lbID.setText(s.getId());
		lbmitglied.setText(s.getVor());
		
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
	public void actionBack(ActionEvent e) {
		Stage stage;
		Parent root;
		stage = (Stage)btnback.getScene().getWindow();
		try {
			root = FXMLLoader.load(getClass().getResource("Hauptmenue.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
	}
	
	@FXML
	private void auswahlKurs(ActionEvent event) {
		Button button = (Button)event.getSource();
		wertButton = button.getText();
		zeitKurs = GridPane.getRowIndex(button);
		tagKurs = GridPane.getColumnIndex(button);
		
		if(zeitKurs == 11) {
			zeitK = "10:00";
			}else if(zeitKurs == 13) {
				zeitK = "12:00";
			}else if(zeitKurs == 15) {
				zeitK = "14:00";
			}else if(zeitKurs == 17) {
				zeitK = "16:00";
			}else if(zeitKurs == 19) {
				zeitK = "18:00";
			}else if(zeitKurs == 21) {
				zeitK = "20:00";
			}else if(zeitKurs == 23) {
				zeitK = "22:00";
			}
		
		if(tagKurs.equals(1)) {
			tagK = "Montag";
		}else if(tagKurs.equals(2)) {
			tagK = "Dienstag";
		}else if(tagKurs.equals(3)) {
			tagK = "Mittwoch";
		}else if(tagKurs.equals(4)) {
			tagK = "Donnertag";
		}else if(tagKurs.equals(5)) {
			tagK = "Freitag";
		}
		
		Stage stage = new Stage();
		stage.setTitle("KursUebersicht");
		stage.show();
		try {
			s.AbrufKurse(wertButton, zeitK, tagK);
			new KursUebersicht().start(stage);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void hoverAction(MouseEvent event) {
		
	}
	
	
	public String getWertButton() {
		return wertButton;
	}
	public Integer getZeitKurs() {
		return zeitKurs;
	}

	public void setZeitKurs(Integer zeitKurs) {
		this.zeitKurs = zeitKurs;
	}

	public Integer getTagKurs() {
		return tagKurs;
	}

	public void setTagKurs(Integer tagKurs) {
		this.tagKurs = tagKurs;
	}
}
