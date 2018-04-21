package com.showroom.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.showroom.dao.TbMotorDao;
import com.showroom.dto.HargaDTO;
import com.showroom.dto.MotorDTO;
import com.showroom.model.TbHarga;
import com.showroom.model.TbMotor;

@RestController
@RequestMapping("/rest/motor")
public class RestServicesMotor {

	@Autowired
	private TbMotorDao tbMotorDao;

	@GetMapping("/all")
	public ResponseEntity getAllMotor() {

		List<MotorDTO> motorList = new ArrayList<MotorDTO>();

		for (TbMotor tbMotor : tbMotorDao.findAll()) {
			MotorDTO mtr = new MotorDTO();

			// Set data di tabel ke dto
			mtr.setIdMotor(tbMotor.getIdMotor());
			mtr.setJenisMotor(tbMotor.getJenisMotor());
			mtr.setMerekMotor(tbMotor.getMerekMotor());
			mtr.setTipeMotor(tbMotor.getTipeMotor());
			mtr.setUrlGambar(tbMotor.getUrlGambar());
			mtr.setDeskripsiMotor(tbMotor.getDeskripsiMotor());
			mtr.setTransmisiMotor(tbMotor.getTransmisiMotor());
			mtr.setCc(tbMotor.getCc());
			mtr.setTahun(tbMotor.getTahun());
			mtr.setWarnaMotor(tbMotor.getWarnaMotor());
			mtr.setCreatedBy(tbMotor.getCreatedBy());
			mtr.setCreatedAt(tbMotor.getCreatedAt());
			mtr.setUpdatedBy(tbMotor.getUpdatedBy());
			mtr.setUpdatedAt(tbMotor.getUpdatedAt());

			HargaDTO hargaDTO = new HargaDTO();
			hargaDTO.setIdMotor(tbMotor.getTbHarga().getIdMotor());
			hargaDTO.setHargaOtr(tbMotor.getTbHarga().getHargaOtr());
			hargaDTO.setDiskon(tbMotor.getTbHarga().getDiskon());
			hargaDTO.setStok(tbMotor.getTbHarga().getStok());
			hargaDTO.setHargaNetcash(tbMotor.getTbHarga().getHargaNetcash());
			hargaDTO.setSimulasiKredit(tbMotor.getTbHarga().getSimulasiKredit());

			mtr.setHargaDTO(hargaDTO);

			motorList.add(mtr);
		}

		return new ResponseEntity(motorList, HttpStatus.OK);
	}

	// Get Motor Menggunakan Id Motor
	@GetMapping("/{idMotor}")
	public ResponseEntity getMotorById(@PathVariable("idMotor") Long idMotor) {
		MotorDTO mtr = new MotorDTO();

		TbMotor tbMotor = tbMotorDao.findOne(idMotor);

		if (tbMotor != null) {
			mtr.setIdMotor(tbMotor.getIdMotor());
			mtr.setJenisMotor(tbMotor.getJenisMotor());
			mtr.setMerekMotor(tbMotor.getMerekMotor());
			mtr.setTipeMotor(tbMotor.getTipeMotor());
			mtr.setUrlGambar(tbMotor.getUrlGambar());
			mtr.setDeskripsiMotor(tbMotor.getDeskripsiMotor());
			mtr.setTransmisiMotor(tbMotor.getTransmisiMotor());
			mtr.setCc(tbMotor.getCc());
			mtr.setTahun(tbMotor.getTahun());
			mtr.setWarnaMotor(tbMotor.getWarnaMotor());
			mtr.setCreatedBy(tbMotor.getCreatedBy());
			mtr.setCreatedAt(tbMotor.getCreatedAt());
			mtr.setUpdatedBy(tbMotor.getUpdatedBy());
			mtr.setUpdatedAt(tbMotor.getUpdatedAt());

			HargaDTO hargaDTO = new HargaDTO();
			hargaDTO.setIdMotor(tbMotor.getTbHarga().getIdMotor());
			hargaDTO.setHargaOtr(tbMotor.getTbHarga().getHargaOtr());
			hargaDTO.setDiskon(tbMotor.getTbHarga().getDiskon());
			hargaDTO.setStok(tbMotor.getTbHarga().getStok());
			hargaDTO.setHargaNetcash(tbMotor.getTbHarga().getHargaNetcash());
			hargaDTO.setSimulasiKredit(tbMotor.getTbHarga().getSimulasiKredit());

			mtr.setHargaDTO(hargaDTO);
		} else
			return new ResponseEntity("Not Found", HttpStatus.NOT_FOUND);

		return new ResponseEntity(mtr, HttpStatus.OK);
	}

