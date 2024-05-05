package com.example.parcial_2;

public class producto {
    private String ID;
    private String nombre;
    private String precio;
    private String costo;

    public producto(String nombre, String ID, String costo, String precio) {
        this.ID = ID;
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

    public String getId() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "producto{" +
                "ID='" + ID + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio='" + precio + '\'' +
                ", costo='" + costo + '\'' +
                '}';
    }
}
