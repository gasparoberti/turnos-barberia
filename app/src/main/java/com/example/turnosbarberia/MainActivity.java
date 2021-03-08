package com.example.turnosbarberia;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private FloatingActionButton fabNuevoReclamo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabNuevoReclamo = findViewById(R.id.fabNuevoReclamo);
        fabNuevoReclamo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.fabNuevoReclamo:
                toNuevoTurnoActivity();
                break;
        }
    }

    private void toNuevoTurnoActivity() {
        Intent intent = new Intent(MainActivity.this, NuevoTurnoActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
//                listarReclamos(loadSharedPref(TOKEN));
            }
            if (resultCode == RESULT_CANCELED) {
//                progressDialog.dismiss();
            }
        }
    }
}
