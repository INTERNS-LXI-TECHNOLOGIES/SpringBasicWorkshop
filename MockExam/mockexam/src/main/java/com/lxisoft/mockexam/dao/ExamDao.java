package com.lxisoft.mockexam.dao;

import java.util.List;

import com.lxisoft.mockexam.model.Exam;

public interface ExamDao {
		
	public void addQuestion(Exam exam);
	public void delQuestion(int qid);
	public void updQuestion(Exam exam);
	public List<Exam> getExamData();
	public Exam getExamById(int examSlNo);

}
