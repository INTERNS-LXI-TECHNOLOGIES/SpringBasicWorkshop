package com.lxisoft.repository;

import com.lxisoft.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("AddressRepository")
public interface AddressRepository extends JpaRepository<Address,Integer> {
    //@Query("from Address address where address.contactId = :contactId")
    public Address findByContactId(@Param("contactId") int contactId);
}
