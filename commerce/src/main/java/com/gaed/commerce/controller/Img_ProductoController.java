package com.gaed.commerce.controller;

import com.gaed.commerce.repository.Img_ProductoRep;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Img_ProductoController {
    private final String PATH_IMG = "images/producto/";
    private final Img_ProductoRep img_ProductoRep;

    public Img_ProductoController(Img_ProductoRep img_productoRep) {
        img_ProductoRep = img_productoRep;
    }

    //----------------------IMAGENES------------------------------
    @PostMapping("/image/up")
    public String upLoadImagen(@RequestParam("Id") String Id,
                               @RequestParam("file") MultipartFile file) throws IOException {
        System.out.print("Llamada a upLoadImage");

        String fileName = Id+"-Product."+file.getContentType().split("/")[1];
        Files.copy(file.getInputStream(), Paths.get(PATH_IMG+fileName), StandardCopyOption.REPLACE_EXISTING);
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
}
