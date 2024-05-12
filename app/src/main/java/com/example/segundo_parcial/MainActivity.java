package com.example.segundo_parcial;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    EditText id,nombre,precio,costo;

    Button insertar,eliminar,listar,editar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insertar = findViewById(R.id.btn_insertar);
        listar = findViewById(R.id.btn_listar);
        eliminar = findViewById(R.id.btn_eliminar);
        editar = findViewById(R.id.btn_actualizar);
        id = findViewById(R.id.ing_ID);
        nombre = findViewById(R.id.ing_nombre);
        precio = findViewById(R.id.ing_precio);
        costo = findViewById(R.id.ing_costo);

        insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                producto P = new producto(id.getText().toString(), nombre.getText().toString(), precio.getText().toString(), costo.getText().toString());
                ProductoController PC = new ProductoController(getApplicationContext());
                PC.agregarProducto(P);
            }
        });

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProductoController PC = new ProductoController(getApplicationContext());
                PC.eliminarProdcuto(id.getText().toString());
            }
        });

        listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), listar_productos.class);
                startActivity(i);
            }
        });

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                producto P = new producto(id.getText().toString(), nombre.getText().toString(), precio.getText().toString(), costo.getText().toString());
                ProductoController PC = new ProductoController(getApplicationContext());
                PC.actualizarproducto(P);
            }
        });

    }
}