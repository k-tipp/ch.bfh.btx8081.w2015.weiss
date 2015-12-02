package ch.bfh.btx8081.weiss.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int patientID = 0;

	@OneToMany(mappedBy = "patient")
	private final List<Appointment> appointments = null;

	private String picture = null;  //base64
	private String firstName = null;
	private String lastName = null;
	private String eMail = null;
	private String gender = null;
	private String street = null;
	private String zip = null;
	private String city = null;
	private String ssn = null;
	private LocalDate birthday = null;
	private int harmID = 0;

	public Patient() {
	}
	
	public Patient(int id)
	{
		this.patientID = id;
	}

	// autogenerated

	public int getPatientID() {
		return patientID;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String geteMail() {
		return eMail;
	}

	public String getGender() {
		return gender;
	}

	public String getStreet() {
		return street;
	}

	public String getZip() {
		return zip;
	}

	public String getCity() {
		return city;
	}

	public String getSsn() {
		return ssn;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public int getHarmID() {
		return harmID;
	}
	
	public String getPicture() {
		return picture;
	}


	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public void setHarmID(int harmID) {
		this.harmID = harmID;
	}
	
	public void setPicture(String picture) {
		this.picture = picture;
	}

}
