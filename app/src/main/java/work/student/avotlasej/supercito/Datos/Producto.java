package work.student.avotlasej.supercito.Datos;

/**
 * Created by Avotlasej on 23/10/2017.
 */

public class Producto {
    int id;
    String producto;
    float precio;
    String urlFoto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Producto(String producto, float precio, String urlFoto) {
        this.producto = producto;
        this.precio = precio;
        this.urlFoto = urlFoto;
    }

    public Producto(int id, String producto, float precio, String urlFoto) {
        this.id = id;
        this.producto = producto;
        this.precio = precio;
        this.urlFoto = urlFoto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }
}
