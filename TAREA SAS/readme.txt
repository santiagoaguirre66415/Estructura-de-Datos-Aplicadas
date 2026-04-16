================================================================================
DOCUMENTACIÓN: Administrador de Tareas v1.0
================================================================================

GESTOR INTEGRAL DE TAREAS EN JAVA
==================================

INTRODUCCIÓN:
Implementación de un sistema ligero basado en ArrayList que permite
la administración y control de tareas con operaciones CRUD, búsquedas
avanzadas y clasificación por urgencia.

ARQUITECTURA DE COMPONENTES:
---------------------------
→ Tarea.java: Estructura fundamental que encapsula cada tarea
→ SistemaTareas.java: Gestor centralizado del repositorio
→ MainTarea.java: Demostración con banco de pruebas

ANÁLISIS DE RENDIMIENTO:
------------------------

Operaciones básicas - Tarea:
  Constructor ............................ O(1)
  Métodos de acceso (getters) ........... O(1)
  Métodos de asignación (setters) ...... O(1)
  Serialización (toString) ............. O(1)
  Comparación (equals) ................. O(1)

Operaciones principales - SistemaGestionTareas:
  Inicialización ....................... O(1)
  Inserción de tarea ................... O(1) amortizado
  Listado completo ..................... O(n)
  Búsqueda por identificador ........... O(n)
  Actualización a completada ........... O(n)
  Supresión de tarea ................... O(n)
  Filtrado de pendientes ............... O(n)
  Clasificación por urgencia ........... O(n)
  Conteo total ......................... O(1)
  Verificación de vacío ................ O(1)

Nota: n representa la cantidad de tareas registradas.

FUNCIONALIDADES PRINCIPALES:
----------------------------
• Generación de IDs secuenciales única automática
• Validación estricta de rango de prioridad [1-5]
• Gestión de excepciones para búsquedas inválidas
• Retroalimentación clara al usuario
• Manejo consistente de estados

BATERÍA DE VERIFICACIONES:
--------------------------
✓ Registro exitoso de tareas con validación
✓ Exhibición del inventario completo
✓ Localización por identificador válido
✓ Manejo de búsquedas con ID inválido
✓ Transición de estado a finalizado
✓ Extracción de tareas pendientes
✓ Agrupamiento por nivel de importancia
✓ Eliminación segura de registros
✓ Rechazo de prioridades fuera de rango
✓ Verificación de asignación de IDs secuenciales
✓ Comportamiento en estado vacío del sistema