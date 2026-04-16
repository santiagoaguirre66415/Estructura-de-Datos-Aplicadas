public class NumeroPrimo {
    public boolean esPrimo(int n, int d) {
    if (d == 1) return true; // Caso base [cite: 74]
    if (n % d == 0) return false; 
    return esPrimo(n, d - 1); // Reducción [cite: 75]
}
 
    public static void main(String[] args) {
        NumeroPrimo numeroPrimo = new NumeroPrimo();
        int n = 7; // El número puede variar según lo que se quiera comprobar
        boolean resultado = numeroPrimo.esPrimo(n, n - 1);
        System.out.println("El número " + n + " es primo: " + resultado);
    }

}
