package com.gaed.commerce.pojo;

import javax.persistence.*;

@Entity
@Table(name = "USUARIO")
public class UsuarioPojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String UserName;
    private String UserPassword;

    public UsuarioPojo() {

    }

    public UsuarioPojo(int id, String userName, String userPassword) {
        this.Id = id;
        this.UserName = userName;
        this.UserPassword = userPassword;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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
