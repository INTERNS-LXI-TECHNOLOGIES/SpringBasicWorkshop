package com.lxisoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.lxisoft.entity.ExamModel;

@Repository("examRepository")
public interface ExamRepository extends JpaRepository<ExamModel, Integer> {

	
}