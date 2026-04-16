public class CuentaProgresiva {
    public void cuenta(int n) {
    if (n == 0) return;
    cuenta(n - 1);
    System.out.println(n);
}
 
    public static void main(String[] args) {
        CuentaProgresiva cuenta = new CuentaProgresiva();
        int n = 5; // El número puede variar según lo que se quiera contar
        System.out.println("Contando de 1 a " + n + ":");
        cuenta.cuenta(n);
    }

}
