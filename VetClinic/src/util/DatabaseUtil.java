package util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Animal;
import model.Appoitement;
import model.Doctor;

public class DatabaseUtil {

	public static EntityManagerFactory entityManagerFactory; 
	public static EntityManager entityManager;

	public void setUp() { 
											
		entityManagerFactory = Persistence.createEntityManagerFactory("VetClinic"); 
		entityManager = entityManagerFactory.createEntityManager();
	}

	public void saveAnimal(Animal animal) {
		entityManager.persist(animal);

	}
	
	public void saveDoctor(Doctor doctor) {
		entityManager.persist(doctor);

	}

	public void saveAppointement(Appoitement appointement) {
		entityManager.persist(appointement);

	}


	public void startTransaction() {
		entityManager.getTransaction().begin();
	}

	public void commitTransaction() {
		entityManager.getTransaction().commit();
	}

	public void closeEntityManager() {
		entityManager.close();
	}

	public void printAllAnimalsFromDB() {// printeaza rezultatul din baza de date
		List<Animal> results = entityManager.createNativeQuery("Select * from vetclinic.animal",Animal.class).getResultList();
	   for(Animal animal : results) {
		   System.out.println("Animal :"+animal.getAnimalName()+" is a "+animal.getAnimalType()+ " has ID :"+animal.getIdanimal()+ " age: "+animal.getAnimalAge());
	   }
	}
	public List<Animal> animalList() {
		List<Animal> animalList= (List<Animal>)entityManager.createNativeQuery("SELECT * from vetclinic.animal", Animal.class).getResultList();
				
		return animalList;
	}
	
	public void printAllDoctorsFromDB() {
		List<Doctor> results = entityManager.createNativeQuery("Select * from vetclinic.doctor",Doctor.class).getResultList();
	   for(Doctor doctor : results) {
		   System.out.println("Doctor :"+doctor.getDoctorName()+ " has ID :"+doctor.getIddoctor());
	   }
	}
	public List<Doctor> doctorList() {
		List<Doctor> doctorList= (List<Doctor>)entityManager.createNativeQuery("SELECT * from vetclinic.doctor", Doctor.class).getResultList();
				return doctorList;
	}
	
	public void printAllAppointemensFromDB() {
		List<Appoitement> results = entityManager.createNativeQuery("Select * from vetclinic.appoitement",Appoitement.class).getResultList();
	   for(Appoitement appointement : results) {
		   System.out.println("Appointement :"+appointement.getAppoitementType()+ " has ID :"+appointement.getIdappoitement()+" in month" + appointement.getAppoitementMonth());
	   }
	}
	public List<Appoitement> appointementList() {
		List<Appoitement> appointementList= (List<Appoitement>)entityManager.createNativeQuery("SELECT * from vetclinic.appoitement", Appoitement.class).getResultList();
				return appointementList;
	}
	
}

