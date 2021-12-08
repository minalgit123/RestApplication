package com.companyportal.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.companyportal.app.entity.Employee;
import com.companyportal.app.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String displayRegistrationForm(Model model) {
		Employee employee = new Employee();

		model.addAttribute("employee", employee);
		return "employeeform";
	}

	@GetMapping(value = "/employees")
	@ResponseBody
	public List<Employee> getEmployeesData() {
		List<Employee> employeeList = employeeService.getEmployeesData();

		return employeeList;
	}

	@DeleteMapping(value = "/employees/{employeeId}")
	@ResponseBody
	public String deleteEmployee(@PathVariable int employeeId) {
		employeeService.deleteEmployee(employeeId);
		return "Employee Data Deleted Successfully";

	}

	@PostMapping(value = "/employees", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Employee saveEmployees(@RequestBody Employee employee) {
		employeeService.saveEmployeeData(employee);
		return employee;
	}

}
