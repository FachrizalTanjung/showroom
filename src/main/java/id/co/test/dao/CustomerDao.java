package id.co.test.dao;

import org.springframework.data.repository.CrudRepository;

import id.co.test.model.Customer;

public interface CustomerDao extends CrudRepository<Customer, String> {

}

