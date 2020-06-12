package com.lxisoft.mockexamjpa.repository;

import com.lxisoft.mockexamjpa.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepo extends JpaRepository<Exam,Integer>
{

}
