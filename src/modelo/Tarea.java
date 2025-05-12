package modelo;

import java.time.LocalDate;

public class Tarea {
    private int id;
    private String tipo;
    private String estado;
    private LocalDate fecha;
    private int idPropiedad;

    public Tarea() {}

    public Tarea(int id, String tipo, String estado, LocalDate fecha, int idPropiedad) {
        this.id = id;
        this.tipo = tipo;
        this.estado = estado;
        this.fecha = fecha;
        this.idPropiedad = idPropiedad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(int idPropiedad) {
        this.idPropiedad = idPropiedad;
    }
}
