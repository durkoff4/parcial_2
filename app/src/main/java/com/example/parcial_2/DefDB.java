package com.example.parcial_2;

public class DefDB {

    public static final String nameDB = "Productos";
    public static final String tabla_producto = "producto";
    public static final String col_cod = "codigo";
    public static final String col_nombre = "nombre";
    public static final String col_precio = "precio";
    public static final String col_costo = "costo";

    public static final String crear_tabla = "CREATE TABLE IF NOT EXISTS "
            + DefDB.tabla_producto + "(" + DefDB.col_cod + " text primary key," +
            DefDB.col_nombre + " text," +
            DefDB.col_precio + " text," +
            DefDB.col_costo + " text);";
}
