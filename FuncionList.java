import java.util.ArrayList;
import java.util.List;

public class FuncionList implements ReservedFunciones {
    /*
     * Clase que representa la función list de lenguaje.
     */
    @Override
    public void execute() {
        // se obtienen los arguemntos de la línea que se evalúa
        String argumentos = obtainArgumentos(Controlador.linea);

        // para cada elemento dentro del argumento
        List<String> elements = analizeData(argumentos);

        System.out.print("(");
        // mostrar los elements
        for(int count = 0; count < elements.size(); count++){
            if(count > 0){
                System.out.print(" ");
            }
            System.out.print(elements.get(count));
        }
        System.out.println(")");
    }

    // se sacan los argumentos
    private String obtainArgumentos(String line){
        int inicio = line.indexOf('(');

        if (inicio != -1){
            int last = line.lastIndexOf(')');

            if(last != -1){
                return line.substring(inicio + 1, last);
            }
        }
        return "";
    }

    // separar los elementos según su caso
    private List<String> analizeData(String argumentos) {
        List<String> lista = new ArrayList<>();
        StringBuilder element = new StringBuilder();

        boolean entreComillas = false; 
        boolean elEscape = false; // para los caracteres especiales como \, indica que no debería contarse como las comullas o el espacio en blanco

        for (char espaciador : argumentos.toCharArray()){

            // para  los que sean del Escape 
            if(espaciador == '\\' && !elEscape){
                elEscape = true;
                continue;
            }

            // si los elements están entre "" 
            if(espaciador == '"' && !elEscape){
                entreComillas = !entreComillas; // se actualiza cómo se encuentra entreComillas
            }

            // para cuando hay espacio pero no hay comillas - el element actual va a la lista
            if(espaciador == ' ' && !entreComillas){
                if(element.length() > 0){
                    lista.add(element.toString());
                    element.setLength(0);
                }
            } 
            else{
                element.append(espaciador);
                // se agrega el símbolo al elemento  actua
            }

            elEscape = false;
        }

        // si no está vacío, se  le añade al final de la lista
        if(element.length() > 0){
            lista.add(element.toString());
        }

        // se elimina el list
        if(!lista.isEmpty() &&  lista.get(0).equals("list")){
            lista.remove(0);
        }

        return lista;
    }
}
