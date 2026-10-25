
package umg.DAO;

import umg.modelo.CamioneroCamion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CamioneroCamionDAO {

    public List<CamioneroCamion> listar() {
        List<CamioneroCamion> lista = new ArrayList<>();

        String sql = """
            SELECT r.idCamioneroCamion,
                   r.idCamionero,
                   r.idCamion,
                   cc.Nombre AS nombreCamionero,
                   ca.NoPlaca AS noPlaca
            FROM camionerocamion r
            INNER JOIN camionero cc
                ON r.idCamionero = cc.idCamionero
            INNER JOIN camion ca
                ON r.idCamion = ca.idCamion
            ORDER BY r.idCamioneroCamion
            """;

        try (Connection con = ConexionDB.abrir();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                CamioneroCamion relacion = new CamioneroCamion();

                relacion.setIdCamioneroCamion(
                    rs.getInt("idCamioneroCamion"));
                relacion.setIdCamionero(
                    rs.getInt("idCamionero"));
                relacion.setIdCamion(
                    rs.getInt("idCamion"));
                relacion.setNombreCamionero(
                    rs.getString("nombreCamionero"));
                relacion.setNoPlaca(
                    rs.getString("noPlaca"));

                lista.add(relacion);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                null,
                "Error al listar las asignaciones: " + e.getMessage()
            );
        }

        return lista;
    }

    public boolean insertar(CamioneroCamion relacion) {
        String sql = """
            INSERT INTO camionerocamion (idCamionero, idCamion)
            VALUES (?, ?)
            """;

        try (Connection con = ConexionDB.abrir();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, relacion.getIdCamionero());
            ps.setInt(2, relacion.getIdCamion());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                null,
                "Error al registrar la asignación: " + e.getMessage()
            );
            return false;
        }
    }

    public boolean eliminar(int idCamioneroCamion) {
        String sql = """
            DELETE FROM camionerocamion
            WHERE idCamioneroCamion = ?
            """;

        try (Connection con = ConexionDB.abrir();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idCamioneroCamion);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                null,
                "Error al eliminar la asignación: " + e.getMessage()
            );
            return false;
        }
    }
    
public boolean actualizar(CamioneroCamion relacion) {
    String sql = """
        UPDATE camionerocamion
        SET idCamionero = ?, idCamion = ?
        WHERE idCamioneroCamion = ?
        """;

    try (Connection con = ConexionDB.abrir();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, relacion.getIdCamionero());
        ps.setInt(2, relacion.getIdCamion());
        ps.setInt(3, relacion.getIdCamioneroCamion());

        return ps.executeUpdate() > 0;

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(
            null,
            "Error al actualizar la asignación: " + e.getMessage()
        );
        return false;
    }
}

}
