package com.gaed.commerce.controller;

import com.gaed.commerce.pojo.TrabajadorPojo;
import com.gaed.commerce.repository.TrabajadorRep;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/trabajador")
public class TrabajadorController {
    private final TrabajadorRep trabajadorRep;

    public TrabajadorController(TrabajadorRep trabajadorRep) {
        this.trabajadorRep = trabajadorRep;
    }

    @GetMapping
    public List<TrabajadorPojo> getTrabajador(){
        System.out.print("Llamada a getTrabajador");
        return trabajadorRep.findAll();
    }

    @GetMapping("/{id}")
    public TrabajadorPojo getTrabajador(@PathVariable int id){
        System.out.println("Llamada a getTrabajador por ID: " + id);
        return trabajadorRep.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity createTrabajador(@RequestBody TrabajadorPojo trabajadorPojo) throws URISyntaxException {
        System.out.print("Llamada a crear Trabajadores");
        TrabajadorPojo saveTrabajador = trabajadorRep.save(trabajadorPojo);
        return ResponseEntity.created(new URI("/trabajador/"+saveTrabajador.getId())).body(saveTrabajador);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateTrabajador(@PathVariable int id, @RequestBody TrabajadorPojo trabajadorPojo){
        System.out.print("Llamada a actualizar trabajador");
        trabajadorPojo.setId(id);
        TrabajadorPojo currentTrabajador = trabajadorRep.saveAndFlush(trabajadorPojo);
        return ResponseEntity.ok(currentTrabajador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTrabajdor(@PathVariable int id){
        System.out.print("Llamada a eliminar un trabajador");
        trabajadorRep.deleteById(id);
        return ResponseEntity.ok().build();
    }
}



















