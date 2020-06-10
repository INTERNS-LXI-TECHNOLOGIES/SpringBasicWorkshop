package com.lxisoft.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lxisoft.entity.Exam;

@Repository("examRepository")
public interface ExamRepository extends JpaRepository<Exam, Integer> {

	void addExam(Exam exam);

	List<Exam> getAllExam();

	void deleteExam(Integer examId);

	Exam getExam(int exmid);

	Exam updateExam(Exam exam);
}