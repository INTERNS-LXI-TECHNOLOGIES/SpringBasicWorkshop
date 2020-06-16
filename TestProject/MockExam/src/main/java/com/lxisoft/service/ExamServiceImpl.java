package com.lxisoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lxisoft.dao.ExamDAO;
import com.lxisoft.model.ExamModel;

@Service
@Transactional
public class ExamServiceImpl implements ExamService {

	@Autowired
	private ExamDAO examDAO;

	@Override
	@Transactional
	public void addExam(ExamModel examModel) {
		examDAO.addExam(examModel);
	}

	@Override
	@Transactional
	public List<ExamModel> getAllExams() {
		return examDAO.getAllExam();
	}

	@Override
	@Transactional
	public void deleteExam(Integer examId) {
		examDAO.deleteExam(examId);
	}

	public ExamModel getExam(int exmid) {
		return examDAO.getExam(exmid);
	}

	public ExamModel updateExam(ExamModel examModel) {
		
		return examDAO.updateExam(examModel);
	}

	public void setExamDAO(ExamDAO examDAO) {
		this.examDAO = examDAO;
	}

}
