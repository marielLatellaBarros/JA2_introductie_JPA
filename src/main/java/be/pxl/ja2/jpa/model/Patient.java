package be.pxl.ja2.jpa.model;

import javax.persistence.*;

/**One-to-one relationship: bidirectional
 */
@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 40, nullable = false)
	private String name;
	/**
	 * One patient has one and only one medical file
	 * A medical file belongs to one patient
	 */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private MedicalFile medicalFile;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MedicalFile getMedicalFile() {
		return medicalFile;
	}

	public void setMedicalFile(MedicalFile medicalFile) {
		this.medicalFile = medicalFile;
	}
}
