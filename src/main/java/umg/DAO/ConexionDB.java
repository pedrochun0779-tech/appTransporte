
package umg.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 *
 * @author hp
 */
public class ConexionDB {
    private static final String URL =
            "jdbc:mysql://localhost:3306/db_paqueteria"
            + "?useSSL=false"
            + "&allowpublicKeyRetrieval=true"
            + "serverTimezone=America/Guatemala";
    
    private static final String USER = "root";
    private static final String PASS = "Nor.1234.glft";
    
    public static Connection abrir () throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
