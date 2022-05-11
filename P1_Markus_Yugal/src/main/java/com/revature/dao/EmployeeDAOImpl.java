package com.revature.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Employee;
import com.revature.util.HibernateUtil;

public class EmployeeDAOImpl implements EmployeeDAO{
	private static Logger log = Logger.getLogger(EmployeeDAOImpl.class);
	
	@Override
	public int insert(Employee user) {
		log.info("adding user to database. User info: " + user);
		
		Session ses = HibernateUtil.getSession();
		
		Transaction tx = ses.beginTransaction();
		
		int pk = (int) ses.save(user);
		
		tx.commit();
		
		log.info("insert successful! New user id is " + pk);
		return pk; //return the auto-generated pk
	}

	@Override
	public Employee selectById(int id) {
		log.info("searching user by id: " + id);
		
		Session ses = HibernateUtil.getSession();
		
		Employee user = (Employee) ses.createNativeQuery("SELECT * FROM store_users WHERE store_user_id = " + id + "", Employee.class).getSingleResult();
		
		log.info("Search complete! Found: " + user);
		
		return user;
	}

	@Override
	public Employee selectByFirstName(String firstName) {
		log.info("searching user by firstName: " + firstName);
		
		Session ses = HibernateUtil.getSession();
		
		Employee user = (Employee) ses.createNativeQuery("SELECT * FROM store_users WHERE store_user_firstname = '" + firstName + "'", Employee.class).getSingleResult();
		
		log.info("Search complete! Found: " + user);
		
		return user;
	}

	@Override
	public List<Employee> selectAll() {
		log.info("getting all users from database....");
		Session ses = HibernateUtil.getSession();
		List<Employee> userList = ses.createQuery("from User", Employee.class).list();
		log.info("User list retrieved! Size: " + userList.size());
		return userList;
	}

	@Override
	public boolean update(Employee user) {
		log.info("Updating user. User info: " + user);
		
		Session ses = HibernateUtil.getSession();
		
		Transaction tx = ses.beginTransaction();
		
		ses.clear();
		
		ses.update(user);
		
		tx.commit();
		
		log.info("update complete");
		
		return true;
	}

	@Override
	public boolean delete(Employee user) {
		log.info("Deleting user. User info: " + user);
		
		Session ses = HibernateUtil.getSession();
		
		Transaction tx = ses.beginTransaction();
		
		ses.clear();
		
		ses.delete(user);
		
		tx.commit();
		
		log.info("deletion complete");
		
		return true;
	}
}