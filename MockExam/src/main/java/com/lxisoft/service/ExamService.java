package com.lxisoft.service;
import java.util.List;
import com.lxisoft.model.Exam;
// import net.javaguides.springmvc.exception.ResourceNotFoundException;
public interface ExamService 
{
	public void saveExam(Exam exam);
	 
    public List<Exam> getAllExam();
 
    public void deleteExam(Integer examId);
 
    public Exam getExam(int examid);

	public Exam updateExam(Exam exam);
}
