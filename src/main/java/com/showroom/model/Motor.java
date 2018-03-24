package com.showroom.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "motor")
public class Motor implements java.io.Serializable {

	//@Id = Untuk primary key
	//@Column = Pendefinisian nama kolom
	//@Temporal = Untuk tipe data yang berupa tanggal
	//unique = Untuk keunikan data = true / false
	//nullable = Untuk data yang kosong, jika false tidak boleh kosong jika true boleh kosong
	//length = Panjang karakter di database
	
	@Id
	@Column(name = "idMotor", unique = true, nullable = false, length = 25)
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
