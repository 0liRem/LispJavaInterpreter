public class FuncionAtom implements ReservedFunciones {

    @Override
    public void execute() {
        if (Controlador.linea == null) {
            System.out.println("La línea leída está vacía");
        } 
        else {
            String argumento = obtenerArgumento(Controlador.linea);
            String esAtomo = esAtomo(argumento);
            System.out.println(esAtomo);
        }
    }

    
    private String obtenerArgumento(String linea) {
        // se busca el paréntisis de apertura
        int inicio = linea.indexOf('(');
        if (inicio != -1) {
            // encontrar la posición del 1er espacio después del (
            int espacio = linea.indexOf(' ', inicio);
            if (espacio != -1) {
                // encontrar la posición del 1er )  después del 1er espacio
                int fin = linea.indexOf(')', espacio);
                if (fin != -1) {
                    // return la subcadena entre el primer espacio y el primer )
                    return linea.substring(espacio + 1, fin);
                }
            }
        }
        // si no se encuentra return una cadena vacía
        return "";
    }
    
    
    

    
    private String esAtomo(String cadena) {

        // se muestra error si está sin argumento
        if (cadena.trim().isEmpty()){
            throw new IllegalArgumentException("El argumento no puede estar vacío");
        }

        // ver si es un número
        try {
            Double.parseDouble(cadena);
            // true si sí es átomo
            return "t"; 
        }catch (NumberFormatException e) {
            // falso/nil si no es átomo
            if (cadena.isEmpty() || cadena.contains(" ")) {
                return "nil";
            } else {
                return "t";
            }
        }
    }
    
}
