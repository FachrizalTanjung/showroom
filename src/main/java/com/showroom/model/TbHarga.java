package com.showroom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "tb_harga", catalog = "dbshowroom")
public class TbHarga implements java.io.Serializable {

	@Id
	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "tbMotor"))
	@GeneratedValue(generator = "generator")
	@Column(name = "id_motor", unique = true, nullable = false)
	private long idMotor;

	@Column(name = "harga_otr", nullable = false)
	private int hargaOtr;

	@Column(name = "diskon")
	private Integer diskon;

	@Column(name = "stok", nullable = false)
	private int stok;

	@Column(name = "harga_netcash", nullable = false)
	private int hargaNetcash;

	@Column(name = "simulasi_kredit")
	private Integer simulasiKredit;

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private TbMotor tbMotor;

	public long getIdMotor() {
		return idMotor;
	}

	public void setIdMotor(long idMotor) {
		this.idMotor = idMotor;
	}

	public int getHargaOtr() {
		return hargaOtr;
	}

	public void setHargaOtr(int hargaOtr) {
		this.hargaOtr = hargaOtr;
	}

	public Integer getDiskon() {
		return diskon;
	}

	public void setDiskon(Integer diskon) {
		this.diskon = diskon;
	}

	public int getStok() {
		return stok;
	}

	public void setStok(int stok) {
		this.stok = stok;
	}

	public int getHargaNetcash() {
		return hargaNetcash;
	}

	public void setHargaNetcash(int hargaNetcash) {
		this.hargaNetcash = hargaNetcash;
	}

	public Integer getSimulasiKredit() {
		return simulasiKredit;
	}

	public void setSimulasiKredit(Integer simulasiKredit) {
		this.simulasiKredit = simulasiKredit;
	}

	public TbMotor getTbMotor() {
		return tbMotor;
	}

	public void setTbMotor(TbMotor tbMotor) {
		this.tbMotor = tbMotor;
	}

}
