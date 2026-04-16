/**
 * archivo: mcd
 * este archivo calcula el máximo común divisor por recursión, bien bacano.
 */
public class MCD {
    public int mcd(int a, int b) {
    if (b == 0) return a; // caso base, ahí se acaba la vuelta [cite: 70]
    return mcd(b, a % b); // algoritmo de euclides, pues [cite: 67, 70]
}
 
    public static void main(String[] args) {
        MCD mcd = new MCD();
        int a = 48; // el número puede variar según lo que se quiera calcular, parce
        int b = 18; // el número puede variar según lo que se quiera calcular, pues
        int resultado = mcd.mcd(a, b);
        System.out.println("El MCD de " + a + " y " + b + " es: " + resultado);
    }

}
