public class FuncionQuote implements ReservedFunciones{

    @Override
    public void execute() {
        if(Controlador.linea == null){
            System.out.println("La linea leída esta vacía");
        }
        else{
            int inicio = Controlador.linea.indexOf('(');
            if (inicio != -1){
                int last = Controlador.linea.lastIndexOf(')');
            if(last != -1){
                String algo = Controlador.linea.substring(inicio + 1, last);
                System.out.println(algo);   
            }
        }   
        }   
    }
}
