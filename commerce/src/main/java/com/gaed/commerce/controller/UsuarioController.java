package com.gaed.commerce.controller;

import com.gaed.commerce.pojo.UsuarioPojo;
import com.gaed.commerce.repository.UsuarioRep;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    private final UsuarioRep usuarioRep;

    public UsuarioController(UsuarioRep usuarioRep) {
        this.usuarioRep = usuarioRep;
    }

    @GetMapping
    public List<UsuarioPojo> getUser(){
        System.out.print("Llamar a GetUser");
        return usuarioRep.findAll();
    }

    @GetMapping("/{id}")
    public UsuarioPojo getUser(@PathVariable int id){
        System.out.println("Llamada a GetUser por ID "+id);
        return usuarioRep.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody UsuarioPojo usuarioPojo) throws URISyntaxException {
        System.out.print("Llamada para crear productos");
        UsuarioPojo saveUsuario = usuarioRep.save(usuarioPojo);
        return ResponseEntity.created(new URI("/user/"+saveUsuario.getId())).body(saveUsuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUsuario(@PathVariable int id, @RequestBody UsuarioPojo usuarioPojo){
        System.out.print("Llamada a actualizar producto");
        usuarioPojo.setId(id);
        UsuarioPojo currentUsuario = usuarioRep.saveAndFlush(usuarioPojo);
        return ResponseEntity.ok(currentUsuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProducto(@PathVariable int id){
        System.out.print("Llamada a borrar producto");
        usuarioRep.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
