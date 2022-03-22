package com.gaed.commerce.interfaceService;

import com.gaed.commerce.pojo.ClientePojo;

import java.util.List;
import java.util.Optional;

public interface ICliente {
    public List<ClientePojo> listar();
    public Optional<ClientePojo> listarId(int id);
    public  int save(ClientePojo c);
    public void delete(int id);
}
