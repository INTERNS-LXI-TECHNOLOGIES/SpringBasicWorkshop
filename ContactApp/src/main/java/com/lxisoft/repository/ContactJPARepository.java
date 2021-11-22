package com.lxisoft.repository;

import com.lxisoft.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
@Repository("ContactJPARepository")
public interface ContactJPARepository extends JpaRepository<Contact,Integer> {


}
