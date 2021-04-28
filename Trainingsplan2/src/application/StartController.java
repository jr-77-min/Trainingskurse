package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class StartController implements Initializable{
	@FXML private Label name;
	@FXML private Label getname;
	@FXML private Label date;
	@FXML private ImageView kalender;
	@FXML private ImageView profil;
	
	private GregorianCalendar ldate;
	private FileInputStream input1;
	private FileInputStream input2;
	private Image imagep;
	private Image imagec;
	private String sDate;
	
	public void Image() {
		File file = new File("/Trainingsplan2/src/rescources/snip.PNG");
        Image image = new Image(file.toURI().toString());
        kalender.setImage(image);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Image();
		ldate = new GregorianCalendar();
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
		sDate = df.format(ldate.getTime());
		name.setText("Name");
		getname.setText("XXX");
		date.setText(sDate);
		kalender.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				new Calender‹bersicht();
			}
		});
		
		profil.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				new ProfilController();
			}
		});
		
		
	}
	
}
