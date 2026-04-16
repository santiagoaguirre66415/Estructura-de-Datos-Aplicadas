/**
 * archivo: analisis de complejidad
 * reúne ejemplos breves de complejidad algorítmica.
 */
public class AnalisisComplejidad {
    
    // fragmento 1: encontrar el máximo en un array
    // recorremos todo el array una sola vez O(n)
    public static int encontrarMaximo(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
    // complejidad: O(n) - tenemos que ver todos los elementos
    
    // fragmento 2: verifica si un número es primo
    // solo revisamos hasta la raíz cuadrada del número
    // el if base es O(1), pero el bucle siempre es O(√n)
    public static boolean esPrimo(int numero) {
        if (numero <= 1) return false;  // O(1)
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false; // Encontramos un divisor, no es primo
            }
        }
        return true;
    }
    // complejidad: O(√n) - mucho más eficiente que revisar todos los números
    
    // fragmento 3: imprime una matriz fila por fila
    // dos bucles anidados = n filas × m columnas
    // total: O(n*m), y O(n^2) cuando es matriz cuadrada
    public static void imprimirMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int valor : fila) {
                System.out.print(valor + " ");
            }
            System.out.println(); // nueva línea después de cada fila
        }
    }
    // complejidad: O(n*m) - visitamos cada elemento; O(n^2) para matrices cuadradas
    
    // fragmento 4: búsqueda binaria (requiere array ordenado)
    // dividimos el espacio de búsqueda a la mitad cada vez O(log n)
    public static int busquedaBinaria(int[] array, int objetivo) {
        int izquierda = 0;
        int derecha = array.length - 1;
        
        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2; // evita overflow
            
            if (array[medio] == objetivo) {
                return medio; // ¡encontrado!
            } else if (array[medio] < objetivo) {
                izquierda = medio + 1; // buscar a la derecha
            } else {
                derecha = medio - 1; // buscar a la izquierda
            }
        }
        return -1; // no encontrado
    }
    // complejidad: O(log n) - muy eficiente, cortamos el problema a la mitad
    
    public static void main(String[] args) {
        // ejemplos de uso
    }
}