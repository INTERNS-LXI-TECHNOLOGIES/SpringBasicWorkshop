package com.lxisoft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lxisoft.entity.Exam;
import com.lxisoft.repository.ExamRepository;

@Service
public class ExamServiceImpl  {

    @Autowired
    private ExamRepository examRepository;

    
    @Transactional
    public List  <Exam> getExams() {
        return examRepository.findAll();
    }

   
    @Transactional
    public void saveExam(Exam theExam) {
        examRepository.save(theExam);
    }

   
    @Transactional
    public Optional<Exam> getExam(int id)  {
        return examRepository.findById(id);
    }

    
    @Transactional
    public void deleteExam(int theId) {
        examRepository.deleteById(theId);
    }
}