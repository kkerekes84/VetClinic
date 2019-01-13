package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import model.Animal;
import model.Doctor;


/**
 * The persistent class for the appoitement database table.
 * 
 */
@Entity
@NamedQuery(name="Appoitement.findAll", query="SELECT a FROM Appoitement a")
public class Appoitement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idappoitement;

	@Column(name="appointement_year")
	private int appointementYear;

	@Column(name="appoitement_day")
	private int appoitementDay;

	@Column(name="appoitement_time")
	private Time appoitementTime;

	@Column(name="appoitement_type")
	private String appoitementType;
	
	@Column(name="appoitement_month")
	private int appoitementMonth;

	//bi-directional many-to-one association to Animal
	@ManyToOne
	@JoinColumn(name="idanimal")
	private Animal animal;

	//bi-directional many-to-one association to Doctor
	@ManyToOne
	@JoinColumn(name="iddoctor")
	private Doctor doctor;

	public Appoitement() {
	}



	public Appoitement(int app_id,String app_type,int appointementYear2, Animal animal2, Doctor doctor2,int appoitementDay2,Time appoitementTime2,int appoitementMonth2) {
	
		this.idappoitement=app_id;
		this.appoitementType=app_type;
		this.appointementYear=appointementYear2;
		this.animal=animal2;
		this.doctor=doctor2;
		this.appoitementDay=appoitementDay2;
		this.appoitementTime=appoitementTime2;
		this.appoitementMonth=appoitementMonth2;
		
		
	}



	public int getIdappoitement() {
		return this.idappoitement;
	}

	public void setIdappoitement(int idappoitement) {
		this.idappoitement = idappoitement;
	}

	public int getAppointementYear() {
		return this.appointementYear;
	}

	public void setAppointementYear(int appointementYear) {
		this.appointementYear = appointementYear;
	}

	public int getAppoitementDay() {
		return this.appoitementDay;
	}

	public void setAppoitementDay(int appoitementDay) {
		this.appoitementDay = appoitementDay;
	}

	public Time getAppoitementTime() {
		return this.appoitementTime;
	}

	public void setAppoitementTime(Time appoitementTime) {
		this.appoitementTime = appoitementTime;
	}

	public String getAppoitementType() {
		return this.appoitementType;
	}

	public void setAppoitementType(String appoitementType) {
		this.appoitementType = appoitementType;
	}

	public int getAppoitementMonth() {
		return this.appoitementMonth;
	}

	public void setAppoitementMonth(int appoitementMonth) {
		this.appoitementMonth = appoitementMonth;
	}
	public Animal getAnimal() {
		return this.animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Doctor getDoctor() {
		return this.doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

}