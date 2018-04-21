package com.showroom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_booking", catalog = "dbshowroom")
public class TbBooking implements java.io.Serializable {

	private String tiketPesan;
	private String nama;
	private String nomorTelepon;
	private String alamat;
	private String isiPesan;

	@Id
	@Column(name = "tiket_pesan", unique = true, nullable = false, length = 10)
	public String getTiketPesan() {
		return this.tiketPesan;
	}

	public void setTiketPesan(String tiketPesan) {
		this.tiketPesan = tiketPesan;
	}

	@Column(name = "nama", length = 30)
	public String getNama() {
		return this.nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	@Column(name = "nomor_telepon", length = 20)
	public String getNomorTelepon() {
		return this.nomorTelepon;
	}

	public void setNomorTelepon(String nomorTelepon) {
		this.nomorTelepon = nomorTelepon;
	}

	@Column(name = "alamat", length = 50)
	public String getAlamat() {
		return this.alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	@Column(name = "isi_pesan", length = 160)
	public String getIsiPesan() {
		return this.isiPesan;
	}

	public void setIsiPesan(String isiPesan) {
		this.isiPesan = isiPesan;
	}

}
