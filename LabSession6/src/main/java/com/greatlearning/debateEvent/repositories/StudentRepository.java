package com.greatlearning.debateEvent.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.debateEvent.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {

	
}
