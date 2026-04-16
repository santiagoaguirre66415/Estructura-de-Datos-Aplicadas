/**
 * archivo: decimalabinario
 * este archivo convierte un número decimal a binario por recursión.
 */
public class DecimalaBinario {
    public String aBinario(int n) {
    if (n == 0) return ""; // caso base [cite: 51]
    return aBinario(n / 2) + (n % 2); // caso recursivo [cite: 54, 55]
}
 
    public static void main(String[] args) {
        DecimalaBinario decimalaBinario = new DecimalaBinario();
        int n = 1101; // el número puede variar según lo que se quiera convertir
        String resultado = decimalaBinario.aBinario(n);
        System.out.println("El número " + n + " en binario es: " + resultado);
    }

}
