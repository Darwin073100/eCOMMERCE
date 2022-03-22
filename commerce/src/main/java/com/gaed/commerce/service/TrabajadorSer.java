package com.gaed.commerce.service;

import com.gaed.commerce.interfaceService.ITrabajador;
import com.gaed.commerce.pojo.TrabajadorPojo;
import com.gaed.commerce.repository.TrabajadorRep;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TrabajadorSer implements ITrabajador {

    @Autowired
    private TrabajadorRep data;

    @Override
    public List<TrabajadorPojo> listar() {
        return (List<TrabajadorPojo>) data.findAll();
    }

    @Override
    public Optional<TrabajadorPojo> listarId(int id) {
        return data.findById(id);
    }

    @Override
    public int save(TrabajadorPojo t) {
        int res = 0;
        TrabajadorPojo trabajador = data.save(t);
        if (trabajador.equals(null)){
            res = 1;
        }
        return res;
    }

    @Override
    public void delete(int id) {
    data.deleteById(id);
    }
}
