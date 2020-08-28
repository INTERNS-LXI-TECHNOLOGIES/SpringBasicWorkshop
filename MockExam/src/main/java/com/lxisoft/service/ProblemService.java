package com.lxisoft.service;

import com.lxisoft.model.Problem;
import com.lxisoft.dao.ProblemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProblemService
{
    @Autowired
    private ProblemDao problemDao;

    @Transactional
    public List<Problem> getProblemData()
    {
        return problemDao.findAll();
    }

    @Transactional
    public void saveProblem(Problem exam)
    {
        problemDao.save(exam);
    }
    @Transactional
    public  void deleteProblem(int questionId)
    {
        problemDao.deleteProblem(questionId);
    }

    @Transactional
    public Problem getQuestionById(int id)
    {
        return problemDao.getQuestionById(id);
    }


}