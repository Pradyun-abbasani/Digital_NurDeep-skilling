package com.cognizant.ormlearn;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.service.EmployeeService;

@SpringBootApplication
public class OrmLearnApplication1 {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication1.class);

	private static EmployeeService employeeService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication1.class, args);
		employeeService = context.getBean(EmployeeService.class);
		
		testAddEmployee();
		testGetAllEmployees();
	}

	private static void testAddEmployee() {
		LOGGER.info("Start testAddEmployee");
		Employee emp = new Employee();
		emp.setName("Jane Smith");
		emp.setSalary(60000);
		emp.setPermanent(true);
		emp.setDateOfBirth(new Date());

		employeeService.addEmployee(emp);
		LOGGER.info("Employee added successfully");
		LOGGER.info("End testAddEmployee");
	}

	private static void testGetAllEmployees() {
		LOGGER.info("Start testGetAllEmployees");
		List<Employee> employees = employeeService.getAllEmployees();
		LOGGER.debug("employees={}", employees);
		LOGGER.info("End testGetAllEmployees");
	}
}
