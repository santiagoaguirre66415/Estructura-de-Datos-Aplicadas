package TAREA_SAS;

/**
 * Clase que representa una tarea en el sistema de gestión
 */
public class Tarea {
    private int id;
    private String descripcion;
    private int prioridad; // 1-5, donde 1 es máxima prioridad
    private boolean completada;
    
    /**
     * Constructor de la clase Tarea
     * @param id Identificador único de la tarea
     * @param descripcion Descripción de la tarea
     * @param prioridad Prioridad de la tarea (1-5)
     */
    public Tarea(int id, String descripcion, int prioridad) {
        this.id = id;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.completada = false; // Por defecto, la tarea no está completada
    }
    
    // Getters y Setters
    public int getId() {
        return id;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public int getPrioridad() {
        return prioridad;
    }
    
    public boolean isCompletada() {
        return completada;
    }
    
    public void setCompletada(boolean completada) {
        this.completada = completada;
    }
    
    @Override
    public String toString() {
        return "ID: " + id + " | Prioridad: " + prioridad + 
               " | Completada: " + (completada ? "Sí" : "No") + 
               " | Descripción: " + descripcion;
    }
} 
