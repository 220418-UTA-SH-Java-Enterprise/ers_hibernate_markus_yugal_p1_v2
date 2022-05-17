package com.revature.dao;

import java.util.List;

import com.revature.models.Ers_Reimbursement;

public interface Ers_ReimbursementDao {

	public int insert(Ers_Reimbursement ers_reimbursement);
	
	public Ers_Reimbursement selectById(int id);
	
	public Ers_Reimbursement selectByName(String name);
	
	public List<Ers_Reimbursement> selectAll();
	
	public boolean update(Ers_Reimbursement user);
	
	public boolean delete(Ers_Reimbursement user);
}
