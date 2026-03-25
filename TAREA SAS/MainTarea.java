package TAREA_SAS;

/**
 * Clase principal que contiene el método main para probar el sistema
 */
public class MainTarea {

    /**
     * Método principal que ejecuta las pruebas del sistema
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        SistemaGestionTareas sistema = new SistemaGestionTareas();
        
        System.out.println("=================================");
        System.out.println("SISTEMA DE GESTIÓN DE TAREAS");
        System.out.println("=================================\n");
        
        // PRUEBA 1: Agregar tareas válidas
        System.out.println("--- PRUEBA 1: Agregar tareas válidas ---");
        sistema.agregarTarea("Comprar alimentos para la semana", 3);
        sistema.agregarTarea("Estudiar para el examen de matemáticas", 1);
        sistema.agregarTarea("Hacer ejercicio", 2);
        sistema.agregarTarea("Llamar al médico", 4);
        sistema.agregarTarea("Leer un libro", 5);
        System.out.println("Total de tareas: " + sistema.obtenerTotalTareas());
        
        // PRUEBA 2: Listar todas las tareas
        System.out.println("\n--- PRUEBA 2: Listar todas las tareas ---");
        sistema.listarTareas();
        
        // PRUEBA 3: Buscar por ID existente
        System.out.println("\n--- PRUEBA 3: Buscar tarea con ID 3 ---");
        Tarea tareaEncontrada = sistema.buscarPorId(3);
        if (tareaEncontrada != null) {
            System.out.println("Tarea encontrada: " + tareaEncontrada);
        } else {
            System.out.println("Tarea no encontrada");
        }
        
        // PRUEBA 4: Buscar por ID no existente
        System.out.println("\n--- PRUEBA 4: Buscar tarea con ID 99 (no existe) ---");
        tareaEncontrada = sistema.buscarPorId(99);
        if (tareaEncontrada != null) {
            System.out.println("Tarea encontrada: " + tareaEncontrada);
        } else {
            System.out.println("Tarea no encontrada - Resultado esperado");
        }
        
        // PRUEBA 5: Marcar tareas como completadas
        System.out.println("\n--- PRUEBA 5: Marcar tareas como completadas ---");
        sistema.marcarCompletada(1);
        sistema.marcarCompletada(3);
        sistema.marcarCompletada(99);
        
        // PRUEBA 6: Ver tareas pendientes
        System.out.println("\n--- PRUEBA 6: Ver tareas pendientes ---");
        sistema.obtenerTareasPendientes();
        
        // PRUEBA 7: Ver tareas por prioridad
        System.out.println("\n--- PRUEBA 7: Ver tareas por prioridad ---");
        sistema.obtenerTareasPorPrioridad(1);
        sistema.obtenerTareasPorPrioridad(5);
        sistema.obtenerTareasPorPrioridad(6);
        
        // PRUEBA 8: Eliminar una tarea
        System.out.println("\n--- PRUEBA 8: Eliminar tarea ID 5 ---");
        sistema.eliminarTarea(5);
        System.out.println("Total de tareas después de eliminar: " + sistema.obtenerTotalTareas());
        
        // PRUEBA 9: Ver todas las tareas después de eliminar
        System.out.println("\n--- PRUEBA 9: Listar tareas después de eliminar ---");
        sistema.listarTareas();
        
        // PRUEBA 10: Agregar tarea con prioridad inválida
        System.out.println("\n--- PRUEBA 10: Agregar tarea con prioridad inválida ---");
        sistema.agregarTarea("Tarea con prioridad 6", 6);
        sistema.agregarTarea("Tarea con prioridad 0", 0);
        
        // PRUEBA 11: Verificar IDs automáticos
        System.out.println("\n--- PRUEBA 11: Verificar IDs automáticos ---");
        sistema.agregarTarea("Nueva tarea después de eliminaciones", 2);
        sistema.listarTareas();
        
        // PRUEBA 12: Marcar todas como completadas y ver pendientes
        System.out.println("\n--- PRUEBA 12: Marcar todas como completadas ---");
        sistema.marcarCompletada(2);
        sistema.marcarCompletada(4);
        sistema.marcarCompletada(6);
        sistema.obtenerTareasPendientes();
        
        // PRUEBA 13: Verificar estado del sistema
        System.out.println("\n--- PRUEBA 13: Estado final del sistema ---");
        System.out.println("Total de tareas: " + sistema.obtenerTotalTareas());
        System.out.println("¿Sistema vacío? " + (sistema.estaVacio() ? "Sí" : "No"));
        
        System.out.println("\n=================================");
        System.out.println("FIN DE LAS PRUEBAS");
        System.out.println("=================================");
    }

}