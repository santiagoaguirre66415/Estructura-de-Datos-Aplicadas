package TAREA_SAS;

import java.util.ArrayList;

/**
 * sistema centralizado para administrar una colección de tareas, bien ordenadito.
 */
public class SistemaGestionTareas {

    private ArrayList<Tarea> tareas;
    private int proximoId;

    /**
     * constructor que inicializa el sistema de gestión de tareas, pues.
     */
    public SistemaGestionTareas() {
        this.tareas = new ArrayList<>();
        this.proximoId = 1;
    }

    /**
     * agrega una nueva tarea al sistema.
     * complejidad: O(1) amortizado.
     * @param descripcion texto con la descripción de la tarea
     * @param prioridad nivel de urgencia (1-5)
     */
    public void agregarTarea(String descripcion, int prioridad) {
        if (prioridad < 1 || prioridad > 5) {
            System.out.println("Error: La prioridad debe estar entre 1 y 5");
            return;
        }
        Tarea nuevaTarea = new Tarea(proximoId, descripcion, prioridad);
        tareas.add(nuevaTarea);
        proximoId++;
    }

    /**
     * lista todas las tareas en el sistema.
     * complejidad: O(n).
     */
    public void listarTareas() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas registradas");
            return;
        }
        for (Tarea t : tareas) {
            System.out.println(t);
        }
    }

    /**
     * busca una tarea específica por su identificador.
     * complejidad: O(n).
     * @param id identificador de la tarea
     * @return la Tarea encontrada o null si no existe
     */
    public Tarea buscarPorId(int id) {
        for (Tarea t : tareas) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    /**
     * marca una tarea como completada.
     * complejidad: O(n).
     * @param id identificador de la tarea a marcar
     */
    public void marcarCompletada(int id) {
        Tarea t = buscarPorId(id);
        if (t != null) {
            t.setCompletada(true);
            System.out.println("Tarea con ID " + id + " marcada como completada.");
        } else {
            System.out.println("Tarea con ID " + id + " no encontrada.");
        }
    }

    /**
     * elimina una tarea del sistema.
     * complejidad: O(n).
     * @param id identificador de la tarea a eliminar
     */
    public void eliminarTarea(int id) {
        for (int i = 0; i < tareas.size(); i++) {
            if (tareas.get(i).getId() == id) {
                tareas.remove(i);
                System.out.println("Tarea con ID " + id + " eliminada.");
                return;
            }
        }
        System.out.println("Tarea con ID " + id + " no encontrada.");
    }

    /**
     * obtiene todas las tareas pendientes (no completadas).
     * complejidad: O(n).
     */
    public void obtenerTareasPendientes() {
        ArrayList<Tarea> pendientes = new ArrayList<>();
        for (Tarea t : tareas) {
            if (!t.isCompletada()) {
                pendientes.add(t);
            }
        }
        if (pendientes.isEmpty()) {
            System.out.println("No hay tareas pendientes");
            return;
        }
        for (Tarea t : pendientes) {
            System.out.println(t);
        }
    }

    /**
     * obtiene todas las tareas con una prioridad específica.
     * complejidad: O(n).
     * @param prioridad nivel de urgencia a filtrar
     */
    public void obtenerTareasPorPrioridad(int prioridad) {
        if (prioridad < 1 || prioridad > 5) {
            System.out.println("Error: La prioridad debe estar entre 1 y 5");
            return;
        }
        ArrayList<Tarea> resultado = new ArrayList<>();
        for (Tarea t : tareas) {
            if (t.getPrioridad() == prioridad) {
                resultado.add(t);
            }
        }
        if (resultado.isEmpty()) {
            System.out.println("No hay tareas con prioridad " + prioridad);
            return;
        }
        System.out.println("Tareas con prioridad " + prioridad + ":");
        for (Tarea t : resultado) {
            System.out.println(t);
        }
    }

    /**
     * retorna el número total de tareas en el sistema.
     * complejidad: O(1).
     * @return cantidad de tareas
     */
    public int obtenerTotalTareas() {
        return tareas.size();
    }

    /**
     * verifica si el sistema no contiene tareas.
     * complejidad: O(1).
     * @return true si está vacío, false en caso contrario
     */
    public boolean estaVacio() {
        return tareas.isEmpty();
    }
}