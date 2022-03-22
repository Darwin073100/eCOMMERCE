package com.gaed.commerce.repository;

import com.gaed.commerce.pojo.Det_VentaPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetVentaRep extends JpaRepository<Det_VentaPojo, Integer> {
}
