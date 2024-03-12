public class FuncionQuote implements ReservedFunciones{

    @Override
    public void execute() {
        if(Controlador.linea == null){
            System.out.println("La linea leída esta vacía");
        }
        else{
            System.out.println(Controlador.linea);
        }
        
    }
    
}
