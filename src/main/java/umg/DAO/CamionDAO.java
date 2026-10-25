
package umg.DAO;

import umg.modelo.Camion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CamionDAO {

    // LISTAR TODOS LOS CAMIONES
    public List<Camion> listar() throws SQLException {
        List<Camion> lista = new ArrayList<>();

        String sql = "SELECT idCamion, NoPlaca, Modelo, Tipo, Potencia "
                   + "FROM camion ORDER BY idCamion";

        try (Connection con = ConexionDB.abrir();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Camion camion = new Camion(
                    rs.getInt("idCamion"),
                    rs.getString("NoPlaca"),
                    rs.getString("Modelo"),
                    rs.getString("Tipo"),
                    rs.getString("Potencia")
                );

                lista.add(camion);
            }
        }

        return lista;
    }

    // INSERTAR UN CAMION
    public boolean insertar(Camion camion) throws SQLException {
        String sql = "INSERT INTO camion "
                   + "(NoPlaca, Modelo, Tipo, Potencia) "
                   + "VALUES (?, ?, ?, ?)";

        try (Connection con = ConexionDB.abrir();
             PreparedStatement ps = con.prepareStatement(sql)) {

            if (con == null) {
                throw new SQLException("La conexión con MySQL es nula.");
            }

            ps.setString(1, camion.getNoPlaca());
            ps.setString(2, camion.getModelo());
            ps.setString(3, camion.getTipo());
            ps.setString(4, camion.getPotencia());

            int filas = ps.executeUpdate();

            return filas > 0;
        }
    }

    // ACTUALIZAR UN CAMION
    public boolean actualizar(Camion camion) throws SQLException {
        String sql = "UPDATE camion "
                   + "SET NoPlaca = ?, Modelo = ?, Tipo = ?, Potencia = ? "
                   + "WHERE idCamion = ?";

        try (Connection con = ConexionDB.abrir();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, camion.getNoPlaca());
            ps.setString(2, camion.getModelo());
            ps.setString(3, camion.getTipo());
            ps.setString(4, camion.getPotencia());
            ps.setInt(5, camion.getIdCamion());

            return ps.executeUpdate() > 0;
        }
    }

    // ELIMINAR UN CAMION POR ID
    public boolean eliminar(int idCamion) throws SQLException {
        String sql = "DELETE FROM camion WHERE idCamion = ?";

        try (Connection con = ConexionDB.abrir();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idCamion);
            return ps.executeUpdate() > 0;
        }
    }
}
