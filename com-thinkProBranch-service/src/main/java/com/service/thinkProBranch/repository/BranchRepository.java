package com.service.thinkProBranch.repository;


import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.service.thinkProBranch.domain.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer> {

    @Modifying
    @Query("UPDATE Branch SET address_id = NULL WHERE (branch_code = :branch_code)")
    void deleteAddressId(@Param("branch_code") int branchCode);

    @Modifying
    @Query("DELETE FROM Branch WHERE (branch_code = :branch_code)")
    void deleteBranch(@Param("branch_code") int branchCode);

    @Query(value = "SELECT * from Branch",
            nativeQuery = true)
    Collection<Branch> findAllActiveUsersNative();
}
/*    @Query(value = "SELECT branch_code FROM Branch group by bank_id having count(*) >= 2",
            nativeQuery = true)
    Collection<Branch> findDuplcates();*/