package com.gaed.commerce.service;

import com.gaed.commerce.interfaceService.ICliente;
import com.gaed.commerce.pojo.ClientePojo;
import com.gaed.commerce.repository.ClienteRep;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ClienteSer implements ICliente {

    @Autowired
    private ClienteRep data;

    @Override
    public List<ClientePojo> listar() {
        return (List<ClientePojo>) data.findAll();
    }

    @Override
    public Optional<ClientePojo> listarId(int id) {
        return data.findById(id);
    }

    @Override
    public int save(ClientePojo c) {
        int res = 0;
        ClientePojo cliente = data.save(c);
        if (!cliente.equals(null)){
            res = 1;
        }
        return res;
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }
}
