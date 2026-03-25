public class AnalisisComplejidad {
    //Fragmento 1
    public static int encontrarMaximo(int[] array) {   // Encuentra el valor máximo en un array de enteros  
        int max = array[0];     // Big O: O(1) para el primer elemento
        for (int i = 1; i < array.length; i++) {  // Big O: O(n) para iterar sobre el array       
            if (array[i] > max) {             // Big O: O(1) para cada comparación
                max = array[i];         // Big O: O(1) para cada asignación
            }     
        }     
        return max; // Big O: O(n) debido a la necesidad de revisar cada elemento del array
    }// Big O: O(n) debido a la necesidad de revisar cada elemento del array para encontrar el máximo
    
    //Fragmento 2
    public static boolean esPrimo(int numero) {    // Verifica si un número es primo 
        if (numero <= 1) return false;     // Big O: O(1) para casos pequeños, O(sqrt(n)) para casos grandes
        for (int i = 2; i <= Math.sqrt(numero); i++) {       // Solo necesitamos verificar hasta la raíz cuadrada de número  
            if (numero % i == 0) {             
                return false;  // Big O: O(1) para casos pequeños, O(n) para casos grandes       
            }     
        }     
        return true; // Big O: O(sqrt(n)) debido a la raíz cuadrada en el límite del bucle
    }// Big O: O(sqrt(n)) debido a la necesidad de verificar divisores hasta la raíz cuadrada del número
    
    //Fragmento 3
    public static void imprimirMatriz(int[][] matriz) {    // Big O: O(n*m) donde n = número de filas y m = número de columnas 
        for (int i = 0; i < matriz.length; i++) {  // Itera sobre filas       
            for (int j = 0; j < matriz[i].length; j++) {   // Itera sobre columnas          
                System.out.print(matriz[i][j] + " ");    // Big O: O(1) para cada elemento     
            }         
            System.out.println();    // Nueva línea después de cada fila 
        } 
    }// Big O: O(n*m) debido a la necesidad de revisar cada elemento de la matriz y O(n^2) para matrices cuadradas
    
    //Fragmento 4
    public static int busquedaBinaria(int[] array, int objetivo) {     
        int izquierda = 0;    // Índice inicial 
        int derecha = array.length - 1;     // Requiere array ordenado
        while (izquierda <= derecha) {         
            int medio = izquierda + (derecha - izquierda) / 2;   // Evita overflow      
            if (array[medio] == objetivo) {      // Elemento encontrado       
                return medio;         // Big O: O(1)
            } else if (array[medio] < objetivo) {             
                izquierda = medio + 1;   // Buscar en la mitad derecha      
            } else {             // Buscar en la mitad izquierda
                derecha = medio - 1;  // Big O: O(log n)       
            }     
        }     
        return -1; // Elemento no encontrado
    }// Big O: O(log n) debido a la división del espacio de búsqueda en cada iteración
    
    public static void main(String[] args) {
        // Main method for testing
    }
}