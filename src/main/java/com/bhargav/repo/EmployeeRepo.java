package com.bhargav.repo;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bhargav.model.Employee;

@Transactional
@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Long>{
	public Employee findByEmail(String email);
}
