package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Time;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Animal;
import model.Appoitement;
import model.Doctor;
import util.DatabaseUtil;

public class MainController implements Initializable{
	
	
	//@FXML
	//private ListView<Appoitement> Appoitments;
	@FXML
	private TableView<Appoitement> tableView;
	private TableColumn<Appoitement,Integer> year_column;
	private TableColumn<Appoitement,Integer> day_column;
	private TableColumn<Appoitement,Time> hour_column;
	private TableColumn<Appoitement,String> animal_name;
	private TableColumn<Appoitement,String> appoitement_type;
	private TableColumn<Appoitement,String> doctor_name;
	
	
	@FXML
	private DatePicker PickDate;
	
	@FXML
	private Button ShowAnimals;
	
    public void populateMainListView() {
    	int year= (PickDate.getValue().getYear());
	    int month=(PickDate.getValue().getMonthValue());
	    int day=(PickDate.getValue().getDayOfMonth());
	 
    	DatabaseUtil db = new DatabaseUtil();
		db.setUp();
		db.startTransaction();
		List<Appoitement> appointementDBListbasedOnDate= (List<Appoitement>) db.appointementList();
		ObservableList<Appoitement> names = FXCollections.observableArrayList();
		for (Appoitement a : appointementDBListbasedOnDate) {
		if(a.getAppointementYear()==year) {
			 names.add(new Appoitement(a.getAppointementYear(),a.getAppoitementDay(),a.getAppoitementTime(),a.getAnimal(),a.getDoctor()));
		  
			
	      }
	    	}
		year_column.setCellValueFactory(new PropertyValueFactory<Appoitement,Integer>("appointement_year"));
    	day_column.setCellValueFactory(new PropertyValueFactory<Appoitement,Integer>("appoitement_day"));
    	hour_column.setCellValueFactory(new PropertyValueFactory<Appoitement,Time>("appoitement_time"));
    	animal_name.setCellValueFactory(new PropertyValueFactory<Appoitement,String>("idanimal"));
    	appoitement_type.setCellValueFactory(new PropertyValueFactory<Appoitement,String>("appoitement_type"));
    	doctor_name.setCellValueFactory(new PropertyValueFactory<Appoitement,String>("iddoctor"));
		tableView.setItems(names);
		//Appoitments.setItems(names);
		//Appoitments.refresh();
		db.closeEntityManager();
		//populateMainListView();
    
    }
    
    public void ShowAnimals() throws IOException {
    	BorderPane animal = (BorderPane) FXMLLoader.load(getClass().getResource("/controllers/ShowAnimals.fxml"));
        Scene scene1 = new Scene(animal,800,800);
        Stage stage1 = new Stage();
        stage1.setTitle("Animal_List");
        stage1.setScene(scene1);
        stage1.show();
    	
    }
  
@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	}
	


