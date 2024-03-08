//EL CONTEXTO EXISTE PARA GUARDAR FUNCIONES, VARIABLES, ETC, EN DETERMINADO MOMENTO SIRVE PARA LAS FUNCIONES RECURSIVAS O EL SETQ

import java.util.HashMap;
import java.util.Map;

public class Contexto {
        private Map<String, String> variables = new HashMap<>();

    public void setVariable(String name, String value) {
        variables.put(name, value);
    }
    
    public String getVariable(String name) {
        return variables.getOrDefault(name, "NIL"); // Retorna "NIL" si la variable no existe
    }    

    // Método para clonar el contexto actual, útil para llamadas a funciones
    public Contexto clone() {
        Contexto newContext = new Contexto();
        newContext.variables.putAll(this.variables);
        return newContext;
    }
}
