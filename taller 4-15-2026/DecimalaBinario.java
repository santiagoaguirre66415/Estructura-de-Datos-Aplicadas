public class DecimalaBinario {
    public String aBinario(int n) {
    if (n == 0) return ""; // Caso base [cite: 51]
    return aBinario(n / 2) + (n % 2); // Caso recursivo [cite: 54, 55]
}
 
    public static void main(String[] args) {
        DecimalaBinario decimalaBinario = new DecimalaBinario();
        int n = 1101; // El número puede variar según lo que se quiera convertir
        String resultado = decimalaBinario.aBinario(n);
        System.out.println("El número " + n + " en binario es: " + resultado);
    }

}
