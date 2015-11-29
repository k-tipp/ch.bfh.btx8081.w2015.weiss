package ch.bfh.btx8081.weiss.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SelfHarm {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int harmID = 0;
	private String Status = null;
}
