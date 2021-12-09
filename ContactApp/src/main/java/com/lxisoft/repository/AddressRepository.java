package com.lxisoft.repository;

import com.lxisoft.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("AddressRepository")
public interface AddressRepository extends JpaRepository<Address,Integer> {

}
