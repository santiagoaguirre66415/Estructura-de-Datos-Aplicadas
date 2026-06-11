import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Clase Vuelo - Representa un vuelo de la aerolinea.
 * 
 * Cada vuelo tiene un codigo unico (como "AV101"), la ciudad de origen y destino,
 * y una capacidad maxima de pasajeros.
 * 
 * Usa dos estructuras de datos importantes:
 * - listaPasajeros (ArrayList): guarda los pasajeros que ya tienen reserva confirmada.
 * - listaEspera (Queue con LinkedList): cola de pasajeros que esperan un cupo.
 *   Funciona como cola real: el primero que llega es el primero en ser atendido
 *   cuando se libera un asiento (FIFO).
 */
public class Vuelo {

    private String codigoVuelo;
    private String origen;
    private String destino;
    private int capacidadMaxima;
    private ArrayList<Pasajero> listaPasajeros;  // LISTA: pasajeros confirmados
    private Queue<Pasajero> listaEspera;          // COLA: pasajeros esperando cupo

    public Vuelo(String codigoVuelo, String origen, String destino, int capacidadMaxima) {
        this.codigoVuelo = codigoVuelo;
        this.origen = origen;
        this.destino = destino;
        this.capacidadMaxima = capacidadMaxima;
        this.listaPasajeros = new ArrayList<>();
        this.listaEspera = new LinkedList<>();
    }

    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public ArrayList<Pasajero> getListaPasajeros() {
        return listaPasajeros;
    }

    public Queue<Pasajero> getListaEspera() {
        return listaEspera;
    }

    // Revisa si el vuelo ya no acepta mas pasajeros
    public boolean estaLleno() {
        return listaPasajeros.size() >= capacidadMaxima;
    }

    // Intenta agregar un pasajero a la lista de confirmados.
    // Si el vuelo esta lleno devuelve false, si hay cupo lo agrega y devuelve true.
    public boolean agregarPasajero(Pasajero p) {
        if (estaLleno()) {
            return false;
        }
        listaPasajeros.add(p);
        return true;
    }

    // Busca al pasajero por documento y lo quita de la lista de confirmados.
    // Devuelve true si lo encontro y elimino, false si no estaba en este vuelo.
    public boolean cancelarReserva(String documento) {
        for (int i = 0; i < listaPasajeros.size(); i++) {
            if (listaPasajeros.get(i).getDocumento().equals(documento)) {
                listaPasajeros.remove(i);
                return true;
            }
        }
        return false;
    }

    // Agrega un pasajero al final de la cola de espera (operacion enqueue)
    public void agregarAListaEspera(Pasajero p) {
        listaEspera.add(p);
    }

    // Saca al primer pasajero de la cola de espera (operacion dequeue).
    // Devuelve null si la cola esta vacia.
    public Pasajero siguienteEnEspera() {
        return listaEspera.poll();
    }

    // Revisa si hay al menos alguien esperando en la cola
    public boolean tieneListaEspera() {
        return !listaEspera.isEmpty();
    }

    // Busca un pasajero dentro de la lista de confirmados de este vuelo
    // segun su documento. Lo usamos desde el metodo recursivo de busqueda global.
    public Pasajero buscarPasajeroPorDocumento(String documento) {
        for (Pasajero p : listaPasajeros) {
            if (p.getDocumento().equals(documento)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Vuelo{codigo='" + codigoVuelo + "', " + origen + " -> " + destino +
               ", capacidad=" + capacidadMaxima + ", pasajeros=" + listaPasajeros.size() +
               ", enEspera=" + listaEspera.size() + "}";
    }
}
