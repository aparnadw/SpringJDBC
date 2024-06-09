package com.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/*import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;*/

@Configuration
@ComponentScan(basePackages = {"com.spring.jdbc.dao"})
public class JdbcConfig {
	
	@Bean(name = {"ds"})
	public DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("root1234");
		return ds;
	}
	
	@Bean(name = {"jdbcTemplate"})
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		 jdbcTemplate.setDataSource(getDataSource()); 
		 return jdbcTemplate; 
	}
	
	/*
	 * Using @@Autowired we don't need to add DAO class in config
	 * @Bean(name = {"studentDao"}) public StudentDao getstudentDao() {
	 * StudentDaoImpl studentDao= new StudentDaoImpl();
	 * studentDao.setJdbcTemplate(getJdbcTemplate()); return studentDao; }
	 */
}
