package ch.bfh.btx8081.weiss.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int PatientID = 0;
	private LocalDateTime appointment = null;

}
