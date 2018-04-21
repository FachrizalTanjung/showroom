package com.showroom.dto;

public class HargaDTO {
	
	private Long idMotor;
	private Integer hargaOtr;
	private Integer diskon;
	private Integer stok;
	private Integer hargaNetcash;
	private Integer simulasiKredit;
	private MotorDTO motorDTO;
	public Long getIdMotor() {
		return idMotor;
	}
	public void setIdMotor(Long idMotor) {
		this.idMotor = idMotor;
	}
	public Integer getHargaOtr() {
		return hargaOtr;
	}
	public void setHargaOtr(Integer hargaOtr) {
		this.hargaOtr = hargaOtr;
	}
	public Integer getDiskon() {
		return diskon;
	}
	public void setDiskon(Integer diskon) {
		this.diskon = diskon;
	}
	public Integer getStok() {
		return stok;
	}
	public void setStok(Integer stok) {
		this.stok = stok;
	}
	public Integer getHargaNetcash() {
		return hargaNetcash;
	}
	public void setHargaNetcash(Integer hargaNetcash) {
		this.hargaNetcash = hargaNetcash;
	}
	public Integer getSimulasiKredit() {
		return simulasiKredit;
	}
	public void setSimulasiKredit(Integer simulasiKredit) {
		this.simulasiKredit = simulasiKredit;
	}
	public MotorDTO getMotorDTO() {
		return motorDTO;
	}
	public void setMotorDTO(MotorDTO motorDTO) {
		this.motorDTO = motorDTO;
	}
	
	

}
