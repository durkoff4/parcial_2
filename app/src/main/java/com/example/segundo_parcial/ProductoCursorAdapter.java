package com.example.segundo_parcial;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;


public class ProductoCursorAdapter extends CursorAdapter {

    public ProductoCursorAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_productos,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView Id = view.findViewById(R.id.txt_id);
        TextView nombre = view.findViewById(R.id.txt_nombre);
        TextView precio = view.findViewById(R.id.txt_precio);
        TextView costo = view.findViewById(R.id.txt_costo);

        Id.setText(cursor.getString(0));
        nombre.setText(cursor.getString(1));
        precio.setText(cursor.getString(3));
        costo.setText(cursor.getString(2));

    }
}