package com.service.thinkProBranch.service;

import java.util.Collection;

import org.json.JSONException;

import com.service.thinkProBranch.domain.Branch;

public interface BranchService {

	public abstract String getBranchById(int id) throws JSONException;

	public abstract Branch getBranchInfo(int id);

	public abstract boolean saveBranch(Branch branch);

	public abstract boolean updateBranch(Branch branch);

	public abstract void deleteBranch(int id) throws InterruptedException;

	public abstract Collection<Branch> getAllBranches();
}
