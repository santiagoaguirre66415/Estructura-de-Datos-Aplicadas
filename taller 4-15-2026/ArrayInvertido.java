/**
 * archivo: arrayinvertido
 * invierte un arreglo de forma recursiva.
 */
public class ArrayInvertido {
    public void invertir(int[] arr, int ini, int fin) {
    if (ini >= fin) return; // caso base [cite: 45]
    int aux = arr[ini];
    arr[ini] = arr[fin];
    arr[fin] = aux;
    invertir(arr, ini + 1, fin - 1); // caso recursivo [cite: 44]
}
 
    public static void main(String[] args) {
        ArrayInvertido arrayInvertido = new ArrayInvertido();
        int[] arr = {1, 2, 3, 4}; // el arreglo puede variar según lo que se quiera invertir
        System.out.print("Arreglo original: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        arrayInvertido.invertir(arr, 0, arr.length - 1);
        
        System.out.print("Arreglo invertido: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

}
