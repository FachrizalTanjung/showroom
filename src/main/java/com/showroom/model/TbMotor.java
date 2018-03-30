package com.showroom.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_motor", catalog = "dbshowroom")
public class TbMotor implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_motor", unique = true, nullable = false)
	private long idMotor;

	@Column(name = "jenis_motor", nullable = false, length = 20)
	private String jenisMotor;

	@Column(name = "merek_motor", nullable = false, length = 50)
	private String merekMotor;

	@Column(name = "tipe_motor", nullable = false, length = 30)
	private String tipeMotor;

	@Column(name = "url_gambar")
	private String urlGambar;

	@Column(name = "deskripsi_motor")
	private String deskripsiMotor;

	@Column(name = "transmisi_motor", nullable = false, length = 10)
	private String transmisiMotor;

	@Column(name = "cc", nullable = false, length = 10)
	private String cc;

	@Column(name = "tahun", nullable = false, length = 4)
	private String tahun;

	@Column(name = "warna_motor", nullable = false, length = 20)
	private String warnaMotor;

	@Column(name = "created_by", nullable = false, length = 30)
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false, length = 19)
	private Date createdAt;

	@Column(name = "updated_by", length = 30)
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", length = 19)
	private Date updatedAt;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbMotor")
	private Set<TbTransaksi> tbTransaksis = new HashSet<TbTransaksi>(0);
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "tbMotor")
	private TbHarga tbHarga;

	public long getIdMotor() {
		return idMotor;
	}

	public void setIdMotor(long idMotor) {
		this.idMotor = idMotor;
	}

	public TbHarga getTbHarga() {
		return tbHarga;
	}

	public void setTbHarga(TbHarga tbHarga) {
		this.tbHarga = tbHarga;
	}

	public String getJenisMotor() {
		return jenisMotor;
	}

	public void setJenisMotor(String jenisMotor) {
		this.jenisMotor = jenisMotor;
	}

	public String getMerekMotor() {
		return merekMotor;
	}

	public void setMerekMotor(String merekMotor) {
		this.merekMotor = merekMotor;
	}

	public String getTipeMotor() {
		return tipeMotor;
	}

	public void setTipeMotor(String tipeMotor) {
		this.tipeMotor = tipeMotor;
	}

	public String getUrlGambar() {
		return urlGambar;
	}

	public void setUrlGambar(String urlGambar) {
		this.urlGambar = urlGambar;
	}

	public String getDeskripsiMotor() {
		return deskripsiMotor;
	}

	public void setDeskripsiMotor(String deskripsiMotor) {
		this.deskripsiMotor = deskripsiMotor;
	}

	public String getTransmisiMotor() {
		return transmisiMotor;
	}

	public void setTransmisiMotor(String transmisiMotor) {
		this.transmisiMotor = transmisiMotor;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getTahun() {
		return tahun;
	}

	public void setTahun(String tahun) {
		this.tahun = tahun;
	}

	public String getWarnaMotor() {
		return warnaMotor;
	}

	public void setWarnaMotor(String warnaMotor) {
		this.warnaMotor = warnaMotor;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Set<TbTransaksi> getTbTransaksis() {
		return tbTransaksis;
	}

	public void setTbTransaksis(Set<TbTransaksi> tbTransaksis) {
		this.tbTransaksis = tbTransaksis;
	}

}
