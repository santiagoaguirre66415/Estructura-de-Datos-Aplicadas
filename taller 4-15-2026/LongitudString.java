/**
 * archivo: longitudstring
 * este archivo calcula la longitud de un texto por recursión.
 */
public class LongitudString {
    public int longitud(String s) {
    if (s.isEmpty()) return 0;
    return 1 + longitud(s.substring(1));
}
 
    public static void main(String[] args) {
        LongitudString longitud = new LongitudString();
        String s = "Hola Mundo"; // el string puede variar según lo que se quiera medir
        int resultado = longitud.longitud(s);
        System.out.println("La longitud del string \"" + s + "\" es: " + resultado);
    }

}
