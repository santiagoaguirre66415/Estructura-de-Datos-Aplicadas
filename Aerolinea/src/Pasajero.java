/**
 * Clase Pasajero - Representa a una persona que viaja en un vuelo.
 * 
 * Cada pasajero tiene un id unico que le asigna el sistema, su nombre completo,
 * su numero de documento (que usamos para identificarlo en las reservas) y su
 * nacionalidad.
 */
public class Pasajero {

    private int id;
    private String nombre;
    private String documento;
    private String nacionalidad;

    // Constructor: crea un pasajero con todos sus datos
    public Pasajero(int id, String nombre, String documento, String nacionalidad) {
        this.id = id;
        this.nombre = nombre;
        this.documento = documento;
        this.nacionalidad = nacionalidad;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    // El documento es la clave principal para buscar y cancelar reservas
    public String getDocumento() {
        return documento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    @Override
    public String toString() {
        return "Pasajero{id=" + id + ", nombre='" + nombre + "', documento='" + documento + "', nacionalidad='" + nacionalidad + "'}";
    }
}
