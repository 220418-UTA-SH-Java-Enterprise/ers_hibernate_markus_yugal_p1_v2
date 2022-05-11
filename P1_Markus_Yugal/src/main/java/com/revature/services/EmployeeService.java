package com.revature.services;

import java.util.List;

import com.revature.models.Employee;

public interface EmployeeService {

	public Employee login(String username, String password);
	
	public int register(Employee user);
	
	public Employee findUserById(int id);
	
	public Employee findUserByFirstName(String firstName);
	
	public List<Employee> findAllUsers();
	
	public boolean editUser(Employee user);
	
	public boolean deleteUser(Employee user);
}