import java.util.Vector;

public class Queue {

    private Vector<Object> v;

    public Queue() {
        v = new Vector<Object>();
    }

    // Add an object to the queue
    public void enqueue(Object o) {
        v.addElement(o);
    }

    // Return the number of elements on this queue
    public int size() {
        return v.size();
    }

    // Looks at the object at the beginning of the queue without removing it from the queue.
    public Object head() {
        int size = v.size();
        Object o = null;
        if (size > 0) {
            o = (Object) v.elementAt(0);
        }
        return o;
    }

    // Looks at the object at the end of the queue without removing it from the queue.
    public Object tail() {
        int size = v.size();
        Object o = null;
        if (size > 0) {
            o = (Object) v.elementAt(size-1);
        }
        return o;
    }

    // Removes the first object added to the queue and returns that object as the value of this function.
    public Object dequeue() {
        int size = v.size();
        Object o = null;
        if (size > 0) {
            o = (Object) v.elementAt(0);
            v.removeElementAt(0);
        }
        return o;
    }

    // Tests if this queue is empty.
    public boolean isEmpty() {
        if (v.size() > 0) {
            return false;
        } else {
            return true;
        }
    }

}