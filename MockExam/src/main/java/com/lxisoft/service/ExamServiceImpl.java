package com.lxisoft.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lxisoft.dao.ExamDAO;
import com.lxisoft.model.Exam;
@Service
@Transactional
public class ExamServiceImpl implements ExamService {

	@Autowired
    private ExamDAO examDAO;
 
	
	@Override
	@Transactional
	public void addExam(Exam exam) {
		examDAO.addExam(exam);
	}

	@Override
	@Transactional
	public List<Exam> getAllExam() {
		return examDAO.getAllExam();
	}
	
	@Override
    @Transactional
    public void deleteExam(Integer examId) {
	examDAO.deleteExam(examId);
	}

	
	public Exam getExam(int exmid) {
		return examDAO.getExam(exmid);
	}
	
	public Exam updateExam(Exam exam) {
       return examDAO.updateExam(exam);
    }
 
    public void setExamDAO(ExamDAO examDAO) {
        this.examDAO = examDAO;
    }
 
}

