package dao;

import conexion.ConexionBD;
import modelo.Propiedad;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PropiedadDAO {

    public List<Propiedad> listarPropiedades() {
        List<Propiedad> lista = new ArrayList<>();
        String sql = "SELECT * FROM Propiedad";

        try (Connection conn = ConexionBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Propiedad p = new Propiedad();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setUbicacion(rs.getString("ubicacion"));
                p.setPrecioNoche(rs.getDouble("precioNoche"));
                lista.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}
