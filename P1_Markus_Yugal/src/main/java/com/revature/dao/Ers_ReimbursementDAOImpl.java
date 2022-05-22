package com.revature.dao;

import java.sql.Timestamp;
import java.time.LocalDateTime;
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

	public int insertType(String reimb_type, Session ses, Transaction tx) {
		log.info("adding type to database. reimbursement type: " + reimb_type);
		
		int typeid = (int) ses.save(reimb_type);
		
		tx.commit();
		
		log.info("type has been saved as: " + typeid);
		return typeid;
	}
	
	//public String getReimTypeById(int id, Session ses) {
		//log.info("get type by id. id: " + id);
		
		//String type = (String) ses.createNativeQuery("SELECT * FROM Ers_Reimbursement_type WHERE reimb_typeid=" + id + "", Ers_reimbursement_Type.class).getSingleResult();
		
		//return type;
	//}
	
	@Override
	public boolean insert(Ers_Reimbursement ers) {

		System.out.println("New reimbursement info: " + ers);
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.clear();
		
		double reimb_amount = ers.getReimb_amount();
		Timestamp reimb_submitted = ers.getReimb_submitted();
		Timestamp reimb_resolved = ers.getReimb_resolved();
		String reimb_description = ers.getReimb_description();
		String reimb_receipt = ers.getReimb_receipt();
		String reimb_author = ers.getReimb_author();
		String reimb_resolver = ers.getReimb_resolver();
		int reimb_statusid = ers.getReimb_statusid();
		int reimb_type_id = ers.getReimb_id();
		String reimb_type = ers.getReimb_type();
		
		//ses.update(user);
		String sql = "insert into Ers_Reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_statusid, reimb_type_id, reimb_type) values (" + reimb_amount + "," + reimb_submitted + "," + reimb_resolved + "," + reimb_description + "," + reimb_receipt + "," + reimb_author + "," + reimb_resolver + "," + reimb_statusid + "," + reimb_type_id + "," + reimb_type + ")";
		ses.createNativeQuery(sql, Ers_Reimbursement.class)
		.setParameter(0, 0)
		.setParameter(0, 0)
		.executeUpdate();
		tx.commit();
		
		System.out.println("Reimbursement complete!");
		
		return true;
		
		
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

	@Override
	public int insert(String reimb_type) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
