package work.student.avotlasej.supercito.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import work.student.avotlasej.supercito.Datos.Producto;

/**
 * Created by Avotlasej on 23/10/2017.
 */

public class ProductoCRUD {
    private DataBaseHelper helper;

    public ProductoCRUD(Context context) {
        helper = new DataBaseHelper(context);
    }

    public void newProducto(Producto item){
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(DataBaseContract.Producto.COLUMNA_PRODUCTO, item.getProducto());
        values.put(DataBaseContract.Producto.COLUMNA_PRECIO, item.getPrecio());
        values.put(DataBaseContract.Producto.COLUMNA_URLFOTO, item.getUrlFoto());

        long newRowId = db.insert(DataBaseContract.Producto.NOMBRE_TABLA, null, values);
        db.close();
    }

    public ArrayList<Producto> getProductos(){
        ArrayList<Producto> items = new ArrayList<Producto>();
        SQLiteDatabase db = helper.getReadableDatabase();
        String[] columnas = {
                DataBaseContract.Producto.COLUMNA_ID,
                DataBaseContract.Producto.COLUMNA_PRODUCTO,
                DataBaseContract.Producto.COLUMNA_PRECIO,
                DataBaseContract.Producto.COLUMNA_URLFOTO,
        };

        Cursor c = db.query(
                DataBaseContract.Producto.NOMBRE_TABLA,
                columnas,
                null,
                null,
                null,
                null,
                null);

        while(c.moveToNext()){
            items.add(new Producto(
                    c.getInt(c.getColumnIndexOrThrow(DataBaseContract.Producto.COLUMNA_ID)),
                    c.getString(c.getColumnIndexOrThrow(DataBaseContract.Producto.COLUMNA_PRODUCTO)),
                    c.getFloat(c.getColumnIndexOrThrow(DataBaseContract.Producto.COLUMNA_PRECIO)),
                    c.getString(c.getColumnIndexOrThrow(DataBaseContract.Producto.COLUMNA_URLFOTO))
            ));
        }
        c.close();
        return items;
    }

    public Producto getProducto(String producto){
        Producto item = null;
        SQLiteDatabase db = helper.getReadableDatabase();
        String[] columnas = {
                DataBaseContract.Producto.COLUMNA_ID,
                DataBaseContract.Producto.COLUMNA_PRODUCTO,
                DataBaseContract.Producto.COLUMNA_PRECIO,
                DataBaseContract.Producto.COLUMNA_URLFOTO,
        };

        Cursor c = db.query(
                DataBaseContract.Producto.NOMBRE_TABLA,
                columnas,
                "id=?",
                new String[]{String.valueOf(producto)},
                null,
                null,
                null);
        while(c.moveToNext()){
            item = new Producto(
                    c.getInt(c.getColumnIndexOrThrow(DataBaseContract.Producto.COLUMNA_ID)),
                    c.getString(c.getColumnIndexOrThrow(DataBaseContract.Producto.COLUMNA_PRODUCTO)),
                    c.getFloat(c.getColumnIndexOrThrow(DataBaseContract.Producto.COLUMNA_PRECIO)),
                    c.getString(c.getColumnIndexOrThrow(DataBaseContract.Producto.COLUMNA_URLFOTO))
            );
        }
        c.close();
        return item;
    }

    public void updateProducto(Producto item){
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DataBaseContract.Producto.COLUMNA_PRODUCTO, item.getProducto());
        values.put(DataBaseContract.Producto.COLUMNA_PRECIO, item.getPrecio());
        values.put(DataBaseContract.Producto.COLUMNA_URLFOTO, item.getUrlFoto());

        db.update(DataBaseContract.Producto.NOMBRE_TABLA,values,"id=?",new String[]{String.valueOf(item.getId())});

        db.close();
    }

    public void deleteProducto(Producto item){
        SQLiteDatabase db = helper.getWritableDatabase();
        db.delete(DataBaseContract.Producto.NOMBRE_TABLA,"id=?",new String[]{String.valueOf(item.getId())});
        db.close();
    }
}
