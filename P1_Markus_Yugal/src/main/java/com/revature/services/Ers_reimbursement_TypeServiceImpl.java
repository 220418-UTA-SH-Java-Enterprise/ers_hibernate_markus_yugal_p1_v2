package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;

import com.revature.dao.Ers_reimbursement_TypeDAO;
import com.revature.dao.Ers_reimbursement_TypeDAOImpl;
import com.revature.models.Ers_reimbursement_Type;

public class Ers_reimbursement_TypeServiceImpl implements Ers_reimbursement_TypeService{
	private Ers_reimbursement_TypeDAO ersdao;
	private static Logger log = Logger.getLogger(Ers_reimbursement_TypeServiceImpl.class);
	
	// Introduce Dependency Injection via Constructor injection
	public Ers_reimbursement_TypeServiceImpl(Ers_reimbursement_TypeDAOImpl dao) {
		super();
		this.ersdao = dao;
	}

	@Override
	public Ers_reimbursement_Type findErsReimbursementById(int rid) {
		System.out.println("In service layer. Finding ers reimbursement id num: " + rid);
		return ersdao.selectReimbursementTypeId(rid);
	}

	@Override
	public List<Ers_reimbursement_Type> findAllReimbursements() {
		System.out.println("In service layer. Finding all Reimbursements...");
		return ersdao.selectAll();
	}

}