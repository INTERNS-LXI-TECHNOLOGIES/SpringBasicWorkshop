package com.lxisoft.service;

import com.lxisoft.model.Problem;
import com.lxisoft.repository.UserReppo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProblemService {
    @Autowired
    private UserReppo userReppo;

    @Transactional
    public List<User> getAllUsers()
    {
        return userReppo.findAll();
    }

}