	// Untuk Insert atau update motor
	@PostMapping("/insertMotor")
	public ResponseEntity insertOrUpdateMotor(@RequestBody MotorDTO data) {
		if (data == null)
			return new ResponseEntity("Failed", HttpStatus.GONE);
		TbMotor tbMotor = tbMotorDao.findOne(data.getIdMotor());

		HargaDTO hargaDTO = new HargaDTO();

		if (tbMotor == null) {
			// Untuk insert
			TbMotor tbm = new TbMotor();
			tbm.setJenisMotor(data.getJenisMotor());
			tbm.setMerekMotor(data.getMerekMotor());
			tbm.setTipeMotor(data.getTipeMotor());
			tbm.setUrlGambar(data.getUrlGambar());
			tbm.setDeskripsiMotor(data.getDeskripsiMotor());
			tbm.setTransmisiMotor(data.getTransmisiMotor());
			tbm.setCc(data.getCc());
			tbm.setTahun(data.getTahun());
			tbm.setWarnaMotor(data.getWarnaMotor());
			tbm.setCreatedBy("USER");
			tbm.setCreatedAt(new Date());

			TbHarga tbHarga = new TbHarga();

			tbHarga.setHargaOtr(hargaDTO.getHargaOtr());
			tbHarga.setDiskon(hargaDTO.getDiskon());
			tbHarga.setStok(hargaDTO.getStok());
			tbHarga.setHargaNetcash(hargaDTO.getHargaNetcash());
			tbHarga.setSimulasiKredit(hargaDTO.getSimulasiKredit());

			tbm.setTbHarga(tbHarga);

			tbMotorDao.save(tbm);
		} else {
			// Untuk update
			tbMotor.setJenisMotor(data.getJenisMotor());
			tbMotor.setMerekMotor(data.getMerekMotor());
			tbMotor.setTipeMotor(data.getTipeMotor());
			tbMotor.setUrlGambar(data.getUrlGambar());
			tbMotor.setDeskripsiMotor(data.getDeskripsiMotor());
			tbMotor.setTransmisiMotor(data.getTransmisiMotor());
			tbMotor.setCc(data.getCc());
			tbMotor.setTahun(data.getTahun());
			tbMotor.setWarnaMotor(data.getWarnaMotor());
			tbMotor.setUpdatedBy("USER");
			tbMotor.setUpdatedAt(new Date());

			TbHarga tbHarga = new TbHarga();

			tbHarga.setHargaOtr(hargaDTO.getHargaOtr());
			tbHarga.setDiskon(hargaDTO.getDiskon());
			tbHarga.setStok(hargaDTO.getStok());
			tbHarga.setHargaNetcash(hargaDTO.getHargaNetcash());
			tbHarga.setSimulasiKredit(hargaDTO.getSimulasiKredit());

			tbMotor.setTbHarga(tbHarga);

			tbMotorDao.save(tbMotor);
		}

		return new ResponseEntity("Success", HttpStatus.OK);
	}

	// Untuk delete motor
	@PostMapping("/delete")
	public ResponseEntity deleteMotor(@RequestBody Long idMotor) {
		TbMotor tbMotor = tbMotorDao.findOne(idMotor);

		if (tbMotor != null) {
			tbMotorDao.delete(idMotor);
		} else
			return new ResponseEntity(HttpStatus.GONE);

		return new ResponseEntity("Success", HttpStatus.OK);
	}
}