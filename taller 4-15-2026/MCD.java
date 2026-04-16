/**
 * archivo: mcd
 * calcula el máximo común divisor por recursión.
 */
public class MCD {
    public int mcd(int a, int b) {
    if (b == 0) return a; // caso base [cite: 70]
    return mcd(b, a % b); // algoritmo de euclides [cite: 67, 70]
}
 
    public static void main(String[] args) {
        MCD mcd = new MCD();
        int a = 48; // el número puede variar según lo que se quiera calcular
        int b = 18; // el número puede variar según lo que se quiera calcular
        int resultado = mcd.mcd(a, b);
        System.out.println("El MCD de " + a + " y " + b + " es: " + resultado);
    }

}
