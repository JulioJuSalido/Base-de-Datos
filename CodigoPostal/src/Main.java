import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
// JULIO CÉSAR JU SALIDO
public class Main {
    public static void main(String[] args) {
        String rutaArchivo = "C:\\\\Users\\\\juli0\\\\IdeaProjects\\\\CodigoPostal\\\\codigos_postales_hmo.csv"; // Cambia por la ruta real en tu PC
        String linea; // Variable que guarda cada linea del archivo
        Map<String, Integer> conteoCP = new HashMap<>(); // Mapa para almacenar el codigo postal y asentamientos

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) { // Se usa try para cerrar el archivo al terminar

            boolean primeraLinea = true;

            while ((linea = br.readLine()) != null) { // Permite leer linea por linea
                // Si es la primera línea, se salta porque es el encabezado
                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }


                String[] datos = linea.split(",", -1); // Dividimos la línea usando la coma como separador

                if (datos.length >= 2) { // Aseguramos que haya al menos dos columnas (CP y colonia)
                    String codigoPostal = datos[0].trim(); // Código Postal en la primera columna


                    conteoCP.put(codigoPostal, conteoCP.getOrDefault(codigoPostal, 0) + 1); // Con esto se incrementa el conteo de colonias para este Código Postal
                }
            }


            for (Map.Entry<String, Integer> entry : conteoCP.entrySet()) { // Con este se recorre el mapa y se enseñan resultados
                System.out.println(entry.getKey() + " tiene " + entry.getValue() + " asentamientos");
            }

        } catch (IOException e) {
            e.printStackTrace(); // Por si ocurre error al leer el archivo
        }
    }
}