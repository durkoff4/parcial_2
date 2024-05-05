package com.example.parcial_2;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;

public class ProductoCursorAdapter extends CursorAdapter {
    public ProductoCursorAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_productos, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView Id = view.findViewById(R.id.txt_id);
        EditText nombre = view.findViewById(R.id.txt_nombre);
        EditText precio = view.findViewById(R.id.txt_precio);
        EditText costo = view.findViewById(R.id.txt_costo);
        Button editar = view.findViewById(R.id.btn_editar);


        int id = cursor.getInt(0);
        String nombreProducto = cursor.getString(1);
        String precioProducto = cursor.getString(2);
        String costoProducto = cursor.getString(3);

        Id.setText(String.valueOf(id));
        nombre.setText(nombreProducto);
        precio.setText(precioProducto);
        costo.setText(costoProducto);

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String codigo = Id.getText().toString();
                String nuevoNombre = nombre.getText().toString();
                String nuevoPrecio = precio.getText().toString();
                String nuevoCosto = costo.getText().toString();

                producto P = new producto(codigo, nuevoNombre, nuevoPrecio, nuevoCosto);
                ProductoController PC = new ProductoController(context.getApplicationContext());
                PC.actualizarProducto(P);
            }
        });
    }
}


