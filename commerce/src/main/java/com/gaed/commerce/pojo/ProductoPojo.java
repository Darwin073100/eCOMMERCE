package com.gaed.commerce.pojo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PRODUCTO")
public class ProductoPojo {

    @Id
    private String Id;
    private String Nombre;
    private String Tipo;
    private String Estado;
    private double Precio;
    private int Consumo;
    private String Fecha;
    private String Descripcion;
    private String Version;

    @OneToMany(mappedBy = "productoPojo")
    private List<Det_VentaPojo> det_ventaPojo;

    @OneToMany(mappedBy = "productoPojo")
    private List<Img_ProductoEntity> img_productoEntities;

    public ProductoPojo() {

    }

    public ProductoPojo(String id, String nombre, String tipo, String estado, double precio, int consumo, String fecha, String descripcion, String version) {
        this.Id = id;
        this.Nombre = nombre;
        this.Tipo = tipo;
        this.Estado = estado;
        this.Precio = precio;
        this.Consumo = consumo;
        this.Fecha = fecha;
        this.Descripcion = descripcion;
        this.Version = version;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    public int getConsumo() {
        return Consumo;
    }

    public void setConsumo(int consumo) {
        Consumo = consumo;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }

}
