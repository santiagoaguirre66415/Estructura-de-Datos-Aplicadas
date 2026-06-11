import java.util.Scanner;

/**
 * Clase Main - Punto de entrada del programa. Maneja toda la interaccion con el usuario
 * a traves de menus en consola.
 * 
 * Desde aqui se accede a todas las funcionalidades del sistema:
 * - Gestionar vuelos
 * - Gestionar pasajeros y reservas
 * - Manejar listas de espera (colas)
 * - Ver historial y deshacer operaciones (pilas)
 * - Reportes usando recursividad
 */
public class Main {

    private static Aerolinea aerolinea = new Aerolinea();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = leerEntero("Que quieres hacer? ");
            switch (opcion) {
                case 1:
                    menuVuelos();
                    break;
                case 2:
                    menuPasajerosReservas();
                    break;
                case 3:
                    menuListasEspera();
                    break;
                case 4:
                    menuHistorialDeshacer();
                    break;
                case 5:
                    menuReportes();
                    break;
                case 0:
                    System.out.println("\nGracias por usar el sistema. Buen viaje!");
                    break;
                default:
                    System.out.println("\nEsa opcion no existe. Elige una del menu.");
            }
        } while (opcion != 0);
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n+============================================+");
        System.out.println("|    SISTEMA DE GESTION DE AEROLINEA         |");
        System.out.println("+============================================+");
        System.out.println("| 1. Vuelos (registrar, listar, buscar)      |");
        System.out.println("| 2. Pasajeros y Reservas                    |");
        System.out.println("| 3. Listas de Espera (colas)                |");
        System.out.println("| 4. Historial y Deshacer (pilas)            |");
        System.out.println("| 5. Reportes con Recursividad               |");
        System.out.println("| 0. Salir                                   |");
        System.out.println("+============================================+");
    }

    // ==================== MENU VUELOS ====================

    private static void menuVuelos() {
        int opcion;
        do {
            System.out.println("\n+--- VUELOS ---+");
            System.out.println("| 1. Crear un vuelo nuevo");
            System.out.println("| 2. Ver todos los vuelos registrados");
            System.out.println("| 3. Buscar vuelo por codigo (recursivo)");
            System.out.println("| 0. Volver al menu principal");
            opcion = leerEntero("Elige: ");
            switch (opcion) {
                case 1:
                    registrarVuelo();
                    break;
                case 2:
                    listarVuelos();
                    break;
                case 3:
                    buscarVueloPorCodigo();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);
    }

    private static void registrarVuelo() {
        System.out.println("\n--- Crear vuelo nuevo ---");
        System.out.print("Codigo del vuelo (ej. AV101): ");
        String codigo = scanner.nextLine().trim();

        // Verificamos que no exista otro vuelo con el mismo codigo
        Vuelo existente = aerolinea.buscarVueloPorCodigoRecursivo(codigo, 0);
        if (existente != null) {
            System.out.println("Ya existe un vuelo con ese codigo. Prueba con otro.");
            return;
        }

        System.out.print("Ciudad de origen: ");
        String origen = scanner.nextLine().trim();
        System.out.print("Ciudad de destino: ");
        String destino = scanner.nextLine().trim();
        int capacidad = leerEntero("Cuantos asientos tiene el vuelo? ");

        if (capacidad <= 0) {
            System.out.println("La capacidad tiene que ser mayor a 0.");
            return;
        }

        Vuelo vuelo = new Vuelo(codigo, origen, destino, capacidad);
        aerolinea.registrarVuelo(vuelo);
        System.out.println("Vuelo registrado con exito!");
        System.out.println("  " + vuelo);
    }

    private static void listarVuelos() {
        System.out.println("\n--- Vuelos registrados ---");
        if (aerolinea.getVuelos().isEmpty()) {
            System.out.println("Aun no hay vuelos registrados. Crea uno primero.");
            return;
        }
        for (Vuelo v : aerolinea.getVuelos()) {
            System.out.println("  " + v);
        }
    }

    private static void buscarVueloPorCodigo() {
        System.out.println("\n--- Buscar vuelo por codigo (usando recursividad) ---");
        System.out.print("Escribe el codigo del vuelo: ");
        String codigo = scanner.nextLine().trim();

        Vuelo vuelo = aerolinea.buscarVueloPorCodigoRecursivo(codigo, 0);
        if (vuelo != null) {
            System.out.println("Encontre este vuelo:");
            System.out.println("  " + vuelo);
        } else {
            System.out.println("No encontre ningun vuelo con el codigo '" + codigo + "'.");
        }
    }

    // ==================== MENU PASAJEROS Y RESERVAS ====================

    private static void menuPasajerosReservas() {
        int opcion;
        do {
            System.out.println("\n+--- PASAJEROS Y RESERVAS ---+");
            System.out.println("| 1. Registrar pasajero en un vuelo");
            System.out.println("| 2. Cancelar reserva de un pasajero");
            System.out.println("| 3. Ver pasajeros de un vuelo");
            System.out.println("| 4. Ver lista de espera de un vuelo");
            System.out.println("| 0. Volver al menu principal");
            opcion = leerEntero("Elige: ");
            switch (opcion) {
                case 1:
                    registrarPasajeroEnVuelo();
                    break;
                case 2:
                    cancelarReserva();
                    break;
                case 3:
                    mostrarPasajerosDeVuelo();
                    break;
                case 4:
                    mostrarListaEsperaDeVuelo();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);
    }

    private static void registrarPasajeroEnVuelo() {
        System.out.println("\n--- Registrar pasajero en un vuelo ---");
        System.out.print("Codigo del vuelo: ");
        String codigo = scanner.nextLine().trim();

        Vuelo vuelo = aerolinea.buscarVueloPorCodigoRecursivo(codigo, 0);
        if (vuelo == null) {
            System.out.println("No encontre un vuelo con ese codigo. Verifica e intenta de nuevo.");
            return;
        }

        System.out.print("Nombre del pasajero: ");
        String nombre = scanner.nextLine().trim();
        System.out.print("Numero de documento: ");
        String documento = scanner.nextLine().trim();
        System.out.print("Nacionalidad: ");
        String nacionalidad = scanner.nextLine().trim();

        Pasajero pasajero = new Pasajero(aerolinea.getSiguienteIdPasajero(), nombre, documento, nacionalidad);

        if (vuelo.estaLleno()) {
            // El vuelo ya no tiene asientos, mandamos al pasajero a la cola de espera
            System.out.println("El vuelo ya esta lleno. Te ponemos en lista de espera.");
            vuelo.agregarAListaEspera(pasajero);
            aerolinea.registrarOperacion("LISTA_ESPERA", documento, codigo, pasajero);
            System.out.println(nombre + " fue agregado a la lista de espera del vuelo " + codigo + ".");
            System.out.println("En cuanto se libere un cupo, se le asignara automaticamente.");
        } else {
            // Hay cupo, reserva confirmada
            vuelo.agregarPasajero(pasajero);
            aerolinea.registrarOperacion("RESERVA", documento, codigo, pasajero);
            System.out.println("Reserva confirmada! " + nombre + " tiene asiento en el vuelo " + codigo + ".");
        }
    }

    private static void cancelarReserva() {
        System.out.println("\n--- Cancelar reserva ---");
        System.out.print("Codigo del vuelo: ");
        String codigo = scanner.nextLine().trim();

        Vuelo vuelo = aerolinea.buscarVueloPorCodigoRecursivo(codigo, 0);
        if (vuelo == null) {
            System.out.println("No encontre un vuelo con ese codigo.");
            return;
        }

        System.out.print("Documento del pasajero que cancela: ");
        String documento = scanner.nextLine().trim();

        Pasajero pasajero = vuelo.buscarPasajeroPorDocumento(documento);
        if (pasajero == null) {
            System.out.println("No hay ningun pasajero con ese documento en este vuelo.");
            return;
        }

        // Quitamos al pasajero y registramos la cancelacion en el historial
        vuelo.cancelarReserva(documento);
        aerolinea.registrarOperacion("CANCELACION", documento, codigo, pasajero);
        System.out.println("Reserva cancelada: " + pasajero.getNombre() + " ya no esta en el vuelo " + codigo + ".");

        // Si hay alguien en la lista de espera, se le asigna el cupo que quedo libre
        if (vuelo.tieneListaEspera()) {
            Pasajero siguiente = vuelo.siguienteEnEspera();
            vuelo.agregarPasajero(siguiente);
            aerolinea.registrarOperacion("RESERVA_AUTO", siguiente.getDocumento(), codigo, siguiente);
            System.out.println("Se libero un cupo y " + siguiente.getNombre() +
                    " (que estaba en lista de espera) ahora tiene asiento!");
        }
    }

    private static void mostrarPasajerosDeVuelo() {
        System.out.println("\n--- Pasajeros de un vuelo ---");
        System.out.print("Codigo del vuelo: ");
        String codigo = scanner.nextLine().trim();

        Vuelo vuelo = aerolinea.buscarVueloPorCodigoRecursivo(codigo, 0);
        if (vuelo == null) {
            System.out.println("No encontre un vuelo con ese codigo.");
            return;
        }

        if (vuelo.getListaPasajeros().isEmpty()) {
            System.out.println("Este vuelo aun no tiene pasajeros registrados.");
            return;
        }

        System.out.println("Pasajeros del vuelo " + codigo +
                " (" + vuelo.getListaPasajeros().size() + "/" + vuelo.getCapacidadMaxima() + " asientos ocupados):");
        for (Pasajero p : vuelo.getListaPasajeros()) {
            System.out.println("  - " + p);
        }
    }

    private static void mostrarListaEsperaDeVuelo() {
        System.out.println("\n--- Lista de espera de un vuelo ---");
        System.out.print("Codigo del vuelo: ");
        String codigo = scanner.nextLine().trim();

        Vuelo vuelo = aerolinea.buscarVueloPorCodigoRecursivo(codigo, 0);
        if (vuelo == null) {
            System.out.println("No encontre un vuelo con ese codigo.");
            return;
        }

        if (vuelo.getListaEspera().isEmpty()) {
            System.out.println("No hay nadie en lista de espera para este vuelo.");
            return;
        }

        System.out.println("Lista de espera del vuelo " + codigo + ":");
        int pos = 1;
        for (Pasajero p : vuelo.getListaEspera()) {
            System.out.println("  " + pos + ". " + p);
            pos++;
        }
    }

    // ==================== MENU LISTAS DE ESPERA ====================

    private static void menuListasEspera() {
        int opcion;
        do {
            System.out.println("\n+--- LISTAS DE ESPERA (COLAS) ---+");
            System.out.println("| 1. Poner un pasajero en lista de espera");
            System.out.println("| 2. Darle un cupo al siguiente en la fila");
            System.out.println("| 3. Ver lista de espera de un vuelo");
            System.out.println("| 0. Volver al menu principal");
            opcion = leerEntero("Elige: ");
            switch (opcion) {
                case 1:
                    agregarAListaEspera();
                    break;
                case 2:
                    procesarListaEspera();
                    break;
                case 3:
                    mostrarListaEsperaDeVuelo();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);
    }

    private static void agregarAListaEspera() {
        System.out.println("\n--- Agregar pasajero a lista de espera ---");
        System.out.print("Codigo del vuelo: ");
        String codigo = scanner.nextLine().trim();

        Vuelo vuelo = aerolinea.buscarVueloPorCodigoRecursivo(codigo, 0);
        if (vuelo == null) {
            System.out.println("No encontre un vuelo con ese codigo.");
            return;
        }

        System.out.print("Nombre del pasajero: ");
        String nombre = scanner.nextLine().trim();
        System.out.print("Numero de documento: ");
        String documento = scanner.nextLine().trim();
        System.out.print("Nacionalidad: ");
        String nacionalidad = scanner.nextLine().trim();

        Pasajero pasajero = new Pasajero(aerolinea.getSiguienteIdPasajero(), nombre, documento, nacionalidad);
        vuelo.agregarAListaEspera(pasajero);
        aerolinea.registrarOperacion("LISTA_ESPERA", documento, codigo, pasajero);
        System.out.println(nombre + " fue agregado a la lista de espera del vuelo " + codigo + ".");
    }

    private static void procesarListaEspera() {
        System.out.println("\n--- Dar cupo al siguiente en la fila ---");
        System.out.print("Codigo del vuelo: ");
        String codigo = scanner.nextLine().trim();

        Vuelo vuelo = aerolinea.buscarVueloPorCodigoRecursivo(codigo, 0);
        if (vuelo == null) {
            System.out.println("No encontre un vuelo con ese codigo.");
            return;
        }

        if (!vuelo.tieneListaEspera()) {
            System.out.println("No hay nadie en la lista de espera de este vuelo.");
            return;
        }

        if (vuelo.estaLleno()) {
            System.out.println("El vuelo sigue lleno. No se puede asignar cupo ahora.");
            System.out.println("Alguien tiene que cancelar su reserva primero para que se libere un asiento.");
            return;
        }

        // Sacamos al primero de la cola y lo metemos como pasajero confirmado
        Pasajero siguiente = vuelo.siguienteEnEspera();
        vuelo.agregarPasajero(siguiente);
        aerolinea.registrarOperacion("RESERVA_AUTO", siguiente.getDocumento(), codigo, siguiente);
        System.out.println("Listo! " + siguiente.getNombre() + " paso de la lista de espera a tener asiento confirmado.");
    }

    // ==================== MENU HISTORIAL Y DESHACER ====================

    private static void menuHistorialDeshacer() {
        int opcion;
        do {
            System.out.println("\n+--- HISTORIAL Y DESHACER (PILAS) ---+");
            System.out.println("| 1. Ver que operaciones se han hecho");
            System.out.println("| 2. Deshacer la ultima operacion");
            System.out.println("| 0. Volver al menu principal");
            opcion = leerEntero("Elige: ");
            switch (opcion) {
                case 1:
                    aerolinea.mostrarHistorial();
                    break;
                case 2:
                    deshacerOperacion();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);
    }

    private static void deshacerOperacion() {
        System.out.println("\n--- Deshacer ultima operacion ---");

        if (!aerolinea.hayHistorial()) {
            System.out.println("No hay ninguna operacion para deshacer.");
            return;
        }

        // Sacamos la ultima operacion de la pila
        Operacion op = aerolinea.deshacerUltimaOperacion();
        System.out.println("Voy a deshacer: " + op);

        Vuelo vuelo = aerolinea.buscarVueloPorCodigoRecursivo(op.getCodigoVuelo(), 0);
        if (vuelo == null) {
            System.out.println("El vuelo de esa operacion ya no existe. No se puede deshacer.");
            return;
        }

        switch (op.getTipo()) {
            case "RESERVA":
            case "RESERVA_AUTO":
                // Si fue una reserva, la revertimos quitando al pasajero del vuelo
                vuelo.cancelarReserva(op.getDocumentoPasajero());
                System.out.println("Reserva deshecha: " + op.getDocumentoPasajero() +
                        " fue quitado del vuelo " + op.getCodigoVuelo() + ".");
                break;

            case "CANCELACION":
                // Si fue una cancelacion, volvemos a meter al pasajero en el vuelo
                if (vuelo.estaLleno()) {
                    // Si ya esta lleno de nuevo, lo mandamos a lista de espera
                    vuelo.agregarAListaEspera(op.getPasajero());
                    System.out.println("El vuelo ya esta lleno otra vez. " + op.getPasajero().getNombre() +
                            " fue puesto en lista de espera en vez de reingresarlo directamente.");
                } else {
                    vuelo.agregarPasajero(op.getPasajero());
                    System.out.println("Cancelacion deshecha: " + op.getPasajero().getNombre() +
                            " volvio a tener asiento en el vuelo " + op.getCodigoVuelo() + ".");
                }
                break;

            case "LISTA_ESPERA":
                // Si fue un agregado a lista de espera, lo sacamos de la cola
                boolean removido = removerDeCola(vuelo, op.getDocumentoPasajero());
                if (removido) {
                    System.out.println(op.getPasajero().getNombre() +
                            " fue sacado de la lista de espera del vuelo " + op.getCodigoVuelo() + ".");
                } else {
                    System.out.println("No encontre a ese pasajero en la lista de espera (quizas ya le habian dado cupo).");
                }
                break;

            default:
                System.out.println("Tipo de operacion desconocido. No se puede deshacer.");
        }
    }

    // Metodo auxiliar para sacar a un pasajero especifico de la cola de espera.
    // Como Queue no deja remover un elemento por valor, tenemos que vaciar la cola,
    // omitir al pasajero que queremos sacar, y volver a encolar los demas en el mismo orden.
    private static boolean removerDeCola(Vuelo vuelo, String documento) {
        java.util.Queue<Pasajero> colaOriginal = vuelo.getListaEspera();
        java.util.LinkedList<Pasajero> temporal = new java.util.LinkedList<>();
        boolean encontrado = false;

        while (!colaOriginal.isEmpty()) {
            Pasajero p = colaOriginal.poll();
            if (p.getDocumento().equals(documento) && !encontrado) {
                encontrado = true;  // Lo saltamos, no lo reencolamos
            } else {
                temporal.add(p);    // Los demas vuelven a la cola en el mismo orden
            }
        }

        colaOriginal.addAll(temporal);
        return encontrado;
    }

    // ==================== MENU REPORTES (RECURSIVIDAD) ====================

    private static void menuReportes() {
        int opcion;
        do {
            System.out.println("\n+--- REPORTES (usando recursividad) ---+");
            System.out.println("| 1. Cuantos pasajeros tiene un vuelo?");
            System.out.println("| 2. Cuantos pasajeros van a un destino?");
            System.out.println("| 3. Buscar pasajero por documento en todos los vuelos");
            System.out.println("| 0. Volver al menu principal");
            opcion = leerEntero("Elige: ");
            switch (opcion) {
                case 1:
                    contarPasajerosDeVuelo();
                    break;
                case 2:
                    contarPasajerosPorDestino();
                    break;
                case 3:
                    buscarPasajeroPorDocumentoGlobal();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);
    }

    private static void contarPasajerosDeVuelo() {
        System.out.println("\n--- Contar pasajeros de un vuelo (recursivo) ---");
        System.out.print("Codigo del vuelo: ");
        String codigo = scanner.nextLine().trim();

        Vuelo vuelo = aerolinea.buscarVueloPorCodigoRecursivo(codigo, 0);
        if (vuelo == null) {
            System.out.println("No encontre un vuelo con ese codigo.");
            return;
        }

        int total = aerolinea.contarPasajerosRecursivo(vuelo, 0);
        System.out.println("El vuelo " + codigo + " tiene " + total +
                " pasajero" + (total != 1 ? "s" : "") + " de " + vuelo.getCapacidadMaxima() + " asientos.");
    }

    private static void contarPasajerosPorDestino() {
        System.out.println("\n--- Contar pasajeros por destino (recursivo) ---");
        System.out.print("A que destino quieres contar? ");
        String destino = scanner.nextLine().trim();

        int total = aerolinea.contarPasajerosPorDestinoRecursivo(destino, 0);
        System.out.println("Hay " + total + " pasajero" + (total != 1 ? "s" : "") +
                " viajando hacia " + destino + " en todos los vuelos.");
    }

    private static void buscarPasajeroPorDocumentoGlobal() {
        System.out.println("\n--- Buscar pasajero por documento en todos los vuelos (recursivo) ---");
        System.out.print("Numero de documento: ");
        String documento = scanner.nextLine().trim();

        Pasajero p = aerolinea.buscarPasajeroPorDocumentoRecursivo(documento, 0);
        if (p != null) {
            System.out.println("Lo encontre! Estos son sus datos:");
            System.out.println("  " + p);
        } else {
            System.out.println("No encontre ningun pasajero con el documento '" + documento + "' en ningun vuelo.");
        }
    }

    // ==================== UTILIDADES ====================

    // Lee un numero entero por teclado. Si el usuario escribe algo que no es numero,
    // le pide que intente de nuevo en vez de crashear el programa.
    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                String linea = scanner.nextLine().trim();
                return Integer.parseInt(linea);
            } catch (NumberFormatException e) {
                System.out.println("Eso no es un numero valido. Intenta de nuevo.");
            }
        }
    }
}
