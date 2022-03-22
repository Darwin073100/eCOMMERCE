package com.gaed.commerce.service;

import com.gaed.commerce.interfaceService.IVenta;
import com.gaed.commerce.pojo.VentaPojo;
import com.gaed.commerce.repository.VentaRep;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class VentaServ implements IVenta {

    @Autowired
    private VentaRep data;

    @Override
    public List<VentaPojo> listar() {
        return (List<VentaPojo>) data.findAll();
    }

    @Override
    public Optional<VentaPojo> listarId(int id) {
        return data.findById(id);
    }

    @Override
    public int save(VentaPojo v) {
        int res = 0;
        VentaPojo venta = data.save(v);
        if (!venta.equals(null)){
            res = 1;
        }
        return res;
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }
}
