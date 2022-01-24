package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entites.Student;

public class StudentDao {
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int insert(Student student) {
		
		Integer i = (Integer) this.hibernateTemplate.save(student);
		return i;
		
	}
	
	public Student getStudent(int studentId) {
		Student student = (Student) this.hibernateTemplate.get(Student.class, studentId);
		return student;
		
	}
	
	public List<Student> getAll(){
		List<Student> students = this.hibernateTemplate.loadAll(Student.class);
		return students;
	}
	
	@Transactional
	public void updateStudent(Student student) {
		this.hibernateTemplate.update(student);
	}
	
	@Transactional
	public Student deleteStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		return student;
		
	}

}
