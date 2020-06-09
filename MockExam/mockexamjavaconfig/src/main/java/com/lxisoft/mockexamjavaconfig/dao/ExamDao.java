package com.lxisoft.mockexamjavaconfig.dao;

import java.util.List;

import com.lxisoft.mockexamjavaconfig.model.Exam;

public interface ExamDao {
		
	public void addQuestion(Exam exam);
	public void delQuestion(int qid);
	public Exam updQuestion(Exam exam);
	public List<Exam> getExamData();
	public Exam getExamById(int examSlNo);

}
