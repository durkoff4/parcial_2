package com.example.parcial_2;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FilterQueryProvider;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class listar_productos extends AppCompatActivity {

    Button filtrar;
    EditText txt_filtrar;
    ListView listado;
    ProductoCursorAdapter PCA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_productos);
        listado = findViewById(R.id.lista_productos);
        filtrar = findViewById(R.id.btn_filtrar);
        txt_filtrar = findViewById(R.id.id_a_filtrar);
        ProductoController pc = new ProductoController(this);
        Cursor c = pc.todosLosProductos();
        if (c.getCount() > 0) {
            PCA = new ProductoCursorAdapter(this, c, false);
            listado.setAdapter(PCA);
            listado.setTextFilterEnabled(true);
            PCA.setFilterQueryProvider(new FilterQueryProvider() {
                @Override
                public Cursor runQuery(CharSequence constraint) {
                    return null;
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), "No hay datos", Toast.LENGTH_SHORT).show();
        }

        filtrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = txt_filtrar.getText().toString();
                if (txt.isEmpty()) {
                    recreate();
                } else {
                    ProductoController PC = new ProductoController(getApplicationContext());
                    Cursor C = PC.buscarProducto(txt);
                    if (C != null && C.getCount() > 0) {
                        PCA.changeCursor(C);
                        PCA.notifyDataSetChanged();
                    } else {
                        Toast.makeText(getApplicationContext(), "Producto no encontrado", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}

