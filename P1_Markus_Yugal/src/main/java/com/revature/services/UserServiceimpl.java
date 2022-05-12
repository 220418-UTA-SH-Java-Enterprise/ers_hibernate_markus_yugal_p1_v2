package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;


import com.revature.dao.Userdao;
import com.revature.dao.Userdaoimpl;
import com.revature.models.Employee;
import com.revature.models.User;

public class UserServiceimpl  implements UserService {

	private Userdao udao;
	private static Logger log = Logger.getLogger(Userdaoimpl.class);
	
	public UserServiceimpl(Userdaoimpl dao) {
		super();
		this.udao = dao; 
	}
	
	
	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		log.info("in service layer. Logging in user with creds: " + username + ", " + password);
		//utilize Streams API
		Optional<User> users = udao.selectAll()
				.stream()
				.filter(u -> (u.getUsername().equals(username) && u.getPassword().equals(password))) //filter out to all users that match criteria/condition
				.findFirst(); //returns the element that is left after filtering
		return (users.isPresent() ? users.get() : null);
	}

	@Override
	public User findUserById(int id) {
		log.info("in service layer. searching user by id: " + id);
		return udao.selectById(id);
	}

	@Override
	public List<User> findAllUsers() {
		log.info("in service layer. finding all users...");
		return udao.selectAll();
	}

	@Override
	public boolean editUser(User user) {
		log.info("in service layer. editing user: " + user);
		return udao.update(user);
	}

	@Override
	public boolean deleteUser(User user) {
		log.info("in service layer. removing user: " + user);
		return udao.delete(user);
	}
	
}
