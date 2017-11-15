package com.example.viniciusaudibert.logincwi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.time.Instant;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.login) {
            login();
        }
    }

    private void login() {
        Instant instant = new Instant(this, StepsLoginActivity.class);
        startActivity(instant);
    }
}
