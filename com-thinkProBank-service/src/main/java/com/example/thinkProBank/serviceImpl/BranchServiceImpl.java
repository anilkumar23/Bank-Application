package com.example.thinkProBank.serviceImpl;

import java.util.Collection;

import javax.transaction.Transactional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.thinkProBank.domain.Branch;
import com.example.thinkProBank.repository.AddressRepository;
import com.example.thinkProBank.repository.BankRepository;
import com.example.thinkProBank.repository.BranchRepository;
import com.example.thinkProBank.service.BranchService;

@Component
public class BranchServiceImpl implements BranchService {

    @Autowired
	private  BranchRepository branchRepository;
    
    @Autowired
  	private  BankRepository bankRepository;

	@Autowired
	private AddressRepository addressRepository;

	JSONObject jsonObj;

	@Transactional
	public Branch getBranchById(int branchCode) {
		return branchRepository.getOne(branchCode);
	}

	@Transactional
	public boolean saveBranch(Branch branch) {
		return branchRepository.save(branch) != null;
	}

	@Transactional
	public boolean updateBranch(Branch branch) {
		int branchCode= branch.getBranchCode();
		int addressID= branchRepository.getOne(branchCode).getAddress().getAddressId();
		branchRepository.deleteAddressId(branchCode);
		addressRepository.deleteById(addressID);
		return branchRepository.save(branch) != null;
	}


	@Transactional
	public Collection<Branch> getAllBranches() {
		return branchRepository.findAllActiveUsersNative();
	}
	
	@Transactional
	public void deleteBranch(int branchCode) throws InterruptedException {
		Branch branch = branchRepository.getOne(branchCode);
		int addressID= branch.getAddress().getAddressId();
		branchRepository.deleteAddressId(branchCode);
		addressRepository.deleteById(addressID);
		branchRepository.deleteBranch(branchCode);
	}

	
}
