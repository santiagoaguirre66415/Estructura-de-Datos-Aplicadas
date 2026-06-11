import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * Clase Aerolinea - Es el corazon del sistema. Maneja toda la logica central.
 * 
 * Aqui tenemos las estructuras de datos principales:
 * - vuelos (ArrayList): la lista de todos los vuelos registrados en el sistema.
 * - historial (Deque usada como PILA): guarda las operaciones para poder deshacer.
 *   Funciona como pila: la ultima operacion en entrar es la primera en salir (LIFO).
 * - contadorIdPasajero: lleva la cuenta para asignar ids unicos a cada pasajero.
 * 
 * Tambien estan los 4 metodos recursivos lineales que exige el proyecto.
 */
public class Aerolinea {

    private ArrayList<Vuelo> vuelos;          // LISTA: todos los vuelos del sistema
    private Deque<Operacion> historial;       // PILA: historial de operaciones para undo
    private int contadorIdPasajero;

    public Aerolinea() {
        vuelos = new ArrayList<>();
        historial = new ArrayDeque<>();
        contadorIdPasajero = 1;
    }

    // Agrega un vuelo nuevo a la lista de vuelos
    public void registrarVuelo(Vuelo v) {
        vuelos.add(v);
    }

    public ArrayList<Vuelo> getVuelos() {
        return vuelos;
    }

    // Devuelve el siguiente id disponible para un pasajero nuevo
    public int getSiguienteIdPasajero() {
        return contadorIdPasajero++;
    }

    // ===================== METODOS DE LA PILA (HISTORIAL / UNDO) =====================

    // Registra una operacion en la pila del historial.
    // Cada vez que se hace una reserva, cancelacion o agregado a lista de espera,
    // se apila la operacion para poder deshacerla despues.
    public void registrarOperacion(String tipo, String documento, String codigoVuelo, Pasajero pasajero) {
        Operacion op = new Operacion(tipo, documento, codigoVuelo, pasajero);
        historial.push(op);  // push apila la operacion en el tope de la pila
    }

    // Saca la ultima operacion de la pila para deshacerla.
    // Si la pila esta vacia devuelve null.
    public Operacion deshacerUltimaOperacion() {
        if (historial.isEmpty()) {
            return null;
        }
        return historial.pop();  // pop saca y devuelve el elemento del tope
    }

    // Revisa si hay operaciones en el historial
    public boolean hayHistorial() {
        return !historial.isEmpty();
    }

    // Muestra todas las operaciones del historial, de la mas reciente a la mas antigua
    public void mostrarHistorial() {
        if (historial.isEmpty()) {
            System.out.println("No hay operaciones en el historial.");
            return;
        }
        System.out.println("=== Historial de operaciones (de mas reciente a mas antiguo) ===");
        for (Operacion op : historial) {
            System.out.println("  - " + op);
        }
    }

    // ===================== METODOS RECURSIVOS LINEALES =====================

    /**
     * RECURSIVO 1: Buscar vuelo por codigo recorriendo la lista de vuelos.
     * 
     * Caso base: si el indice llega al final de la lista (indice >= vuelos.size()),
     *            significa que ya revisamos todos los vuelos y no encontramos el codigo.
     *            Devolvemos null.
     * 
     * Caso recursivo: miramos el vuelo en la posicion 'indice'. Si su codigo coincide
     *                 con el que buscamos, lo devolvemos. Si no, llamamos al mismo
     *                 metodo pero con indice+1 para revisar el siguiente vuelo.
     * 
     * Es recursividad lineal porque en cada llamada solo hacemos UNA llamada recursiva.
     */
    public Vuelo buscarVueloPorCodigoRecursivo(String codigo, int indice) {
        // Caso base: ya revisamos toda la lista y no esta
        if (indice >= vuelos.size()) {
            return null;
        }
        // Si el vuelo actual es el que buscamos, lo retornamos
        if (vuelos.get(indice).getCodigoVuelo().equals(codigo)) {
            return vuelos.get(indice);
        }
        // Caso recursivo: seguir buscando en el siguiente indice
        return buscarVueloPorCodigoRecursivo(codigo, indice + 1);
    }

