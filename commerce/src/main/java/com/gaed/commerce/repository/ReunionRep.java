package com.gaed.commerce.repository;

import com.gaed.commerce.pojo.ReunionPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReunionRep extends JpaRepository<ReunionPojo, Integer> {
}
