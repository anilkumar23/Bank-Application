package com.example.thinkProCustomer.ServiceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.thinkProCustomer.Domain.Customer;
import com.example.thinkProCustomer.Repository.AddressRepository;
import com.example.thinkProCustomer.Repository.CustomerRepository;
import com.example.thinkProCustomer.Service.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public boolean createCustomer(Customer customer) {
		return customerRepo.save(customer) !=null;
	}

	@Transactional
	public Customer getCustomerInfo(int CustomerId) {
		return customerRepo.getOne(CustomerId);
	}

	@Transactional
	public String getCustomerById(int CustomerId) throws JSONException {
		String str = customerRepo.getOne(CustomerId).toString();
		JsonParser jsonParser = new JsonParser();
		JsonObject objectFromString = jsonParser.parse(str).getAsJsonObject();
		System.out.println("CustomerDetails---->" + objectFromString);
		return String.valueOf(objectFromString);
	}


	@Override
	public boolean updateCustomer(Customer customer) {
		addressRepository.save(customer.getAddress());
		return customerRepo.save(customer) !=null;
	}

	@Transactional
	public void deleteCustomer(int CustomerId) {
		customerRepo.deleteById(CustomerId);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepo.findAll();
	}
	

}
