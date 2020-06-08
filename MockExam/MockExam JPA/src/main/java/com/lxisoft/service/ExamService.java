package com.lxisoft.service;

import java.util.List;

import com.lxisoft.entity.ExamModel;

public interface ExamService {
	
	public void addExam(ExamModel examModel);

	public List<ExamModel> getAllExams();

	public void deleteExam(Integer examId);

	public ExamModel getExam(int examid);

	public ExamModel updateExam(ExamModel examModel);
}






