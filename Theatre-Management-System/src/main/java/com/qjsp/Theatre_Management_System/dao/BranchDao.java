package com.qjsp.Theatre_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qjsp.Theatre_Management_System.Exception.BranchIdNotFound;
import com.qjsp.Theatre_Management_System.Repo.BranchRepository;
import com.qjsp.Theatre_Management_System.dto.Branch;

@Repository
public class BranchDao {

	@Autowired
	public BranchRepository branchRepository;
	
	public Branch saveBranch(Branch branch) {
		return branchRepository.save(branch);
	}
	
	public Branch fetchBranchById(int branchId) {
		Optional<Branch> optional = branchRepository.findById(branchId);
		if(optional.isEmpty()) {
			throw new BranchIdNotFound("No Branch present with the given Id "+branchId);
		}
		else {
			
			return branchRepository.findById(branchId).get();
		}
	}

	public Branch deleteBranchById(int branchId) {
		Branch branch = fetchBranchById(branchId);
		branchRepository.delete(branch);
		return branch;

	}

	public Branch updateBranchById(int branchId, Branch branch) {
		fetchBranchById(branchId);
		branch.setBranchId(branchId);
		return saveBranch(branch);

	}
	
	public List<Branch> fetchAll(){
		return branchRepository.findAll();
	}
	
}
