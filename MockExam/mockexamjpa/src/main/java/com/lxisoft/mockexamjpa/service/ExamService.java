package com.lxisoft.mockexamjpa.service;

import com.lxisoft.mockexamjpa.entity.Exam;
import com.lxisoft.mockexamjpa.exception.ResourceNotFoundException;
import com.lxisoft.mockexamjpa.repository.ExamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExamService
{
    @Autowired
    private ExamRepo examRepo;

    @Transactional
    public List<Exam> getExamData()
    {
        return examRepo.findAll();
    }

    @Transactional
    public void saveQuestion(Exam exam)
    {
        examRepo.save(exam);
    }
    @Transactional
    public  void deleteQuestion(int questionId)
    {
        examRepo.deleteById(questionId);
    }
    
    @Transactional
    public Exam getQuestionById(int id) throws ResourceNotFoundException {
        return examRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }
   
    
}
