package work.student.avotlasej.supercito.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Avotlasej on 23/10/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String DB_NOMBRE = "Supercito.db";
    private static final int DB_VERSION = 1;

    public static final String CREATE_PRODUCTOS_TABLE = "CREATE TABLE "
            + DataBaseContract.Producto.NOMBRE_TABLA + "("
            + DataBaseContract.Producto.COLUMNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + DataBaseContract.Producto.COLUMNA_PRODUCTO + " TEXT, "
            + DataBaseContract.Producto.COLUMNA_URLFOTO + " TEXT, "
            + DataBaseContract.Producto.COLUMNA_PRECIO + " REAL" + ")";

    public static final String CREATE_COMPRAS_TABLE = "CREATE TABLE "
            + DataBaseContract.Compra.NOMBRE_TABLA + "("
            + DataBaseContract.Compra.COLUMNA_ID + " TEXT, "
            + DataBaseContract.Compra.COLUMNA_PRODUCTO + " TEXT, "
            + DataBaseContract.Compra.COLUMNA_CANTIDAD + " REAL, "
            + DataBaseContract.Compra.COLUMNA_PRECIO + " REAL" + ")";


    private static final String SQL_DELETE_PRODUCTOS =
            "DROP TABLE IF EXIST " +DataBaseContract.Producto.NOMBRE_TABLA;
    private static final String SQL_DELETE_COMPRAS =
            "DROP TABLE IF EXIST " +DataBaseContract.Compra.NOMBRE_TABLA;

    public DataBaseHelper(Context context) {super(context,DB_NOMBRE,null,DB_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL(CREATE_PRODUCTOS_TABLE);
        sqLiteDatabase.execSQL(CREATE_COMPRAS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_PRODUCTOS);
        sqLiteDatabase.execSQL(SQL_DELETE_COMPRAS);
        onCreate(sqLiteDatabase);
    }
}
