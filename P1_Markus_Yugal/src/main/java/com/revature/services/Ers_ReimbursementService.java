package com.revature.services;

import java.util.List;

import com.revature.models.Ers_Reimbursement;

public interface Ers_ReimbursementService {
	
	public boolean addReimbursement(Ers_Reimbursement ersReimb);
	
	public List<Ers_Reimbursement> findAllReimbursements();
	
}