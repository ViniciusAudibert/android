package com.example.viniciusaudibert.troopersapp.activity.trooper;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.viniciusaudibert.troopersapp.R;

/**
 * Created by vinicius.audibert on 18/11/2017.
 */

public class TrooperHolder extends RecyclerView.ViewHolder {
    private TextView tvTrooperName;
    private ImageView imvTrooperAffiliation;
    private View vSeparator;

    public TrooperHolder(View view) {
        super(view);

        this.tvTrooperName = itemView.findViewById(R.id.trooper_name);
        this.imvTrooperAffiliation = itemView.findViewById(R.id.trooper_affiliationImage);
        this.vSeparator = itemView.findViewById(R.id.trooper_lineSeparator);
    }

    public TextView getTvTrooperName() {
        return tvTrooperName;
    }

    public ImageView getImvTrooperAffiliation() {
        return imvTrooperAffiliation;
    }

    public View getvSeparator() {
        return vSeparator;
    }
}
