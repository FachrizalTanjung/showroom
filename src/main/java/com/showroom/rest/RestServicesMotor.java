package com.showroom.rest;

import java.util.ArrayList;
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

import com.showroom.dao.MotorDao;
import com.showroom.dto.MotorDTO;
import com.showroom.model.Motor;

@RestController
@RequestMapping("/rest/motor")
public class RestServicesMotor {

	@Autowired
	private MotorDao motorDao;

	@GetMapping("/all")
	public ResponseEntity getAllMotor() {

		List<MotorDTO> motorList = new ArrayList<MotorDTO>();

		for (Motor motor : motorDao.findAll()) {
			MotorDTO mtr = new MotorDTO();

			// Set data di tabel ke dto
			mtr.setIdMotor(motor.getIdMotor());
			mtr.setBebek(motor.getBebek());
			mtr.setMatic(motor.getMatic());
			mtr.setSport(motor.getSport());

			motorList.add(mtr);
		}

		return new ResponseEntity(motorList, HttpStatus.OK);
	}

	// Get Motor Menggunakan Id Motor
	@GetMapping("/{idMotor}")
	public ResponseEntity getMotorById(@PathVariable("idMotor") String idMotor) {
		MotorDTO mtr = new MotorDTO();

		Motor motor = motorDao.findOne(idMotor);

		if (motor != null) {
			mtr.setIdMotor(motor.getIdMotor());
			mtr.setBebek(motor.getBebek());
			mtr.setMatic(motor.getMatic());
			mtr.setSport(motor.getSport());
		} else
			return new ResponseEntity("Not Found", HttpStatus.NOT_FOUND);

		return new ResponseEntity(mtr, HttpStatus.OK);
	}

	// Untuk Insert atau update motor
	@PostMapping("/insertMotor")
	public ResponseEntity insertOrUpdateMotor(@RequestBody MotorDTO data) {
		if (data == null)
			return new ResponseEntity("Failed", HttpStatus.GONE);
		Motor motor = motorDao.findOne(data.getIdMotor());

		if (motor == null) {
			// Untuk insert
			Motor mtrInsert = new Motor();
			mtrInsert.setIdMotor(data.getIdMotor());
			mtrInsert.setBebek(data.getBebek());
			mtrInsert.setBebek(data.getBebek());
			mtrInsert.setMatic(data.getMatic());
			mtrInsert.setSport(data.getSport());

			motorDao.save(mtrInsert);
		} else {
			// Untuk update
			motor.setIdMotor(data.getIdMotor());
			motor.setBebek(data.getBebek());
			motor.setMatic(data.getMatic());
			motor.setSport(data.getSport());

			motorDao.save(motor);
		}

		return new ResponseEntity("Success", HttpStatus.OK);
	}

	// Untuk delete motor
	@PostMapping("/delete")
	public ResponseEntity deleteMotor(@RequestBody String idMotor) {
		Motor motor = motorDao.findOne(idMotor);

		if (motor != null) {
			motorDao.delete(motor);
		} else
			return new ResponseEntity(HttpStatus.GONE);

		return new ResponseEntity("Success", HttpStatus.OK);
	}
}