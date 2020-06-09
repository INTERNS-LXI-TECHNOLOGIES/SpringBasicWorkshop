package com.lxisoft.mockexamjavaconfig.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxisoft.mockexamjavaconfig.dao.ExamDao;
import com.lxisoft.mockexamjavaconfig.model.Exam;

@Service
@Transactional
public class ExamServiceImpl implements ExamService {

	@Autowired
	private ExamDao examDao;
	
	@Override
	@Transactional
	public void addQuestion(Exam exam) {
		
		examDao.addQuestion(exam);

	}

	@Override
	@Transactional
	public void delQuestion(int qid) {
		
		examDao.delQuestion(qid);
	}

	@Override
	@Transactional
	public Exam updQuestion(Exam exam) {
		
		return examDao.updQuestion(exam);
	}

	@Override
	@Transactional
	public List<Exam> getExamData() {
	
		return examDao.getExamData();
	}

	@Override
	public Exam getExamById(int examSlNo) {
		
		return examDao.getExamById(examSlNo);
	}

}
