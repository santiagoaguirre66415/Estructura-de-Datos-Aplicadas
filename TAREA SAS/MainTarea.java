package TAREA_SAS;

/**
 * clase principal que deja correr las pruebas del sistema, bien al estilo paisa.
 */
public class MainTarea {

    /**
    * método principal que ejecuta las pruebas del sistema, parcero.
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        SistemaGestionTareas sistema = new SistemaGestionTareas();
        
        System.out.println("=================================");
        System.out.println("SISTEMA DE GESTIÓN DE TAREAS");
        System.out.println("=================================\n");
        
        // prueba 1: agregar tareas válidas, pues
        System.out.println("--- PRUEBA 1: Agregar tareas válidas ---");
        sistema.agregarTarea("Comprar alimentos para la semana", 3);
        sistema.agregarTarea("Estudiar para el examen de matemáticas", 1);
        sistema.agregarTarea("Hacer ejercicio", 2);
        sistema.agregarTarea("Llamar al médico", 4);
        sistema.agregarTarea("Leer un libro", 5);
        System.out.println("Total de tareas: " + sistema.obtenerTotalTareas());
        
        // prueba 2: listar todas las tareas, sin enredos
        System.out.println("\n--- PRUEBA 2: Listar todas las tareas ---");
        sistema.listarTareas();
        
        // prueba 3: buscar por id existente, ahí mismo
        System.out.println("\n--- PRUEBA 3: Buscar tarea con ID 3 ---");
        Tarea tareaEncontrada = sistema.buscarPorId(3);
        if (tareaEncontrada != null) {
            System.out.println("Tarea encontrada: " + tareaEncontrada);
        } else {
            System.out.println("Tarea no encontrada");
        }
        
        // prueba 4: buscar por id no existente, para probar bien
        System.out.println("\n--- PRUEBA 4: Buscar tarea con ID 99 (no existe) ---");
        tareaEncontrada = sistema.buscarPorId(99);
        if (tareaEncontrada != null) {
            System.out.println("Tarea encontrada: " + tareaEncontrada);
        } else {
            System.out.println("Tarea no encontrada - Resultado esperado");
        }
        
        // prueba 5: marcar tareas como completadas, pues
        System.out.println("\n--- PRUEBA 5: Marcar tareas como completadas ---");
        sistema.marcarCompletada(1);
        sistema.marcarCompletada(3);
        sistema.marcarCompletada(99);
        
        // prueba 6: ver tareas pendientes, a ver qué quedó faltando
        System.out.println("\n--- PRUEBA 6: Ver tareas pendientes ---");
        sistema.obtenerTareasPendientes();
        
        // prueba 7: ver tareas por prioridad, bien juicioso
        System.out.println("\n--- PRUEBA 7: Ver tareas por prioridad ---");
        sistema.obtenerTareasPorPrioridad(1);
        sistema.obtenerTareasPorPrioridad(5);
        sistema.obtenerTareasPorPrioridad(6);
        
        // prueba 8: eliminar una tarea, para ver la vuelta
        System.out.println("\n--- PRUEBA 8: Eliminar tarea ID 5 ---");
        sistema.eliminarTarea(5);
        System.out.println("Total de tareas después de eliminar: " + sistema.obtenerTotalTareas());
        
        // prueba 9: ver todas las tareas después de eliminar, pues
        System.out.println("\n--- PRUEBA 9: Listar tareas después de eliminar ---");
        sistema.listarTareas();
        
        // prueba 10: agregar tarea con prioridad inválida, a ver que responda
        System.out.println("\n--- PRUEBA 10: Agregar tarea con prioridad inválida ---");
        sistema.agregarTarea("Tarea con prioridad 6", 6);
        sistema.agregarTarea("Tarea con prioridad 0", 0);
        
        // prueba 11: verificar ids automáticos, sin truco
        System.out.println("\n--- PRUEBA 11: Verificar IDs automáticos ---");
        sistema.agregarTarea("Nueva tarea después de eliminaciones", 2);
        sistema.listarTareas();
        
        // prueba 12: marcar todas como completadas y ver pendientes, bien bacano
        System.out.println("\n--- PRUEBA 12: Marcar todas como completadas ---");
        sistema.marcarCompletada(2);
        sistema.marcarCompletada(4);
        sistema.marcarCompletada(6);
        sistema.obtenerTareasPendientes();
        
        // prueba 13: verificar estado del sistema, ya para cerrar
        System.out.println("\n--- PRUEBA 13: Estado final del sistema ---");
        System.out.println("Total de tareas: " + sistema.obtenerTotalTareas());
        System.out.println("¿Sistema vacío? " + (sistema.estaVacio() ? "Sí" : "No"));
        
        System.out.println("\n=================================");
        System.out.println("FIN DE LAS PRUEBAS");
        System.out.println("=================================");
    }

}