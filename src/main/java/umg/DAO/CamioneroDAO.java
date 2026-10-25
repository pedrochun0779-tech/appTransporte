
package umg.DAO;

import umg.modelo.Camionero;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CamioneroDAO {

    // LISTAR CAMIONEROS
    public List<Camionero> listar() throws SQLException {
        List<Camionero> lista = new ArrayList<>();

        String sql = "SELECT idCamionero, Nombre, Telefono, "
                   + "Direccion, Salario, Poblacion "
                   + "FROM camionero ORDER BY idCamionero";

        try (Connection con = ConexionDB.abrir();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new Camionero(
                    rs.getInt("idCamionero"),
                    rs.getString("Nombre"),
                    rs.getString("Telefono"),
                    rs.getString("Direccion"),
                    rs.getDouble("Salario"),
                    rs.getString("Poblacion")
                ));
            }
        }

        return lista;
    }

    // INSERTAR CAMIONERO
    public boolean insertar(Camionero c) throws SQLException {
        String sql = "INSERT INTO camionero "
                   + "(Nombre, Telefono, Direccion, Salario, Poblacion) "
                   + "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = ConexionDB.abrir();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, c.getNombre());
            ps.setString(2, c.getTelefono());
            ps.setString(3, c.getDireccion());
            ps.setDouble(4, c.getSalario());
            ps.setString(5, c.getPoblacion());

            return ps.executeUpdate() > 0;
        }
    }

    // ACTUALIZAR CAMIONERO
    public boolean actualizar(Camionero c) throws SQLException {
        String sql = "UPDATE camionero SET Nombre = ?, Telefono = ?, "
                   + "Direccion = ?, Salario = ?, Poblacion = ? "
                   + "WHERE idCamionero = ?";

        try (Connection con = ConexionDB.abrir();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, c.getNombre());
            ps.setString(2, c.getTelefono());
            ps.setString(3, c.getDireccion());
            ps.setDouble(4, c.getSalario());
            ps.setString(5, c.getPoblacion());
            ps.setInt(6, c.getIdCamionero());

            return ps.executeUpdate() > 0;
        }
    }

    // ELIMINAR CAMIONERO
    public boolean eliminar(int idCamionero) throws SQLException {
        String sql = "DELETE FROM camionero WHERE idCamionero = ?";

        try (Connection con = ConexionDB.abrir();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idCamionero);
            return ps.executeUpdate() > 0;
        }
    }
}
