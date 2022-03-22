package com.gaed.commerce.interfaceService;

import com.gaed.commerce.pojo.VentaPojo;

import java.util.List;
import java.util.Optional;

public interface IVenta {
    public List<VentaPojo> listar();
    public Optional<VentaPojo> listarId(int id);
    public  int save(VentaPojo v);
    public void delete(int id);
}
