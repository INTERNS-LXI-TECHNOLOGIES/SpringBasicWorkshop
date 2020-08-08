package com.lxisoft.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lxisoft.model.Problem;

@Repository
public class QuestionDaoImpl implements QuestionDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addQuestion(Problem que) {
        // TODO Auto-generated method stub
        sessionFactory.getCurrentSession().saveOrUpdate(que);
    }

    @Override
    public void delQuestion(Integer eid) {
        // TODO Auto-generated method stub
        sessionFactory.getCurrentSession().load(Problem.class, eid);
//		if(null != e)
//		{
//			this.sessionFactory.getCurrentSession().delete(e);
//		}
    }

    @Override
    public Problem updQuestion(Problem que) {
        // TODO Auto-generated method stub
        sessionFactory.getCurrentSession().update(que);
        return que;
    }

    @Override
    public Problem getQuestion(int eid) {
        // TODO Auto-generated method stub
        return (Problem) sessionFactory.getCurrentSession().get(Problem.class, eid);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Problem> getAllQuestion(Problem que) {
        // TODO Auto-generated method stub
        return sessionFactory.getCurrentSession().createQuery("from questions").list();
    }

}
