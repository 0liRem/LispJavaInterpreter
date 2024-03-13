public class FuncionSetQ implements ReservedFunciones {
    private Contexto contexto;

    // se recibe el contexto como parámetro
    public FuncionSetQ(Contexto contexto){
        this.contexto = contexto;
    }

    /*
     * Clase que representa la función setq de lenguaje.
     */
    @Override
    public void execute() {
        // datos de la lista
        String datos = getArgumentos(Controlador.linea);
        // separar el nombre de la variable y el valor de esta
        String[] partes = datos.split("\\s+", 3);
        if (partes.length == 3 && partes[0].equals("setq")) {

            String nombreVariable = partes[1];
            String valorVariable = partes[2];
            contexto.setVariable(nombreVariable, valorVariable);


            //String valorAsignado = contexto.getVariable(nombreVariable);
            //System.out.println("El valor de " + nombreVariable + " es: " + valorAsignado);


            // poner variable en contexto 
            contexto.setVariable(partes[0], partes[1]);
        }
        else{
            throw new IllegalArgumentException("Error: Falta el valor de la variable.");
        }
    }

    // sacar los argumentos de la línea
    private String getArgumentos(String linea){
        int inicio = linea.indexOf('(');
        if (inicio != -1){
            int fin = linea.lastIndexOf(')');
            
            if (fin != -1){
                return linea.substring(inicio + 1, fin);
            }
        }
        return "";
    }

    
}
