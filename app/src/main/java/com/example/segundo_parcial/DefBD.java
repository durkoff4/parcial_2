package com.example.segundo_parcial;

public class DefBD {

    public static final String nameDB = "Producto";
    public static final String tabla_producto = "producto";
    public static final String col_cod = "codigo";
    public static final String col_nombre = "nombre";
    public static final String col_precio = "precio";
    public static final String col_costo = "costo";

    public static final String crear_tabla = "CREATE TABLE IF NOT EXISTS "
            + DefBD.tabla_producto + "(" + DefBD.col_cod + " text primary key," +
            DefBD.col_nombre + " text," +
            DefBD.col_precio + " text," +
            DefBD.col_costo + " text);";
}
