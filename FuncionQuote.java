public class FuncionQuote implements ReservedFunciones{

    @Override
    public void execute() {
        if(Controlador.linea == null){
            System.out.println(" nopa");
        }
        else{
            System.out.println(Controlador.linea);
        }
        
    }
    
}
