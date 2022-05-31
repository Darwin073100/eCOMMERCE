package com.gaed.commerce.repository;

import com.gaed.commerce.pojo.Img_ProductoEntity;
import com.gaed.commerce.pojo.ProductoPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRep extends JpaRepository<ProductoPojo, String> {
    List<ProductoPojo> findByTipo(String Tipo);
}
