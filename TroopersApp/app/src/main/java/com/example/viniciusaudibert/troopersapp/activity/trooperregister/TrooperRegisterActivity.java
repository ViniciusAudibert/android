package com.example.viniciusaudibert.troopersapp.activity.trooperregister;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.viniciusaudibert.troopersapp.R;
import com.example.viniciusaudibert.troopersapp.constants.ExtraConstants;
import com.example.viniciusaudibert.troopersapp.model.Trooper;
import com.example.viniciusaudibert.troopersapp.repository.TrooperRepository;
import com.squareup.picasso.Picasso;

public class TrooperRegisterActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trooper_register);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    private void saveTrooper(Trooper trooper) {
        TrooperRepository.saveTrooper(trooper);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.
        }
    }
}
