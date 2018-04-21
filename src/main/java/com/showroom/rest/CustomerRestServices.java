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

import com.showroom.dao.TbCustomerDao;
import com.showroom.dto.CustomerDTO;
import com.showroom.model.TbCustomer;

@RestController
@RequestMapping("/rest/customer")
public class CustomerRestServices {

	// @RequestBody = request berupa string

	@Autowired
	private TbCustomerDao tbCustomerDao;

	// Get Semua Data Customer
	@GetMapping("/all")
	public ResponseEntity getAllCustomer() {
		// Membuat list kosong
		List<CustomerDTO> customerList = new ArrayList<CustomerDTO>();

		// Looping data di tabel customer
		for (TbCustomer tbCustomer : tbCustomerDao.findAll()) {
			CustomerDTO cst = new CustomerDTO();

			// Set data di tabel ke dto
			cst.setIdCustomer(tbCustomer.getIdCustomer());
			cst.setNamaCustomer(tbCustomer.getNamaCustomer());
			cst.setTempatLahir(tbCustomer.getTempatLahir());
			cst.setTanggalLahir(tbCustomer.getTanggalLahir());
			cst.setPekerjaan(tbCustomer.getPekerjaan());
			cst.setAlamat(tbCustomer.getAlamat());
			cst.setCreatedBy(tbCustomer.getCreatedBy());
			cst.setCreatedAt(tbCustomer.getCreatedAt());
			cst.setUpdatedBy(tbCustomer.getUpdatedBy());
			cst.setUpdatedAt(tbCustomer.getUpdatedAt());

			// Menampung hasil looping data ke dalam list
			customerList.add(cst);
		}

		return new ResponseEntity(customerList, HttpStatus.OK);
	}

	// Get Customer Menggunakan Id Customer
	@GetMapping("/{idCustomer}")
	public ResponseEntity getCustomerById(@PathVariable("idCustomer") Long idCustomer) {
		CustomerDTO cst = new CustomerDTO();

		TbCustomer tbCustomer = tbCustomerDao.findOne(idCustomer);

		if (tbCustomer != null) {
			cst.setIdCustomer(tbCustomer.getIdCustomer());
			cst.setNamaCustomer(tbCustomer.getNamaCustomer());
			cst.setTempatLahir(tbCustomer.getTempatLahir());
			cst.setTanggalLahir(tbCustomer.getTanggalLahir());
			cst.setPekerjaan(tbCustomer.getPekerjaan());
			cst.setAlamat(tbCustomer.getAlamat());
			cst.setCreatedBy(tbCustomer.getCreatedBy());
			cst.setCreatedAt(tbCustomer.getCreatedAt());
			cst.setUpdatedBy(tbCustomer.getUpdatedBy());
			cst.setUpdatedAt(tbCustomer.getUpdatedAt());
		} else
			return new ResponseEntity("Not Found", HttpStatus.NOT_FOUND);

		return new ResponseEntity(cst, HttpStatus.OK);
	}

	// Untuk Insert atau update customer
	@PostMapping("/insert")
	public ResponseEntity insertOrUpdateCustomer(@RequestBody CustomerDTO data) {
		if (data == null)
			return new ResponseEntity("Failed", HttpStatus.GONE);

		TbCustomer tbCustomer = tbCustomerDao.findOne(data.getIdCustomer());

		if (tbCustomer == null) {
			// Untuk insert
			TbCustomer cst = new TbCustomer();
			cst.setNamaCustomer(data.getNamaCustomer());
			cst.setTempatLahir(data.getTempatLahir());
			cst.setTanggalLahir(data.getTanggalLahir());
			cst.setPekerjaan(data.getPekerjaan());
			cst.setAlamat(data.getAlamat());
			cst.setCreatedBy("USER");
			cst.setCreatedAt(new Date());

			tbCustomerDao.save(cst);
		} else {
			// Untuk update
			tbCustomer.setNamaCustomer(data.getNamaCustomer());
			tbCustomer.setTempatLahir(data.getTempatLahir());
			tbCustomer.setTanggalLahir(data.getTanggalLahir());
			tbCustomer.setPekerjaan(data.getPekerjaan());
			tbCustomer.setAlamat(data.getAlamat());
			tbCustomer.setUpdatedBy("USER");
			tbCustomer.setUpdatedAt(new Date());

			tbCustomerDao.save(tbCustomer);
		}

		return new ResponseEntity("Success", HttpStatus.OK);
	}

	// Untuk delete customer
	@PostMapping("/delete")
	public ResponseEntity deleteCustomer(@RequestBody Long idCustomer) {
		TbCustomer tbCustomer = tbCustomerDao.findOne(idCustomer);

		if (tbCustomer != null) {
			tbCustomerDao.delete(tbCustomer);
		} else
			return new ResponseEntity(HttpStatus.GONE);

		return new ResponseEntity("Success", HttpStatus.OK);
	}
}