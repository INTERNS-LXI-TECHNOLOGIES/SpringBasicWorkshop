package com.lxisoft.mockexam.service;

import java.util.List;

import com.lxisoft.mockexam.model.Exam;

public interface ExamService {
	
	
	public void addQuestion(Exam exam);
	public void delQuestion(int qid);
	public void updQuestion(Exam exam);
	public List<Exam> getExamData();
	public Exam getExamById(int examSlNo);
	
	
}
