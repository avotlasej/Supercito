package work.student.avotlasej.supercito.Views;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import work.student.avotlasej.supercito.Adapters.*;

import work.student.avotlasej.supercito.DB.DataBaseHelper;
import work.student.avotlasej.supercito.DB.ProductoCRUD;
import work.student.avotlasej.supercito.Datos.Compra;
import work.student.avotlasej.supercito.Datos.Producto;
import work.student.avotlasej.supercito.R;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Producto> productos;
    private RecyclerView lista;
    private LinearLayoutManager linearLayoutManager;
    private ProductoCRUD crud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // getApplicationContext().deleteDatabase("Supercito.db");

        Toolbar myToolbar = (Toolbar) findViewById(R.id.barra);
        setSupportActionBar(myToolbar);
        productos=new ArrayList<Producto>();
        crud=new ProductoCRUD(this);
        productos = crud.getProductos();

        lista = (RecyclerView) findViewById(R.id.lista);
        lista.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this);
        lista.setLayoutManager(linearLayoutManager);
        RecyclerViewCustomAdapter adapter  = new RecyclerViewCustomAdapter(productos, this, new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(MainActivity.this, Detalle.class);
                intent.putExtra("id", String.valueOf(productos.get(position).getId()));
                startActivity(intent);
            }
        });
        lista.setAdapter(adapter);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.itemNuevo) {
           // Intent intent = new Intent(MainActivity.this,Nuevo.class );
            startActivity(new Intent(MainActivity.this,Nuevo.class ));
            return true;
        }else if (id == R.id.itemHistorial) {
            startActivity(new Intent(MainActivity.this, Historial.class));
            return true;
        }else if (id == R.id.itemCompra) {
            Calendar c = Calendar.getInstance();
            System.out.println("Current time => "+c.getTime());

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formattedDate = df.format(c.getTime());
            // formattedDate have current date/time
            Toast.makeText(this, formattedDate, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, Nueva.class);
            intent.putExtra("id", formattedDate);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
