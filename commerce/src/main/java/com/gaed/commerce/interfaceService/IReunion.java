package com.gaed.commerce.interfaceService;

import com.gaed.commerce.pojo.ReunionPojo;

import java.util.List;
import java.util.Optional;

public interface IReunion {
    public List<ReunionPojo> listar();
    public Optional<ReunionPojo> listarId(int id);
    public  int save(ReunionPojo r);
    public void delete(int id);
}
