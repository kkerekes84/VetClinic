package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the animal database table.
 * 
 */
@Entity
@NamedQuery(name="Animal.findAll", query="SELECT a FROM Animal a")
public class Animal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idanimal;

	@Column(name="animal_age")
	private int animalAge;

	@Column(name="animal_name")
	private String animalName;

	@Column(name="animal_type")
	private String animalType;

	//bi-directional many-to-one association to Appoitement
	@OneToMany(mappedBy="animal")
	private List<Appoitement> appoitements;

	public Animal() {
	}

	public int getIdanimal() {
		return this.idanimal;
	}

	public void setIdanimal(int idanimal) {
		this.idanimal = idanimal;
	}

	public int getAnimalAge() {
		return this.animalAge;
	}

	public void setAnimalAge(int animalAge) {
		this.animalAge = animalAge;
	}

	public String getAnimalName() {
		return this.animalName;
	}

	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}

	public String getAnimalType() {
		return this.animalType;
	}

	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}

	public List<Appoitement> getAppoitements() {
		return this.appoitements;
	}

	public void setAppoitements(List<Appoitement> appoitements) {
		this.appoitements = appoitements;
	}

	public Appoitement addAppoitement(Appoitement appoitement) {
		getAppoitements().add(appoitement);
		appoitement.setAnimal(this);

		return appoitement;
	}

	public Appoitement removeAppoitement(Appoitement appoitement) {
		getAppoitements().remove(appoitement);
		appoitement.setAnimal(null);

		return appoitement;
	}

}