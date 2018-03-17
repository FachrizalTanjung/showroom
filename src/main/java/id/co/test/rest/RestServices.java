package id.co.test.rest;

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

import id.co.test.dao.CustomerDao;
import id.co.test.dto.CustomerDTO;
import id.co.test.model.Customer;

@RestController
@RequestMapping("/rest/customer")
public class RestServices {
	
	//@RequestBody = request berupa string
	
	@Autowired
	private CustomerDao customerDao;
	
	//Get Semua Data Customer
	@GetMapping("/all")
    public ResponseEntity getAllCustomer()
	{
		//Membuat list kosong
		List<CustomerDTO> customerList = new ArrayList<CustomerDTO>();
		
		//Looping data di tabel customer
        for(Customer customer : customerDao.findAll())
        {
        	CustomerDTO cst = new CustomerDTO();
        	
        	//Set data di tabel ke dto
        	cst.setIdCustomer(customer.getIdcustomer());
        	cst.setNamaCustomer(customer.getNamacustomer());
        	cst.setTempatLahir(customer.getTempatlahir());
        	cst.setTanggalLahir(customer.getTanggallahir());
        	cst.setPekerjaan(customer.getPekerjaan());
        	cst.setAlamat(customer.getAlamat());
        	
        	//Menampung hasil looping data ke dalam list
        	customerList.add(cst);
        }
		
		return new ResponseEntity(customerList, HttpStatus.OK);
    }
	
	//Get Customer Menggunakan Id Customer
	@GetMapping("/{idCustomer}")
    public ResponseEntity getCustomerById(@PathVariable("idCustomer") String idCustomer)
	{
		CustomerDTO cst = new CustomerDTO();
		
		Customer customer = customerDao.findOne(idCustomer);
		
		if(customer != null)
		{
			cst.setIdCustomer(customer.getIdcustomer());
			cst.setNamaCustomer(customer.getNamacustomer());
			cst.setTempatLahir(customer.getTempatlahir());
			cst.setTanggalLahir(customer.getTanggallahir());
			cst.setPekerjaan(customer.getPekerjaan());
			cst.setAlamat(customer.getAlamat());
		}
		else
			return new ResponseEntity("Not Found", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity(cst, HttpStatus.OK);
    }
	
	//Untuk Insert atau update customer
	@PostMapping("/insert")
    public ResponseEntity insertOrUpdateCustomer(@RequestBody CustomerDTO data)
	{
		if(data == null)
			return new ResponseEntity("Failed",HttpStatus.GONE);;
		
		Customer customer = customerDao.findOne(data.getIdCustomer());
		
		if(customer == null)
		{
			//Untuk insert
			Customer cstInsert = new Customer();
			cstInsert.setIdcustomer(data.getIdCustomer());
			cstInsert.setNamacustomer(data.getNamaCustomer());
			cstInsert.setTempatlahir(data.getTempatLahir());
			cstInsert.setTanggallahir(data.getTanggalLahir());
			cstInsert.setPekerjaan(data.getPekerjaan());
			cstInsert.setAlamat(data.getAlamat());
			
			customerDao.save(cstInsert);
		} else
		{
			//Untuk update
			customer.setNamacustomer(data.getNamaCustomer());
			customer.setTempatlahir(data.getTempatLahir());
			customer.setTanggallahir(data.getTanggalLahir());
			customer.setPekerjaan(data.getPekerjaan());
			customer.setAlamat(data.getAlamat());
			
			customerDao.save(customer);
		}
		
		return new ResponseEntity("Success",HttpStatus.OK);
    }
	
	//Untuk delete customer
	@PostMapping("/delete")
	public ResponseEntity deleteCustomer(@RequestBody String idCustomer) 
	{
		Customer customer = customerDao.findOne(idCustomer);

		if (customer != null)
		{
			customerDao.delete(customer);
		} else
			return new ResponseEntity(HttpStatus.GONE);

		return new ResponseEntity("Success",HttpStatus.OK);
	}
}