package com.showroom.dao;

import org.springframework.data.repository.CrudRepository;

import com.showroom.model.TbBooking;

public interface TbBookingDao extends CrudRepository<TbBooking, String> {

}
