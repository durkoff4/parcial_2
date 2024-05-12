package com.example.segundo_parcial;

import java.io.Serializable;

public class producto implements Serializable {
    private String codigo;
    private String nombre;
    private String precio;
    private String costo;

    public producto(String nombre, String _id, String costo, String precio) {
        this.codigo = _id;
        this.nombre = nombre;
        this.precio = precio;
        this.costo = costo;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setId(String _id) {
        this.codigo = _id;
    }

    @Override
    public String toString() {
        return "producto{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio='" + precio + '\'' +
                ", costo='" + costo + '\'' +
                '}';
    }
}