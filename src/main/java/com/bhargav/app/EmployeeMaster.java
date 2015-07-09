package com.bhargav.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.bhargav.config.BeanConfiguration;
import com.bhargav.model.Employee;
import com.bhargav.repo.EmployeeRepo;

public class EmployeeMaster {
	
	@Autowired
	public static EmployeeRepo employeeRepo;
	
	public static void main(String...strings) {
		System.out.println("Hello world");
		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		//EmployeeRepo repository = context.getBean(EmployeeRepo.class);
		
		
		
		Employee emp = new Employee();
		emp.setEmail("someemail");
		emp.setFirstName("somefname");
		emp.setLastName("somelname");
		emp.setIdEmployee("324");
		try{
		System.out.println(emp.toString());
		Employee createdEmp = employeeRepo.save(emp);
		System.out.println(createdEmp.toString());
		}catch(Exception e)
		{
			System.out.println("Exception in .save method : "+e.getMessage());
			e.printStackTrace();
		}
		
		//repository.save(emp);
		System.out.println("EMPLOYEE DETAILS");
		/*Iterable<Employee> emps = repository.findAll();
		for (Employee employee : emps) {
			System.out.println(employee);
		}*/
		((AbstractApplicationContext) context).close();
	}
}
