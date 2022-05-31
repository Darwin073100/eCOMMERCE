package com.gaed.commerce.controller;

import com.gaed.commerce.pojo.Img_ProductoEntity;
import com.gaed.commerce.repository.Img_ProductoRep;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@RestController
@RequestMapping("imgproducto")
public class Img_ProductoController {
    private final String PATH_IMG = "images/producto/";
    private final Img_ProductoRep img_ProductoRep;

    public Img_ProductoController(Img_ProductoRep img_productoRep) {
        img_ProductoRep = img_productoRep;
    }
    //-----------------ALAMACENAR INFORMACION DE LA IMAGEN EN LA BD------------------------
    @GetMapping
    public List<Img_ProductoEntity> getImagenes(){
        System.out.println("Lamada  getImagenes");
        return img_ProductoRep.findAll();
    }
    @GetMapping("/{id}")
    public Img_ProductoEntity getIdImagen(@PathVariable String id){
        System.out.println("Llamada a getIdImagen");
        return img_ProductoRep.findById(id).orElseThrow(RuntimeException::new);
    }
    @GetMapping("/producto/{id_prod}")
    public List<Img_ProductoEntity> getIdImagenes(@PathVariable String id_prod){
        System.out.println("Llamada a getIdImagen");
        return img_ProductoRep.findByidproducto(id_prod);
    }

    @PostMapping
    public ResponseEntity createImg(@RequestBody Img_ProductoEntity img_productoEntity) throws URISyntaxException {
        Img_ProductoEntity saveImg = img_ProductoRep.save(img_productoEntity);
        return ResponseEntity.created(new URI("/imgproducto/"+saveImg.getId())).body(saveImg);
    }

    @PutMapping("/{id}")
    public  ResponseEntity updateImg(@PathVariable String id, @RequestBody Img_ProductoEntity img_productoEntity){
        img_productoEntity.setId(id);
        Img_ProductoEntity currenttImg = img_ProductoRep.saveAndFlush(img_productoEntity);
        return  ResponseEntity.ok(currenttImg);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteImg(@PathVariable String id){
        img_ProductoRep.deleteById(id);
        return  ResponseEntity.ok().build();
    }


    //-------------------------------FIN IMAGEN EN BD--------------------------------------
    //----------------------ALMACENAR IMAGENES EN EL SERVIDOR------------------------------
    @PostMapping("/image/up")
    public String upLoadImagen(@RequestParam("Id") String Id, @RequestParam("IdProd") String IDPROD,
                               @RequestParam("file") MultipartFile file) throws IOException {
        System.out.print("Llamada a upLoadImage");

        String fileName = Id+"-"+IDPROD+"-Product."+file.getContentType().split("/")[1];
        Files.copy(file.getInputStream(), Paths.get(PATH_IMG+fileName), StandardCopyOption.REPLACE_EXISTING);
        return "Imagen Guardada con exito en: "+ PATH_IMG+fileName;
    }

    @GetMapping(value = "/image/{id}/{id_prod}",produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public  byte[] getImg(@PathVariable String id,@PathVariable String id_prod) throws IOException {
        File file = new File(PATH_IMG+id+"-"+id_prod+"-Product.png");
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes, 0, inputStream.available());
        return bytes;
    }
    @DeleteMapping("/image/{id}/{id_prod}")
    public String deleteImg(@PathVariable String id,@PathVariable String id_prod){
        String mensaje="";
        File file = new File(PATH_IMG+id+"-"+id_prod+"-Product.png");
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
