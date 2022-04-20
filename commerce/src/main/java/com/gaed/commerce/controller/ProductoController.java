package com.gaed.commerce.controller;

import com.gaed.commerce.pojo.ProductoPojo;
import com.gaed.commerce.repository.ProductoRep;
import com.gaed.commerce.service.ProductoServ;
import com.gaed.commerce.util.CustomErrorType;
import org.hibernate.type.CustomType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    private final ProductoRep productoRep;

    public ProductoController(ProductoRep productoRep) {
        this.productoRep = productoRep;
    }
    //----------------------IMAGENES------------------------------
    @PostMapping("/subir")
    public String upLoadImagen(@RequestParam("Id") String Id,
       @RequestParam("file")MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getName()+ Id);
        System.out.println(file.getContentType());
        System.out.println(file.getSize());

        String PATH = "images/producto/";
        String fileName = Id+"-Product."+file.getContentType().split("/")[1];

        Files.copy(file.getInputStream(),Paths.get(PATH+fileName),StandardCopyOption.REPLACE_EXISTING);
        return "Imagen subida con exito"+Id;
    }
    //----------------------FIN-IMAGENES------------------------------
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