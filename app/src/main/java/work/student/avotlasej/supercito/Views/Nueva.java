package work.student.avotlasej.supercito.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Iterator;

import work.student.avotlasej.supercito.Adapters.RecyclerViewClickListener;
import work.student.avotlasej.supercito.Adapters.RecyclerViewCustomAdapter;
import work.student.avotlasej.supercito.Adapters.RecyclerViewCustomAdapterCompra;
import work.student.avotlasej.supercito.DB.CompraCRUD;
import work.student.avotlasej.supercito.DB.ProductoCRUD;
import work.student.avotlasej.supercito.Datos.Compra;
import work.student.avotlasej.supercito.Datos.Producto;
import work.student.avotlasej.supercito.R;

/**
 * Created by Avotlasej on 27/10/2017.
 */

public class Nueva extends AppCompatActivity {

    private EditText cantidad;
    private Button  bAgregar, bFinalizar;
    private Spinner spinner;

    private ProductoCRUD crud;
    private CompraCRUD   crudC;
    private ArrayList<Producto> productosO;
    private Producto temp;
    private RecyclerView lista1;
    private LinearLayoutManager linearLayoutManager;
    private ArrayList<Compra> compra;
    private String idFecha;
    private RecyclerViewCustomAdapterCompra adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compra);
        idFecha = getIntent().getStringExtra("id");
        cantidad = (EditText) findViewById(R.id.etCantidad);

        bAgregar = (Button) findViewById(R.id.bAgregar);

        bFinalizar = (Button) findViewById(R.id.bFinalizar);

        spinner = (Spinner) findViewById(R.id.spinner);
        compra = new ArrayList<Compra>();
        crud = new ProductoCRUD(this);
        crudC = new CompraCRUD(this);
        productosO = crud.getProductos();

        ArrayList<String> productos = new ArrayList<String>();

        for(int i=0; i<productosO.size();i++)
        {
            productos.add(productosO.get(i).getProducto());
        }

        spinner.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,productos));


        lista1 = (RecyclerView) findViewById(R.id.lista1);
        lista1.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this);
        lista1.setLayoutManager(linearLayoutManager);
        adapter  = new RecyclerViewCustomAdapterCompra(compra, this, new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {

            }
        });
        lista1.setAdapter(adapter);
        bAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp = productosO.get(spinner.getSelectedItemPosition());
                compra.add(new Compra(idFecha,temp.getProducto(), Float.valueOf(cantidad.getText().toString()),temp.getPrecio()));
                adapter.notifyDataSetChanged();
            }
        });
        bFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i=0;i<compra.size();i++)
                {
                    crudC.newCompra(compra.get(i));
                }
               startActivity(new Intent(Nueva.this, MainActivity.class));
    }
});

    }
}
