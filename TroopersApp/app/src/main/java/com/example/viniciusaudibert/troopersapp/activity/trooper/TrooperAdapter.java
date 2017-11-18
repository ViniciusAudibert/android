package com.example.viniciusaudibert.troopersapp.activity.trooper;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.viniciusaudibert.troopersapp.R;
import com.example.viniciusaudibert.troopersapp.model.Trooper;

import java.util.List;

/**
 * Created by vinicius.audibert on 18/11/2017.
 */

public class TrooperAdapter extends RecyclerView.Adapter<TrooperHolder> implements View.OnClickListener {
    private List<Trooper> listTrooper;
    private OnItemClickListener onItemClickListener;
    private View.OnLongClickListener onLongClickListener;

    public TrooperAdapter(List<Trooper> listTrooper, OnItemClickListener onItemClickListener, View.OnLongClickListener onLongClickListener) {
        this.listTrooper = listTrooper;
        this.onItemClickListener = onItemClickListener;
        this.onLongClickListener = onLongClickListener;
    }

    @Override
    public TrooperHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_item_trooper, parent, false);

        return new TrooperHolder(v);
    }

    @Override
    public void onBindViewHolder(TrooperHolder holder, int position) {
        Trooper trooper = listTrooper.get(position);

        holder.itemView.setTag(trooper);
        holder.itemView.setOnClickListener(this);
        holder.itemView.setOnLongClickListener(onLongClickListener);

        holder.getTvTrooperName().setText(trooper.getName());
        holder.getImvTrooperAffiliation().setImageResource(trooper.getAffiliation().getImage());
        holder.getvSeparator().setVisibility(isLastItem(position) ? View.INVISIBLE : View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return listTrooper.size();
    }

    @Override
    public void onClick(View view) {
        onItemClickListener.onItemClick((Trooper) view.getTag());
    }

    public interface OnItemClickListener {
        void onItemClick(Trooper trooper);
    }

    private boolean isLastItem(int position) {
        return position == getItemCount() - 1;
    }
}
