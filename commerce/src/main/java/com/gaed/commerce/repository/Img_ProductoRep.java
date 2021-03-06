package com.gaed.commerce.repository;

import com.gaed.commerce.pojo.Img_ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Img_ProductoRep extends JpaRepository<Img_ProductoEntity, String> {
    List<Img_ProductoEntity> findByidproducto(String idProducto);
}
