	package com.greatlearning.debateEvent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.debateEvent.entity.Student;
import com.greatlearning.debateEvent.repositories.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepo;
	
	@Override
	public List<Student> findAll() {
		return studentRepo.findAll();
	}

	@Override
	public void save(Student students) {
		studentRepo.save(students);

	}

	@Override
	public Student findById(int student_id) {
		
		return studentRepo.findById(student_id).get();
	}

	@Override
	public void delete(Student students) {
		studentRepo.delete(students);

	}

}
