package com.graphicaInternational.datajpa;

import java.security.PublicKey;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.graphicaInternational.datajpa.dao.StudentDAO;
import com.graphicaInternational.datajpa.entity.Student;

@SpringBootApplication
public class DatajpaApplication {
	@Autowired
	StudentDAO studentDAO;

	public static void main(String[] args) {
		SpringApplication.run(DatajpaApplication.class, args);
	}	
		public void run(String...args ) throws Exception{
			saveStudent();
			
			Student student= studentDAO.findById(1);
			System.out.println(student);
			
			List<Student> allStudentList = studentDAO.findAllStudent();
			allStudentList.forEach(allStudent -> System.out.println(allStudent));
			
			List<Student> allStudentWithFirstName = studentDAO.findAllStudentWithFirstName("Bijay");
			allStudentWithFirstName.forEach(studentWithFirstName -> System.out.println(studentWithFirstName));
			
		
	}
	
	public void saveStudent() {
		// transient obj
		Student student = new Student();
		student.setAddress("NYC");
		student.setMobileNumber(454443);
		student.setStudentName("John Doe");
	}

}
