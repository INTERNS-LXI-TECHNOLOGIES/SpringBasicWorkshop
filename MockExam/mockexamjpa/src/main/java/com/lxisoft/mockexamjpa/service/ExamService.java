package com.lxisoft.mockexamjpa.service;

import com.lxisoft.mockexamjpa.entity.Exam;
import com.lxisoft.mockexamjpa.repository.ExamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
    public Optional<Exam> getQuestionById(int id)
    {
        return examRepo.findById(id);
    }
}
