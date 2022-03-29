package com.gaed.commerce.controller;

import com.gaed.commerce.pojo.VentaPojo;
import com.gaed.commerce.repository.VentaRep;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/venta")
public class VentaController {
    private final VentaRep ventaRep;

    public VentaController(VentaRep ventaRep) {
        this.ventaRep = ventaRep;
    }

    @GetMapping
    public List<VentaPojo> getVenta(){
        System.out.print("Llamar a GetVenta");
        return ventaRep.findAll();
    }

    @GetMapping("/{id}")
    public VentaPojo getVenta(@PathVariable int id){
        System.out.println("Llamada a GetVenta por ID "+id);
        return ventaRep.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity createVenta(@RequestBody VentaPojo VentaPojo) throws URISyntaxException {
        System.out.print("Llamada para crear ventas");
        VentaPojo saveVenta = ventaRep.save(VentaPojo);
        return ResponseEntity.created(new URI("/venta/"+saveVenta.getId())).body(saveVenta);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateVenta(@PathVariable int id, @RequestBody VentaPojo VentaPojo){
        System.out.print("Llamada a actualizar ventas");
        VentaPojo.setId(id);
        VentaPojo currentVenta = ventaRep.saveAndFlush(VentaPojo);
        return ResponseEntity.ok(currentVenta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteVenta(@PathVariable int id){
        System.out.print("Llamada a borrar ventas");
        ventaRep.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
