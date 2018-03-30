package com.showroom.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_customer", catalog = "dbshowroom")
public class TbCustomer implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_customer", unique = true, nullable = false)
	private Long idCustomer;

	@Column(name = "nama_customer", nullable = false, length = 30)
	private String namaCustomer;

	@Column(name = "tempat_lahir", nullable = false, length = 30)
	private String tempatLahir;

	@Temporal(TemporalType.DATE)
	@Column(name = "tanggal_lahir", nullable = false, length = 10)
	private Date tanggalLahir;

	@Column(name = "pekerjaan", nullable = false, length = 25)
	private String pekerjaan;

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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbCustomer")
	private Set<TbTransaksi> tbTransaksis = new HashSet<TbTransaksi>(0);

	public Long getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(Long idCustomer) {
		this.idCustomer = idCustomer;
	}

	public String getNamaCustomer() {
		return namaCustomer;
	}

	public void setNamaCustomer(String namaCustomer) {
		this.namaCustomer = namaCustomer;
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
