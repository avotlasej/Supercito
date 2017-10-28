package work.student.avotlasej.supercito.Datos;

/**
 * Created by Avotlasej on 28/10/2017.
 */

public class Historia {
    String id;
    Float total;
    int   elementos;

    public Historia(String id, Float total) {
        this.id = id;
        this.total = total;
    }

    public Historia(String id, Float total, int elementos) {
        this.id = id;
        this.total = total;
        this.elementos = elementos;
    }

    public int getElementos() {
        return elementos;
    }

    public void setElementos(int elementos) {
        this.elementos = elementos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }
}
