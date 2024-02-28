public class node <T> {
    T value;
    node<T> next;

    public node(T val) {
        value = val;
        next = null;
    }

    public T getvalue() {
        return value;
    }

    public node<T> getNext() {
        return next;
    }

    public void setvalue(T newValue) {
        value = newValue;
    }

    public void setnext(node<T> n) {
        next = n;
    }

}
