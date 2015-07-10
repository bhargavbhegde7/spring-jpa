package com.bhargav.config;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.bhargav.model.Employee;
import com.bhargav.repo.EmployeeRepo;

@Configuration
@EnableJpaRepositories("com.bhargav.repo")
@EnableTransactionManagement
public class BeanConfiguration {
	
	private LocalContainerEntityManagerFactoryBean lef;

	@Bean
	public DataSource dataSource() {

		BasicDataSource ds = new org.apache.commons.dbcp.BasicDataSource();

		ds.setDriverClassName("com.mysql.jdbc.Driver");

		ds.setUrl("jdbc:mysql://localhost:3306/empl");

		ds.setUsername("root");

		ds.setPassword("");
		
		return ds;
		
		/*EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
	    return builder.setType(EmbeddedDatabaseType.HSQL).build();*/

	}
	
	@Bean

	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {

		LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();

		lef.setDataSource(dataSource);

		lef.setJpaVendorAdapter(jpaVendorAdapter);

		lef.setPackagesToScan("com.bhargav.model");

		return lef;

	}

	@Bean

	public JpaVendorAdapter jpaVendorAdapter() {

		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();

		hibernateJpaVendorAdapter.setShowSql(false);

		hibernateJpaVendorAdapter.setGenerateDdl(true);

		hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);

		return hibernateJpaVendorAdapter;

	}

	@Bean

	public PlatformTransactionManager transactionManager() {

		return new JpaTransactionManager();

	}
	
	/*@Bean public EmployeeRepo employeeRepo()
	{
		
		return (EmployeeRepo) new SimpleJpaRepository(Employee.class, (EntityManager) lef);
	}*/
}
