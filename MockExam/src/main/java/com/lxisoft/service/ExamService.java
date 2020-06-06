package com.lxisoft.service;
import java.util.List;
import com.lxisoft.model.Exam;
public interface ExamService 
{
	public void addExam(Exam exam);
	 
    public List<Exam> getAllExam();
 
    public void deleteExam(Integer examId);
 
    public Exam getExam(int examid);

	public Exam updateExam(Exam exam);
}
