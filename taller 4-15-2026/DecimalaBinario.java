/**
 * archivo: decimalabinario
 * este archivo pasa un decimal a binario por recursión, bien bacano.
 */
public class DecimalaBinario {
    public String aBinario(int n) {
    if (n == 0) return ""; // caso base, ahí se corta la vuelta [cite: 51]
    return aBinario(n / 2) + (n % 2); // caso recursivo, seguimos con la vuelta [cite: 54, 55]
}
 
    public static void main(String[] args) {
        DecimalaBinario decimalaBinario = new DecimalaBinario();
        int n = 1101; // el número puede variar según lo que se quiera convertir, parcero
        String resultado = decimalaBinario.aBinario(n);
        System.out.println("El número " + n + " en binario es: " + resultado);
    }

}
