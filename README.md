# Gestor de Tareas - Implementación en Java

## Resumen

Esta es una **aplicación Java** que facilita la administración integral de tareas con funcionalidades CRUD completas (Crear, Consultar, Actualizar, Suprimir).
Fue desarrollada como herramienta educativa para ilustrar conceptos fundamentales de **OOP (Orientación a Objetos)**, **manejo de colecciones**, validaciones y **análisis de rendimiento algorítmico**.

Cada tarea almacena su descripción, prioridad asignada y estado actual. A través de `ArrayList` se mantiene un registro dinámico con generación automática de identificadores únicos.

Perfecto para aprender sobre:

- Diseño y modelado de entidades
- Estructuras dinámicas en Java
- Lógica empresarial
- Evaluación de complejidad temporal

---

## Métodos Disponibles

| Operación                     | Propósito                                          | Tiempo |
|-------------------------------|----------------------------------------------------|--------|
| `agregarTarea()`              | Inserta una nueva tarea al sistema                 | O(1)   |
| `listarTareas()`              | Exhibe el inventario completo de tareas            | O(n)   |
| `buscarPorId()`               | Localiza una tarea mediante su identificador       | O(n)   |
| `marcarCompletada()`          | Actualiza el estado de una tarea a finalizada      | O(n)   |
| `eliminarTarea()`             | Remueve una tarea del registro                     | O(n)   |
| `obtenerTareasPendientes()`   | Retorna las tareas aún sin completar               | O(n)   |
| `obtenerTareasPorPrioridad()` | Agrupa según nivel de urgencia                     | O(n)   |
| `obtenerTotalTareas()`        | Cantidad de tareas almacenadas                     | O(1)   |
| `estaVacio()`                 | Verifica presencia de tareas en el sistema         | O(1)   |

---

## Organización de Archivos

```
GestorTareas/
│
├── Tarea.java
├── SistemaGestionTareas.java
├── Main.java
└── README.md
```

### Detalles de Componentes

**Tarea.java**
Define la estructura de datos que representa cada tarea individual.

Propiedades:

- `id` (int) — Identificador único
- `descripcion` (String) — Contenido de la tarea
- `prioridad` (int) — Rango 1-5 (siendo 1 la máxima urgencia)
- `completada` (boolean) — Indicador de estado

Componentes incluidos:

- Inicializador parametrizado
- Accesores y mutadores
- Método `toString()` personalizado

Rendimiento de operaciones: **O(1)**.

---

**SistemaGestionTareas.java**
Nucleo que implementa la lógica operacional.

Implementaciones clave:

- `ArrayList<Tarea>` como base de datos en memoria
- Asignación automática de IDs secuenciales
- Suite completa de CRUD
- Búsquedas y filtrados
- Validación de rangos de prioridad

---

**Main.java**
Clase de demostración con casos de uso prácticos.

Funcionalidades probadas:

- Alta de nuevas tareas
- Localización por identificador
- Eliminación de registros
- Cambio de estado
- Validaciones funcionales
- Situaciones extremas

---

## Configuración e Inicio

### Paso 1: Clonar desde el repositorio

```bash
git clone https://github.com/santiagoaguirre66415/Estructura-de-Datos-Aplicadas.git
cd "taller git"
```

### Paso 2: Compilar todos los módulos

```bash
javac *.java
javac TAREA\ SAS/*.java
```

### Paso 3: Ejecutar el análisis de complejidad

```bash
java AnalisisComplejidad
```

### Paso 4: Ejecutar el sistema de gestión de tareas

```bash
java -cp TAREA\ SAS;. TAREA_SAS.MainTarea
```

O si prefieres desde el directorio específico:

```bash
cd TAREA\ SAS
javac *.java
java MainTarea
```

**Requisitos previos:**
- JDK 8 o superior
- Git instalado
- Variables de entorno Java configuradas (`JAVA_HOME`)

**Estructura del repositorio:**
```
estructura-datos-aplicadas/
├── taller git/
│   ├── AnalisisComplejidad.java
│   ├── TAREA SAS/
│   │   ├── tarea.java
│   │   ├── SistemaTareas.java
│   │   └── MainTarea.java
│   └── README.md
```

---

## Guía de Uso

### Registrando tareas

```java
SistemaGestionTareas sistema = new SistemaGestionTareas();

sistema.agregarTarea("Estudiar Java", 2);
sistema.agregarTarea("Hacer ejercicio", 3);
sistema.agregarTarea("Completar proyecto", 1);

sistema.listarTareas();
```

### Resultado esperado

```
ID: 1 | Descripción: Estudiar Java | Prioridad: 2 | Completada: No
ID: 2 | Descripción: Hacer ejercicio | Prioridad: 3 | Completada: No
ID: 3 | Descripción: Completar proyecto | Prioridad: 1 | Completada: No
```

---

### Completando una tarea

```java
sistema.marcarCompletada(2);
```

Salida del sistema:

```
Tarea con ID 2 marcada como completada.
```

---

### Consultando tareas pendientes

```java
sistema.obtenerTareasPendientes();
```

Respuesta:

```
ID: 1 | Estudiar Java
ID: 3 | Completar proyecto
```

---

## Suite de Pruebas

El archivo `Main.java` contiene un conjunto exhaustivo de verificaciones:

### Flujos positivos

- Inserción de nuevas tareas con éxito
- Visualización del catálogo total
- Búsqueda exitosa de registros específicos
- Supresión de tareas
- Cambio de estado a completado

### Escenarios límite

- Intento de ubicar un ID inexistente
- Eliminación de registros que no existen
- Finalización de tareas no registradas
- Creación con prioridades fuera del rango permitido

### Controles de coherencia

- Rango de prioridad **1-5**
- Identificadores inválidos o faltantes
- Operaciones sobre lista vacía

---

## Evoluciones Potenciales

Posibles extensiones del proyecto:

- Persistencia mediante serialización o base de datos relacional
- Interfaz gráfica utilizando Swing o JavaFX
- Ordenamiento automático por nivel de urgencia
- Optimización con `HashMap` para lograr **O(1)** en búsquedas
- Inclusión de plazos/deadlines
- Sistema de agrupación por categorías
- API REST con **Spring Boot**
- Sincronización multi-usuario
- Notificaciones de tareas próximas a vencer

---

## Autoría

Santiago Aguirre Salinas

Trabajo académico enfocado en dominar **Java, estructuras de colecciones y evaluación algorítmica**.