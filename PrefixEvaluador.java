import java.util.Stack;

public class PrefixEvaluador {

    public Double EvaluationPrefix(String data) {
        Stack<Double> stack = new Stack<>();

        // Dividir la cadena en tokens
        String[] tokens = data.trim().split("\\s*(\\(|\\)|\\s)\\s*");
        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];
            if (isOperator(token)) {
                // Realizar la operación y agregar el resultado a la pila
                Double secondOperand = stack.pop();
                Double firstOperand = stack.pop();
                Double result = performOperation(token, firstOperand, secondOperand);
                stack.push(result);
            } else {
                // Verificar si el token es un número antes de intentar convertirlo
                try {
                    Double number = Double.parseDouble(token);
                    stack.push(number);
                } catch (NumberFormatException e) {
                    // Ignorar paréntesis y otros caracteres no numéricos
                }
            }
        }

        if (stack.size() != 1) {
            throw new RuntimeException(
                    "\nError de evaluación: la pila no contiene un solo valor al final de la evaluación");
        }

        return stack.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private Double performOperation(String operator, Double operand1, Double operand2) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new ArithmeticException("\nError de evaluación: División por cero");
                }
                return operand2 / operand1;
            default:
                throw new IllegalArgumentException("\nOperador no válido: " + operator);
        }
    }
}
