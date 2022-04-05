package com.gaed.commerce.pojo;

import javax.persistence.*;

@Entity
@Table(name = "CLIENTE")
public class ClientePojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String Nombre;
    private String Apellidos;
    @Column(name = "Email")
    private String eMail;
    @Column(name = "Clave_Pais")
    private String ClavePais;
    private String Telefono;
    @Column(name = "No_Compras")
    private int NoCompras;
    private String Direccion;
    @Column(name = "Id_User")
    private int IdUser;

    public ClientePojo() {

    }

    public ClientePojo(int id, String nombre, String apellidos, String eMail, String clavePais, String telefono, int noCompras, String direccion, int idUser) {
        this.Id = id;
        this.Nombre = nombre;
        this.Apellidos = apellidos;
        this.eMail = eMail;
        this.ClavePais = clavePais;
        this.Telefono = telefono;
        this.NoCompras = noCompras;
        this.Direccion = direccion;
        this.IdUser = idUser;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getClavePais() {
        return ClavePais;
    }

    public void setClavePais(String clavePais) {
        ClavePais = clavePais;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public int getNoCompras() {
        return NoCompras;
    }

    public void setNoCompras(int noCompras) {
        NoCompras = noCompras;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public int getIdUser() {
        return IdUser;
    }

    public void setIdUser(int idUser) {
        IdUser = idUser;
    }
}
