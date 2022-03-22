package com.gaed.commerce.service;

import com.gaed.commerce.interfaceService.IUsuario;
import com.gaed.commerce.pojo.UsuarioPojo;
import com.gaed.commerce.repository.UsuarioRep;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UsuarioServ implements IUsuario {

    @Autowired
    private UsuarioRep data;

    @Override
    public List<UsuarioPojo> listar() {
        return (List<UsuarioPojo>) data.findAll();
    }

    @Override
    public Optional<UsuarioPojo> listarId(int id) {
        return data.findById(id);
    }

    @Override
    public int save(UsuarioPojo u) {
        int res = 0;
        UsuarioPojo usuario = data.save(u);
        if (!usuario.equals(null)){
            res = 1;
        }
        return res;
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }
}
