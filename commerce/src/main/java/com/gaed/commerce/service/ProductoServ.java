package com.gaed.commerce.service;

import com.gaed.commerce.interfaceService.IProducto;
import com.gaed.commerce.pojo.ProductoPojo;
import com.gaed.commerce.repository.ProductoRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServ implements IProducto {

    @Autowired
    private ProductoRep data;

    @Override
    public List<ProductoPojo> listar() {
        return (List<ProductoPojo>) data.findAll();
    }

    @Override
    public Optional<ProductoPojo> listarId(String id) {
        return data.findById(id);
    }

    @Override
    public int save(ProductoPojo p) {
        int res= 0;
        ProductoPojo producto = data.save(p);
        if (!producto.equals(null)){
            res = 1;
        }
        return res;
    }

    @Override
    public void delete(String id) {
        data.deleteById(id);
    }
}
