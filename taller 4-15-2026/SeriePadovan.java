/**
 * archivo: seriepadovan
 * este archivo calcula términos de la serie de padovan por recursión, bien paisa.
 */
public class SeriePadovan {
    public int padovan(int n) {
    if (n == 0 || n == 1 || n == 2) return 1; // casos base, ahí comienza la vuelta [cite: 57, 60]
    return padovan(n - 2) + padovan(n - 3); // caso recursivo, seguimos la cadena [cite: 57, 59]
}
 
    public static void main(String[] args) {
        SeriePadovan seriePadovan = new SeriePadovan();
        int n = 6; // el número puede variar según lo que se quiera calcular, pues
        int resultado = seriePadovan.padovan(n);
        System.out.println("El término " + n + " de la serie de Padovan es: " + resultado);
    }

}
