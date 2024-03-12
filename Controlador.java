
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;


public class Controlador {
    private PrefixEvaluador operaciones = new PrefixEvaluador();
    private Map<String, Defunc> mapfunc = new HashMap<>();
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
        String cuerpo="";
        String dato="";
        File archivo = new File(arch);

         // Verificar si el archivo existe
        try {
            FileReader fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            System.out.println("\nSe ha abierto con exito el archivo.");
            // Leer la expresión prefix del archivo
            boolean indefun=false;
            int oppar=0;
            
            while ((linea = br.readLine()) != null) {
                linea=linea.toLowerCase();
                linea=linea.trim();


                if (indefun){
                    
                    cuerpo=cuerpo+"\n"+linea;

                    oppar+=linea.chars().filter(ch ->ch=='(').count();
                    oppar-=linea.chars().filter(ch->ch==')').count();
                    if (oppar<=0){

                        definidor(dato+" "+cuerpo);
                        indefun=false;
                    }
                }
                else{                

                    if(linea.startsWith(";")){
                        //es un comentario así que lo devuelve
                        System.out.println("Comentario: "+linea);
                        }
                    if(linea.startsWith("(defun")){
                        //definidor(linea);
                        //System.out.println("Funcion definida");
                        oppar+=linea.chars().filter(ch ->ch=='(').count();
                        oppar-=linea.chars().filter(ch->ch==')').count();
                        indefun=true;
                        dato=linea;
                        }
                    
                    // EVALUAR QUOTE
                    if(linea.startsWith("quote")){
                        diccionario.getFunciones("QUOTE");
                    }
                    // EVALUAR ATOM
                    if(linea.startsWith("(atom")){
                        diccionario.getFunciones("ATOM");
                    }
                    // EVALUAR LIST
                    if(linea.startsWith("(list")){
                        diccionario.getFunciones("LIST");
                    }
                    // EVALUAR EQUAL
                    if(linea.startsWith("(equal")){
                        diccionario.getFunciones("EQUAL");
                    }
                
                    else if (linea.startsWith("arch")){
                        Double resultado = operaciones.EvaluationPrefix(linea.trim());
                        // Mostrar el resultado
                        System.out.println("\nEl resultado es: " + resultado);
                        }
                    
                    String nombFuncion=obtenerNombre(linea);
                    if (mapfunc.containsKey(nombFuncion)){
                        evaluarfuncion(linea, null);
                        //Se llamara un validador de funcion para verificar que todo es legal, luego ira linea por linea del cuerpo de la funcion ejecutando las instrucciones
                        //para lo que hay que adaptar la clase archivo para que se puede llamar, para esto recomiendo que se valide si se esta leyendo la instruccion 
                }
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
    //Define funciones
    private void definidor(String datos) {
        //(Defun
        String SinDefuncion = datos.substring(6, datos.length() - 1).trim();  //Obtiene los datos del defun, eliminando el defun al saber que son el string de 0 a 5 iniciando en el 6
        String[] Arr = SinDefuncion.split("\\s+", 3); //Separa en partes la funcion, por nombre y variables
        String NombreFuncion = Arr[0];
        List<String> varibales = Arrays.asList(Arr[1].replaceAll("[()]", "").split("\\s+")); //Elimina los parentesis de la funcion
        String cuerpo=Arr[2];//obtiene el cuerpo de la funcion
        mapfunc.put(NombreFuncion, new Defunc(varibales, cuerpo)); //Crea un nuevo defunc con el nombre de la funcion que creamos, mandando los parametros y el cuerpo de la funcion

    }
    //Funcion que obtiene el nombre de una funcion obteniendolo cada linea del archivo, sirve para verificar si se llama una funcion
    private String obtenerNombre(String nombre) {
        int espacio = nombre.indexOf(' ');
        return espacio != -1 ? nombre.substring(1, espacio) : "";
    }


    //Menú de procesos utilizado dentro de la función, para poder realizar los procesos recursivos sin el problema de estar en un archivo
    public String evaluador(String expression, Contexto context) throws Exception{
        System.out.println("a");
        return("a");
    }

    //Sirve para validar si se llama de manera correcta una función
    private String evaluarfuncion(String nombre, Contexto contexto) throws Exception{
        String fnombre = obtenerNombre(nombre);
        Defunc pfunc = mapfunc.get(fnombre);
        String argsStr = nombre.substring(fnombre.length()+1).trim().replace(")","");
        List<String> argumento = SepararArgumento(argsStr); //crea una lista con los argumentos separados
        Contexto funcontexto = new Contexto();//crea un nuevo contexto para la funcion
        List<String> parametro = pfunc.getparametros(); //obtiene los parametros de la funcion 

        if (argumento.size() != parametro.size()) { //valida que se haya mandado la misma cantidad de argumentos que de variables
            throw new IllegalArgumentException("Error, cantidad de argumentos y parametros no conciden");
        }

        for (int i = 0; i < argumento.size(); i++) {//va a evaluar cada linea del cuerpo yendo linea por linea teniendo como parametro el contexto actual, para las funciones recursivas
            String valorargumento = evaluador(argumento.get(i), contexto);//va a buscar el valor del argumento mandado
            System.out.println(argumento.get(i));
            funcontexto.setVariable(parametro.get(i), valorargumento); //va a establecer el valor del argumento como el del parametro
        }
        //va a realizar las lineas de texto dadas en el evaluador
        return evaluador(pfunc.getcuerpo(), funcontexto);//regresa el resultado obtenido


    }

    //Separa los argumentos de una función para poder empezar a trabajar con ellos
    private List<String> SepararArgumento(String argumento) {
        List<String> arguments = new ArrayList<>();//arreglo para guardar los argumentos
        int inicio = 0;
        int opcont = 0;
        for (int i = 0; i < argumento.length(); i++) {
            char c = argumento.charAt(i);
            if (c == '(') opcont++;
            if (c == ')') opcont--;
            boolean isSpace = c == ' ';//revisa que el caracter sea espacio, si lo es se elimina el espacio
            if ((isSpace && opcont == 0) || i == argumento.length() - 1) {
                String arg = argumento.substring(inicio, (isSpace ? i : i + 1)).trim();
                if (!arg.isEmpty()) {
                    arguments.add(arg);//se añaden los argumentos
                }
                inicio = i + 1;
            }
        }
        return arguments;
    }



    
        
    
    
}
