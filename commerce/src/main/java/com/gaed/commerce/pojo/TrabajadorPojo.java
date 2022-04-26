package com.gaed.commerce.pojo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TRABAJADOR")
public class TrabajadorPojo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String Nombre;
    private String Apellidos;
    private String Telefono;
    @Column(name = "Email")
    private String eMail;
    @Column(name = "Id_User")
    private int IdUser;

    @OneToOne
    @JoinColumn(name = "Id_User", insertable = false, updatable = false)
    private UsuarioPojo usuarioPojo;

    @OneToMany(mappedBy = "trabajadorPojo")
    private List<VentaPojo> ventaPojos;

    public TrabajadorPojo() {

    }

    public TrabajadorPojo(int id, String nombre, String apellidos, String telefono, String eMail, int idUser) {
        this.Id = id;
        this.Nombre = nombre;
        this.Apellidos = apellidos;
        this.Telefono = telefono;
        this.eMail = eMail;
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

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public int getIdUser() {
        return IdUser;
    }

    public void setIdUser(int idUser) {
        IdUser = idUser;
    }
}
