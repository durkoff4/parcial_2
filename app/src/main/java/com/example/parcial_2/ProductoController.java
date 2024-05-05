package com.example.parcial_2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;
public class ProductoController {
    private BaseDatos bd;
    private Context c;

    public ProductoController(Context c){
        this.bd = new BaseDatos(c, DefDB.nameDB, 1);
        this.c = c;
    }

    public void agregarProducto(producto p){
        try{
            SQLiteDatabase sql = bd.getWritableDatabase();

            String[] arg = new String[] {p.getId()};
            Cursor c = sql.query(DefDB.tabla_producto, null, "codigo=?", arg, null, null, null);
            if (c.getCount() > 0) {
                Toast.makeText((Context) c, "El código de producto ya existe", Toast.LENGTH_SHORT).show();
                return;
            }

            ContentValues valores = new ContentValues();
            valores.put(DefDB.col_cod, p.getId());
            valores.put(DefDB.col_nombre, p.getNombre());
            valores.put(DefDB.col_precio, p.getPrecio());
            valores.put(DefDB.col_costo, p.getCosto());
            long id = sql.insert(DefDB.tabla_producto, null, valores);
            Toast.makeText((Context) c, "Registro exitoso", Toast.LENGTH_SHORT).show();
        }
        catch (Exception ex){
            Toast.makeText(c, "Error en la operación " + ex.getMessage() , Toast.LENGTH_SHORT).show();
        }
    }

    public Cursor buscarProducto(String id){
        SQLiteDatabase sql = bd.getReadableDatabase();
        String[] args = new String[]{id};
        Cursor c = sql.query(DefDB.tabla_producto, null, "codigo=?", args, null, null, null);
        if (c.moveToFirst()) {
            return c; // Devuelve el cursor
        } else {
            Toast.makeText((Context) c, "Producto no encontrado", Toast.LENGTH_SHORT).show();
            return null;
        }
    }




    public void eliminarProducto(String codigo){
        try{
            SQLiteDatabase sql = bd.getWritableDatabase();
            String[] arg = new String[] {codigo};
            sql.delete(DefDB.tabla_producto, "codigo=?", arg);
            Toast.makeText(this.c, "Eliminación exitosa", Toast.LENGTH_LONG).show();
        }
        catch (Exception ex){
            Toast.makeText(c, "Error en la operación " + ex.getMessage() , Toast.LENGTH_SHORT).show();
        }
    }

    public void actualizarProducto(producto p){
        try{
            SQLiteDatabase sql = bd.getWritableDatabase();
            String arg[] = {p.getId()};
            ContentValues values = new ContentValues();
            values.put(DefDB.col_nombre, p.getNombre());
            values.put(DefDB.col_precio, p.getPrecio());
            values.put(DefDB.col_costo, p.getCosto());
            sql.update(DefDB.tabla_producto, values, "codigo=?", arg);
            Toast.makeText(this.c, "Actualización exitosa", Toast.LENGTH_LONG).show();
        }
        catch (Exception e){
            Toast.makeText(c, "Error en la operación " + e.getMessage() , Toast.LENGTH_SHORT).show();
        }
    }

    public Cursor todosLosProductos(){
        Cursor cur;
        try{
            SQLiteDatabase sql = bd.getReadableDatabase();
            cur = sql.query(DefDB.tabla_producto, null, null, null, null, null, null);
            return cur;
        }
        catch (Exception e){
            Toast.makeText(c, "Error en la operación " + e.getMessage() , Toast.LENGTH_SHORT).show();
            return null;
        }
    }
}


