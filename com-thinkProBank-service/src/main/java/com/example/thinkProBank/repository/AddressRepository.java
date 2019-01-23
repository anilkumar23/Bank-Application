package com.example.thinkProBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.thinkProBank.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    @Modifying
    @Query("DELETE FROM Address WHERE address_id = :address_id")
    void deleteById(@Param("address_id") int addressId);

}
