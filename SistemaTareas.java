import java.util.ArrayList;

class Tarea {
    int id;
    String descripcion;
    int prioridad;
    boolean completada;

    public Tarea(int id, String descripcion, int prioridad) {
        this.id = id;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.completada = false;
    }

    public String toString() {
        return "ID: " + id + " | " + descripcion + " | Prioridad: " + prioridad + " | Completada: " + completada;
    }
}

public class SistemaTareas {

    static ArrayList<Tarea> tareas = new ArrayList<>();

    // O(1)
    public static void agregarTarea(Tarea tarea){
        tareas.add(tarea);
    }

    // O(n)
    public static void listarTareas(){
        for(Tarea t : tareas){
            System.out.println(t);
        }
    }

    // O(n)
    public static Tarea buscarPorId(int id){
        for(Tarea t : tareas){
            if(t.id == id){
                return t;
            }
        }
        return null;
    }

    // O(n)
    public static void marcarCompletada(int id){
        Tarea t = buscarPorId(id);
        if(t != null){
            t.completada = true;
        }
    }

    // O(n)
    public static void eliminarTarea(int id){
        for(int i = 0; i < tareas.size(); i++){
            if(tareas.get(i).id == id){
                tareas.remove(i);
                break;
            }
        }
    }

    // O(n)
    public static ArrayList<Tarea> obtenerTareasPendientes(){
        ArrayList<Tarea> pendientes = new ArrayList<>();
        for(Tarea t : tareas){
            if(!t.completada){
                pendientes.add(t);
            }
        }
        return pendientes;
    }

    // O(n)
    public static ArrayList<Tarea> obtenerTareasPorPrioridad(int prioridad){
        ArrayList<Tarea> resultado = new ArrayList<>();
        for(Tarea t : tareas){
            if(t.prioridad == prioridad){
                resultado.add(t);
            }
        }
        return resultado;
    }

    public static void main(String[] args){

        agregarTarea(new Tarea(1,"Estudiar estructuras de datos",3));
        agregarTarea(new Tarea(2,"Hacer taller de programación",5));
        agregarTarea(new Tarea(3,"Leer documentación de Java",2));

        listarTareas();

        marcarCompletada(1);

        System.out.println("Tareas pendientes:");
        for(Tarea t : obtenerTareasPendientes()){
            System.out.println(t);
        }

        eliminarTarea(2);

        System.out.println("Lista final:");
        listarTareas();
    }
}