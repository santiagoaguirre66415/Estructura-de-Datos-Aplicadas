/**
 * archivo: seriepadovan
 * calcula términos de la serie de padovan por recursión.
 */
public class SeriePadovan {
    public int padovan(int n) {
    if (n == 0 || n == 1 || n == 2) return 1; // casos base [cite: 57, 60]
    return padovan(n - 2) + padovan(n - 3); // caso recursivo [cite: 57, 59]
}
 
    public static void main(String[] args) {
        SeriePadovan seriePadovan = new SeriePadovan();
        int n = 6; // el número puede variar según lo que se quiera calcular
        int resultado = seriePadovan.padovan(n);
        System.out.println("El término " + n + " de la serie de Padovan es: " + resultado);
    }

}
