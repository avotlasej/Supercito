package work.student.avotlasej.supercito.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import work.student.avotlasej.supercito.Datos.Compra;
import work.student.avotlasej.supercito.Datos.Producto;
import work.student.avotlasej.supercito.R;

/**
 * Created by Avotlasej on 27/10/2017.
 */

public class RecyclerViewCustomAdapterCompra extends
        RecyclerView.Adapter<RecyclerViewCustomAdapterCompra.CustomViewHolder> {

    private ArrayList<Compra> items;
    private RecyclerViewClickListener listener;
    private Context context;

    public RecyclerViewCustomAdapterCompra(ArrayList<Compra> items, Context context, RecyclerViewClickListener listener) {
        this.items = items;
        this.listener = listener;
        this.context = context;
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder{
        private TextView tvProductoC, tvCantidadC,tvPrecioC;

        CustomViewHolder(View vista){
            super(vista);

            tvProductoC = (TextView) vista.findViewById(R.id.tvProductoC);
            tvCantidadC = (TextView) vista.findViewById(R.id.tvCantidadC);
            tvPrecioC = (TextView) vista.findViewById(R.id.tvPrecioC);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onBindViewHolder(RecyclerViewCustomAdapterCompra.CustomViewHolder holder, int position) {
        holder.tvProductoC.setText(items.get(position).getProducto());
        holder.tvCantidadC.setText(""+items.get(position).getCantidad()+" de " +items.get(position).getPrecio());
        holder.tvPrecioC.setText("$"+items.get(position).getPrecio()*items.get(position).getCantidad());
    }


    @Override
    public RecyclerViewCustomAdapterCompra.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.filacompra, parent, false);

        return new RowViewHolderCompra(vista, listener);
    }

}