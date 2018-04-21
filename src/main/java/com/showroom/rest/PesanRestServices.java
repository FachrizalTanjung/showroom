package com.showroom.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.showroom.dao.TbBookingDao;
import com.showroom.dto.BookingDTO;
import com.showroom.model.TbBooking;

@RestController
@RequestMapping("/rest/pesan")
public class PesanRestServices {

	@Autowired
	private TbBookingDao tbBookingDao;

	@PostMapping("/insertPesan")
	public ResponseEntity insertOrUpdatePesan(@RequestBody BookingDTO data) {

		if (data == null)
			return new ResponseEntity("Failed", HttpStatus.GONE);

		TbBooking tbBooking = tbBookingDao.findOne(data.getTiketPesan());

		if (tbBooking == null) {
			TbBooking tbb = new TbBooking();
			tbb.setTiketPesan(data.getTiketPesan());
			tbb.setNama(data.getNama());
			tbb.setNomorTelepon(data.getNomorTelepon());
			tbb.setAlamat(data.getAlamat());
			tbb.setIsiPesan(data.getIsiPesan());

			tbBookingDao.save(tbb);
		}

		return new ResponseEntity("Success", HttpStatus.OK);
	}

}
