package controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import model.Animal;
import util.DatabaseUtil;

public class ShowAnimalsController implements Initializable {
	
	@FXML
    private ListView<String> Animals;
	
	public void populateAnimalList()
	{
		DatabaseUtil db = new DatabaseUtil();
		db.setUp();
		db.startTransaction();
		List<Animal> animalDBList =(List<Animal>) db.animalList();
		ObservableList<String> animalNamesList = getAnimalName(animalDBList);
		Animals.setItems(animalNamesList);
		Animals.refresh();
		db.closeEntityManager();
	}
	
	public ObservableList<String> getAnimalName(List<Animal> animals) {
		ObservableList<String> names = FXCollections.observableArrayList();
		for (Animal a : animals) {
			names.add(a.getAnimalName());
		}
		return names;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		populateAnimalList();
		
	}

}
