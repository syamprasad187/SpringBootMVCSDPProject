package com.klef.jfsd.springboot.service;

import java.util.List;

import com.klef.jfsd.springboot.model.Employee;

public interface EmployeeService {
	
	public String EmployeeRegistration(Employee emp);
	public Employee checkEmployeeLogin(String eemail,String epwd);
	public String updateEmployeeProfile(Employee employee);
	public Employee displayEmployeeByID(int eid);
	public List<Employee> displayEmployeesByDept(String department);
}
