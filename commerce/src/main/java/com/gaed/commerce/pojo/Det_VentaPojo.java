package com.gaed.commerce.pojo;

import javax.persistence.*;

@Entity
@Table(name = "DET_VENTA")
public class Det_VentaPojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private int IdVENT;
    private String IdPROD;
    private String NombreProd;
    private double Precio;
    private double Descuento;
    private String Fecha;

    public Det_VentaPojo() {

    }

    public Det_VentaPojo(int id, int idVENT, String idPROD, String nombreProd, double precio, double descuento, String fecha) {
        this.Id = id;
        this.IdVENT = idVENT;
        this.IdPROD = idPROD;
        this.NombreProd = nombreProd;
        this.Precio = precio;
        this.Descuento = descuento;
        this.Fecha = fecha;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getIdVENT() {
        return IdVENT;
    }

    public void setIdVENT(int idVENT) {
        IdVENT = idVENT;
    }

    public String getIdPROD() {
        return IdPROD;
    }

    public void setIdPROD(String idPROD) {
        IdPROD = idPROD;
    }

    public String getNombreProd() {
        return NombreProd;
    }

    public void setNombreProd(String nombreProd) {
        NombreProd = nombreProd;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    public double getDescuento() {
        return Descuento;
    }

    public void setDescuento(double descuento) {
        Descuento = descuento;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }
}
