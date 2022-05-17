package com.revature.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.revature.models.Ers_reimbursement_Type;
import com.revature.util.HibernateUtil;

public class Ers_reimbursement_TypeDAOImpl implements Ers_reimbursement_TypeDAO{
	private static Logger log = Logger.getLogger(Ers_reimbursement_Type.class);

	@Override
	public Ers_reimbursement_Type selectReimbursementTypeId(int rid) {
		log.info("selecting reimbursement type by id " + rid);
		
		System.out.println("searching ers_reimbursement_type by id: " + rid);
		Session ses = HibernateUtil.getSession();
		Ers_reimbursement_Type ert = (Ers_reimbursement_Type) ses.createNativeQuery("SELECT * FROM Ers_Reimbursement_type WHERE reimb_typeid = " + rid + "", Ers_reimbursement_Type.class).getSingleResult();
		
		System.out.println("Search complete! Found: " + ert);
		
		log.info("ers reimbursement has been found: " + ert);
		return ert;
	}

	@Override
	public List<Ers_reimbursement_Type> selectAll() {
		log.info("selecting all ers reimbursements ");
		
		System.out.println("getting all ers data...");
		Session ses = HibernateUtil.getSession();
		
		List<Ers_reimbursement_Type> ersList = ses.createQuery("FROM Ers_Reimbursement_type ORDER BY reimb_typeid", Ers_reimbursement_Type.class).list();
		
		System.out.println("User list retrieval complete! Size: " + ersList.size());
		
		log.info("all ers reimbursements have been found " + ersList);
		return ersList;
	}

}