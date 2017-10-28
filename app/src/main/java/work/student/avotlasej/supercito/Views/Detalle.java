package work.student.avotlasej.supercito.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import work.student.avotlasej.supercito.DB.ProductoCRUD;
import work.student.avotlasej.supercito.Datos.Producto;
import work.student.avotlasej.supercito.R;

/**
 * Created by Avotlasej on 23/10/2017.
 */

public class Detalle extends AppCompatActivity {
    private TextView tvProducto, tvPrecio;
    private Button bMod,bEli;
    private Producto producto;

    private ProductoCRUD crud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        tvProducto = (TextView) findViewById(R.id.tvProductod);
        tvPrecio = (TextView) findViewById(R.id.tvPreciod);

        bMod = (Button) findViewById(R.id.bMod);
        bEli = (Button) findViewById(R.id.bEli);

        crud = new ProductoCRUD(this);

        producto = crud.getProducto(getIntent().getStringExtra("id"));
        tvProducto.setText(producto.getProducto());
        tvPrecio.setText(String.valueOf(producto.getPrecio()));

        bMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Detalle.this, Nuevo.class);
                intent.putExtra("id", String.valueOf(producto.getId()));
                startActivity(intent);
            }
        });

        bEli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crud.deleteProducto(producto);
                startActivity(new Intent(Detalle.this, MainActivity.class));
            }
        });

    }
}
