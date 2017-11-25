package br.com.cwi.restapplication.Adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import br.com.cwi.restapplication.Models.MovieModel;
import br.com.cwi.restapplication.R;

/**
 * Created by juliano.nardon on 25/11/17.
 */

public class MoviewListAdapter extends RecyclerView.Adapter<MoviewListAdapter.ViewHolder> implements View.OnClickListener {

    private ArrayList<MovieModel> movieModels;
    private OnItemClickListener onItemClickListener;

    public MoviewListAdapter(ArrayList<MovieModel> movieModels, OnItemClickListener onItemClickListener) {
        this.movieModels = movieModels;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public void onBindViewHolder(final MoviewListAdapter.ViewHolder holder, int position) {
        MovieModel movieModel = movieModels.get(position);

        holder.imageView.setOnClickListener(this);
        holder.imageView.setTag(movieModel.getImdbID());

        Picasso.with(holder.imageView.getContext())
                .load(movieModel.getPoster())
                .into(holder.imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        holder.progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {
                        holder.progressBar.setVisibility(View.GONE);
                    }
                });
    }

    @Override
    public MoviewListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_card_item, parent, false));
    }

    @Override
    public int getItemCount() {
        return movieModels.size();
    }

    @Override
    public void onClick(View view) {
        onItemClickListener.onItemClick((String) view.getTag());
    }

    public interface OnItemClickListener {
        void onItemClick(String id);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public ProgressBar progressBar;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_view);
            progressBar = itemView.findViewById(R.id.progress_bar);
        }
    }

    public void setItemList(ArrayList<MovieModel> movieModels) {
        this.movieModels = movieModels;
    }
}
