package com.lxisoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lxisoft.entity.ExamModel;
import com.lxisoft.repository.ExamRepository;

@Service
public class ExamServiceImpl  {

    @Autowired
    private ExamRepository examRepository;
          

	@Transactional
	public void addExam(ExamModel examModel) {
		examRepository.addExam(examModel);
	}

	
	@Transactional
	public List<ExamModel> getAllExams() {
		return examRepository.getAllExam();
	}

	
	@Transactional
	public void deleteExam(Integer examId) {
		examRepository.deleteExam(examId);
	}

	public ExamModel getExam(int exmid) {
		return examRepository.getExam(exmid);
	}

	public ExamModel updateExam(ExamModel examModel) {
		
		return examRepository.updateExam(examModel);
	}

	public void setExamRepository(ExamRepository examRepository) {
		this.examRepository = examRepository;
	}

	

}
