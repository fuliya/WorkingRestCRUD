package com.uhg.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhg.model.Employee;
import com.uhg.repository.EmployeeRepository;
@Service
public class EmployeeDAO {

	@Autowired
	EmployeeRepository employeeRespository;
	
	public Employee save(Employee emp) {
		return employeeRespository.save(emp);
	}
		public List<Employee> findAll(){
			return employeeRespository.findAll();
		}
		public Employee findOne(Long empID) {
			 return employeeRespository.getOne(empID);
		}
		
		public void delete(Employee emp) {
			 employeeRespository.delete(emp);
		}
}
