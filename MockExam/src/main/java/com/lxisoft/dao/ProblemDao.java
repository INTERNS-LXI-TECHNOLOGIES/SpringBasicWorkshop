package com.lxisoft.dao;

import java.util.List;

import com.lxisoft.model.Problem;

public interface ProblemDao {

    public void addProblem(Problem prblm);
    public void deleteProblem(int qid);
    public void editProblem(Problem prblm);
    public List<Problem> getProblemData();
    public Problem getQuestionById(int examSlNo);
}
