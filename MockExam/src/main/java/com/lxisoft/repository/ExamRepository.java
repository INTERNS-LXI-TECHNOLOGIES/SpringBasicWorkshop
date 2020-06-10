package com.lxisoft.repository;

import org.springframework.data.repository.CrudRepository;
import com.lxisoft.entity.Exam;
import java.util.List;

public interface ExamRepository<P> extends CrudRepository<Exam, Long> {
    List<Exam> findByQuestion(String question);
}