package com.companyportal.app.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.companyportal.app.dao.EmployeeDao;
import com.companyportal.app.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveEmployeeData(Employee employee) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(employee);

		session.getTransaction().commit();

		session.close();
	}

	@Override
	public List<Employee> getEmployeesData() {

		List<Employee> empList = new ArrayList<Employee>();

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		empList = session.createQuery("From Employee").list();

		session.getTransaction().commit();

		session.close();

		return empList;

	}

	@Override
	public void deleteEmployee(int employeeId) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Employee empl = new Employee();
		empl.setEmployeeId(employeeId);
		session.delete(empl);

		session.getTransaction().commit();

		session.close();

	}

}
