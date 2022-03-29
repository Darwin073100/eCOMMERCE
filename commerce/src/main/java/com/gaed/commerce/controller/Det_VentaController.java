package com.gaed.commerce.controller;

import com.gaed.commerce.pojo.Det_VentaPojo;
import com.gaed.commerce.repository.DetVentaRep;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/detalleventa")
public class Det_VentaController {
    private final DetVentaRep detVentaRep;

    public Det_VentaController(DetVentaRep detVentaRep) {
        this.detVentaRep = detVentaRep;
    }


    @GetMapping
    public List<Det_VentaPojo> getDetVenta(){
        System.out.print("Llamar a GetDetVenta");
        return detVentaRep.findAll();
    }

    @GetMapping("/{id}")
    public Det_VentaPojo getDetVenta(@PathVariable int id){
        System.out.println("Llamada a GetDetVenta por ID "+id);
        return detVentaRep.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity createDetVenta(@RequestBody Det_VentaPojo Det_VentaPojo) throws URISyntaxException {
        System.out.print("Llamada para crear detalles de ventas");
        Det_VentaPojo saveVenta = detVentaRep.save(Det_VentaPojo);
        return ResponseEntity.created(new URI("/detalleventa/"+saveVenta.getId())).body(saveVenta);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateDetVenta(@PathVariable int id, @RequestBody Det_VentaPojo Det_VentaPojo){
        System.out.print("Llamada a actualizar detalles de ventas");
        Det_VentaPojo.setId(id);
        Det_VentaPojo currentDetVenta = detVentaRep.saveAndFlush(Det_VentaPojo);
        return ResponseEntity.ok(currentDetVenta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteDetVenta(@PathVariable int id){
        System.out.print("Llamada a borrar detalles de ventas");
        detVentaRep.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
