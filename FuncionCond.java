import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FuncionCond implements ReservedFunciones {
    /*
     * Clase que representa la función cond de lenguaje.
     */
    @Override
    public void execute() {
        System.out.println(Controlador.linea);
        boolean result = evaluateLispExpression(Controlador.linea);
        //String argumentos = obtainArgumentos(Controlador.linea);
        
    }

    public static boolean evaluateLispExpression(String expression) {
        
        Stack<String> stack = new Stack<>();
     
        String[] tokens = expression.split(" ");
        

        for (int i = tokens.length - 1; i >= 0; i--) {
            stack.push(tokens[i]);
            System.out.println(tokens[i]);
        }
        System.out.println(stack);

        return evaluateExpression(stack);

    }

    private static boolean evaluateExpression(Stack<String> stack) {
        System.out.println("a");
        if (stack.empty()) {
            throw new IllegalArgumentException("Expresión inválida");
        }
        System.out.println("b");

        String token = stack.pop();
        System.out.println(token);

        if (token.trim().substring(1).equalsIgnoreCase("cond")) {
            System.out.println(token);
            return evaluateCondExpression(stack);
        } else if (token.equals("(")) {
            System.out.println(token);
            return evaluateExpression(stack);
        } else {
            System.out.println("WTF");
            throw new IllegalArgumentException("Operador desconocido: " + token);
        }
        
    }

    private static boolean evaluateCondExpression(Stack<String> stack) {
        while (!stack.empty()) {
            String conditionToken = stack.pop();
            if (conditionToken.equals("(")) {
                return evaluateExpression(stack);
            } else {
                Predicate<Boolean> condition = result -> result;
                boolean result = condition.test(Boolean.parseBoolean(conditionToken));

                if (result) {
                    System.out.println("true peteeeee");
                    return true;
                    
                }
            }
        }

        throw new IllegalArgumentException("COND mal formado");
    }
    
}
