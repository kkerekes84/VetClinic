package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Doctor;
import util.DatabaseUtil;

public class AddDoctorController implements Initializable {

	
	@FXML
	TextField add_doctor;
	@FXML
	Button save;
	
	public void AddDoctor() {
		DatabaseUtil db = new DatabaseUtil();
		db.setUp();
		db.startTransaction();
	    //String name= new String();
	    Button button= new Button("Save");
	    TextField add_doctor= new TextField();
	    button.setOnAction(e -> 
	    {
	    	Doctor doctor= new Doctor();
		    doctor.setDoctorName(add_doctor.getText());
		    db.saveDoctor(doctor);
		    db.commitTransaction();
	    }
	    );
	    
	    
	    db.closeEntityManager();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
