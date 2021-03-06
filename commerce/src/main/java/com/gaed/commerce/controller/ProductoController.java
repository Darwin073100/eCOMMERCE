package com.gaed.commerce.controller;

import com.gaed.commerce.pojo.ProductoPojo;
import com.gaed.commerce.repository.ProductoRep;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    private final ProductoRep productoRep;
    public ProductoController(ProductoRep productoRep) {
        this.productoRep = productoRep;
    }

    @GetMapping
    public List<ProductoPojo> getProductos(){
        System.out.print("Llamar a GetProductos");
        return productoRep.findAll();
    }

    @GetMapping("/{id}")
    public ProductoPojo getProducto(@PathVariable String id){
        System.out.println("Llamada a GetProducto por ID "+id);
        return productoRep.findById(id).orElseThrow(RuntimeException::new);
    }
    @GetMapping("tipo/{tipo}")
    public List<ProductoPojo> getTipoProd(@PathVariable String tipo){
        return productoRep.findByTipo(tipo);
    }

    @PostMapping
    public ResponseEntity createProducto(@RequestBody ProductoPojo productoPojo) throws URISyntaxException {
        System.out.print("Llamada para crear productos");
        ProductoPojo saveProducto = productoRep.save(productoPojo);
        return ResponseEntity.created(new URI("/producto/"+saveProducto.getId())).body(saveProducto);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProducto(@PathVariable String id, @RequestBody ProductoPojo productoPojo){
        System.out.print("Llamada a actualizar producto");
        productoPojo.setId(id);
        ProductoPojo currentProducto = productoRep.saveAndFlush(productoPojo);
        return ResponseEntity.ok(currentProducto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProducto(@PathVariable String id){
        System.out.print("Llamada a borrar producto");
        productoRep.deleteById(id);
        return ResponseEntity.ok().build();
    }
}