package com.example.turnosbarberia.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Turno {
    @SerializedName("turnoId")
    @Expose
    public Integer turnoId;
    @SerializedName("nombre")
    @Expose
    public String nombre;
    @SerializedName("apellido")
    @Expose
    public String apellido;
    @SerializedName("reservado")
    @Expose
    public Boolean reservado;
    @SerializedName("sucursalId")
    @Expose
    public Integer sucursalId;
    @SerializedName("servicioId")
    @Expose
    public Integer servicioId;
    @SerializedName("barberoId")
    @Expose
    public Integer barberoId;
    @SerializedName("fecha")
    @Expose
    public String fecha;
    @SerializedName("barbero")
    @Expose
    public Object barbero;
    @SerializedName("servicio")
    @Expose
    public Object servicio;
    @SerializedName("sucursal")
    @Expose
    public Object sucursal;

    public Turno(Integer turnoId, String nombre, String apellido, Boolean reservado, Integer sucursalId, Integer servicioId, Integer barberoId, String fecha, Object barbero, Object servicio, Object sucursal) {
        this.turnoId = turnoId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.reservado = reservado;
        this.sucursalId = sucursalId;
        this.servicioId = servicioId;
        this.barberoId = barberoId;
        this.fecha = fecha;
        this.barbero = barbero;
        this.servicio = servicio;
        this.sucursal = sucursal;
    }

    public Integer getTurnoId() {
        return turnoId;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Boolean getReservado() {
        return reservado;
    }

    public Integer getSucursalId() {
        return sucursalId;
    }

    public Integer getServicioId() {
        return servicioId;
    }

    public Integer getBarberoId() {
        return barberoId;
    }

    public String getFecha() {
        return fecha;
    }

    public Object getBarbero() {
        return barbero;
    }

    public Object getServicio() {
        return servicio;
    }

    public Object getSucursal() {
        return sucursal;
    }
}
