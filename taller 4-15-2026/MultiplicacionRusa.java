import java.util.Scanner;
public class MultiplicacionRusa {
    public int multiplicar(int a, int b) {
    if (b == 0) return 0;
    return a + multiplicar(a, b - 1);
}
 
    public static void main(String[] args) {
        MultiplicacionRusa multiplicacion = new MultiplicacionRusa();
        Scanner scanner = new java.util.Scanner(System.in);
        
        System.out.print("Ingrese el primer número: ");
        int a = scanner.nextInt();
        
        System.out.print("Ingrese el segundo número: ");
        int b = scanner.nextInt();
        
        int resultado = multiplicacion.multiplicar(a, b);
        System.out.println("El resultado de la multiplicación rusa es: " + resultado);
        
        
    }
 }

