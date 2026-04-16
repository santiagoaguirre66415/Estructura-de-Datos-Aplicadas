public class MCD {
    public int mcd(int a, int b) {
    if (b == 0) return a; // Caso base [cite: 70]
    return mcd(b, a % b); // Algoritmo de Euclides [cite: 67, 70]
}
 
    public static void main(String[] args) {
        MCD mcd = new MCD();
        int a = 48; // El número puede variar según lo que se quiera calcular
        int b = 18; // El número puede variar según lo que se quiera calcular
        int resultado = mcd.mcd(a, b);
        System.out.println("El MCD de " + a + " y " + b + " es: " + resultado);
    }

}
