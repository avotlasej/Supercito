package work.student.avotlasej.supercito.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import work.student.avotlasej.supercito.Datos.Producto;
import work.student.avotlasej.supercito.R;

/**
 * Created by Avotlasej on 23/10/2017.
 */

public class RecyclerViewCustomAdapter extends
        RecyclerView.Adapter<RecyclerViewCustomAdapter.CustomViewHolder> {

    private ArrayList<Producto> items;
    private RecyclerViewClickListener listener;
    private Context context;

    public RecyclerViewCustomAdapter(ArrayList<Producto> items, Context context, RecyclerViewClickListener listener) {
        this.items = items;
        this.listener = listener;
        this.context = context;
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder{
        private TextView tvProducto, tvPrecio;

        CustomViewHolder(View vista){
            super(vista);

            tvProducto = (TextView) vista.findViewById(R.id.tvProducto);
            tvPrecio = (TextView) vista.findViewById(R.id.tvPrecio);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.tvProducto.setText(items.get(position).getProducto());
        holder.tvPrecio.setText(String.valueOf(items.get(position).getPrecio()));
    }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.filaproducto, parent, false);

        return new RowViewHolder(vista, listener);
    }

}
