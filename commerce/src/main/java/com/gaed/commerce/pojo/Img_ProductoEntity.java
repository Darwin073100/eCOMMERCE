package com.gaed.commerce.pojo;

import javax.persistence.*;

@Entity
@Table(name = "img_producto")
public class Img_ProductoEntity {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    @Column(name = "Imagen")
    private String Imagen;
    @Column(name = "Id_Producto")
    private String idproducto;

    @ManyToOne
    @JoinColumn(name = "Id_Producto",insertable = false, updatable = false)
    private ProductoPojo productoPojo;

    public Img_ProductoEntity() {
    }

    public Img_ProductoEntity(int Id, String Imagen, String Idproducto){
        this.Id = Id;
        this.Imagen= Imagen;
        this.idproducto = Idproducto;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String imagen) {
        Imagen = imagen;
    }

    public String getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(String idproducto) {
        this.idproducto = idproducto;
    }

}
