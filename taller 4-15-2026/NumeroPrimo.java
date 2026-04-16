/**
 * archivo: numeroprimo
 * este archivo revisa si un número es primo por recursión, pues.
 */
public class NumeroPrimo {
    public boolean esPrimo(int n, int d) {
    if (d == 1) return true; // caso base, ahí ya quedó [cite: 74]
    if (n % d == 0) return false; 
    return esPrimo(n, d - 1); // seguimos bajando, pues [cite: 75]
}
 
    public static void main(String[] args) {
        NumeroPrimo numeroPrimo = new NumeroPrimo();
        int n = 7; // el número puede variar según lo que se quiera comprobar, parcero
        boolean resultado = numeroPrimo.esPrimo(n, n - 1);
        System.out.println("El número " + n + " es primo: " + resultado);
    }

}
