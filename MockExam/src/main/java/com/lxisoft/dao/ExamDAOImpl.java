package com.lxisoft.dao;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.lxisoft.model.Exam;
 
@Repository
public class ExamDAOImpl implements ExamDAO 
{
	@Autowired
    private SessionFactory sessionFactory;
 
    public void addExam(Exam exam) {
        sessionFactory.getCurrentSession().saveOrUpdate(exam);
 
    }
 
    @SuppressWarnings("unchecked")
    public List<Exam> getAllExam() {
 
        return sessionFactory.getCurrentSession().createQuery("from Exam")
                .list();
    }
 
    @Override
    public void deleteExam(Integer examId) {
        Exam exam = (Exam) sessionFactory.getCurrentSession().load(
                Exam.class, examId);
        if (null != exam) {
            this.sessionFactory.getCurrentSession().delete(exam);
        }
 
    }
 
    public Exam getExam(int exmid) {
        return (Exam) sessionFactory.getCurrentSession().get(
                Exam.class, exmid);
    }
 
    @Override
    public Exam updateExam(Exam exam) {
        sessionFactory.getCurrentSession().update(exam);
        return exam;
    }
 
}
