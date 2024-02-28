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

// POP. Obtiene el siguiente valor en la pila y regresa un espacio.
public T pop() {
    if (firstNode != null) {
        T value = firstNode.getvalue();
        firstNode = firstNode.getNext();
        length--;
        return value;
    }
    throw new RuntimeException("Stack underflow");
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
