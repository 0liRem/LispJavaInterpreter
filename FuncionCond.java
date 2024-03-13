import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class FuncionCond implements ReservedFunciones {
    
    /*
     * Clase que representa la función cond de lenguaje.
     */
    @Override
    public void execute() {

        System.out.println(Controlador.linea);

      

        String lineaCOND = Controlador.linea;  
        if (funcionCOND(lineaCOND)){
            System.out.println("El resultado es Verdadero");
        } else {
            System.out.println("El resultado es Falso");
        }
        
    }

    private boolean funcionCOND(String pSentencia) {
  
        
        // Separando al linea de sentencia en sus partes
        String[] v_partesSentencia = pSentencia.replaceAll("\\(|\\)", "").split("\\s+");        

        // el operador actual de una condicion está en la posicion 1
        // y los operandos del operador binario estan en la posicion 2 y 3 del array
        if (v_partesSentencia[1].equals("equal")){
            if (Double.parseDouble(v_partesSentencia[2]) == Double.parseDouble(v_partesSentencia[3])){
                boolean v_regresa = true;
                return v_regresa;
            } else{
                boolean v_regresa = false;
                return v_regresa;
            }
                

            
        } else {
            boolean v_regresa = v_partesSentencia[1].equals(">") ? Double.parseDouble(v_partesSentencia[2]) > Double.parseDouble(v_partesSentencia[3]) : Double.parseDouble(v_partesSentencia[2]) < Double.parseDouble(v_partesSentencia[3]);
            return v_regresa;
    }

        
    } 

}