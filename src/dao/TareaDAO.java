package dao;

import conexion.ConexionBD;
import modelo.Tarea;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TareaDAO {

    public List<Tarea> listarTareas() {
        List<Tarea> lista = new ArrayList<>();
        String sql = "SELECT * FROM Tarea";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Tarea t = new Tarea();
                t.setId(rs.getInt("id"));
                t.setTipo(rs.getString("tipo"));
                t.setEstado(rs.getString("estado"));
                t.setFecha(rs.getDate("fecha").toLocalDate());
                t.setIdPropiedad(rs.getInt("id_propiedad"));
                lista.add(t);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}
