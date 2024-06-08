package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entites.Student;

public class App 
{
    private static ApplicationContext context;

	public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        
        // DAO call
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
        
        Student student= new Student();
        student.setId(4);
        student.setName("Amit");
        student.setCity("UK");
		/*
		 * int result = studentDao.insert(student);
		 *  System.out.println("insert data " + result);
		 */
        
        Student studentUp= new Student();
        studentUp.setId(4);
        studentUp.setName("Amit");
        studentUp.setCity("rewa");
        int result = studentDao.update(studentUp);
        System.out.println("update data " + result);
        
     }
}
