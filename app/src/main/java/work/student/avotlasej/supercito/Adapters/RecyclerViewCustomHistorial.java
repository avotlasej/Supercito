package work.student.avotlasej.supercito.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import work.student.avotlasej.supercito.Datos.Compra;
import work.student.avotlasej.supercito.Datos.Historia;
import work.student.avotlasej.supercito.R;

/**
 * Created by Avotlasej on 28/10/2017.
 */

public class RecyclerViewCustomHistorial extends
        RecyclerView.Adapter<RecyclerViewCustomHistorial.CustomViewHolder> {

    private ArrayList<Historia> items;
    private RecyclerViewClickListener listener;
    private Context context;

    public RecyclerViewCustomHistorial(ArrayList<Historia> items, Context context, RecyclerViewClickListener listener) {
        this.items = items;
        this.listener = listener;
        this.context = context;
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder{
        private TextView tvCompraH, tvTotalH,tvCantidadH;

        CustomViewHolder(View vista){
            super(vista);

            tvCompraH = (TextView) vista.findViewById(R.id.tvCompraH);
            tvCantidadH = (TextView) vista.findViewById(R.id.tvCantidadH);
            tvTotalH = (TextView) vista.findViewById(R.id.tvTotalH);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onBindViewHolder(RecyclerViewCustomHistorial.CustomViewHolder holder, int position) {
        holder.tvCompraH.setText(items.get(position).getId());
        holder.tvCantidadH.setText(""+items.get(position).getElementos()+" Elementos");
        holder.tvTotalH.setText("$"+items.get(position).getTotal());
    }


    @Override
    public RecyclerViewCustomHistorial.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.filahistorial, parent, false);

        return new RowViewHolderHistorial(vista, listener);
    }
}
