package com.showroom.dao;

import org.springframework.data.repository.CrudRepository;


import com.showroom.model.Motor;

public interface MotorDao extends CrudRepository<Motor, String> {

}

