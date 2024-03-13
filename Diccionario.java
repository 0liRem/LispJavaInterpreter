import java.util.HashMap;
import java.util.Map;

public class Diccionario {
    private Map<String, Runnable> reservedFunciones = new HashMap<>();

    FuncionAtom funcionAtom = new FuncionAtom();
    FuncionQuote funcionQuote = new FuncionQuote();
    FuncionList funcionList = new FuncionList();
    FuncionEqual funcionEqual = new FuncionEqual();
    FuncionSetQ funcionSetQ = new FuncionSetQ();
    FuncionMenorQue funcionMenorQue = new FuncionMenorQue();
    FuncionMayorQue funcionMayorQue = new FuncionMayorQue();
    FuncionCaracter funcionCaracter = new FuncionCaracter();
    FuncionFormat funcionFormat = new FuncionFormat();
    FuncionCond funcionCond = new FuncionCond();

    public Diccionario() {        

        // palabras reservadas y sus respectivas funciones asociadas
        reservedFunciones.put("ATOM", ()-> funcionAtom.execute());
        reservedFunciones.put("LIST", ()-> funcionList.execute());
        reservedFunciones.put("EQUAL", ()-> funcionEqual.execute());
        reservedFunciones.put("SETQ", ()-> funcionSetQ.execute());
        reservedFunciones.put("<", ()-> funcionMenorQue.execute());
        reservedFunciones.put(">", ()-> funcionMayorQue.execute());
        reservedFunciones.put("CAR", ()-> funcionCaracter.execute());
        reservedFunciones.put("format", ()-> funcionFormat.execute());
        reservedFunciones.put("QUOTE", ()-> funcionQuote.execute());
        reservedFunciones.put("COND", ()-> funcionCond.execute());

    }

    public void getFunciones(String keyword) {
        reservedFunciones.get(keyword).run();
    }

}
