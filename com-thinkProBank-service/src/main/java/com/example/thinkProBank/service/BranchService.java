package com.example.thinkProBank.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.example.thinkProBank.domain.Branch;

@Service
public interface BranchService {

	public abstract Branch getBranchById(int id);

	public abstract boolean saveBranch(Branch branch);

	public abstract boolean updateBranch(Branch branch);

	public abstract void deleteBranch(int id) throws InterruptedException;

	public abstract Collection<Branch> getAllBranches();
}
