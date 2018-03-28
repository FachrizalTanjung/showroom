package com.showroom.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "motor")
public class Motor implements java.io.Serializable {

	
	@Id
	@Column(name = "idmotor", unique = true, nullable = false, length = 25)
	private String idMotor;
	
	@Column(name = "bebek", nullable = false, length = 25)
	private String bebek;
	
	@Column(name = "matic", nullable = false, length = 25)
	private String matic;
	
	@Column(name = "sport", nullable = false, length = 25)
	private String sport;

	public String getIdMotor() {
		return idMotor;
	}

	public void setIdMotor(String idMotor) {
		this.idMotor = idMotor;
	}

	public String getBebek() {
		return bebek;
	}

	public void setBebek(String bebek) {
		this.bebek = bebek;
	}

	public String getMatic() {
		return matic;
	}

	public void setMatic(String matic) {
		this.matic = matic;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}
}
