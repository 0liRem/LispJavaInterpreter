
import java.util.List;

public class Defunc {
    private List<String> parametros;
    private String cuerpo;

    public Defunc(List<String> parametros, String cuerpo) {
        this.parametros = parametros;
        this.cuerpo = cuerpo;
    }

    public List<String> getparametros() {
        return parametros;
    }

    public String getcuerpo() {
        return cuerpo;
    }


}
