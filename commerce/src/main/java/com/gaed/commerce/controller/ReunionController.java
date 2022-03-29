package com.gaed.commerce.controller;

import com.gaed.commerce.pojo.ReunionPojo;
import com.gaed.commerce.repository.ReunionRep;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Controller
@RequestMapping("/reunion")
public class ReunionController {

    private final ReunionRep reunionRep;

    public ReunionController(ReunionRep reunionRep) {
        this.reunionRep = reunionRep;
    }

    @GetMapping
    public List<ReunionPojo> getReunion(){
        System.out.print("Llamada a getReunion");
        return reunionRep.findAll();
    }

    @GetMapping("/{id}")
    public ReunionPojo getReunion(@PathVariable int id){
        System.out.println("Llamada a getReunion por ID: " + id);
        return reunionRep.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity createReunion(@RequestBody ReunionPojo ReunionPojo) throws URISyntaxException {
        System.out.print("Llamada a crear reunion");
        ReunionPojo saveCliente = reunionRep.save(ReunionPojo);
        return ResponseEntity.created(new URI("/reunion/"+saveCliente.getId())).body(saveCliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateReunion(@PathVariable int id, @RequestBody ReunionPojo ReunionPojo){
        System.out.print("Llamada a actualizar reunion");
        ReunionPojo.setId(id);
        ReunionPojo currentReunion = reunionRep.saveAndFlush(ReunionPojo);
        return ResponseEntity.ok(currentReunion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteReunion(@PathVariable int id){
        System.out.print("Llamada a eliminar un reunion");
        reunionRep.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
