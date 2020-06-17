package com.lxisoft.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.entity.MockEntity;

@Repository("MockRepository")
public interface MockRepository extends JpaRepository<MockEntity, Integer> 
{

}
