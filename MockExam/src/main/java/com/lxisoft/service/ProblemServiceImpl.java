package com.lxisoft.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxisoft.dao.ProblemDao;
import com.lxisoft.model.Problem;

@Service
@Transactional
public class ProblemServiceImpl implements ProblemService {

    @Autowired
    private ProblemDao problemDao;

    @Override
    @Transactional
    public void addProblem(Problem prblm) {

        problemDao.addProblem(prblm);

    }

    @Override
    @Transactional
    public void deleteProblem(int qid) {

        problemDao.deleteProblem(qid);
    }

    @Override
    @Transactional
    public void updateProblem(Problem prblm) {

       problemDao.updateProblem(prblm);
    }

    @Override
    @Transactional
    public List<Problem> getProblemData() {

        return problemDao.getProblemData();
    }

}
