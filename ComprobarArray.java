public class ComprobarArray {
    public boolean estaOrdenado(int[] arr, int i) {
    if (i >= arr.length - 1) return true; // Caso base [cite: 49]
    if (arr[i] > arr[i + 1]) return false;
    return estaOrdenado(arr, i + 1); // Reducción [cite: 50]
}
 
    public static void main(String[] args) {
        ComprobarArray comprobar = new ComprobarArray();
        int[] arr = {1, 3, 5, 8}; // El arreglo puede variar según lo que se quiera comprobar
        boolean resultado = comprobar.estaOrdenado(arr, 0);
        System.out.println("El arreglo está ordenado: " + resultado);
    }

}
