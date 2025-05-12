import dao.PropiedadDAO;
import dao.ReservaDAO;
import dao.TareaDAO;

import modelo.Propiedad;
import modelo.Reserva;
import modelo.Tarea;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Mostrar propiedades
        System.out.println("--- Propiedades ---");
        PropiedadDAO propiedadDAO = new PropiedadDAO();
        List<Propiedad> propiedades = propiedadDAO.listarPropiedades();

        for (Propiedad p : propiedades) {
            System.out.println(p.getNombre() + " - " + p.getUbicacion() + " - $" + p.getPrecioNoche());
        }

        // Mostrar reservas
        System.out.println("\n--- Reservas ---");
        ReservaDAO reservaDAO = new ReservaDAO();
        List<Reserva> reservas = reservaDAO.listarReservas();

        for (Reserva r : reservas) {
            System.out.println("Reserva ID: " + r.getId() +
                    " | Huesped ID: " + r.getIdHuesped() +
                    " | Propiedad ID: " + r.getIdPropiedad() +
                    " | Desde: " + r.getFechaInicio() +
                    " | Hasta: " + r.getFechaFin());
        }

        // Mostrar tareas
        System.out.println("\n--- Tareas ---");
        TareaDAO tareaDAO = new TareaDAO();
        List<Tarea> tareas = tareaDAO.listarTareas();

        for (Tarea t : tareas) {
            System.out.println("Tarea ID: " + t.getId() +
                    " | Tipo: " + t.getTipo() +
                    " | Estado: " + t.getEstado() +
                    " | Fecha: " + t.getFecha() +
                    " | Propiedad ID: " + t.getIdPropiedad());
        }
    }
}
