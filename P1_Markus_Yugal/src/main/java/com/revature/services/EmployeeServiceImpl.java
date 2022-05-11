package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;

import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.models.Employee;

public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeDAO udao;
	private static Logger log = Logger.getLogger(EmployeeServiceImpl.class);
	
	//introducing dependency injection through use of a construction injection
	//so we are not manually injecting what we need for this class; we are handing that control over to the application
	public EmployeeServiceImpl(EmployeeDAOImpl dao) {
		super();
		this.udao = dao; //this is the same as this: private static UserDAO udao = new UserDAOImpl();
	}

	@Override
	public Employee login(String username, String password) {
		log.info("in service layer. Logging in user with creds: " + username + ", " + password);
		//utilize Streams API
		Optional<Employee> users = udao.selectAll()
				.stream()
				.filter(u -> (u.getUsername().equals(username) && u.getPassword().equals(password))) //filter out to all users that match criteria/condition
				.findFirst(); //returns the element that is left after filtering
		return (users.isPresent() ? users.get() : null);
	}

	@Override
	public int register(Employee user) {
		log.info("in service layer. Registering user: " + user);
		return udao.insert(user);
	}

	@Override
	public Employee findUserById(int id) {
		log.info("in service layer. searching user by id: " + id);
		return udao.selectById(id);
	}

	@Override
	public Employee findUserByFirstName(String firstName) {
		log.info("in service layer. searching user by first name: " + firstName);
		return udao.selectByFirstName(firstName);
	}

	@Override
	public List<Employee> findAllUsers() {
		log.info("in service layer. finding all users...");
		return udao.selectAll();
	}

	@Override
	public boolean editUser(Employee user) {
		log.info("in service layer. editing user: " + user);
		return udao.update(user);
	}

	@Override
	public boolean deleteUser(Employee user) {
		log.info("in service layer. removing user: " + user);
		return udao.delete(user);
	}

	
}