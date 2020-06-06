package com.lxisoft.dao;
import java.util.List;
import com.lxisoft.model.Exam;
public interface ExamDAO 
{
	public void addExam(Exam exam);
	 
    public List<Exam> getAllExam();
 
    public void deleteExam(Integer examId);
 
    public Exam updateExam(Exam exam);
 
    public Exam getExam(int examid);
}
