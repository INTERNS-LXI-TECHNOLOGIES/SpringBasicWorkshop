package com.lxisoft.repository;

import java.util.List;

import com.lxisoft.model.Doctor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository("DoctorReppo")
public interface DoctorReppo extends JpaRepository<Doctor,Integer>
{


}