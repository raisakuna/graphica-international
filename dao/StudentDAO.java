package com.graphicaInternational.datajpa.dao;

import java.util.List;

import org.hibernate.annotations.DialectOverride.Where;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.graphicaInternational.datajpa.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAO {
	
	@Autowired
	EntityManager eneEntityManager;
	
	@Transactional // begin
	public void save(Student student) {
		
		//giving the transient obj to persistence context (em)
		eneEntityManager.persist(student); // auto generating
		System.out.println("Student record saved...");
		
} // committed
	
	// finding student by id
	public Student findById(int id) {
		Student student = null;
		 student = eneEntityManager.find(Student.class, id);
		return  student;
	}

	// Finding all Students
	public List<Student> findAllStudent(){
		List<Student> studentList= null;
		// SELECT * FROM graphicainternational.students;
		// JPQL -> from Student (Student is an entity, class name. We are not getting it from database column name)
		TypedQuery<Student> query = eneEntityManager.createQuery("from Student", Student.class);
		studentList= query.getResultList();
		
		return studentList;
		
	}
	
	// Finding All Student where first name = 'Vijay'
	public List<Student> findAllStudentWithFirstName(String theName){
		List<Student> studentWithFirstName= null;
		// SELECT * FROM graphicainternational.students where studentname = 'Vijay'
		// JPQL -> from Student (Student is an entity, class name. We are not getting it from database column name)
		// This is hardcoded, you will only get Vijay value
		//TypedQuery<Student> query = eneEntityManager.createQuery("from Student Where studentNameWhere='Vijay'", Student.class);
		
		// For dynamic
		// Also remember there might be chance of SQL injection so security is very important
		TypedQuery<Student> query = eneEntityManager.createQuery("from Student Where studentNameWhere='name'", Student.class);
		query.setParameter("name", theName);

		studentWithFirstName= query.getResultList();
		
		return studentWithFirstName;
		
	}
}
