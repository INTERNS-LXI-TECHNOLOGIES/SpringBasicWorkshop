package com.lxisoft.repository;

import com.lxisoft.model.Contact;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.sql.SQLException;
import java.util.List;
@Repository("ContactJPARepository")
public interface ContactJPARepository extends JpaRepository<Contact,Integer> {

    @Query(value = "select * from contacts where name like '%'|| :name ||'%' order by name")
    public List<Contact> searchResult (@Param("name") String name);
}
