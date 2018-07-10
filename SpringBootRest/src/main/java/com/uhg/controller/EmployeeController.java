package com.uhg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uhg.DAO.EmployeeDAO;
import com.uhg.model.Employee;

@RestController
@RequestMapping("/company")
public class EmployeeController {

	@Autowired
	EmployeeDAO employeeDao;

	// to save an employee
	@PostMapping("/employee")
	public Employee createEmployee(@Valid @RequestBody Employee emp) {
		return employeeDao.save(emp);
	}

	// to get all employee
	@GetMapping("/employee")
	public List<Employee> getAllEmployee() {
		return employeeDao.findAll();
	}

	// to get employee by id
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeID(@PathVariable(value = "id") Long id) {
		Employee emp = employeeDao.findOne(id);

		if (id == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
	}

	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long empID,
			@Valid @RequestBody Employee empDetails) {
		Employee emp = employeeDao.findOne(empID);

		if (empID == null) {
			return ResponseEntity.notFound().build();
		}
		emp.setId(empID);
		emp.setDestination(empDetails.getDestination());
		emp.setExperties(empDetails.getExperties());

		Employee updateEmployee = employeeDao.save(emp);

		return ResponseEntity.ok().body(updateEmployee);
	}

	// delete employee
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Employee> deleteEmp(@PathVariable(value = "id") Long empID) {
		Employee emp = employeeDao.findOne(empID);

		if (empID == null) {
			return ResponseEntity.notFound().build();
		}
		employeeDao.delete(emp);
		return ResponseEntity.ok().build();
	}
}
