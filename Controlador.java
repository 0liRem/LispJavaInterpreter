
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import java.util.ArrayList;

public class Controlador {
    FileReader fr = null;
    BufferedReader br = null;
    String linea = null;
    //Operations operador = new Operations();
    Stack<Double> pila = new Stack<>();

    double resultado, numero;
    /**
    * Metodo que permite realizar un archivo de texto en la pantalla.
    * 
    * @param arch - El archivo que haya recibido
     * @throws Exception 
    */
    public void archivos(String arch) throws Exception{
        BufferedReader br = null;
        try {
            File archivo = new File(arch);
            FileReader fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            System.out.println("Se ha abierto con exito");
            // Leer la expresión prefix del archivo
            
            while ((linea=br.readLine()) != null) {
                // Se crea una instancia de PrefixEvaluador
                PrefixEvaluador pre = new PrefixEvaluador();
                // Evaluar la expresión prefix
                Double resultado = pre.EvaluationPrefix(linea.trim());
                // Mostrar el resultado
                System.out.println("El resultado es: " + resultado);
            } 
        } catch (Exception e) {
            throw e;
        } finally {
            // Cerrar el BufferedReader
            if (br != null) {
                br.close();
            }
        }
    }
}

