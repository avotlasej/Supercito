package work.student.avotlasej.supercito.Adapters;

import android.view.View;

/**
 * Created by Avotlasej on 23/10/2017.
 */

public class RowViewHolder extends RecyclerViewCustomAdapter.CustomViewHolder
        implements View.OnClickListener {

    private RecyclerViewClickListener listener;

    public RowViewHolder(View itemView, RecyclerViewClickListener listener) {
        super(itemView);
        this.listener = listener;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        listener.onClick(view, getAdapterPosition());
    }
}
