package com.revature.dao;

import java.util.List;

import com.revature.models.Ers_reimbursement_Type;

public interface Ers_reimbursement_TypeDAO {
	//Basic CRUD operations
	
	public Ers_reimbursement_Type selectReimbursementTypeId(int rid);
	
	public List<Ers_reimbursement_Type> selectAll();
	
	
	
	
}