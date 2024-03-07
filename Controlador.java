
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controlador {
    private PrefixEvaluador operaciones = new PrefixEvaluador();
    private Map<String, Defunc> funcion = new HashMap<>();
    FileReader fr = null;
    BufferedReader br = null;
    public static String linea = null;
    // Operations operador = new Operations();
    Stack<Double> pila = new Stack<>();

    Diccionario diccionario = new Diccionario();
    
    double resultado, numero;

    /**
     * Metodo que permite realizar un archivo de texto en la pantalla.
     * 
     * @param arch - El archivo que haya recibido
     * @throws Exception
     */
    public void archivos(String arch) throws Exception {
        BufferedReader br = null;
        try {
            File archivo = new File(arch);
            FileReader fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            System.out.println("\nSe ha abierto con exito el archivo.");
            // Leer la expresión prefix del archivo

            while ((linea = br.readLine()) != null) {
                linea=linea.toLowerCase();
                linea=linea.trim();
                if(linea.startsWith(";")){
                    //es un comentario así que lo devuelve
                    System.out.println("Comentario: "+linea);
                }
                if(linea.startsWith("(defun")){
                    definidor(linea);
                    System.out.println("Funcion definida");
                }
                if(linea.startsWith("quote")){
                    diccionario.getFunciones("QUOTE");
                }
                else if (linea.startsWith("arch")){
                    Double resultado = operaciones.EvaluationPrefix(linea.trim());
                    // Mostrar el resultado
                    System.out.println("\nEl resultado es: " + resultado);
                }

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
    private void definidor(String datos) {
        //(Defun
        String SinDefuncion = datos.substring(6, datos.length() - 1).trim();  //Obtiene los datos del defun, eliminando el defun al saber que son el string de 0 a 5 iniciando en el 6
        String[] Arr = SinDefuncion.split("\\s+", 3); //Separa en partes la funcion, por nombre y variables
        String NombreFuncion = Arr[0];
        List<String> parametros = Arrays.asList(Arr[1].replaceAll("[()]", " ").split("\\s+")); //Elimina los parentesis de la funcion
        String cuerpo = Arr[2]; //Obtiene el cuerpo de la funcion
        System.out.println(SinDefuncion);
        System.out.println(cuerpo);
        funcion.put(NombreFuncion, new Defunc(parametros, cuerpo)); //Crea un nuevo defunc con el nombre de la funcion que creamos, mandando los parametros y el cuerpo de la funcion
        }

    }

