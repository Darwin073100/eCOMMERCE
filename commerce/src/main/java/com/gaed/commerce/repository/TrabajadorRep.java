package com.gaed.commerce.repository;

import com.gaed.commerce.pojo.TrabajadorPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabajadorRep extends JpaRepository<TrabajadorPojo, Integer> {
}
