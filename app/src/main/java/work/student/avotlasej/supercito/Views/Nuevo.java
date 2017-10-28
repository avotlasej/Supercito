package work.student.avotlasej.supercito.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import work.student.avotlasej.supercito.DB.ProductoCRUD;
import work.student.avotlasej.supercito.Datos.Producto;
import work.student.avotlasej.supercito.R;

/**
 * Created by Avotlasej on 23/10/2017.
 */

public class Nuevo extends AppCompatActivity {

    private EditText etProducto, etPrecio;
    private Button bAdd;
    private Producto producto;

    private ProductoCRUD crud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        etProducto = (EditText) findViewById(R.id.etProducto);
        etPrecio = (EditText) findViewById(R.id.etPrecio);

        bAdd = (Button) findViewById(R.id.bAdd);

        crud = new ProductoCRUD(this);

        if(getIntent().getStringExtra("id")==null)
        {
            bAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    crud.newProducto(new Producto(etProducto.getText().toString(), Float.valueOf(etPrecio.getText().toString()),"URL"));
                    startActivity(new Intent(Nuevo.this, MainActivity.class));
                }
            });
        }else {
            producto = crud.getProducto(getIntent().getStringExtra("id"));
            etProducto.setText(producto.getProducto());
            etPrecio.setText(String.valueOf(producto.getPrecio()));
            bAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    producto.setProducto(etProducto.getText().toString());
                    producto.setPrecio(Float.valueOf(etPrecio.getText().toString()));
                    crud.updateProducto(producto);
                    startActivity(new Intent(Nuevo.this, MainActivity.class));
                }
            });
        }

    }
}
