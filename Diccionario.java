import java.util.HashMap;
import java.util.Map;

public class Diccionario {
    private Map<String, ReservedFunciones> reservedFunciones;

    public Diccionario() {
        reservedFunciones = new HashMap<>();

        // palabras reservadas y sus respectivas funciones asociadas
        reservedFunciones.put("ATOM", new FuncionAtom());
        reservedFunciones.put("LIST", new FuncionList());
        reservedFunciones.put("EQUAL", new FuncionEqual());
        reservedFunciones.put("SETQ", new FuncionSetQ());
        reservedFunciones.put("<", new FuncionMenorQue());
        reservedFunciones.put(">", new FuncionMayorQue());
        reservedFunciones.put("CAR", new FuncionCaracter());
        reservedFunciones.put("format", new FuncionFormat());

    }

    public ReservedFunciones getFunciones(String keyword) {
        return this.reservedFunciones.get(keyword);

    }

}
