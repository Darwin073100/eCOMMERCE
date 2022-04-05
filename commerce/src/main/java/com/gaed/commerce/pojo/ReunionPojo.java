package com.gaed.commerce.pojo;

import javax.persistence.*;

@Entity
@Table(name = "REUNION")
public class ReunionPojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String Descripcion;
    private String Fecha;
    private String Hora;
    @Column(name = "Id_Cli")
    private int IdCli;
    @Column(name = "Nombre_Cli")
    private String NombreCli;
    private String Tipo;

    public ReunionPojo() {

    }

    public ReunionPojo(int id, String descripcion, String fecha, String hora, int idCli, String nombreCli, String tipo) {
        this.Id = id;
        this.Descripcion = descripcion;
        this.Fecha = fecha;
        this.Hora = hora;
        this.IdCli = idCli;
        this.NombreCli = nombreCli;
        this.Tipo = tipo;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String hora) {
        Hora = hora;
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

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }
}
