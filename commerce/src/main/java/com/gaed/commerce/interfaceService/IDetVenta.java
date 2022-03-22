package com.gaed.commerce.interfaceService;

import com.gaed.commerce.pojo.Det_VentaPojo;

import java.util.List;
import java.util.Optional;

public interface IDetVenta {
    public List<Det_VentaPojo> listar();
    public Optional<Det_VentaPojo> listarId(int id);
    public  int save(Det_VentaPojo dv);
    public void delete(int id);
}
