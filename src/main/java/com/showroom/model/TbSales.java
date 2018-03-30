package com.showroom.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_sales", catalog = "dbshowroom")
public class TbSales implements java.io.Serializable {

	@Id
	@Column(name = "id_sales", unique = true, nullable = false, length = 15)
	private String idSales;

	@Column(name = "nama_sales", nullable = false, length = 30)
	private String namaSales;

	@Column(name = "usia", nullable = false)
	private int usia;

	@Column(name = "tempat_lahir", nullable = false, length = 30)
	private String tempatLahir;

	@Temporal(TemporalType.DATE)
	@Column(name = "tanggal_lahir", nullable = false, length = 10)
	private Date tanggalLahir;

	@Column(name = "alamat", nullable = false, length = 50)
	private String alamat;

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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbSales")
	private Set<TbTransaksi> tbTransaksis = new HashSet<TbTransaksi>(0);

	public String getIdSales() {
		return idSales;
	}

	public void setIdSales(String idSales) {
		this.idSales = idSales;
	}

	public String getNamaSales() {
		return namaSales;
	}

	public void setNamaSales(String namaSales) {
		this.namaSales = namaSales;
	}

	public int getUsia() {
		return usia;
	}

	public void setUsia(int usia) {
		this.usia = usia;
	}

	public String getTempatLahir() {
		return tempatLahir;
	}

	public void setTempatLahir(String tempatLahir) {
		this.tempatLahir = tempatLahir;
	}

	public Date getTanggalLahir() {
		return tanggalLahir;
	}

	public void setTanggalLahir(Date tanggalLahir) {
		this.tanggalLahir = tanggalLahir;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
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
