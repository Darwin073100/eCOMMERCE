package com.gaed.commerce.repository;

import com.gaed.commerce.pojo.ProductoPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRep extends JpaRepository<ProductoPojo, String> {

}
