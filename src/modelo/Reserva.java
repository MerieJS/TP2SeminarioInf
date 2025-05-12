package modelo;

import java.time.LocalDate;

public class Reserva {
    private int id;
    private int idHuesped;
    private int idPropiedad;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Reserva() {}

    public Reserva(int id, int idHuesped, int idPropiedad, LocalDate fechaInicio, LocalDate fechaFin) {
        this.id = id;
        this.idHuesped = idHuesped;
        this.idPropiedad = idPropiedad;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdHuesped() {
        return idHuesped;
    }

    public void setIdHuesped(int idHuesped) {
        this.idHuesped = idHuesped;
    }

    public int getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(int idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
}
