package com.lxisoft.mockexam.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxisoft.mockexam.dao.ExamDao;
import com.lxisoft.mockexam.model.Exam;

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
	public void updQuestion(Exam exam) {
		
		examDao.updQuestion(exam);
	}

	@Override
	@Transactional
	public List<Exam> getExamData() {
	
		return examDao.getExamData();
	}

	@Override
	public Exam getExamById(int examSlNo) {
		// TODO Auto-generated method stub
		return examDao.getExamById(examSlNo);
	}

}
