public class AnalisisComplejidad {
    
    // Fragmento 1: Encontrar el máximo en un array
    // Recorremos todo el array una sola vez O(n)
    public static int encontrarMaximo(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
    // Complejidad: O(n) - tenemos que ver todos los elementos
    
    // Fragmento 2: Verifica si un número es primo
    // Solo revisamos hasta la raíz cuadrada del número O(√n)
    public static boolean esPrimo(int numero) {
        if (numero <= 1) return false;
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false; // Encontramos un divisor, no es primo
            }
        }
        return true;
    }
    // Complejidad: O(√n) - eficiente porque no revisamos todos los números
    
    // Fragmento 3: Imprime una matriz fila por fila
    // Dos bucles anidados = n filas × m columnas
    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println(); // Nueva línea después de cada fila
        }
    }
    // Complejidad: O(n×m) - visitamos cada elemento de la matriz
    
    // Fragmento 4: Búsqueda binaria (requiere array ordenado)
    // Dividimos el espacio de búsqueda a la mitad cada vez O(log n)
    public static int busquedaBinaria(int[] array, int objetivo) {
        int izquierda = 0;
        int derecha = array.length - 1;
        
        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2; // Evita overflow
            
            if (array[medio] == objetivo) {
                return medio; // ¡Encontrado!
            } else if (array[medio] < objetivo) {
                izquierda = medio + 1; // Buscar a la derecha
            } else {
                derecha = medio - 1; // Buscar a la izquierda
            }
        }
        return -1; // No encontrado
    }
    // Complejidad: O(log n) - muy eficiente, cortamos el problema a la mitad
    
    public static void main(String[] args) {
        // Ejemplos de uso
    }
}