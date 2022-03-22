package com.gaed.commerce.repository;

import com.gaed.commerce.pojo.VentaPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRep extends JpaRepository<VentaPojo, Integer> {
}
