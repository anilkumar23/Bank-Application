package com.service.thinkProBranch.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.thinkProBranch.domain.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Integer> {


}
