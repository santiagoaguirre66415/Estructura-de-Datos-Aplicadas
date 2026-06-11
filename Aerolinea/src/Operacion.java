/**
 * Clase Operacion - Guarda la informacion de cada accion importante que se hace
 * en el sistema (reservar, cancelar, agregar a lista de espera).
 * 
 * Estas operaciones se apilan en un historial (pila) para despues poder
 * deshacer la ultima accion si el usuario lo necesita.
 * 
 * Tipos de operacion que se manejan:
 * - "RESERVA": se creo una reserva de un pasajero en un vuelo.
 * - "CANCELACION": se cancelo la reserva de un pasajero.
 * - "LISTA_ESPERA": se agrego un pasajero a la cola de espera porque el vuelo estaba lleno.
 * - "RESERVA_AUTO": se asigno automaticamente un cupo a alguien de la lista de espera
 *   despues de que otro pasajero cancelo.
 */
public class Operacion {

    private String tipo;
    private String documentoPasajero;
    private String codigoVuelo;
    private Pasajero pasajero;  // Guardamos el objeto completo para poder deshacer cancelaciones

    public Operacion(String tipo, String documentoPasajero, String codigoVuelo, Pasajero pasajero) {
        this.tipo = tipo;
        this.documentoPasajero = documentoPasajero;
        this.codigoVuelo = codigoVuelo;
        this.pasajero = pasajero;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDocumentoPasajero() {
        return documentoPasajero;
    }

    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    @Override
    public String toString() {
        return tipo + ": Pasajero " + documentoPasajero + " en vuelo " + codigoVuelo;
    }
}
