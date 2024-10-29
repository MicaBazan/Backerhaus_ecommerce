package com.Backerhaus_Ecommerce.models;


import jakarta.persistence.*;

@Entity
@Table(name = "familia")
public class familia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_familia;

    private String nombre;
    private String descripcion;

    public int getId_familia() {
        return id_familia;
    }

    public void setId_familia(int id_familia) {
        this.id_familia = id_familia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
