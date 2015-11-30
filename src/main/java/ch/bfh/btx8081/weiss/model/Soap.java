package ch.bfh.btx8081.weiss.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Soap {
	// @Id
	// @GeneratedValue(strategy = GenerationType.TABLE)
	private String s = null;
	private String o = null;
	private String a = null;
	private String p = null;

	public Soap() {
	}

}
