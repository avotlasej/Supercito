package work.student.avotlasej.supercito.DB;

import android.provider.BaseColumns;

/**
 * Created by Avotlasej on 23/10/2017.
 */

public class DataBaseContract {
    private DataBaseContract(){}

    public static class Producto implements BaseColumns {
        public static final String NOMBRE_TABLA = "productos";
        public static final String COLUMNA_ID = "id";
        public static final String COLUMNA_PRODUCTO = "producto";
        public static final String COLUMNA_PRECIO = "precio";
        public static final String COLUMNA_URLFOTO = "urlFoto";
    }

    public static class Compra implements BaseColumns {
        public static final String NOMBRE_TABLA = "compras";
        public static final String COLUMNA_ID = "id";
        public static final String COLUMNA_PRODUCTO = "producto";
        public static final String COLUMNA_CANTIDAD = "cantidad";
        public static final String COLUMNA_PRECIO = "precio";
    }


}
