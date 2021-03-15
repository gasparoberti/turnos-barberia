package com.example.turnosbarberia.Api;

import com.example.turnosbarberia.Models.Turno;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("Turnos/{fecha}")
    Call<List<Turno>> getTurnos(@Path("fecha") String fecha);
}
