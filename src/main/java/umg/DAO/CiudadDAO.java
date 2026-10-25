
package umg.DAO;
import umg.modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;


/**
 *
 * @author hp
 */
public class CiudadDAO {

    // Método para guardar datos en la tabla ciudad de la base de datos
    public void insertar(Ciudad ciudad) throws SQLException {

        String sql = "INSERT INTO ciudad (Nombre) VALUES (?)";

        try (Connection cn = ConexionDB.abrir();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, ciudad.getNombre());

            int filas = ps.executeUpdate();

            if (filas == 0) {
                throw new SQLException("No se pudo insertar el registro.");
            }
        }
    }
   
    // Método para actualizar una ciudad existente
    public void actualizar(Ciudad ciudad) throws SQLException {

        String sql = "UPDATE ciudad SET Nombre = ? WHERE idCiudad = ?";

        try (Connection cn = ConexionDB.abrir();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, ciudad.getNombre());
            ps.setInt(2, ciudad.getIdCiudad());

            int filas = ps.executeUpdate();

            if (filas == 0) {
                throw new SQLException(
                    "No se encontró una ciudad con ese ID."
                );
            }
        }
    }

    // Método para eliminar una ciudad por su ID
    public void eliminar(int idCiudad) throws SQLException {

        String sql = "DELETE FROM ciudad WHERE idCiudad = ?";

        try (Connection cn = ConexionDB.abrir();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, idCiudad);

            int filas = ps.executeUpdate();

            if (filas == 0) {
                throw new SQLException(
                    "No se encontró una ciudad con ese ID."
                );
            }
        }
    }
 // Consultar todas las ciudades
public List<Ciudad> listar() throws SQLException {

    List<Ciudad> ciudades = new ArrayList<>();

    String sql = "SELECT idCiudad, Nombre FROM ciudad ORDER BY idCiudad";

    try (Connection cn = ConexionDB.abrir();
         PreparedStatement ps = cn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            Ciudad ciudad = new Ciudad();
            ciudad.setIdCiudad(rs.getInt("idCiudad"));
            ciudad.setNombre(rs.getString("Nombre"));
            ciudades.add(ciudad);
        }
    }
    return ciudades;
}
}

    
