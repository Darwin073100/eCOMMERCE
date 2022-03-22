package com.gaed.commerce.repository;

import com.gaed.commerce.pojo.UsuarioPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRep extends JpaRepository<UsuarioPojo, Integer> {
}
