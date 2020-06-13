package com.lxisoft.mockexamjpa.repository;

import com.lxisoft.mockexamjpa.entity.Exam;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ExamRepo")
public interface ExamRepo extends JpaRepository<Exam,Integer>
{


	

	
}
