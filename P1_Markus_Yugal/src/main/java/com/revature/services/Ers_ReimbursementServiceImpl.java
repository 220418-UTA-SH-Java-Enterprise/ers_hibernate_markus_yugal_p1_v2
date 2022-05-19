package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;

import com.revature.dao.Ers_ReimbursementDao;
import com.revature.dao.Ers_ReimbursementDAOImpl;
import com.revature.models.Ers_Reimbursement;

public class Ers_ReimbursementServiceImpl implements Ers_ReimbursementService{
	private Ers_ReimbursementDao ersdao;
	private static Logger log = Logger.getLogger(Ers_ReimbursementServiceImpl.class);
	
	// Introduce Dependency Injection via Constructor injection
	public Ers_ReimbursementServiceImpl(Ers_ReimbursementDAOImpl dao) {
		super();
		this.ersdao = dao;
	}

	@Override
	public int addReimbursement(Ers_Reimbursement ers) {
		log.info("In service layer. Adding Reimbursement: " + ers);
		return ersdao.insert(ers);
	}

	@Override
	public Ers_Reimbursement findReimbursementById(int id) {
		System.out.println("In service layer. Finding reimbursement by id num: " + id);
		return ersdao.selectById(id);
	}

	@Override
	public List<Ers_Reimbursement> findAllReimbursements() {
		System.out.println("In service layer. Finding all users...");
		return ersdao.selectAll();
	}

}