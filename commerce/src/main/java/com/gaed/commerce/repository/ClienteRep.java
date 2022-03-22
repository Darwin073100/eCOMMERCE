package com.gaed.commerce.repository;

import com.gaed.commerce.pojo.ClientePojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRep extends JpaRepository<ClientePojo, Integer> {
}
