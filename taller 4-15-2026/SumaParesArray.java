/**
 * archivo: sumaparesarray
 * este archivo suma los valores pares de un arreglo por recursión, sin enredarse.
 */
public class SumaParesArray {
    public int sumaParesArray(int[] arr, int i) {
    if (i == arr.length) return 0;
    int valor = (arr[i] % 2 == 0) ? arr[i] : 0;
    return valor + sumaParesArray(arr, i + 1); // [cite: 79, 80]
}
 
    public static void main(String[] args) {
        SumaParesArray sumaPares = new SumaParesArray();
        int[] arr = {1, 2, 3, 4, 5}; // el arreglo puede variar según lo que se quiera calcular, parce
        int resultado = sumaPares.sumaParesArray(arr, 0);
        System.out.println("La suma de los números pares en el arreglo es: " + resultado);
    }

}
