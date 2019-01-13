package controllers;

import java.net.URL;
import java.sql.Time;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import model.Animal;
import model.Appoitement;
import model.Doctor;
import util.DatabaseUtil;



public class ShowAppointements implements Initializable {

	@FXML
	private ListView<String> id;
	@FXML
	private ListView<String> type;
	@FXML
	private ListView<String> year;
	@FXML
    private ListView<String> animal;
	@FXML
	private ListView<String> doctor;
	@FXML
	private ListView<String> day;
	@FXML
    private ListView<String> time;
	@FXML
    private ListView<String> month;

	
	
	public void PopulateAppointements()
	{
		DatabaseUtil db = new DatabaseUtil();
		db.setUp();
		db.startTransaction();
		List<Appoitement> appointementDBListbasedOnDate= (List<Appoitement>) db.appointementList();
		ObservableList<String> i = FXCollections.observableArrayList();
		ObservableList<String> ty = FXCollections.observableArrayList();
		ObservableList<String> y = FXCollections.observableArrayList();
		ObservableList<String> a = FXCollections.observableArrayList();
		ObservableList<String> doc = FXCollections.observableArrayList();
		ObservableList<String> d = FXCollections.observableArrayList();
		ObservableList<String> t = FXCollections.observableArrayList();
		ObservableList<String> m = FXCollections.observableArrayList();
		
		
		for (Appoitement app : appointementDBListbasedOnDate) 
		{
		i.add(String.valueOf(app.getIdappoitement()));	
		ty.add(String.valueOf(app.getAppoitementType()));
		y.add(String.valueOf(app.getAppointementYear()));
		a.add(String.valueOf(app.getAnimal().getAnimalName()));
		doc.add(String.valueOf(app.getDoctor().getDoctorName()));
		d.add(String.valueOf(app.getAppoitementDay()));
		t.add(String.valueOf(app.getAppoitementTime()));
		m.add(String.valueOf(app.getAppoitementMonth()));
		}
	
		id.setItems(i);
		type.setItems(ty);
		year.setItems(y);
		animal.setItems(a);
		doctor.setItems(doc);
		day.setItems(d);
		time.setItems(t);
		month.setItems(m);
		id.refresh();
		type.refresh();
		year.refresh();
		animal.refresh();
		doctor.refresh();
		day.refresh();
		time.refresh();
		month.refresh();
		
		db.closeEntityManager();
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		PopulateAppointements();
		
	}

}
