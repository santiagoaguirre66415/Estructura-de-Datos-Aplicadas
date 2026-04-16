/**
 * archivo: contarletra
 * este archivo cuenta cuántas veces aparece una letra en un texto.
 */
public class ContarLetra {
    public int contarLetra(String texto, char letra) {
    if (texto.isEmpty()) return 0;
    int contador = (texto.charAt(0) == letra) ? 1 : 0;
    return contador + contarLetra(texto.substring(1), letra);
}
 
    public static void main(String[] args) {
        ContarLetra contar = new ContarLetra();
        String texto = "Banana"; // el texto puede variar según lo que se quiera contar
        char letra = 'a'; // la letra puede variar según lo que se quiera contar
        int resultado = contar.contarLetra(texto, letra);
        System.out.println("La letra '" + letra + "' aparece " + resultado + " veces en el texto \"" + texto + "\".");
    }

}
