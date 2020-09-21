package com.lxisoft.service;

import com.lxisoft.model.Doctor;
import com.lxisoft.repository.DoctorReppo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorReppo doctorReppo;

    @Transactional
    public List<Doctor> getAllUsers()
    {
        return doctorReppo.findAll();
    }

    @Transactional
    public void saveDoctor(Doctor doctor)
    {
        doctorReppo.save(doctor);
    }
    @Transactional
    public  void deleteDoctor(int doctorId)
    {
        doctorReppo.delete(doctorId);
    }

    @Transactional
    public Doctor getDoctorById(int id)
    {
        return doctorReppo.getOne(id);
    }
}