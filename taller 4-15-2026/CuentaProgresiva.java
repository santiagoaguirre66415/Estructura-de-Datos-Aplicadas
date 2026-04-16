/**
 * archivo: cuentaprogresiva
 * este archivo hace una cuenta progresiva por recursión, así bien simple.
 */
public class CuentaProgresiva {
    public void cuenta(int n) {
    if (n == 0) return;
    cuenta(n - 1);
    System.out.println(n);
}
 
    public static void main(String[] args) {
        CuentaProgresiva cuenta = new CuentaProgresiva();
        int n = 5; // el número puede variar según lo que se quiera contar, pues
        System.out.println("Contando de 1 a " + n + ":");
        cuenta.cuenta(n);
    }

}
