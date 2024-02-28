
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import java.util.ArrayList;

public class Controlador {
    FileReader fr = null;
    BufferedReader br = null;
    String linea = null;
    Operations operador = new Operations();
    Stack<Double> pila = new Stack<>();

    double resultado, numero;
    /**
    * Metodo que permite realizar un archivo de texto en la pantalla.
    * 
    * @param arch - El archivo que haya recibido
    */
    public void archivos(String arch){
        try {
            //Cargamos el archivo de la ruta relativa
            File archivo = new File(arch);
            //Cargamos el objeto FileReader
            fr = new FileReader(archivo);
            //Creamos un buffer de lectura
            br = new BufferedReader(fr);
            System.out.println("Se ha abierto con exito");
                    ArrayList<String> dat=new ArrayList<>();
            // Devuelve el separador para el separador.
            while ((linea = br.readLine()) != null) {

            //Utilizamos el separador para los datos

            dat.add(linea.toString());
            }
            String Datos=dat.toString();
            //InfixToPosfix infix=new InfixToPosfix();
            Datos=Datos.replace("]" , "");
            Datos=Datos.replace("[","");
            Datos=Datos.replace(" ", "");
            System.out.println(Datos);
            PrefixEvaluador pre=new PrefixEvaluador();
            System.out.println("El resultado es: " + pre.EvaluationPrefix(Datos));
            
                
            
            //System.out.println("El resultado es: " + resultado);

        } catch (Exception e) {
            throw new RuntimeException("Archivo No Encontrado");
    }


}
}

