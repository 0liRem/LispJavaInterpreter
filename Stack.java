public class Stack <T>{
    private node<T> lastNode;
    private node<T> firstNode;
    private int length=0;


// PUSH. Inserta a la pila un nuevo valor en la última posición del STACK.
public void push(T value) {
    if (lastNode == null){
        lastNode = new node<T>(value);
        firstNode = lastNode;
    }else{
        node<T> current = new node<T>(value);
        current.setnext(firstNode);
        firstNode = current;
    }
    length++;
}

public T pop() {
    if (firstNode != null) { // Si existe algún nodo creado
        T value = firstNode.getvalue();
        firstNode = firstNode.getNext();
        return value;
    }
    return null; // Si aún no existe nodo creado previamente.
}

public boolean empty(){
    return length==0;
}   
public int size(){
    return length;
}
public T ver(){
    if (empty()){
        throw new RuntimeException("Stack underflow");
    }
    return firstNode.getvalue();
}

}
