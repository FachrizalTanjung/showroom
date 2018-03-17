package com.showroom.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "customer")
public class Customer implements java.io.Serializable {

	//@Id = Untuk primary key
	//@Column = Pendefinisian nama kolom
	//@Temporal = Untuk tipe data yang berupa tanggal
	//unique = Untuk keunikan data = true / false
	//nullable = Untuk data yang kosong, jika false tidak boleh kosong jika true boleh kosong
	//length = Panjang karakter di database
	
	@Id
	@Column(name = "idcustomer", unique = true, nullable = false, length = 25)
	private String idcustomer;
	
	@Column(name = "namacustomer", nullable = false, length = 25)
	private String namacustomer;
	
	@Column(name = "tempatlahir", nullable = false, length = 25)
	private String tempatlahir;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "tanggallahir", nullable = false, length = 10)
	private Date tanggallahir;
	
	@Column(name = "pekerjaan", nullable = false, length = 25)
	private String pekerjaan;
	
	@Column(name = "alamat", nullable = false, length = 25)
	private String alamat;

	public String getIdcustomer() {
		return idcustomer;
	}

	public void setIdcustomer(String idcustomer) {
		this.idcustomer = idcustomer;
	}

	public String getNamacustomer() {
		return namacustomer;
	}

	public void setNamacustomer(String namacustomer) {
		this.namacustomer = namacustomer;
	}

	public String getTempatlahir() {
		return tempatlahir;
	}

	public void setTempatlahir(String tempatlahir) {
		this.tempatlahir = tempatlahir;
	}

	public Date getTanggallahir() {
		return tanggallahir;
	}

	public void setTanggallahir(Date tanggallahir) {
		this.tanggallahir = tanggallahir;
	}

	public String getPekerjaan() {
		return pekerjaan;
	}

	public void setPekerjaan(String pekerjaan) {
		this.pekerjaan = pekerjaan;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

}
