package com.showroom.dao;

import org.springframework.data.repository.CrudRepository;

import com.showroom.model.TbCustomer;

public interface TbCustomerDao extends CrudRepository<TbCustomer, Long> {

}

