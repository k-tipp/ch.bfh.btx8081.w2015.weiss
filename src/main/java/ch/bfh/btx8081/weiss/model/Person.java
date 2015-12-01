package ch.bfh.btx8081.weiss.model;

import java.util.ArrayList;
import java.time.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int personId = 0;

	@OneToOne
	@PrimaryKeyJoinColumn
	public Patient patient;

	@OneToOne
	@PrimaryKeyJoinColumn
	public Appointment appointment;
	private String firstName = null;
	private String lastName = null;
	private String eMail = null;
	private String gender = null;
	private String street = null;
	private String zip = null;
	private String city = null;
	private String ssn = null;
	private LocalDateTime birthday = null;

	public Person() {

	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

}