
package umg.modelo;

public class CamioneroCamion {

    private int idCamioneroCamion;
    private int idCamionero;
    private int idCamion;

    private String nombreCamionero;
    private String noPlaca;

    public CamioneroCamion() {
    }

    public CamioneroCamion(int idCamioneroCamion,
                           int idCamionero, int idCamion) {
        this.idCamioneroCamion = idCamioneroCamion;
        this.idCamionero = idCamionero;
        this.idCamion = idCamion;
    }

    public int getIdCamioneroCamion() {
        return idCamioneroCamion;
    }

    public void setIdCamioneroCamion(int id) {
        this.idCamioneroCamion = id;
    }

    public int getIdCamionero() {
        return idCamionero;
    }

    public void setIdCamionero(int idCamionero) {
        this.idCamionero = idCamionero;
    }

    public int getIdCamion() {
        return idCamion;
    }

    public void setIdCamion(int idCamion) {
        this.idCamion = idCamion;
    }

    public String getNombreCamionero() {
        return nombreCamionero;
    }

    public void setNombreCamionero(String nombre) {
        this.nombreCamionero = nombre;
    }

    public String getNoPlaca() {
        return noPlaca;
    }

    public void setNoPlaca(String noPlaca) {
        this.noPlaca = noPlaca;
    }
}
