package com.lxisoft.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lxisoft.model.ExamModel;

@Repository
public class ExamDAOImpl implements ExamDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addExam(ExamModel examModel) {
		sessionFactory.getCurrentSession().saveOrUpdate(examModel);

	}

	@SuppressWarnings("unchecked")
	public List<ExamModel> getAllExam() {

		return sessionFactory.getCurrentSession().createQuery("from ExamModel")
				.list();
	}

	@Override
	public void deleteExam(Integer examId) {
		ExamModel examModel = (ExamModel) sessionFactory.getCurrentSession().load(
				ExamModel.class, examId);
		if (null != examModel) {
			this.sessionFactory.getCurrentSession().delete(examModel);
		}

	}

	public ExamModel getExam(int exmid) {
		return (ExamModel) sessionFactory.getCurrentSession().get(
				ExamModel.class, exmid);
	}

	@Override
	public ExamModel updateExam(ExamModel examModel) {
		sessionFactory.getCurrentSession().update(examModel);
		return examModel;
	}

}