package com.revature.dao;

import java.util.List;


import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;



import com.revature.models.Ers_Reimbursement;
import com.revature.models.Ers_reimbursement_Type;
import com.revature.models.User;
import com.revature.models.UserRole;
import com.revature.models.Ers_reimbursement_Status;

import com.revature.util.HibernateUtil;

public class Ers_ReimbursementDAOImpl implements Ers_ReimbursementDao {
	
	
	private static Logger log = Logger.getLogger(Userdaoimpl.class);

	public int insertType(Ers_reimbursement_Type ers_reimbursement_type, Session ses, Transaction tx) {
		log.info("adding type to database. reimbursement type: " + ers_reimbursement_type);
		
		int typeid = (int) ses.save(ers_reimbursement_type);
		
		tx.commit();
		
		log.info("type has been saved as: " + typeid);
		return typeid;
	}
	
	public Ers_reimbursement_Type getReimTypeById(int id, Session ses) {
		log.info("get type by id. id: " + id);
		
		Ers_reimbursement_Type type = (Ers_reimbursement_Type) ses.createNativeQuery("SELECT * FROM Ers_Reimbursement_type WHERE reimb_typeid=" + id + "", Ers_reimbursement_Type.class).getSingleResult();
		
		return type;
	}
	
	@Override
	public int insert(Ers_Reimbursement ers_reimbursement) {

	log.info("adding user to database. user info: " + ers_reimbursement);
		
		Session ses = HibernateUtil.getSession();
		
		Transaction tx = ses.beginTransaction();
		int typeid = 0;
		try {
			typeid = insertType(ers_reimbursement.getReimbursementtype(), ses, tx);
		}catch(ConstraintViolationException e){
			log.info("This role already exist in database");
			tx.rollback();
			typeid = ers_reimbursement.getReimbursementtype().getReimb_type_id();
		}
		//ses.clear();
		Ers_reimbursement_Type type = getReimTypeById(typeid, ses);
		Transaction tx2 = ses.beginTransaction();
		ers_reimbursement.setReimbursementtype(type);
		
		int pk = (int) ses.save(ers_reimbursement);
		
		tx2.commit();
		log.info("Insert successful! New user id is " + pk);
		
		return pk;
	}

	@Override
	public Ers_Reimbursement selectById(int id) {
		
		System.out.println("searching user by id: " + id);
		Session ses = HibernateUtil.getSession();
		Ers_Reimbursement ers_reimbursement = (Ers_Reimbursement) ses.createNativeQuery("SELECT * FROM ers_users WHERE ers_user_id = " + id + "", Ers_Reimbursement.class).getSingleResult();
		
		System.out.println("Search complete! Found: " + ers_reimbursement);
		
		return ers_reimbursement;	
	}


	@Override
	public List<Ers_Reimbursement> selectAll() {
		
		Session ses = HibernateUtil.getSession();
		
		List<Ers_Reimbursement> reimbList = ses.createQuery("FROM Ers_Reimbursement ORDER BY id", Ers_Reimbursement.class).list();
		
		System.out.println("User list retrieval complete! Size: " + reimbList.size());
		
		return reimbList;
	}

	@Override
	public boolean update(Ers_Reimbursement user) {
		
		return false;
	}

	@Override
	public boolean delete(Ers_Reimbursement user) {
		
		return false;
	}

	@Override
	public Ers_Reimbursement selectByName(String name) {

		return null;
	}

	
}
