package com.lxisoft.repository;

import com.lxisoft.model.Contact;
//import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("ContactJPARepository")
public interface ContactRepository extends JpaRepository<Contact,Integer> {

   // @Query(value = "from Contact contacts order by contacts.name limit ?start , ?contactPerPage")


    @Query(value = "from Contact contacts where contacts.name like '%'|| :name ||'%' order by contacts.name")
    public List<Contact> searchResult (@Param("name") String name);
}
