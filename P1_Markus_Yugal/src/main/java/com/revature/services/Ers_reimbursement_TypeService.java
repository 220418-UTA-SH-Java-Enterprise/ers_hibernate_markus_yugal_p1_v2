package com.revature.services;

import java.util.List;

import com.revature.models.Ers_reimbursement_Type;

public interface Ers_reimbursement_TypeService {
	
	public Ers_reimbursement_Type findErsReimbursementById(int id);
	
	public List<Ers_reimbursement_Type> findAllReimbursements();
	
}