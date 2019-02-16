package com.service.thinkProTransaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.service.thinkProTransaction.domain.Transaction;

import java.util.Collection;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{


    @Modifying
    @Query(value = "SELECT * FROM thinkpro.transaction where (account_id = :account_id)", nativeQuery = true)
    Collection<Transaction> findAllTransactionsOfAccount(@Param("account_id") int account_id);


}
