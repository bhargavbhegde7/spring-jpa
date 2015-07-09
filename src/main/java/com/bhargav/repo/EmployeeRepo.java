package com.bhargav.repo;


import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.bhargav.model.Employee;

@Transactional
public interface EmployeeRepo extends CrudRepository<Employee, Integer>{
	
}
