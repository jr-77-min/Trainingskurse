package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatenbankVerbindung {
	
	private String kunde_id;
	private String vor;
	private String nach;
	private String geb;
	private String str;
	private String hnr;
	private String wohn;
	
	private String kurs_id;
	private String trainer;
	private String startUhrZeit;
	private String dauer;
	private String raum;
	private String verPlaetze;
	private String trainFok;
	private String wochentag;
	
	private int status;
	
	private final String url = "jdbc:oracle:thin:@oracle.s-atiw.de:1521:atiwora";
	private String user = "FS192_RLawson";
	private String password  = "rodrigue";
	
	public Connection erstelleVerbindungProfil() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection verbindung = DriverManager.getConnection(url, user, password);
		return verbindung;
	}
	public void startVerbindung() {
		try{
			String sqlst = "SELECT Kunde_Id, vorname, NACHNAME, GEBURTSDATUM , STRAﬂE, Hausnummer , STADT  FROM FS192_LTROESCH.KUNDE where vorname = 'Duongburg'";
			Connection verbindung = erstelleVerbindungProfil();
			Statement s = verbindung.createStatement();
			ResultSet erg = s.executeQuery(sqlst);
			while(erg.next()) {
				kunde_id = erg.getString("Kunde_ID");
				vor = erg.getString("VORNAME");
				nach = erg.getString("Nachname");
				geb = erg.getString("Geburtsdatum");
				str = erg.getString("Straﬂe");
				hnr = erg.getString("Hausnummer");
				wohn = erg.getString("Stadt");
				//System.out.println(vor+" "+nach+" "+geb+" "+str+" "+wohn);
			}s.close();
			}catch(ClassNotFoundException e) {
				System.err.println("Datenbak-Treiber nicht gefunden");
			}catch(SQLException e) {
				System.err.println("SQL Fehler");
				e.printStackTrace();
			}
	}
	
	public void AbrufKurse(String trainingsfokus, String zeitKurs, String tag) {
		try {
		String sqlst = "SELECT DISTINCT Kurs_ID, Trainer, VERFUEGBARE_PLAETZE, dauer, start_zeit, raum_id, Trainingsfokus, Wochentag FROM FS192_LTROESCH.Kurs where trainingsfokus = '"+trainingsfokus+"' and start_zeit = '"+zeitKurs+"' and Wochentag = '"+tag+"'";
		Connection verbindung = erstelleVerbindungProfil();
		Statement s = verbindung.createStatement();
		ResultSet erg = s.executeQuery(sqlst);
		while(erg.next()) {
			kurs_id = erg.getString("Kurs_ID");
			trainer = erg.getString("Trainer");
			verPlaetze = erg.getString("VERFUEGBARE_PLAETZE");
			dauer = erg.getString("dauer");
			startUhrZeit = erg.getString("start_zeit");
			raum = erg.getString("raum_id");
			trainFok = erg.getString("Trainingsfokus");
			wochentag = erg.getString("Wochentag");
		}s.close();
		}catch(ClassNotFoundException e) {
			System.err.println("Datenbak-Treiber nicht gefunden");
		}catch(SQLException e) {
			System.err.println("SQL Fehler");
			e.printStackTrace();
		}
	}
	
	public void kursBelegung(String kunden_id, String kurs_id, int status) {
		try{
			String sqlst = "INSERT INTO FS192_LTROESCH.Kunde_Kurs VALUES ("+kunden_id+","+kurs_id+","+status+")";
			Connection verbindung = erstelleVerbindungProfil();
			Statement s = verbindung.createStatement();
			ResultSet erg = s.executeQuery(sqlst);
			s.close();
			}catch(ClassNotFoundException e) {
				System.err.println("Datenbak-Treiber nicht gefunden");
			}catch(SQLException e) {
				System.err.println("SQL Fehler");
				e.printStackTrace();
			}
	}
	
	public void belegteKurseAbrufen(String id, String kurs) {
		try{
			String sqlst = "SELECT kunde_Id, kurs_id, status FROM FS192_LTROESCH.KUNDE_Kurs where Kunde_id = '"+id+"' and kurs_id = '"+kurs+"'";
			Connection verbindung = erstelleVerbindungProfil();
			Statement s = verbindung.createStatement();
			ResultSet erg = s.executeQuery(sqlst);
			while(erg.next()) {
				kunde_id = erg.getString("Kunde_ID");
				kurs_id = erg.getString("Kurs_Id");
				status = erg.getInt("Status");
			}s.close();
			}catch(ClassNotFoundException e) {
				System.err.println("Datenbak-Treiber nicht gefunden");
			}catch(SQLException e) {
				System.err.println("SQL Fehler");
				e.printStackTrace();
			}
	}
	public void belegteKurseAbmelden(String id, String kurs) {
		try{
			String sqlst = "UPDATE FS192_LTROESCH.KUNDE_Kurs Set Status = 0 where Kunde_id = '"+id+"' and kurs_id = '"+kurs+"'";
			Connection verbindung = erstelleVerbindungProfil();
			Statement s = verbindung.createStatement();
			ResultSet erg = s.executeQuery(sqlst);
			s.close();
			}catch(ClassNotFoundException e) {
				System.err.println("Datenbak-Treiber nicht gefunden");
			}catch(SQLException e) {
				System.err.println("SQL Fehler");
				e.printStackTrace();
			}
	}
	public String getId() {
		return kunde_id;
	}
	public void setId(String id) {
		this.kunde_id = id;
	}
	public String getVor() {
		return vor;
	}
	public void setVor(String vor) {
		this.vor = vor;
	}
	public String getNach() {
		return nach;
	}
	public void setNach(String nach) {
		this.nach = nach;
	}
	public String getGeb() {
		return geb;
	}
	public void setGeb(String geb) {
		this.geb = geb;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public String getHnr() {
		return hnr;
	}
	public void setHnr(String hnr) {
		this.hnr = hnr;
	}
	public String getWohn() {
		return wohn;
	}
	public void setWohn(String wohn) {
		this.wohn = wohn;
	}
	public String getKurs_id() {
		return kurs_id;
	}
	public void setKurs_id(String kurs_id) {
		this.kurs_id = kurs_id;
	}
	public String getTrainer() {
		return trainer;
	}
	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}
	public String getStartUhrZeit() {
		return startUhrZeit;
	}
	public void setStartUhrZeit(String startUhrZeit) {
		this.startUhrZeit = startUhrZeit;
	}
	public String getDauer() {
		return dauer;
	}
	public String getWochentag() {
		return wochentag;
	}
	public void setWochentag(String wochentag) {
		this.wochentag = wochentag;
	}
	public void setDauer(String dauer) {
		this.dauer = dauer;
	}
	public String getRaum() {
		return raum;
	}
	public void setRaum(String raum) {
		this.raum = raum;
	}
	public String getVerPlaetze() {
		return verPlaetze;
	}
	public void setVerPlaetze(String verPlaetze) {
		this.verPlaetze = verPlaetze;
	}
	public String getTrainFok() {
		return trainFok;
	}
	public void setTrainFok(String trainFok) {
		this.trainFok = trainFok;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
