package be.pxl.ja2.jpa.model;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
//TODO: what is indexes and uniqueConstraints?
@Table(name = "PERSONS",
		uniqueConstraints = {@UniqueConstraint(columnNames = "firstName")},
		indexes = {@Index(name = "LAST_NAME_INDEX",
columnList = "LAST_NAME")})
public class Person {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Temporal(TemporalType.DATE)
	private LocalDate birthday;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Lob
	private byte[] picture;
	private String comment;
	private boolean married;
	private String token;

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
