package com.lxisoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lxisoft.entity.Exam;
import com.lxisoft.repository.ExamRepository;

@Service
public class ExamService {

	@Autowired
	ExamRepository<Exam> examRepository;
	
	@Transactional
	public List<Exam> findByName(String question) {
		return examRepository.findByQuestion(question);
	}

	@Transactional
	public List<Exam> getAllExam() {
		return (List<Exam>) examRepository.findAll();
	}

	@Transactional
	public void deleteExam(Long examId) {
		examRepository.deleteById(examId);
	}

	@Transactional
	public boolean addExam(Exam exam) {
		return examRepository.save(exam) != null;
	}

	@Transactional
	public boolean updateExam(Exam exam) {
		return examRepository.save(exam) != null;
	}
}