    /**
     * RECURSIVO 2: Contar cuantos pasajeros tiene un vuelo de forma recursiva.
     * 
     * Caso base: si el indice llega al final de la lista de pasajeros,
     *            no hay mas pasajeros que contar. Devolvemos 0.
     * 
     * Caso recursivo: contamos 1 por el pasajero actual y le sumamos el resultado
     *                 de contar los pasajeros restantes (indice+1).
     * 
     * Es como decir: "este pasajero cuenta como 1, mas los que haya despues".
     * La pila de llamadas va sumando de a uno al ir regresando.
     */
    public int contarPasajerosRecursivo(Vuelo vuelo, int indice) {
        // Caso base: ya no hay mas pasajeros en la lista
        if (indice >= vuelo.getListaPasajeros().size()) {
            return 0;
        }
        // Caso recursivo: 1 por el actual + los que restan
        return 1 + contarPasajerosRecursivo(vuelo, indice + 1);
    }

    /**
     * RECURSIVO 3: Contar pasajeros que viajan a un destino dado en TODOS los vuelos.
     * 
     * Caso base: si el indice de vuelos llega al final de la lista,
     *            ya revisamos todos los vuelos. Devolvemos 0.
     * 
     * Caso recursivo: miramos el vuelo actual. Si su destino coincide con el que
     *                 buscamos, contamos sus pasajeros usando el metodo recursivo #2
     *                 y se lo sumamos al resultado de buscar en los vuelos restantes.
     *                 Si no coincide el destino, solo avanzamos al siguiente vuelo.
     * 
     * Este metodo combina dos recursiones: la externa recorre vuelos y la interna
     * (contarPasajerosRecursivo) cuenta los pasajeros de cada vuelo que coincide.
     */
    public int contarPasajerosPorDestinoRecursivo(String destino, int indiceVuelo) {
        // Caso base: ya revisamos todos los vuelos
        if (indiceVuelo >= vuelos.size()) {
            return 0;
        }
        Vuelo actual = vuelos.get(indiceVuelo);
        int conteo = 0;
        // Si este vuelo va al destino buscado, contamos sus pasajeros recursivamente
        if (actual.getDestino().equalsIgnoreCase(destino)) {
            conteo = contarPasajerosRecursivo(actual, 0);
        }
        // Caso recursivo: lo que contamos aqui + lo que haya en los vuelos restantes
        return conteo + contarPasajerosPorDestinoRecursivo(destino, indiceVuelo + 1);
    }

    /**
     * RECURSIVO 4: Buscar un pasajero por su documento recorriendo TODOS los vuelos
     * y sus listas de pasajeros.
     * 
     * Caso base 1: si el indice de vuelos llega al final, revisamos todos los vuelos
     *              y no encontramos al pasajero. Devolvemos null.
     * 
     * Caso base 2: si en el vuelo actual encontramos al pasajero con ese documento
     *              (usando buscarPasajeroPorDocumento del vuelo), lo devolvemos.
     * 
     * Caso recursivo: si no estaba en este vuelo, buscamos en el siguiente vuelo
     *                 llamando al metodo con indiceVuelo+1.
     * 
     * Es como buscar en cada avion uno por uno: si no esta en este, paso al siguiente.
     */
    public Pasajero buscarPasajeroPorDocumentoRecursivo(String documento, int indiceVuelo) {
        // Caso base 1: ya revisamos todos los vuelos y no esta
        if (indiceVuelo >= vuelos.size()) {
            return null;
        }
        Vuelo actual = vuelos.get(indiceVuelo);
        // Caso base 2: lo encontramos en este vuelo
        Pasajero encontrado = actual.buscarPasajeroPorDocumento(documento);
        if (encontrado != null) {
            return encontrado;
        }
        // Caso recursivo: buscar en el siguiente vuelo
        return buscarPasajeroPorDocumentoRecursivo(documento, indiceVuelo + 1);
    }
}
