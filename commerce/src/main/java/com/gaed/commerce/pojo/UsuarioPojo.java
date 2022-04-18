package com.gaed.commerce.pojo;

import javax.persistence.*;

@Entity
@Table(name = "USUARIO")
public class UsuarioPojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name = "Tipo")
    private String Tipo;
    @Column(name = "User_Name")
    private String UserName;
    @Column(name = "User_Password")
    private String UserPassword;

    @OneToOne(mappedBy = "usuarioPojo")
    private TrabajadorPojo trabajadorPojo;

    @OneToOne(mappedBy = "usuarioPojo")
    private ClientePojo clientePojo;

    public UsuarioPojo() {

    }

    public UsuarioPojo(int id, String tipo, String userName, String userPassword) {
        this.Id = id;
        this.Tipo = tipo;
        this.UserName = userName;
        this.UserPassword = userPassword;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }
}
