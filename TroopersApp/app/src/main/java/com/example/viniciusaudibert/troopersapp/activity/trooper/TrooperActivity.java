package com.example.viniciusaudibert.troopersapp.activity.trooper;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.viniciusaudibert.troopersapp.R;
import com.example.viniciusaudibert.troopersapp.activity.trooperdetail.TrooperDetailActivity;
import com.example.viniciusaudibert.troopersapp.constants.ExtraConstants;
import com.example.viniciusaudibert.troopersapp.constants.SharedPreferencesConstants;
import com.example.viniciusaudibert.troopersapp.model.Trooper;
import com.example.viniciusaudibert.troopersapp.repository.TrooperRepository;

import java.util.ArrayList;

public class TrooperActivity extends AppCompatActivity implements TrooperAdapter.OnItemClickListener, View.OnLongClickListener {

    private RecyclerView rvTroopers;
    private RecyclerView.Adapter trooperAdapter;
    private RecyclerView.LayoutManager trooperLayoutManager;
    private ArrayList<Trooper> troopers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trooper);

        troopers =  TrooperRepository.tryGettingFromSharedPreferences(getSharedPreferences());

        setTroopersRecycleView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater()
                .inflate(R.menu.trooper_add_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.plus_icon:
                Toast.makeText(this, "T", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    protected void onStop() {
        super.onStop();

        TrooperRepository.saveToSharedPrefereces(troopers, getSharedPreferences());
    }

    @Override
    public void onItemClick(Trooper trooper) {
        Intent intent = new Intent(this, TrooperDetailActivity.class);

        intent.putExtra(ExtraConstants.TROOPER, trooper);
        startActivity(intent);
    }

    @Override
    public boolean onLongClick(final View view) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Excluir Trooper");
        alertDialog.setMessage("Tem certeza que deseja excluir este trooper?");
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Não",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Sim",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        int posistion = rvTroopers.getChildAdapterPosition(view);
                        troopers.remove(posistion);
                        trooperAdapter.notifyDataSetChanged();
                        dialog.dismiss();

                        Toast.makeText(TrooperActivity.this, "Trooper Excluido!", Toast.LENGTH_SHORT).show();
                    }
                });
        alertDialog.show();
        return true;
    }

    private void setTroopersRecycleView() {
        rvTroopers = findViewById(R.id.troopers_rv);
        rvTroopers.setHasFixedSize(true);

        trooperLayoutManager = new LinearLayoutManager(this);
        rvTroopers.setLayoutManager(trooperLayoutManager);

        trooperAdapter = new TrooperAdapter(troopers, this, this);
        rvTroopers.setAdapter(trooperAdapter);
    }

    private SharedPreferences getSharedPreferences() {
        return getSharedPreferences(
                SharedPreferencesConstants.PREFS_NAME,
                MODE_PRIVATE
        );
    }
}
