package com.lxisoft.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lxisoft.entity.Exam;
import com.lxisoft.repository.ExamRepository;

@Service
@Transactional
public class ExamServiceImpl  {

    @Autowired
    private ExamRepository examRepository;

    	
	@Transactional
	public void addExam(Exam exam) {
		examRepository.addExam(exam);
	}

	
	@Transactional
	public List<Exam> getAllExams() {
		return examRepository.getAllExam();
	}

	
	@Transactional
	public void deleteExam(Integer examId) {
		examRepository.deleteExam(examId);
	}

	public Exam getExam(int exmid) {
		return examRepository.getExam(exmid);
	}

	public Exam updateExam(Exam exam) {
		
		return examRepository.updateExam(exam);
	}

	public void setExamDAO(ExamRepository examRepository) {
		this.examRepository = examRepository;
	}


}
