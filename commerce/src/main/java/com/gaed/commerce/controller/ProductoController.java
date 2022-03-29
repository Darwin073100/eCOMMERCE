package com.gaed.commerce.controller;

import com.gaed.commerce.pojo.ProductoPojo;
import com.gaed.commerce.repository.ProductoRep;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

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