package TAREA_SAS;

/**
 * modelo de datos que representa una tarea individual en el sistema.
 * cada tarea tiene un identificador único, descripción, prioridad (1-5)
 * y un estado de finalización.
 */
public class Tarea {
    private int id;
    private String descripcion;
    private int prioridad;         // 1 = máxima urgencia, 5 = menor urgencia
    private boolean completada;    // false por defecto, true cuando se termina
    
    /**
    * crea una nueva tarea.
     * @param id identificador único (generado automáticamente por el sistema)
     * @param descripcion qué hay que hacer
     * @param prioridad nivel de importancia del 1 al 5
     */
    public Tarea(int id, String descripcion, int prioridad) {
        this.id = id;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.completada = false; // todas las tareas comienzan sin completar
    }
    
    // métodos de acceso - para obtener información de la tarea
    public int getId() { return id; }
    public String getDescripcion() { return descripcion; }
    public int getPrioridad() { return prioridad; }
    public boolean isCompletada() { return completada; }
    
    // método para cambiar el estado de la tarea
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
