package com.companyportal.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companyportal.app.dao.EmployeeDao;
import com.companyportal.app.entity.Employee;
import com.companyportal.app.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static int count;

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public void saveEmployeeData(Employee employee) {
		employee.setEmployeeId(count++);

		employeeDao.saveEmployeeData(employee);
	}

	@Override
	public List<Employee> getEmployeesData() {

		return employeeDao.getEmployeesData();
	}

	@Override
	public void deleteEmployee(int employeeId) {
		// TODO Auto-generated method stub
		employeeDao.deleteEmployee(employeeId);
	}

}
