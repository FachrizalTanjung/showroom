package com.showroom.dao;

import org.springframework.data.repository.CrudRepository;

import com.showroom.model.Customer;

public interface CustomerDao extends CrudRepository<Customer, String> {

}

