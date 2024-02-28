public class PrefixEvaluador {
    
    public Double EvaluationPrefix(String Datos) {
        //3. parameterized with Integer
        Stack<Double> pila = new Stack<>();
        Stack<String> pila2 = new Stack<>();
        for(int i=0; i<Datos.length(); i++ ){ pila2.push(Character.toString(Datos.charAt(i)));}
        while (!pila2.empty()) {
            String e = pila2.pop();
            //4. arithmetic sign comparison to string instead 
            //of character
            if (e.equals("+")) {
                pila.push(pila.pop() + pila.pop());
            } else if (e.equals("-")) {
               pila.push(pila.pop() - pila.pop());
            } else if (e.equals("*")) {
               pila.push(pila.pop() * pila.pop());
            } else if (e.equals("/")) {
               pila.push(pila.pop() / pila.pop());
            } else {
               pila.push(Double.valueOf(e));
            }
        }

        return pila.pop();
    }
}
