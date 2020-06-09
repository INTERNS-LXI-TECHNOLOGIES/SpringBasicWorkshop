package com.lxisoft.mockexamjavaconfig.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lxisoft.mockexamjavaconfig.model.Exam;

@Repository
public class ExamDaoImpl implements ExamDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addQuestion(Exam exam) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(exam);
		
	}

	@Override
	public void delQuestion(int qid) {
		
		Exam exam = (Exam)sessionFactory.getCurrentSession().load(Exam.class, qid);
		if(exam != null)
		{
			this.sessionFactory.getCurrentSession().delete(exam);
		}
	}

	@Override
	public Exam updQuestion(Exam exam) {
		
		sessionFactory.getCurrentSession().update(exam);
		return exam;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Exam> getExamData() {
		
		return sessionFactory.getCurrentSession().createQuery("From Exam").list();
	}

	@Override
	public Exam getExamById(int examSlNo) {
		
		return (Exam)sessionFactory.getCurrentSession().get(Exam.class, examSlNo);
	}

}
