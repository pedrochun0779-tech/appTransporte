
package umg.modelo;

public class Camion {

    private int idCamion;
    private String noPlaca;
    private String modelo;
    private String tipo;
    private String potencia;

    // Constructor vacío
    public Camion() {
    }

    // Constructor con todos los atributos
    public Camion(int idCamion, String noPlaca,
                  String modelo, String tipo,
                  String potencia) {
        this.idCamion = idCamion;
        this.noPlaca = noPlaca;
        this.modelo = modelo;
        this.tipo = tipo;
        this.potencia = potencia;
    }

    // Getter y Setter de idCamion
    public int getIdCamion() {
        return idCamion;
    }

    public void setIdCamion(int idCamion) {
        this.idCamion = idCamion;
    }

    // Getter y Setter de noPlaca
    public String getNoPlaca() {
        return noPlaca;
    }

    public void setNoPlaca(String noPlaca) {
        this.noPlaca = noPlaca;
    }

    // Getter y Setter de modelo
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    // Getter y Setter de tipo
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Getter y Setter de potencia
    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        return noPlaca + " - " + modelo;
    }
}
