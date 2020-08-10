package com.lxisoft.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lxisoft.model.Problem;

@Repository
public class ProblemDaoImpl implements ProblemDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addProblem(Problem prblm) {

        sessionFactory.getCurrentSession().saveOrUpdate(prblm);

    }

    @Override
    public void deleteProblem(int qid) {

        Problem prblm = (Problem) sessionFactory.getCurrentSession().load(Problem.class, qid);
        if(prblm != null)
        {
            this.sessionFactory.getCurrentSession().delete(prblm);
        }
    }

    @Override
    public void updateProblem(Problem prblm) {

        sessionFactory.getCurrentSession().update(prblm);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Problem> getProblemData() {

        return sessionFactory.getCurrentSession().createQuery("From Problem").list();
    }

}
