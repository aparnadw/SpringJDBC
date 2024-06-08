package com.spring.jdbc.dao;

import java.util.List;

/*import java.sql.ResultSet;
import java.sql.SQLException;*/

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entites.Student;

public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate jdbcTemplate;

	public int insert(Student student) {
		String query = "insert into student(id, name, city) value(?,?,?)";
		int result = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());

		return result;
	}

	public int update(Student student) {
		String query = "update student set name=?, city=? where id=?";
		int result = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
		return result;
	}

	public int delete(Student student) {
		String query = "delete from student where id = ?";
		int result = this.jdbcTemplate.update(query, student.getId());
		return result;
	}

	public Student getStudent(int studentId) {
		String query = "select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(query, rowMapper, studentId);

		/*
		 * // using anonymous class Student student = (Student)
		 * this.jdbcTemplate.queryForObject(query, new RowMapper<Student>() { public
		 * Student mapRow(ResultSet rs, int rowNum) throws SQLException { Student
		 * student = new Student(); student.setId(rs.getInt(1));
		 * student.setName(rs.getString(2)); student.setCity(rs.getString(3)); return
		 * student; }
		 * 
		 * }, studentId);
		 */

		return student;
	}

	public List<Student> getAllStudent() {
		String query = "select * from student";
		List<Student> student = this.jdbcTemplate.query(query, new RowMapperImpl());
		return student;
	}


	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
