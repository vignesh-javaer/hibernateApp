/**
 * 
 */
package com.example.demo;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author vignesh
 *
 */
@Service
@Transactional
public class StudentRepositoryImpl {
	
	@Autowired private StudentRepository studentRepo;
	
	public void createStudent(final Student student) {
		studentRepo.save(student);
	}
	
	public List<Student> getAllStudent() {
		return studentRepo.findAll();
	}
	
	public Optional<Student> getStudent(final Long studentId) {
		return studentRepo.findById(studentId);
	}

}
