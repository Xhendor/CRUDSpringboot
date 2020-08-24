package com.uabc.edu.crud.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;
    private String name;
    private String cantidad;
    private String precio;
    private String fecha;
    private String marca;




    public Producto(String name, String cantidad, String precio, String fecha, String marca ){
        this.name = name;
        this.cantidad = cantidad;
        this.precio = precio;
        this.fecha = fecha;
        this.marca = marca;
    }

}
