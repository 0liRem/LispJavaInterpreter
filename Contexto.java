//EL CONTEXTO EXISTE PARA GUARDAR FUNCIONES, VARIABLES, ETC, EN DETERMINADO MOMENTO SIRVE PARA LAS FUNCIONES RECURSIVAS O EL SETQ

import java.util.HashMap;
import java.util.Map;

public class Contexto {
        private Map<String, String> variables = new HashMap<>();

    public void setVariable(String nombre, String valor) {
        variables.put(nombre, valor);
    }
    
    public String getVariable(String name) {
        return variables.getOrDefault(name, "VariableInexistente");
    }    

    // Método para clonar el contexto actual, el cual se utilizara para llamar funciones
    public Contexto clone() {
        Contexto NuevoContexto = new Contexto();
        NuevoContexto.variables.putAll(this.variables);
        return NuevoContexto;
    }
}
