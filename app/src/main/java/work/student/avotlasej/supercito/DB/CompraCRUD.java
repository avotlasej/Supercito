package work.student.avotlasej.supercito.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import work.student.avotlasej.supercito.Datos.Compra;
import work.student.avotlasej.supercito.Datos.Historia;
import work.student.avotlasej.supercito.Datos.Producto;

/**
 * Created by Avotlasej on 28/10/2017.
 */

public class CompraCRUD {
    private DataBaseHelper helper;

    public CompraCRUD(Context context) {
        helper = new DataBaseHelper(context);
    }

    public void newCompra(Compra item){
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(DataBaseContract.Compra.COLUMNA_ID, item.getId());
        values.put(DataBaseContract.Compra.COLUMNA_PRODUCTO, item.getProducto());
        values.put(DataBaseContract.Compra.COLUMNA_CANTIDAD, item.getCantidad());
        values.put(DataBaseContract.Compra.COLUMNA_PRECIO, item.getPrecio());

        long newRowId = db.insert(DataBaseContract.Compra.NOMBRE_TABLA, null, values);
        db.close();
    }

    public ArrayList<Historia> getCompras(){
        ArrayList<Historia> items = new ArrayList<Historia>();
        SQLiteDatabase db = helper.getReadableDatabase();
        Compra temp=null;
        int elementos=0;
        Float total=(float)0;
        String[] columnas = {
                DataBaseContract.Compra.COLUMNA_ID,
                DataBaseContract.Compra.COLUMNA_PRODUCTO,
                DataBaseContract.Compra.COLUMNA_CANTIDAD,
                DataBaseContract.Compra.COLUMNA_PRECIO,
        };

        Cursor c = db.query(
                DataBaseContract.Compra.NOMBRE_TABLA,
                columnas,
                null,
                null,
                null,
                null,
                null);

        while(c.moveToNext()){
            if(temp==null){
                temp=new Compra(
                        c.getString(c.getColumnIndexOrThrow(DataBaseContract.Compra.COLUMNA_ID)),
                        c.getString(c.getColumnIndexOrThrow(DataBaseContract.Compra.COLUMNA_PRODUCTO)),
                        c.getFloat(c.getColumnIndexOrThrow(DataBaseContract.Compra.COLUMNA_CANTIDAD)),
                        c.getFloat(c.getColumnIndexOrThrow(DataBaseContract.Compra.COLUMNA_PRECIO))
                );
                total=temp.getPrecio()*temp.getCantidad();
                elementos++;
            }else{
                if (temp.getId().equals(c.getString(c.getColumnIndexOrThrow(DataBaseContract.Compra.COLUMNA_ID)))){
                    total+=c.getFloat(c.getColumnIndexOrThrow(DataBaseContract.Compra.COLUMNA_CANTIDAD))*
                            c.getFloat(c.getColumnIndexOrThrow(DataBaseContract.Compra.COLUMNA_PRECIO));
                    elementos++;
                }else {
                    items.add(new Historia(temp.getId(),total,elementos));
                    elementos=1;
                    temp=new Compra(
                            c.getString(c.getColumnIndexOrThrow(DataBaseContract.Compra.COLUMNA_ID)),
                            c.getString(c.getColumnIndexOrThrow(DataBaseContract.Compra.COLUMNA_PRODUCTO)),
                            c.getFloat(c.getColumnIndexOrThrow(DataBaseContract.Compra.COLUMNA_CANTIDAD)),
                            c.getFloat(c.getColumnIndexOrThrow(DataBaseContract.Compra.COLUMNA_PRECIO))
                    );
                    total=temp.getPrecio()*temp.getCantidad();
                }
            }
            if(temp==null){
                items.add(new Historia(temp.getId(),total,elementos));
            }
        }
        c.close();
        return items;
    }

    public ArrayList<Compra> getCompra(String compra){
        ArrayList<Compra> items = new ArrayList<Compra>();
        SQLiteDatabase db = helper.getReadableDatabase();
        String[] columnas = {
                DataBaseContract.Compra.COLUMNA_ID,
                DataBaseContract.Compra.COLUMNA_PRODUCTO,
                DataBaseContract.Compra.COLUMNA_CANTIDAD,
                DataBaseContract.Compra.COLUMNA_PRECIO,
        };

        Cursor c = db.query(
                DataBaseContract.Compra.NOMBRE_TABLA,
                columnas,
                "id=?",
                new String[]{String.valueOf(compra)},
                null,
                null,
                null);
        while(c.moveToNext()){
            items.add(new Compra(
                    c.getString(c.getColumnIndexOrThrow(DataBaseContract.Compra.COLUMNA_ID)),
                    c.getString(c.getColumnIndexOrThrow(DataBaseContract.Compra.COLUMNA_PRODUCTO)),
                    c.getFloat(c.getColumnIndexOrThrow(DataBaseContract.Compra.COLUMNA_CANTIDAD)),
                    c.getFloat(c.getColumnIndexOrThrow(DataBaseContract.Compra.COLUMNA_PRECIO))
            ));
        }
        c.close();
        return items;
    }

  /*  public void updateProducto(Producto item){
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DataBaseContract.Producto.COLUMNA_PRODUCTO, item.getProducto());
        values.put(DataBaseContract.Producto.COLUMNA_PRECIO, item.getPrecio());
        values.put(DataBaseContract.Producto.COLUMNA_URLFOTO, item.getUrlFoto());

        db.update(DataBaseContract.Producto.NOMBRE_TABLA,values,"id=?",new String[]{String.valueOf(item.getId())});

        db.close();
    }*/

  /*  public void deleteProducto(Producto item){
        SQLiteDatabase db = helper.getWritableDatabase();
        db.delete(DataBaseContract.Producto.NOMBRE_TABLA,"id=?",new String[]{String.valueOf(item.getId())});
        db.close();
    }*/
}
