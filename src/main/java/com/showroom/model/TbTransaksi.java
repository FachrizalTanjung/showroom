package com.showroom.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_transaksi", catalog = "dbshowroom")
public class TbTransaksi implements java.io.Serializable {

	@Id
	@Column(name = "id_faktur", unique = true, nullable = false, length = 30)
	private String idFaktur;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_customer")
	private TbCustomer tbCustomer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_motor")
	private TbMotor tbMotor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_sales")
	private TbSales tbSales;

	@Column(name = "jumlah", nullable = false)
	private int jumlah;

	@Column(name = "total", nullable = false)
	private int total;

	@Column(name = "dibayar", nullable = false)
	private int dibayar;

	@Column(name = "kembali", nullable = false)
	private int kembali;

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

	public String getIdFaktur() {
		return idFaktur;
	}

	public void setIdFaktur(String idFaktur) {
		this.idFaktur = idFaktur;
	}

	public TbCustomer getTbCustomer() {
		return tbCustomer;
	}

	public void setTbCustomer(TbCustomer tbCustomer) {
		this.tbCustomer = tbCustomer;
	}

	public TbMotor getTbMotor() {
		return tbMotor;
	}

	public void setTbMotor(TbMotor tbMotor) {
		this.tbMotor = tbMotor;
	}

	public TbSales getTbSales() {
		return tbSales;
	}

	public void setTbSales(TbSales tbSales) {
		this.tbSales = tbSales;
	}

	public int getJumlah() {
		return jumlah;
	}

	public void setJumlah(int jumlah) {
		this.jumlah = jumlah;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getDibayar() {
		return dibayar;
	}

	public void setDibayar(int dibayar) {
		this.dibayar = dibayar;
	}

	public int getKembali() {
		return kembali;
	}

	public void setKembali(int kembali) {
		this.kembali = kembali;
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

}
