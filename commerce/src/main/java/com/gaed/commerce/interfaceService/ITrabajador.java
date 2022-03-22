package com.gaed.commerce.interfaceService;

import com.gaed.commerce.pojo.TrabajadorPojo;

import java.util.List;
import java.util.Optional;

public interface ITrabajador {
    public List<TrabajadorPojo> listar();
    public Optional<TrabajadorPojo> listarId(int id);
    public  int save(TrabajadorPojo t);
    public void delete(int id);
}
