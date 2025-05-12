package modelo;

public class Propiedad {
    private int id;
    private String nombre;
    private String ubicacion;
    private double precioNoche;

    public Propiedad() {}

    public Propiedad(int id, String nombre, String ubicacion, double precioNoche) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.precioNoche = precioNoche;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public double getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(double precioNoche) {
        this.precioNoche = precioNoche;
    }
}
