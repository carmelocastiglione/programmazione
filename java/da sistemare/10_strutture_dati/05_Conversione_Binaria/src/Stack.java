import java.util.Vector;

public class Stack {

    private Vector<Object> v;

    public Stack() {
        v = new Vector<Object>();
    }

    // Pushes an item onto the top of this stack.
    public void push(Object o) {
        v.addElement(o);
    }

    // Return the number of elements on this stack.
    public int size() {
        return v.size();
    }

    // Looks at the object at the top of this stack without removing it from the stack.
    public Object top() {
        int size = v.size();
        Object o = null;
        if (size > 0) {
            o = (Object) v.elementAt(size-1);
        }
        return o;
    }

    // Removes the object at the top of this stack and returns that object as the value of this function.
    public Object pop() {
        int size = v.size();
        Object o = null;
        if (size > 0) {
            o = (Object) v.elementAt(size-1);
            v.removeElementAt(size-1);
        }
        return o;
    }

    // Tests if this stack is empty.
    public boolean isEmpty() {
        if (v.size() > 0) {
            return false;
        } else {
            return true;
        }
    }

}