package com.fpt.petstore.repository;

import com.fpt.petstore.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContactRepository extends JpaRepository<Contact,Integer>{

}
