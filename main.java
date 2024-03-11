//
//                      DOCUMENTACION INTERNA
//
//   Nombre del programa: INTERPRETELISP.JAVA
//
//   Fin en Mente:
//              Utilizando java y los recursos dados por la Universidad Del Valle, se realizara un programa el cual sera capaz de interpretar el lenguaje LISP.
//        
//             
//   Programadores: Olivier Viau 23544
//                  Fabian Morales 23267
//                  Renato Rojas 23813
//                  Belen Monterroso 231497
//
//   Lenguaje: Java
//
//   Recursos:
//          https://www.geeksforgeeks.org/throw-throws-java/
//          https://docs.oracle.com/javase%2F7%2Fdocs%2Fapi%2F%2F/org/omg/CORBA/Context.html
//          ChatGpt3 para funciones regulares y validaciones
//
//   Historia de Modificaciones:
//
//            [000] 28/02/2024 Programa nuevo
//            [001] 29/02/2024 Validador de paréntesis
//            [002] 4/3/24  Ideas defunc
//            [003] 4/3/24  SetQ
//            [004] 5/3/24  palabras reservadas
//            [005] 7/3/24  Diccionario
//            [006] 8/3/24  Guardar funciones
//            [007] 8/3/24  Quote
//            [008] 11/3/24 List
//            [009] 11/3/24 Atom
//            [010] 11/3/24 Defunc completo 

public class main {
    public static void main(String[] args) throws Exception {
        Vista vista=new Vista();
        vista.menu();
    }
}
