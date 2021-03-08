package com.example.turnosbarberia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class NuevoTurnoActivity extends AppCompatActivity {
    Spinner spinner_direccion, spinner_sucursal, spinner_servicio, spinner_horario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_turno);

        spinner_direccion = findViewById(R.id.spinner_direccion);
        ArrayList<String> comboDireccion = new ArrayList<>();
        comboDireccion.add("Seleccione un barbero");
        comboDireccion.add("Barbero A");
        comboDireccion.add("Barbero B");
        comboDireccion.add("Barbero C");

        ArrayAdapter<CharSequence> adapterVariableDireccion = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item,
                comboDireccion);
        spinner_direccion.setAdapter(adapterVariableDireccion);
        spinner_direccion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).toString().equals("Barbero A")) {
//                    muestro en el spinner de barbería en la que está el barbero
                }
                if (parent.getItemAtPosition(position).toString().equals("Barbero B")) {
//                    muestro en el spinner de barbería en la que está el barbero
                }
                if (parent.getItemAtPosition(position).toString().equals("Barbero C")) {
//                    muestro en el spinner de barbería en la que está el barbero
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinner_sucursal = findViewById(R.id.spinner_sucursal);
        ArrayList<String> comboSucursal = new ArrayList<>();
        comboSucursal.add("Seleccione una sucursal");
        comboSucursal.add("Alem");
        comboSucursal.add("Alameda");

        ArrayAdapter<CharSequence> adapterVariableSucursal = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item,
                comboSucursal);
        spinner_sucursal.setAdapter(adapterVariableSucursal);
        spinner_sucursal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).toString().equals("Alem")) {
                }
                if (parent.getItemAtPosition(position).toString().equals("Alameda")) {
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinner_servicio = findViewById(R.id.spinner_servicio);
        ArrayList<String> comboServicio = new ArrayList<>();
        comboServicio.add("Seleccione un servicio");
        comboServicio.add("Corte");
        comboServicio.add("Barba");
        comboServicio.add("Corte y Barba");
        comboServicio.add("Manos");
        comboServicio.add("Limpieza Facial");
        comboServicio.add("Depilación");

        ArrayAdapter<CharSequence> adapterVariableServicio = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item,
                comboServicio);
        spinner_servicio.setAdapter(adapterVariableServicio);
        spinner_servicio.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).toString().equals("Corte")) {
                }
                if (parent.getItemAtPosition(position).toString().equals("Barba")) {
                }
                if (parent.getItemAtPosition(position).toString().equals("Corte y Barba")) {
                }
                if (parent.getItemAtPosition(position).toString().equals("Manos")) {
                }
                if (parent.getItemAtPosition(position).toString().equals("Limpieza Facial")) {
                }
                if (parent.getItemAtPosition(position).toString().equals("Depilación")) {
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinner_horario = findViewById(R.id.spinner_horario);
        ArrayList<String> comboHorario = new ArrayList<>();
        comboHorario.add("Seleccione un horario");
        comboHorario.add("8:00");
        comboHorario.add("9:00");
        comboHorario.add("10:00");
        comboHorario.add("11:00");
        comboHorario.add("12:00");

        ArrayAdapter<CharSequence> adapterVariableHorario = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item,
                comboHorario);
        spinner_horario.setAdapter(adapterVariableHorario);
        spinner_horario.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).toString().equals("8:00")) {
                }
                if (parent.getItemAtPosition(position).toString().equals("9:00")) {
                }
                if (parent.getItemAtPosition(position).toString().equals("10:00")) {
                }
                if (parent.getItemAtPosition(position).toString().equals("11:00")) {
                }
                if (parent.getItemAtPosition(position).toString().equals("12:00")) {
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}
