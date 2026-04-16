/**
 * archivo: sumanpares
 * este archivo suma los primeros n números pares por recursión, parcero.
 */
public class SumaNpares {
    public int sumaPares(int n) {
    if (n == 0) return 0;
    return (2 * n) + sumaPares(n - 1);
}
 
    public static void main(String[] args) {
        SumaNpares suma = new SumaNpares();
        int n = 4; // el número puede variar según lo que se quiera calcular, pues
        int resultado = suma.sumaPares(n);
        System.out.println("La suma de los primeros " + n + " números pares es: " + resultado);
    }

}
