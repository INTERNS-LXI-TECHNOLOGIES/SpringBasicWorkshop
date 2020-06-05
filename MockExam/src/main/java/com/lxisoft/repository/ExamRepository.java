package com.lxisoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.entity.ExamModel;

@Repository("examRepository")
public interface ExamRepository extends JpaRepository<ExamModel, Integer> {

	void addExam(ExamModel examModel);

	List<ExamModel> getAllExam();

	void deleteExam(Integer examId);

	ExamModel getExam(int exmid);

	ExamModel updateExam(ExamModel examModel);

}