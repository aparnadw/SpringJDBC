package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entites.Student;

public class App 
{
    private static ApplicationContext context;

	public static void main( String[] args )
    {
        System.out.println( "With Annotation" );
        context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        
        // DAO call
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
        
        Student student= new Student();
        student.setId(4);
        student.setName("Amit");
        student.setCity("UK");		
		int resultI = studentDao.insert(student);
		System.out.println("insert data " + resultI);
		 
        
        Student studentUp= new Student();
        studentUp.setId(4);
        studentUp.setName("Amit");
        studentUp.setCity("rewa");
        int result = studentDao.update(studentUp);
        System.out.println("update data " + result);
        
        Student studentDel = new Student();
        studentDel.setId(4);
        int retDl = studentDao.delete(studentDel);
        System.out.println("deleted row " + retDl);
        
        Student studentSelect = studentDao.getStudent(3);
        System.out.println(studentSelect);
        
        List<Student> students = studentDao.getAllStudent();
        for (Student s: students) {
        	System.out.println(s);
        }
     }
}
