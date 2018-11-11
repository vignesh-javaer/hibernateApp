package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DevHibernateStandaloneAppApplication implements CommandLineRunner {
	
	@Autowired private StudentRepositoryImpl respository;
	
	public static void main(String[] args) {
		SpringApplication.run(DevHibernateStandaloneAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<Student> allStudent = respository.getAllStudent();
		for (Student student : allStudent) {
			Long studentId = student.getStudentId();
			StudentInfo studentInfo = student.getStudentInfo();
			System.out.println("StudentId - "+studentId+", Student Info - "+studentInfo.getStudentPhone());
		}
		
		
	}
}
