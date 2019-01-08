package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the doctor database table.
 * 
 */
@Entity
@NamedQuery(name="Doctor.findAll", query="SELECT d FROM Doctor d")
public class Doctor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int iddoctor;

	@Column(name="doctor_name")
	private String doctorName;

	//bi-directional many-to-one association to Appoitement
	@OneToMany(mappedBy="doctor")
	private List<Appoitement> appoitements;

	public Doctor() {
	}

	public int getIddoctor() {
		return this.iddoctor;
	}

	public void setIddoctor(int iddoctor) {
		this.iddoctor = iddoctor;
	}

	public String getDoctorName() {
		return this.doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public List<Appoitement> getAppoitements() {
		return this.appoitements;
	}

	public void setAppoitements(List<Appoitement> appoitements) {
		this.appoitements = appoitements;
	}

	public Appoitement addAppoitement(Appoitement appoitement) {
		getAppoitements().add(appoitement);
		appoitement.setDoctor(this);

		return appoitement;
	}

	public Appoitement removeAppoitement(Appoitement appoitement) {
		getAppoitements().remove(appoitement);
		appoitement.setDoctor(null);

		return appoitement;
	}

}