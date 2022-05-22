package com.revature.dao;

import java.util.List;

import com.revature.models.Ers_Reimbursement;

public interface Ers_ReimbursementDao {

	public boolean insert(Ers_Reimbursement ers_reimbursement);
	 List<Ers_Reimbursement> selectAll();
	
}
