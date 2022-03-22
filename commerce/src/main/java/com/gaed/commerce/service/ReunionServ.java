package com.gaed.commerce.service;

import com.gaed.commerce.interfaceService.IReunion;
import com.gaed.commerce.pojo.ReunionPojo;
import com.gaed.commerce.repository.ReunionRep;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ReunionServ implements IReunion {

    @Autowired
    private ReunionRep data;

    @Override
    public List<ReunionPojo> listar() {
        return (List<ReunionPojo>) data.findAll();
    }

    @Override
    public Optional<ReunionPojo> listarId(int id) {
        return data.findById(id);
    }

    @Override
    public int save(ReunionPojo r) {
        int res = 0;
        ReunionPojo reunion = data.save(r);
        if (!reunion.equals(null)){
            res = 1;
        }
        return res;
    }

    @Override
    public void delete(int id) {
    data.deleteById(id);
    }
}
