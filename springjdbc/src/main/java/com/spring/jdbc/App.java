package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context = 
        		new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        JdbcTemplate template = context.getBean("JdbcTemplate", JdbcTemplate.class);
        
        //insert query
        String query = "insert into student(id, name, city) value(?,?,?)";
        int result = template.update(query, 2,"aarna", "bhopal");
        System.out.println("number of record inserted.." + result);
        
     }
}
