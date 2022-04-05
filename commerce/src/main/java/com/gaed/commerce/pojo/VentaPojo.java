package com.gaed.commerce.pojo;

import javax.persistence.*;

@Entity
@Table(name = "VENTA")
public class VentaPojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name = "Id_Cli")
    private int IdCli;
    @Column(name = "Nombre_Cli")
    private String NombreCli;
    @Column(name = "Direccion_Cli")
    private String DireccionCli;
    private double Total;
    private String Fecha;
    @Column(name = "Id_TRAB")
    private int IdTRAB;
    @Column(name = "Nombre_Trab")
    private String NombreTrab;

    public VentaPojo() {

    }

    public VentaPojo(int id, int idCli, String nombreCli, String direccionCli, double total, String fecha, int idTRAB, String nombreTrab) {
        this.Id = id;
        this.IdCli = idCli;
        this.NombreCli = nombreCli;
        this.DireccionCli = direccionCli;
        this.Total = total;
        this.Fecha = fecha;
        this.IdTRAB = idTRAB;
        this.NombreTrab = nombreTrab;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getIdCli() {
        return IdCli;
    }

    public void setIdCli(int idCli) {
        IdCli = idCli;
    }

    public String getNombreCli() {
        return NombreCli;
    }

    public void setNombreCli(String nombreCli) {
        NombreCli = nombreCli;
    }

    public String getDireccionCli() {
        return DireccionCli;
    }

    public void setDireccionCli(String direccionCli) {
        DireccionCli = direccionCli;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double total) {
        Total = total;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public int getIdTRAB() {
        return IdTRAB;
    }

    public void setIdTRAB(int idTRAB) {
        IdTRAB = idTRAB;
    }

    public String getNombreTrab() {
        return NombreTrab;
    }

    public void setNombreTrab(String nombreTrab) {
        NombreTrab = nombreTrab;
    }
}
