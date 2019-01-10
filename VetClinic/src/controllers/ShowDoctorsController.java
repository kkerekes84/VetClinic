package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Animal;
import model.Doctor;
import util.DatabaseUtil;

public class ShowDoctorsController implements Initializable {
	
	@FXML
    private ListView<String> Doctors;
	
	@FXML Button AddDoctor;
	
	public void populateDoctorsList()
	{
		DatabaseUtil db = new DatabaseUtil();
		db.setUp();
		db.startTransaction();
		List<Doctor> doctorDBList =(List<Doctor>) db.doctorList();
		ObservableList<String> doctorNamesList = getDoctorName(doctorDBList);
		Doctors.setItems(doctorNamesList);
		Doctors.refresh();
		db.closeEntityManager();
	}
	
	public ObservableList<String> getDoctorName(List<Doctor> doctors) {
		ObservableList<String> names = FXCollections.observableArrayList();
		for (Doctor d : doctors) {
			names.add(d.getDoctorName());
		}
		return names;
	}
	
	 public void AddDoctor() throws IOException {
	    	BorderPane doc = (BorderPane) FXMLLoader.load(getClass().getResource("/controllers/AddDoctorView.fxml"));
	        Scene scene = new Scene(doc,800,800);
	        Stage stage = new Stage();
	        stage.setTitle("Add new doctor");
	        stage.setScene(scene);
	        stage.show();
	    	
	    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		populateDoctorsList();
		
	}

}
