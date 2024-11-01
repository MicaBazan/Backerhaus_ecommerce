package com.Backerhaus_Ecommerce.models;


import jakarta.persistence.*;

@Entity
@Table(name = "producto")
public class productoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_producto;

    private String nombre;
    private String descripcion;
    private float precio;
    private String imagen;


    private int cantidad_minima;


    @ManyToOne
    @JoinColumn(name = "id_familia", referencedColumnName = "id_familia")
    private familiaModel fam;


    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getCantidad_minima() {
        return cantidad_minima;
    }

    public void setCantidad_minima(int cantidad_minima) {
        this.cantidad_minima = cantidad_minima;
    }

    public familiaModel getFam() {
        return fam;
    }

    public void setFam(familiaModel fam) {
        this.fam = fam;
    }
}
