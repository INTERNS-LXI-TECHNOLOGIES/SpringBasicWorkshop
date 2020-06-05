package com.lxisoft.service;

import java.util.List;

import com.lxisoft.entity.Exam;

public interface ExamService {

    public List <Exam> getExams();

    public void saveExam(Exam theExam);

    public  Exam getExam(int theId) ;

    public void deleteExam(int theId);
}