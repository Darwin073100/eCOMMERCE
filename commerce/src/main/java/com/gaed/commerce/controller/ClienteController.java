package com.gaed.commerce.controller;

import com.gaed.commerce.pojo.ClientePojo;
import com.gaed.commerce.pojo.TrabajadorPojo;
import com.gaed.commerce.repository.ClienteRep;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteRep clienteRep;

    public ClienteController(ClienteRep clienteRep) {
        this.clienteRep = clienteRep;
    }

    @GetMapping
    public List<ClientePojo> getCliente(){
        System.out.print("Llamada a getCliente");
        return clienteRep.findAll();
    }

    @GetMapping("/{id}")
    public ClientePojo getCliente(@PathVariable int id){
        System.out.println("Llamada a getCliente por ID: " + id);
        return clienteRep.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity createCliente(@RequestBody ClientePojo ClientePojo) throws URISyntaxException {
        System.out.print("Llamada a crear Trabajadores");
        ClientePojo saveCliente = clienteRep.save(ClientePojo);
        return ResponseEntity.created(new URI("/cliente/"+saveCliente.getId())).body(saveCliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCliente(@PathVariable int id, @RequestBody ClientePojo ClientePojo){
        System.out.print("Llamada a actualizar cliente");
        ClientePojo.setId(id);
        ClientePojo currentCliente = clienteRep.saveAndFlush(ClientePojo);
        return ResponseEntity.ok(currentCliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCliente(@PathVariable int id){
        System.out.print("Llamada a eliminar un cliente");
        clienteRep.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
