package ch.bfh.btx8081.weiss.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SoapList {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int patientID = 0;
	private int SoapId;
}
