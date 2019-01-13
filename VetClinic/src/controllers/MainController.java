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
	
	
	
	@FXML
	private TableView<Appoitement> tableView;
	@FXML
	private TableColumn<Appoitement,Integer> app_id;
	@FXML
	private TableColumn<Appoitement,String> appoitement_type;
	@FXML
	private TableColumn<Appoitement,Integer> year_column;
	@FXML
	private TableColumn<Appoitement,String> animal_name;
	@FXML
	private TableColumn<Appoitement,String> doctor_name;
	@FXML
	private TableColumn<Appoitement,Integer> day_column;
	@FXML
	private TableColumn<Appoitement,Time> hour_column;
	@FXML
	private TableColumn<Appoitement,Integer> month_column;
	
	
	@FXML
	private DatePicker PickDate;
	
	@FXML
	private Button ShowAnimals;
	
	@FXML
	private Button ShowAppointements;
	
	@FXML Button ShowDoctors;
	
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
		if(a.getAppointementYear()==year && a.getAppoitementMonth()==month) 
		{	
		 
			/*String a_id,a_type,a_year,a_name,a_doctor,a_day,a_time,a_month= new String();
			a_id=String.valueOf(a.getIdappoitement());
		    a_type=String.valueOf(a.getAppoitementType());
		    a_year=String.valueOf(a.getAppointementYear());
		    a_name=String.valueOf(a.getAnimal().getAnimalName());
		    a_doctor=String.valueOf(a.getDoctor().getDoctorName());
		    a_day=String.valueOf(a.getAppoitementDay());
		    a_time=String.valueOf(a.getAppoitementTime());
		    a_month=String.valueOf(a.getAppoitementMonth());*/
		    
		
			
		/*	 names.add(String.valueOf(a.getIdappoitement()));
		  names.add(String.valueOf(a.getAppoitementType()));
		  names.add(String.valueOf(a.getAppointementYear()));
		  names.add(String.valueOf(a.getAnimal().getAnimalName()));
		  names.add(String.valueOf(a.getDoctor().getDoctorName()));
		  names.add(String.valueOf(a.getAppoitementDay()));
		  names.add(String.valueOf(a.getAppoitementTime()));
		  names.add(String.valueOf(a.getAppoitementMonth())); */
		//names.add(new Appoitement(a.getIdappoitement(),a.getAppoitementType(),a.getAppointementYear(),a.getAnimal(),a.getDoctor(),a.getAppoitementDay(),a.getAppoitementTime(),a.getAppoitementMonth()));
		  names.add(a);
		 // names.addAll(a);
		  
			
			
	     
	     }
	    	}
		db.closeEntityManager();
		
		
		app_id.setCellValueFactory(new PropertyValueFactory<Appoitement,Integer>("idappoitement"));
		appoitement_type.setCellValueFactory(new PropertyValueFactory<Appoitement,String>("appoitement_type"));
		year_column.setCellValueFactory(new PropertyValueFactory<Appoitement,Integer>("appointement_year"));
		animal_name.setCellValueFactory(new PropertyValueFactory<Appoitement,String>("idanimal"));
    	doctor_name.setCellValueFactory(new PropertyValueFactory<Appoitement,String>("iddoctor"));
    	day_column.setCellValueFactory(new PropertyValueFactory<Appoitement,Integer>("appoitement_day"));
    	hour_column.setCellValueFactory(new PropertyValueFactory<Appoitement,Time>("appoitement_time"));
    	month_column.setCellValueFactory(new PropertyValueFactory<Appoitement,Integer>("appoitement_month"));
	
		tableView.setItems(names);
		//tableView.getColumns().addAll(app_id,appoitement_type,year_column,animal_name,doctor_name,day_column,hour_column,month_column);
	
    
    }
    
 

	
    
    public void ShowAnimals() throws IOException {
    	BorderPane animal = (BorderPane) FXMLLoader.load(getClass().getResource("/controllers/ShowAnimals.fxml"));
        Scene scene1 = new Scene(animal,800,800);
        Stage stage1 = new Stage();
        stage1.setTitle("Animal_List");
        stage1.setScene(scene1);
        stage1.show();
    	
    }
    
    public void AllAppointements() throws IOException {
    	BorderPane appointement=(BorderPane) FXMLLoader.load(getClass().getResource("/controllers/ShowAppointements.fxml"));
    	 Scene scene2 = new Scene(appointement,800,800);
         Stage stage2 = new Stage();
         stage2.setTitle("Appointement_List");
         stage2.setScene(scene2);
         stage2.show();
    }
  
    public void AllDoctors() throws IOException {
    	BorderPane appointement=(BorderPane) FXMLLoader.load(getClass().getResource("/controllers/ShowDoctors.fxml"));
    	 Scene scene3 = new Scene(appointement,800,800);
         Stage stage3 = new Stage();
         stage3.setTitle("Doctors_List");
         stage3.setScene(scene3);
         stage3.show();
    }
@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	}
	


