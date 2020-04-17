package be.pxl.ja2.jpa.model;

import javax.persistence.*;

/**One-to-one relationship: bidirectional
 */
@Entity
public class MedicalFile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double weight;
	private int height;
	@OneToOne(mappedBy = "medicalFile")
	private Patient patient;

	public Long getId() {
		return id;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
}
