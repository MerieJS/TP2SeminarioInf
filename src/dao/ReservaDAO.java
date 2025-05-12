package dao;

import conexion.ConexionBD;
import modelo.Reserva;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {

    public List<Reserva> listarReservas() {
        List<Reserva> lista = new ArrayList<>();
        String sql = "SELECT * FROM Reserva";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Reserva r = new Reserva();
                r.setId(rs.getInt("id"));
                r.setIdHuesped(rs.getInt("id_huesped"));
                r.setIdPropiedad(rs.getInt("id_propiedad"));
                r.setFechaInicio(rs.getDate("fechaInicio").toLocalDate());
                r.setFechaFin(rs.getDate("fechaFin").toLocalDate());
                lista.add(r);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}
