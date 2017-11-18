package com.example.viniciusaudibert.troopersapp.activity.trooperdetail;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.viniciusaudibert.troopersapp.R;
import com.example.viniciusaudibert.troopersapp.constants.ExtraConstants;
import com.example.viniciusaudibert.troopersapp.model.Trooper;
import com.squareup.picasso.Picasso;

public class TrooperDetailActivity extends AppCompatActivity {

    private TextView tvDescription;
    private ImageView imvStormTrooper, imvAffiliation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trooper_detail);

        initComponent();
        setTrooperInfo();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater()
                .inflate(R.menu.trooper_detail_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.star_item:
                Toast.makeText(this, "FAVORITAR TROOPER", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void setTrooperInfo() {
        Trooper trooper = (Trooper) getIntent().getExtras().get(ExtraConstants.TROOPER);
        this.tvDescription.setText(trooper.getDescription());
        this.imvAffiliation.setImageResource(trooper.getAffiliation().getImage());
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(trooper.getName());
        actionBar.setDisplayHomeAsUpEnabled(true);

        Picasso.with(this)
                .load(trooper.getImageUrl())
                .into(imvStormTrooper);
    }

    private void initComponent() {
        this.tvDescription = findViewById(R.id.trooper_detail_description);
        this.imvStormTrooper = findViewById(R.id.trooper_detail_trooperImage);
        this.imvAffiliation = findViewById(R.id.trooper_detail_affiliationImage);
    }
}
