package com.lxisoft.dao;

import java.util.List;
import com.lxisoft.model.ExamModel;

public interface ExamDAO {

	public void addExam(ExamModel examModel);

	public List<ExamModel> getAllExam();

	public void deleteExam(Integer examId);

	public ExamModel updateExam(ExamModel examModel);

	public ExamModel getExam(int examid);
}
