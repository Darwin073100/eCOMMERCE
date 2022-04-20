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
    private final String PATH_IMG = "images/producto/";
    public ProductoController(ProductoRep productoRep) {
        this.productoRep = productoRep;
    }
    //----------------------IMAGENES------------------------------
    @PostMapping("/image/up")
    public String upLoadImagen(@RequestParam("Id") String Id,
       @RequestParam("file")MultipartFile file) throws IOException {
        System.out.print("Llamada a upLoadImage");

        String fileName = Id+"-Product."+file.getContentType().split("/")[1];
        Files.copy(file.getInputStream(),Paths.get(PATH_IMG+fileName),StandardCopyOption.REPLACE_EXISTING);
        return "Imagen cargada con exito en: "+ PATH_IMG+fileName;
    }

    @GetMapping(value = "/image/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public  byte[] getImg(@PathVariable String id) throws IOException {
        File file = new File(PATH_IMG+id+"-Product.png");
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes, 0, inputStream.available());
        return bytes;
    }
    @DeleteMapping("/image/{id}")
    public String deleteImg(@PathVariable String id){
        String mensaje="";
        File file = new File(PATH_IMG+id+"-Product.png");
        if (file.exists()){
            file.delete();
            mensaje= "Imagen eliminada con exito";
        } else{
            mensaje = "La imagen con id: "+ id + " no existe.";
        }
        return mensaje;
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