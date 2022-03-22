package com.gaed.commerce.interfaceService;

import com.gaed.commerce.pojo.UsuarioPojo;

import java.util.List;
import java.util.Optional;

public interface IUsuario {
    public List<UsuarioPojo> listar();
    public Optional<UsuarioPojo> listarId(int id);
    public  int save(UsuarioPojo u);
    public void delete(int id);
}
