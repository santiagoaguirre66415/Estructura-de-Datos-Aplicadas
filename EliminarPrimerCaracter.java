public class EliminarPrimerCaracter {
    public String eliminarPrimero(String texto, char letra) {
    if (texto.isEmpty()) return "";
    if (texto.charAt(0) == letra) return texto.substring(1);
    return texto.charAt(0) + eliminarPrimero(texto.substring(1), letra);
}
 
    public static void main(String[] args) {
        EliminarPrimerCaracter eliminar = new EliminarPrimerCaracter();
        String texto = "Manzana"; // El texto puede variar según lo que se quiera modificar
        char letra = 'a'; // La letra puede variar según lo que se quiera eliminar
        String resultado = eliminar.eliminarPrimero(texto, letra);
        System.out.println("El texto después de eliminar la primera aparición de '" + letra + "' es: \"" + resultado + "\".");
    }

}
