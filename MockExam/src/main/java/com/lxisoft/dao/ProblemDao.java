package com.lxisoft.dao;

import java.util.List;

import com.lxisoft.model.Problem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository("ProblemDao")
public interface ProblemDao extends JpaRepository<Problem,Integer> {

//    public void addProblem(Problem prblm);
//    public void deleteProblem(int qid);
//    public void editProblem(Problem prblm);
//    public List<Problem> getProblemData();
//    public Problem getQuestionById(int examSlNo);

   public Problem getQuestionById(int examSlNo) ;
//
//        return (Problem) sessionFactory.getCurrentSession().get(Problem.class, examSlNo);
//
    public void deleteProblem(int qid) ;
//
//        Problem prblm = (Problem) sessionFactory.getCurrentSession().load(Problem.class, qid);
//        if(prblm != null)
//        {
//            this.sessionFactory.getCurrentSession().delete(prblm);
//        }

}
