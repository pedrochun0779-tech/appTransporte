package umg.modelo;

/**
 *
 * @author hp
 */
public class Ciudad {
    private int idCiudad;
    private String nombre;
    
    // Constructor vacío
    public Ciudad() {
    }

    // Constructor con parámetros
    public Ciudad(int idCiudad, String nombre) {
        this.idCiudad = idCiudad;
        this.nombre = nombre;
    }

    // Métodos Get y Set
    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método toString sobrescrito
    @Override
    public String toString() {
        return "Ciudad { idCiudad=" + idCiudad + ", nombre=" + nombre + " }";
    }
}
