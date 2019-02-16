package com.service.thinkProAccount.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.thinkProAccount.domain.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
