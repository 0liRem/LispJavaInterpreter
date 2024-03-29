import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import org.junit.*;

public class JUnitTestingLisp {
Diccionario diccionario = new Diccionario();

   @Test
   public void comprobarAtom(){
     FuncionAtom funcionAtom = new FuncionAtom();
     String assertAtom= "t";
     String entrada = "(atom 123)";
     entrada = funcionAtom.ontainArgument(entrada);
     assertEquals(assertAtom,funcionAtom.isAtom(entrada));
     System.out.println(entrada);
   }

   @Test
    public void comprobaList() {
    FuncionList funcionList = new FuncionList();
    List<String> assertList = Arrays.asList("1", "2", "3", "4");
    String entrada = "(list 1 2 3 4)";
    entrada = funcionList.obtainArgumentos(entrada);
    List<String> elements = funcionList.analizeData(entrada);

    assertEquals(assertList, elements); 
}

@Test
    public void comprobaQuote() {
    FuncionQuote funcionQuote = new FuncionQuote();
    String assertQuote = "QUOTE((* 3 2))";
    Controlador.linea = "QUOTE((* 3 2))";
    if(Controlador.linea.startsWith("QUOTE")){
      diccionario.getFunciones("QUOTE");
  }
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream customOut = new PrintStream(outputStream);
    PrintStream originalOut = System.out;
    System.setOut(customOut);
    
    funcionQuote.execute();
    
    System.setOut(originalOut);
    String entrada = outputStream.toString().trim(); // Se obtiene la salida recién capturada
    
    assertEquals(assertQuote, entrada);
}

@Test
    public void comprobaEqualResultadoCorrecto() {
    FuncionEqual funcionEqual = new FuncionEqual();
    String assertEqual = "true";
    Controlador.linea = "(equal z z)";
    if(Controlador.linea.startsWith("(equal")){
      diccionario.getFunciones("EQUAL");
  }
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream customOut = new PrintStream(outputStream);
    PrintStream originalOut = System.out;
    System.setOut(customOut);
    
    funcionEqual.execute();
    
    System.setOut(originalOut);
    String entrada = outputStream.toString().trim(); // Se obtiene la salida recién capturada
    
    assertEquals(assertEqual, entrada); 
}
@Test
    public void comprobaEqualResultadoIncorrecto() {    //Se espera un resultado incorrecto, pues se darán como parámetros valores no iguales.
    FuncionEqual funcionEqual = new FuncionEqual();
    String assertEqual = "true";
    Controlador.linea = "(equal 7 10)";
    if(Controlador.linea.startsWith("(equal")){
      diccionario.getFunciones("EQUAL");
  }
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream customOut = new PrintStream(outputStream);
    PrintStream originalOut = System.out;
    System.setOut(customOut);
    
    funcionEqual.execute();
    
    System.setOut(originalOut);
    String entrada = outputStream.toString().trim(); // Se obtiene la salida recién capturada
    
    assertEquals(assertEqual, entrada);   //Se obtiene el error esperado. 
}
}

