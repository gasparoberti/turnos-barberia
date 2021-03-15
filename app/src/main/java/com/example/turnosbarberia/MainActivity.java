package com.example.turnosbarberia;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.turnosbarberia.Adapters.TurnoAdapter;
import com.example.turnosbarberia.Api.ApiClient;
import com.example.turnosbarberia.Api.ApiInterface;
import com.example.turnosbarberia.Models.Turno;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private FloatingActionButton fabNuevoReclamo;
    public static ApiInterface apiInterface;
    private TurnoAdapter turnoAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabNuevoReclamo = findViewById(R.id.fabNuevoReclamo);
        fabNuevoReclamo.setOnClickListener(this);

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);     //inicializa el objeto retrofit

        listarTurnos("2021-03-12");
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
                listarTurnos("2021-03-12");
            }
            if (resultCode == RESULT_CANCELED) {
//                progressDialog.dismiss();
            }
        }
    }

    private void listarTurnos(String fecha) {
        Call<List<Turno>> call = apiInterface.getTurnos(fecha);

        call.enqueue(new Callback<List<Turno>>() {
            final AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
            String mensaje = "";

            @Override
            public void onResponse(Call<List<Turno>> call, Response<List<Turno>> response) {
//                progressDialog.dismiss();

                if (!response.isSuccessful()) {
                    mensaje = "Código: " + response.code() + " " + response.message();

                    dialog.setTitle("Error")
                            .setMessage(mensaje);
                    dialog.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            finish();
                        }
                    });
                    dialog.show();
                }
                else {
                    String content = "";
                    for (Turno post : response.body()) {

                        content += "ID: " + post.getNombre() + "\n";
                        content += "User ID: " + post.getTurnoId() + "\n";


                    }

                    Toast.makeText(MainActivity.this, content, Toast.LENGTH_LONG).show();


//                    ReclamosResponse dataRespuesta = response.body();
//                    List<Reclamo> listaReclamos = dataRespuesta.getData();

//                    if (dataRespuesta.getResult() == true && dataRespuesta.getData() != null) {

//                    generateListTurnos(response.body());

//                        if (listaReclamos.size() == 0) {
//                            textView_noElements.setVisibility(View.VISIBLE);
////                            button_paginaSiguiente.setEnabled(false);
//                        }
//                    }
//                    else {

//                        if(dataRespuesta.getMsg().equals("Usuario inválido")){
//                            dialog.setTitle("Error")
//                                    .setMessage("Ha expirado su tiempo de conexión. Inicie sesión nuevamente");
//                            dialog.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int id) {
//                                    signOut();
//                                }
//                            });
//                            dialog.show();
//                        }

//                        mensaje = dataRespuesta.getMsg() + ". ";
//                        if (dataRespuesta.getErrors() != null) {
//                            mensaje += dataRespuesta.getErrors() + ". ";
//                        }

//                        dialog.setTitle("Error")
//                                .setMessage(mensaje);
//                        dialog.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//                                finish();
//                            }
//                        });
//                        dialog.show();
                    }
//                }
            }

            @Override
            public void onFailure(Call<List<Turno>> call, Throwable t) {
//                progressDialog.dismiss();
                mensaje = "Falló la conexión. " + t.getMessage();

                Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_LONG).show();

//                dialog.setTitle("Error")
//                        .setMessage(mensaje);
//                dialog.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
////                        finish();
//                    }
//                });
//                dialog.show();
            }
        });
    }

    private void generateListTurnos(final List<Turno> turnoList) {
        recyclerView = findViewById(R.id.recyclerViewReclamos);
        turnoAdapter = new TurnoAdapter(this, turnoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(turnoAdapter);

//        turnoAdapter.setOnItemClickListener(new TurnoAdapter().OnItemClickListener() {
//            @Override
//            public void onItemClick(int position) {
//                Intent i = new Intent(ReclamosActivity.this, ReclamoActivity.class);
//
//                int id = turnoList.get(position).getTurnoId();
//                Bundle bundle = new Bundle();
//                bundle.putInt("id", id);    //obtengo id del rv y lo paso a la otra actividad para hacer el get por id
//                i.putExtras(bundle);
//
//                startActivity(i);
//            }
//
//            @Override
//            public void onDeleteClick(int position) {
//
//            }
//        });
    }
}
