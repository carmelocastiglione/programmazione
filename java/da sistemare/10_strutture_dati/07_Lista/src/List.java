public class List {
    private Node head;
    private Node tail;

    public List() {
        head = null;
        tail = null;
    }

    public void add(String obj) {
        Node node = new Node(obj);
        Node nextNode, currentNode;
        boolean added = false;
        // Se la lista è vuota
        if (head == null) {
            head = tail = node;
        } else {
            // Controllo se inserire in testa
            if (obj.compareTo((String) head.getData()) < 0) {
                node.setNext(head); 
                head = node; 
            } else {
                // Aggiungo un nodo in un punto della lista
                currentNode = head;
                nextNode = head.getNext();
                while (nextNode != null) {
                    if (obj.compareTo((String) nextNode.getData()) < 0) {
                        currentNode.setNext(node);
                        node.setNext(nextNode);
                        added = true;
                        break;
                    }
                    currentNode = nextNode;
                    nextNode = nextNode.getNext();
                }
                // Inserisco in coda
                if (!added) {
                    tail.setNext(node);
                    tail = node;
                }
            }
        }
    }

    public void print() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNext();
        }
    }

    public void remove(Object obj) {
        Node currentNode, nextNode;
        // se la lista è vuota, non fai nulla
        if (head == null) {
            return;
        }
        // se trovo l'elemento in testa
        if (obj.equals(head.getData())) {
            head = head.getNext();
        } else {
            currentNode = head;
            nextNode = head.getNext();
            while (nextNode != null) {
                if (obj.equals(nextNode.getData())) {
                    currentNode.setNext(nextNode.getNext());
                    break;
                }
                currentNode = nextNode;
                nextNode = nextNode.getNext();
            }
            // controllo se è stata modificata la coda
            if (currentNode.getNext() == null) {
                tail = currentNode;
            }
        }
    }

    public boolean contains(Object obj) {
        Node currentNode = head;
        while (currentNode != null) {
            if (obj.equals(currentNode.getData())) {
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }
}
