package com.lxisoft.dao;

import java.util.List;
import com.lxisoft.model.Problem;

public interface QuestionDao {

    public void addQuestion(Problem que);
    public void delQuestion(Integer eid);
    public Problem updQuestion(Problem que);
    public Problem getQuestion(int eid);
    public List<Problem> getAllQuestion(Problem que);
}
