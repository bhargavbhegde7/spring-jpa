package com.bhargav.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.bhargav.config.BeanConfiguration;
import com.bhargav.model.Employee;
import com.bhargav.repo.EmployeeRepo;

//this link
//http://stackoverflow.com/questions/8313070/spring-bean-injection-in-a-main-method-class


public class EmployeeMaster {
	
	@Autowired
	public static EmployeeRepo employeeRepo;
	
	public static void main(String...strings) {
		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		EmployeeRepo employeeRepo = context.getBean(EmployeeRepo.class);
		
		Employee emp = new Employee();
		emp.setEmail("someemail");
		emp.setFirstName("somefname");
		emp.setLastName("somelname");
		emp.setIdEmployee("fdb234");
		Employee createdEmp = employeeRepo.save(emp);
		System.out.println(createdEmp.toString());
		
		System.out.println("EMPLOYEE DETAILS");
		Iterable<Employee> emps = employeeRepo.findAll();
		for (Employee employee : emps) {
			System.out.println(employee);
		}
		((AbstractApplicationContext) context).close();
	}
}
