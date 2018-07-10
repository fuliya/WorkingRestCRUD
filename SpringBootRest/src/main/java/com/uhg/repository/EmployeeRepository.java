package com.uhg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uhg.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
