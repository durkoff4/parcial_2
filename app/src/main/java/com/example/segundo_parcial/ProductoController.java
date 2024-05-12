package com.example.segundo_parcial;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWindowAllocationException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import androidx.core.database.sqlite.SQLiteDatabaseKt;

public class ProductoController {
    private BaseDatos bd;
    private Context c;


    public ProductoController(Context c) {
        this.bd = new BaseDatos(c, DefBD.nameDB, 2);
        this.c = c;
    }

    public void agregarProducto(producto p) {
        try {
            SQLiteDatabase sql = bd.getWritableDatabase();
            ContentValues valores = new ContentValues();
            valores.put(DefBD.col_cod, p.getNombre());
            valores.put(DefBD.col_nombre, p.getCodigo());
            valores.put(DefBD.col_precio, p.getPrecio());
            valores.put(DefBD.col_costo, p.getCosto());
            Log.d("Database", "Inserting product: " + valores.toString());
            if (!buscarProducto(p)) {
                long id = sql.insert(DefBD.tabla_producto, null, valores);
                Toast.makeText(c, "Registro exitosa", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(c, "Codigo prodcuto ya existe", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception ex) {
            Toast.makeText(c, "Error en la operacion " + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public boolean buscarProducto(producto p) {
        String[] arg = new String[]{p.getCodigo()};

        SQLiteDatabase sql = bd.getReadableDatabase();
        Cursor c = sql.query(DefBD.tabla_producto, null, "codigo=?", arg, null, null, null);
        if (c.getCount() > 0) {
            bd.close();
            return true;
        } else {
            return false;
        }
    }

    public Cursor buscarProduct(String id) {
        String[] args = new String[]{id};
        Cursor cursor;
        try {
            SQLiteDatabase sql = bd.getReadableDatabase();
            cursor = sql.rawQuery("select codigo as _id, nombre, precio, costo from producto where codigo = ?", args);
            return cursor;
        } catch (Exception e) {
            Toast.makeText(c, "Error en la operacion " + e.getMessage(), Toast.LENGTH_SHORT).show();
            return null;
        }
    }

    public void actualizarproducto(producto p) {
        try {
            SQLiteDatabase sql = bd.getWritableDatabase();
            String arg[] = {p.getCodigo()};
            ContentValues valores = new ContentValues();
            valores.put(DefBD.col_nombre, p.getCodigo());
            valores.put(DefBD.col_precio, p.getPrecio());
            valores.put(DefBD.col_costo, p.getCosto());
            sql.update(DefBD.tabla_producto, valores, "codigo=?", arg);
            Log.d("Database", "Inserting product: " + valores.toString());
            Toast.makeText(this.c, "Actualizacion exitosa", Toast.LENGTH_LONG).show();

        } catch (Exception e) {
            Toast.makeText(c, "Error en la operacion " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void eliminarProdcuto(String codigo) {
        try {
            SQLiteDatabase sql = bd.getWritableDatabase();
            String[] arg = new String[]{codigo};
            sql.delete(DefBD.tabla_producto, "codigo=?", arg);
            Toast.makeText(this.c, "Eliminacion exitosa", Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(c, "Error en la operacion " + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    public Cursor allproductos() {
        Cursor cur= null;
        try {
            SQLiteDatabase sql = bd.getReadableDatabase();
            cur = sql.rawQuery("select codigo as _id, nombre, precio, costo from producto order by " + DefBD.col_nombre, null);
            return cur;
        } catch (Exception e) {
            Toast.makeText(c, "Error en la operacion " + e.getMessage(), Toast.LENGTH_SHORT).show();
            return null;
        }
    }

}