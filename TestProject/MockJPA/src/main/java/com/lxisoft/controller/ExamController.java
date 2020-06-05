package com.lxisoft.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import  com.lxisoft.entity.Exam;
import  com.lxisoft.service.ExamService;

@Controller
@RequestMapping("/exam")
public class ExamController {

    private static final Logger LOG = LoggerFactory.getLogger(ExamController.class);

    @Autowired
    private ExamService examService;

    @GetMapping("/list")
    public String listExams(Model theModel) {
        List < Exam > theExams = examService.getExams();
        theModel.addAttribute("Exams", theExams);
        return "list-Exams";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        LOG.debug("inside show Exam-form handler method");
        Exam theExam = new Exam();
        theModel.addAttribute("Exam", theExam);
        return "Exam-form";
    }

    @PostMapping("/saveExam")
    public String saveExam(@ModelAttribute("Exam") Exam theExam) {
        examService.saveExam(theExam);
        return "redirect:/Exam/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("ExamId") int theId,
        Model theModel)  {
        Exam theExam = examService.getExam(theId);
        theModel.addAttribute("Exam", theExam);
        return "Exam-form";
    }

    @GetMapping("/delete")
    public String deleteExam(@RequestParam("ExamId") int theId)  {
        examService.deleteExam(theId);
        return "redirect:/Exam/list";
    }
}