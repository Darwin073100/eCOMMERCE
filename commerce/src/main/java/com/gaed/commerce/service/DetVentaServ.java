package com.gaed.commerce.service;

import com.gaed.commerce.interfaceService.IDetVenta;
import com.gaed.commerce.pojo.Det_VentaPojo;
import com.gaed.commerce.repository.DetVentaRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DetVentaServ implements IDetVenta {

    @Autowired
    private DetVentaRep data;

    @Override
    public List<Det_VentaPojo> listar() {
        return (List<Det_VentaPojo>) data.findAll();
    }

    @Override
    public Optional<Det_VentaPojo> listarId(int id) {
        return data.findById(id);
    }

    @Override
    public int save(Det_VentaPojo dv) {
        int res = 0;
        Det_VentaPojo detalle = data.save(dv);
        if (!detalle.equals(null)){
            res = 1;
        }
        return res;
    }

    @Override
    public void delete(int id){
        data.deleteById(id);
    }
}
