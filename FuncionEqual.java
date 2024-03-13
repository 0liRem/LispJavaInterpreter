import java.util.ArrayList;
import java.util.List;

public class FuncionEqual implements ReservedFunciones {
    /*
     * Clase que representa la función equal de lenguaje.
     */
    @Override
    public void execute() {
        String argumentos = obtainElements(Controlador.linea);

        List<String> elementos = analizeData(argumentos);

        // comprobar si al menos se tiene 2 elementos para comparar
        if(elementos.size() >= 2 ){
            // ver si son todos iguales
            boolean allSame = true;

            // para no tomar en cuenta el equal al comparar, se salta al segundo
            int firstInicio = 0;
            if(elementos.get(0).equals("equal")){
                // si solo hay un elemento luego del equal mostrar una excepción
                if( elementos.size() == 2){
                    throw new IllegalArgumentException("Falta de argumentos");
                }

                firstInicio = 1;
            }

            for(int num = firstInicio + 1; num < elementos.size(); num++){

                String elementoActual = elementos.get(num);
                String elementoBack = elementos.get(num - 1);

                if( !sonIguales(elementoBack, elementoActual) ){
                    allSame = false;
                    break;
                }
            }

            // resultado
            if(allSame){
                System.out.println("true");
            } 
            else {
                System.out.println("false");
            }
        } 
        else{
            // si no hay mínimo 2
            throw new IllegalArgumentException("Falta de argumentos");
        }
    }

    private String obtainElements(String linea) {
        int first = linea.indexOf('(');

        if (first != -1) {
            int fin = linea.lastIndexOf(')');
            
            if(fin != -1){
                return linea.substring(first + 1, fin);
            }
        }

        return "";
    }

    private List<String> analizeData(String argumentos) {
        List<String> lista = new ArrayList<>();
        StringBuilder elemento = new StringBuilder();
        boolean entreComillas = false;
    boolean elEscape = false;

        for (char separador : argumentos.toCharArray()) {
            if (separador == '\\' && !elEscape) {
                elEscape = true;
                continue;
            }

            if (separador == '"' && !elEscape) {
                entreComillas = !entreComillas;
            }

            if(separador == ' ' && !entreComillas){
                if( elemento.length() > 0 ){
                    lista.add(elemento.toString());
                    elemento.setLength(0);
                }
            } 
            else{
                elemento.append(separador);
            }

            elEscape = false;
        }

        if( elemento.length() > 0) {
            lista.add(elemento.toString());
        }

        return lista;
    }

    // ver si son iguales los  dos argumentos
    private boolean sonIguales(String elemento1, String elemento2) {
        return elemento1.equals(elemento2);
    }
}
