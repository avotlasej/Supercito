package work.student.avotlasej.supercito.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import work.student.avotlasej.supercito.Adapters.RecyclerViewClickListener;
import work.student.avotlasej.supercito.Adapters.RecyclerViewCustomAdapter;
import work.student.avotlasej.supercito.Adapters.RecyclerViewCustomHistorial;
import work.student.avotlasej.supercito.DB.CompraCRUD;
import work.student.avotlasej.supercito.DB.ProductoCRUD;
import work.student.avotlasej.supercito.Datos.Compra;
import work.student.avotlasej.supercito.Datos.Historia;
import work.student.avotlasej.supercito.Datos.Producto;
import work.student.avotlasej.supercito.R;

/**
 * Created by Avotlasej on 28/10/2017.
 */

public class Historial extends AppCompatActivity {
    private ArrayList<Historia> historial;
    private RecyclerView lista;
    private LinearLayoutManager linearLayoutManager;
    private CompraCRUD crud;
    private RecyclerViewCustomHistorial adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.barra);
        setSupportActionBar(myToolbar);
        historial = new ArrayList<Historia>();
        crud=new CompraCRUD(this);
        historial = crud.getCompras();
        lista = (RecyclerView) findViewById(R.id.lista);
        lista.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this);
        lista.setLayoutManager(linearLayoutManager);
        adapter = new RecyclerViewCustomHistorial(historial, this, new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
         /*       Intent intent = new Intent(Historial.this, Detalle.class);
                intent.putExtra("id", String.valueOf(productos.get(position).getId()));
                startActivity(intent);*/
            }
        });
        lista.setAdapter(adapter);

    }
}
