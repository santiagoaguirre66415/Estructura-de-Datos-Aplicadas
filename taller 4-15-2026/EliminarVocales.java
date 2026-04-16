/**
 * archivo: eliminarvocales
 * este archivo elimina las vocales de una cadena por recursión.
 */
public class EliminarVocales {
    public String sinVocales(String s) {
    if (s.isEmpty()) return ""; 
    char c = s.toLowerCase().charAt(0);
    boolean esVocal = "aeiou".indexOf(c) != -1;
    if (esVocal) return sinVocales(s.substring(1));
    return s.charAt(0) + sinVocales(s.substring(1)); // [cite: 65, 66]
}
public static void main(String[] args) {
    EliminarVocales eliminar = new EliminarVocales();
    String s = "Escuela"; // el string puede variar según lo que se quiera modificar
    String resultado = eliminar.sinVocales(s);
    System.out.println("El string sin vocales es: \"" + resultado + "\".");
}

}
