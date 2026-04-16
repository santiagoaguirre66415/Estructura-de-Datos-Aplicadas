/**
 * archivo: imprimearray
 * este archivo imprime un arreglo de forma recursiva, pues sin tanta vuelta.
 */
public class ImprimeArray {
    public void imprimir(int[] arreglo, int i) {
    if (i == arreglo.length) return;
    System.out.print(arreglo[i]);
    imprimir(arreglo, i + 1);
}
 
    public static void main(String[] args) {
        ImprimeArray imprime = new ImprimeArray();
        int[] arreglo = {1, 2, 3}; // el arreglo puede variar según lo que se quiera imprimir, parce
        System.out.print("El arreglo es: ");
        imprime.imprimir(arreglo, 0);
    }

}
