package com.gaed.commerce.interfaceService;

import com.gaed.commerce.pojo.ProductoPojo;

import java.util.List;
import java.util.Optional;

public interface IProducto {
    public List<ProductoPojo>listar();
    public Optional<ProductoPojo> listarId(String id);
    public int save(ProductoPojo p);
    public void delete(String id);
}
