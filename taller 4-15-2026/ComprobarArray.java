/**
 * archivo: comprobararray
 * este archivo mira, pues, si un arreglo está ordenado de una.
 */
public class ComprobarArray {
    public boolean estaOrdenado(int[] arr, int i) {
    if (i >= arr.length - 1) return true; // caso base, tranquilito [cite: 49]
    if (arr[i] > arr[i + 1]) return false;
    return estaOrdenado(arr, i + 1); // seguimos bajando, pues [cite: 50]
}
 
    public static void main(String[] args) {
        ComprobarArray comprobar = new ComprobarArray();
        int[] arr = {1, 3, 5, 8}; // el arreglo puede variar según lo que se quiera comprobar, parce
        boolean resultado = comprobar.estaOrdenado(arr, 0);
        System.out.println("El arreglo está ordenado: " + resultado);
    }

}
